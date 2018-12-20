package org.renhj.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.renhj.manager.pojo.domain.TbUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TbUserMapper extends Mapper<TbUser> {
    Integer selectTotalByUsername(@Param("username")String username);

    List<?> selectUsersByUsernameWithPage(@Param("username") String username,
                                          @Param("start") Integer start,
                                          @Param("size") Integer size);
}