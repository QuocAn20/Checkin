package com.example.checkin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapper {

    List<String> getPermission(@Param("id") String id);

    int deletePermission(@Param("id") String id);

    void createPermission(@Param("id") String id, @Param("roleCode") List<String> roleCode);

}
