package org.renhj.service.impl;

import org.renhj.dao.SysUserDao;
import org.renhj.dao.SysUserRoleDao;
import org.renhj.entity.SysUser;
import org.renhj.exception.ResourceNotExistException;
import org.renhj.service.SysUserService;
import org.renhj.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED, timeout = 30)
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao userRoleDao;

    @Override
    public Map<?, ?> findUsersByUsernameWithPage(String username, Integer pageCurrent, Integer pageSize) {
        try {
            HashMap<String, Object> map = new HashMap<>();
            int rowsCount = sysUserDao.getRowCount(username); // 查询总记录数
            if (rowsCount<1) return map;// 如果没有记录 直接返回空map
            // 查找用户记录
            List<SysUser> users = sysUserDao.findUserWithPage((pageCurrent-1)*pageSize, pageSize, username);
            ArrayList<Map<String, Object>> list = new ArrayList<>();
            for (SysUser user: users){
                Map<String, Object> userMap = JsonUtils.obj2Map(user);
                Long[] roleIds = userRoleDao.findRoleIdsByUserId(user.getId());
                userMap.put("roles", roleIds);
                list.add(userMap);
            }

            map.put("row", rowsCount);
            map.put("pageCurrent", pageCurrent);
            map.put("pageSize", pageSize);
            map.put("records",list);
            map.put("pageCount", (rowsCount-1)/pageSize+1);
            return map;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(readOnly = false)
    public SysUser saveUser(SysUser user, Long[] roleIds) {
        sysUserDao.saveUser(user);
        userRoleDao.insertUserRole(user.getId(), roleIds);
        return user;
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteUser(Long id) {
        return sysUserDao.deleteUserById(id);
    }

    @Override
    public SysUser findUserById(Long id) {
        SysUser user = sysUserDao.findUserById(id);
        if (user == null){
            throw new ResourceNotExistException("该用户不存在！");
        }
        return sysUserDao.findUserById(id);
    }

    @Override
    public SysUser updateUser(SysUser user) {
        sysUserDao.updateUser(user);
        return sysUserDao.findUserById(user.getId());
    }
}
