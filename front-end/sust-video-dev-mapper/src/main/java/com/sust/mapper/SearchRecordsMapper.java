package com.sust.mapper;

import com.sust.pojo.SearchRecords;
import com.sust.utils.MyMapper;

import java.util.List;

public interface SearchRecordsMapper extends MyMapper<SearchRecords> {

    public List<String> getHotwords();
}