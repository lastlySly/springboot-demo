package cn.lastlysly.mapper;

import cn.lastlysly.pojo.PermissionSheet;
import cn.lastlysly.pojo.PermissionSheetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionSheetMapper {
    int countByExample(PermissionSheetExample example);

    int deleteByExample(PermissionSheetExample example);

    int deleteByPrimaryKey(Long permissionId);

    int insert(PermissionSheet record);

    int insertSelective(PermissionSheet record);

    List<PermissionSheet> selectByExample(PermissionSheetExample example);

    PermissionSheet selectByPrimaryKey(Long permissionId);

    int updateByExampleSelective(@Param("record") PermissionSheet record, @Param("example") PermissionSheetExample example);

    int updateByExample(@Param("record") PermissionSheet record, @Param("example") PermissionSheetExample example);

    int updateByPrimaryKeySelective(PermissionSheet record);

    int updateByPrimaryKey(PermissionSheet record);
}