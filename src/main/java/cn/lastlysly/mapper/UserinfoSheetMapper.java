package cn.lastlysly.mapper;

import cn.lastlysly.pojo.UserinfoSheet;
import cn.lastlysly.pojo.UserinfoSheetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserinfoSheetMapper {
    int countByExample(UserinfoSheetExample example);

    int deleteByExample(UserinfoSheetExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(UserinfoSheet record);

    int insertSelective(UserinfoSheet record);

    List<UserinfoSheet> selectByExample(UserinfoSheetExample example);

    UserinfoSheet selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") UserinfoSheet record, @Param("example") UserinfoSheetExample example);

    int updateByExample(@Param("record") UserinfoSheet record, @Param("example") UserinfoSheetExample example);

    int updateByPrimaryKeySelective(UserinfoSheet record);

    int updateByPrimaryKey(UserinfoSheet record);
}