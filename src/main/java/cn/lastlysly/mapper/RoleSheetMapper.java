package cn.lastlysly.mapper;

import cn.lastlysly.pojo.RoleSheet;
import cn.lastlysly.pojo.RoleSheetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleSheetMapper {
    int countByExample(RoleSheetExample example);

    int deleteByExample(RoleSheetExample example);

    int deleteByPrimaryKey(Long roleId);

    int insert(RoleSheet record);

    int insertSelective(RoleSheet record);

    List<RoleSheet> selectByExample(RoleSheetExample example);

    RoleSheet selectByPrimaryKey(Long roleId);

    int updateByExampleSelective(@Param("record") RoleSheet record, @Param("example") RoleSheetExample example);

    int updateByExample(@Param("record") RoleSheet record, @Param("example") RoleSheetExample example);

    int updateByPrimaryKeySelective(RoleSheet record);

    int updateByPrimaryKey(RoleSheet record);
}