package com.sust.mapper;

import java.util.List;

import com.sust.pojo.Comments;
import com.sust.pojo.vo.CommentsVO;
import com.sust.utils.MyMapper;

public interface CommentsMapperCustom extends MyMapper<Comments> {
	
	public List<CommentsVO> queryComments(String videoId);
}