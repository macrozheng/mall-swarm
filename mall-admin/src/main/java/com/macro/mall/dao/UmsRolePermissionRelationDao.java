package com.macro.mall.dao;

import com.macro.mall.model.UmsPermission;
import com.macro.mall.model.UmsRolePermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Background user user management custom Dao
 * Created by macro on 2018/9/30.
 */
public interface UmsRolePermissionRelationDao {
    /**
     * Insert roles and permissions in bulk
     */
    int insertList(@Param("list")List<UmsRolePermissionRelation> list);

    /**
     * Get permissions based on role
     */
    List<UmsPermission> getPermissionList(@Param("roleId") Long roleId);
}
