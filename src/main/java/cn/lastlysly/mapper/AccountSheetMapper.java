package cn.lastlysly.mapper;

import cn.lastlysly.pojo.AccountSheet;
import cn.lastlysly.pojo.AccountSheetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountSheetMapper {
    int countByExample(AccountSheetExample example);

    int deleteByExample(AccountSheetExample example);

    int deleteByPrimaryKey(Long accountId);

    int insert(AccountSheet record);

    int insertSelective(AccountSheet record);

    List<AccountSheet> selectByExample(AccountSheetExample example);

    AccountSheet selectByPrimaryKey(Long accountId);

    int updateByExampleSelective(@Param("record") AccountSheet record, @Param("example") AccountSheetExample example);

    int updateByExample(@Param("record") AccountSheet record, @Param("example") AccountSheetExample example);

    int updateByPrimaryKeySelective(AccountSheet record);

    int updateByPrimaryKey(AccountSheet record);
}