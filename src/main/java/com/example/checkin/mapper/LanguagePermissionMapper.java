package com.example.checkin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LanguagePermissionMapper {
    List<String> getLanguagePermission(@Param("id") String id);

    int deleteLanguagePermission(@Param("id") String id);

    int createLanguagePermission(@Param("id") String id, @Param("name") List<String> name);
}
