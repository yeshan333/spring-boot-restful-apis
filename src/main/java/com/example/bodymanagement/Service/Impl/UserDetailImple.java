package com.example.bodymanagement.Service.Impl;

import com.example.bodymanagement.Service.UserService;
import com.example.bodymanagement.entity.JwtUser;
import com.example.bodymanagement.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailImple")
public class UserDetailImple implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity=userService.findOneUserById(s);
        System.out.println(userEntity);
        //将数据库的roles解析为UserDetails的权限集
//        userEntity.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(userEntity.getAuth()));
        return new JwtUser(userEntity);
    }
}
