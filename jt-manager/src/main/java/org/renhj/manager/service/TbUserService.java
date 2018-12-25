package org.renhj.manager.service;

import org.renhj.common.pojo.vo.Page;
import org.renhj.manager.pojo.domain.TbUser;

import java.util.List;

public interface TbUserService {

    /**
     * 分页查询所有用户
     * @param pageCurrent 当前页
     * @param username 模糊搜索用户名
     * @param pageSize 每页大小
     * @return user的集合
     */
    Page<?> findUsersByUsernameWithPage(String username, Integer pageCurrent, Integer pageSize);

    TbUser saveUser(TbUser user);

    Long deleteUserById(String id);

    TbUser updateUser(TbUser user);
}
