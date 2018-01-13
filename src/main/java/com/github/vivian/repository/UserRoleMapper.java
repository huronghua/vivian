package com.github.vivian.repository;

import com.github.vivian.domain.OrangeAuthority;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserRoleMapper {

    /*初始化部门主管的dao*/
    Integer getRoleIdByName(String roleName);

    List<Integer> getCorrespondMasterIdByLevel(Integer level);

    Integer addRoleUserBatch(@Param("roleId") Integer roleId, @Param("masterIdList") List<Integer> masterIdList);

    List<OrangeAuthority> getAllOrangeUserAuthority();

    Integer initialOrangeUserAuthority(@Param(value = "orangeAuthorityList") List<OrangeAuthority> orangeAuthorityList);

}