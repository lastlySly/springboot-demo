package cn.lastlysly.service.serviceimpl;

import cn.lastlysly.mapper.*;
import cn.lastlysly.pojo.*;
import cn.lastlysly.service.UserinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2018-06-26 20:18
 * loginId 即为 username ，登陆账号
 *
 * 用户操作
 **/
@Service
public class UserinfoServiceImpl implements UserinfoService {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserinfoSheetMapper userinfoSheetMapper;

    @Autowired
    private RoleSheetMapper roleSheetMapper;

    @Autowired
    private PermissionSheetMapper permissionSheetMapper;

    @Autowired
    public CustomAccountMapper customAccountMapper;

    @Autowired
    public AccountSheetMapper accountSheetMapper;

    /**
     * 通过 账号（用户名） 获取用户信息
     * @param loginId 登陆账号，即username用户名
     * @return
     */
    @Override
    public UserinfoSheet getUserinfoByLoginId(String loginId) {
        UserinfoSheetExample userinfoSheetExample = new UserinfoSheetExample();
        UserinfoSheetExample.Criteria criteria = userinfoSheetExample.createCriteria();
        criteria.andUserLoginIdEqualTo(loginId);
        List<UserinfoSheet> userinfoSheetList = userinfoSheetMapper.selectByExample(userinfoSheetExample);
        if(userinfoSheetList.size() > 0){
            return userinfoSheetList.get(0);
        }
        return null;
    }

    /**
     * 通过账号（用户名）获取用户角色
     * @param loginId 登陆账号，即username用户名
     * @return
     */
    @Override
    public List<String> listRolesByLoginId(String loginId) {
        RoleSheetExample rolesSheetExample = new RoleSheetExample();
        RoleSheetExample.Criteria criteria = rolesSheetExample.createCriteria();
        criteria.andRoleUsernameEqualTo(loginId);
        List<RoleSheet> rolesSheetsList = roleSheetMapper.selectByExample(rolesSheetExample);
        List<String> rolesList = new ArrayList<String>();
        if (rolesSheetsList.size() > 0){
            for (RoleSheet rolesSheet : rolesSheetsList){
                rolesList.add(rolesSheet.getRoleName());
            }
            return rolesList;
        }

        return null;
    }

    /**
     * 通过账号（用户名）获取用户权限
     * @param loginId 登陆账号，即username用户名
     * @return
     */
    @Override
    public List<String> listPermissionsByLoginId(String loginId) {
        List<String> permissionList = new ArrayList<String>();
        /*通过用户名获取角色*/
        List<String> rolesList = listRolesByLoginId(loginId);

        /*通过角色名查询权限*/
        if (rolesList.size() > 0){
            PermissionSheetExample permissionSheetExample = new PermissionSheetExample();
            PermissionSheetExample.Criteria criteria = permissionSheetExample.createCriteria();
            criteria.andPermissionRoleIn(rolesList);
            List<PermissionSheet> permissionSheetList = permissionSheetMapper.selectByExample(permissionSheetExample);
            if (permissionSheetList.size() > 0){
               for (PermissionSheet permissionSheet : permissionSheetList){
                   permissionList.add(permissionSheet.getPermissionName());
               }
               return permissionList;
            }
        }

        return null;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<AccountSheet> selectAccountInfo() {
        List<AccountSheet> list = accountSheetMapper.selectByExample(null);
        return list;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateTransferAccount(double money, int fromId, int toId) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("inId",toId);
        map.put("outId",fromId);
        map.put("money",money);
        int inRow = customAccountMapper.inAccount(map);

        //测试事务回滚
        int a = 1/0;

        int outRow = customAccountMapper.outAccount(map);

        if (inRow > 0 && outRow >0){
            return true;
        }


        return false;
    }

}
