package com.example.checkin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DayPermissionMapper {
    List<String> getDayPermission(@Param("id") String id);

    int deleteDayPermission(@Param("id") String id);

    int createDayPermission(@Param("id") String id, @Param("name") List<String> name);
}
