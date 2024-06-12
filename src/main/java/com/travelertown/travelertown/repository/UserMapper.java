package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.RoleRegister;
import com.travelertown.travelertown.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public User findUserByUsername(String username);
    public User findUserByNickname(String nickname);
    public User findUserByEmail(String email);
    public int saveUser(User user);
    public RoleRegister findRoleRegisterByUserIdAndRoleId(@Param("userId") int userId, @Param("roleId") int roleId);
    public int saveRole(@Param("userId") int userId, @Param("roleId") int roleId);
    public void editSex(User user);
    public void editAge(User user);
}
