package com.sust.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.sust.pojo.Users;
import com.sust.pojo.vo.PublisherVideo;
import com.sust.service.UserService;
import com.sust.utils.SustJSONResult;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sust.pojo.Users;
import com.sust.pojo.UsersReport;
import com.sust.pojo.vo.PublisherVideo;
import com.sust.pojo.vo.UsersVO;
import com.sust.service.UserService;
import com.sust.utils.SustJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="用户相关业务的接口", tags= {"用户相关业务的controller"})
@RequestMapping("/user")
public class UserController extends BasicController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="用户上传头像", notes="用户上传头像的接口")
	@ApiImplicitParam(name="userId", value="用户id", required=true, 
						dataType="String", paramType="query")
	@PostMapping("/uploadFace")
	public SustJSONResult uploadFace(String userId, @RequestParam("file") MultipartFile[] files) throws Exception {
		
		if (StringUtils.isBlank(userId)) {
			return SustJSONResult.errorMsg("用户id不能为空...");
		}
		
		// 文件保存的命名空间
		String fileSpace = "D:/sust_videos_dev";
		// 保存到数据库中的相对路径
		String uploadPathDB = "/" + userId + "/face";
		
		FileOutputStream fileOutputStream = null;
		InputStream inputStream = null;
		try {
			if (files != null && files.length > 0) {
				
				String fileName = files[0].getOriginalFilename();
				if (StringUtils.isNotBlank(fileName)) {
					// 文件上传的最终保存路径
					String finalFacePath = fileSpace + uploadPathDB + "/" + fileName;
					// 设置数据库保存的路径
					uploadPathDB += ("/" + fileName);
					
					File outFile = new File(finalFacePath);
					if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
						// 创建父文件夹
						outFile.getParentFile().mkdirs();
					}
					
					fileOutputStream = new FileOutputStream(outFile);
					inputStream = files[0].getInputStream();
					IOUtils.copy(inputStream, fileOutputStream);
				}
				
			} else {
				return SustJSONResult.errorMsg("上传出错...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return SustJSONResult.errorMsg("上传出错...");
		} finally {
			if (fileOutputStream != null) {
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}
		
		Users user = new Users();
		user.setId(userId);
		user.setFaceImage(uploadPathDB);
		userService.updateUserInfo(user);
		
		return SustJSONResult.ok(uploadPathDB);
	}
	
	@ApiOperation(value="查询用户信息", notes="查询用户信息的接口")
	@ApiImplicitParam(name="userId", value="用户id", required=true,
						dataType="String", paramType="query")
	@PostMapping("/query")
	public SustJSONResult query(String userId, String fanId) throws Exception {

		if (StringUtils.isBlank(userId)) {
			return SustJSONResult.errorMsg("用户id不能为空...");
		}

		Users userInfo = userService.queryUserInfo(userId);
		UsersVO userVO = new UsersVO();
		BeanUtils.copyProperties(userInfo, userVO);

		//userVO.setFollow(userService.queryIfFollow(userId, fanId));

		return SustJSONResult.ok(userVO);
	}


	@PostMapping("/queryPublisher")
	public SustJSONResult queryPublisher(String loginUserId, String videoId,
			String publishUserId) throws Exception {

		if (StringUtils.isBlank(publishUserId)) {
			return SustJSONResult.errorMsg("");
		}

		// 1. 查询视频发布者的信息
		Users userInfo = userService.queryUserInfo(publishUserId);
		UsersVO publisher = new UsersVO();
		BeanUtils.copyProperties(userInfo, publisher);

		// 2. 查询当前登录者和视频的点赞关系
		boolean userLikeVideo = userService.isUserLikeVideo(loginUserId, videoId);

		PublisherVideo bean = new PublisherVideo();
		bean.setPublisher(publisher);
		bean.setUserLikeVideo(userLikeVideo);

		return SustJSONResult.ok(bean);
	}

	@PostMapping("/beyourfans")
	public SustJSONResult beyourfans(String userId, String fanId) throws Exception {

		if (StringUtils.isBlank(userId) || StringUtils.isBlank(fanId)) {
			return SustJSONResult.errorMsg("");
		}

		userService.saveUserFanRelation(userId, fanId);

		return SustJSONResult.ok("关注成功...");
	}

	@PostMapping("/dontbeyourfans")
	public SustJSONResult dontbeyourfans(String userId, String fanId) throws Exception {

		if (StringUtils.isBlank(userId) || StringUtils.isBlank(fanId)) {
			return SustJSONResult.errorMsg("");
		}

		userService.deleteUserFanRelation(userId, fanId);

		return SustJSONResult.ok("取消关注成功...");
	}

	@PostMapping("/reportUser")
	public SustJSONResult reportUser(@RequestBody UsersReport usersReport) throws Exception {

		// 保存举报信息
		userService.reportUser(usersReport);

		return SustJSONResult.errorMsg("举报成功...有你平台变得更美好...");
	}
	
}
