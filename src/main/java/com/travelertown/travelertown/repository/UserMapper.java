package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.OAuth2.OAuth2;
import com.travelertown.travelertown.entity.RoleRegister;
import com.travelertown.travelertown.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public User findUserByUsername(String username);
    public User findUserByNickname(String nickname);
    public User findUserByEmail(String email);
    public User findUserByOAuth2name(String name);
    public int saveUser(User user);
    public int saveOAuth2(OAuth2 oAuth2);
    public RoleRegister findRoleRegisterByUserIdAndRoleId(@Param("userId") int userId, @Param("roleId") int roleId);
    public int saveRole(@Param("userId") int userId, @Param("roleId") int roleId);
    public int modifyPassword(User user);
    public void editSex(User user);
    public void editAge(User user);
    public void editImg(User user);
}
