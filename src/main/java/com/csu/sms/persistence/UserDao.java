package com.csu.sms.persistence;

import com.csu.sms.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserDao {
    User findById(@Param("id") Long id);

    User findByUsername(@Param("username") String username);

    User findByEmail(@Param("email") String email);

    int insertUser(User user);

    int updateUser(User user);

    int updateUserStatus(@Param("id") Long id, @Param("status") Integer status);

    int updateUserRole(@Param("id") Long id, @Param("role") Integer role);

    int updatePassword(@Param("id") Long id, @Param("password") String password);

    List<User> findUsersByPage(
            @Param("keyword") String keyword,
            @Param("status") Integer status,
            @Param("offset") Integer offset,
            @Param("limit") Integer limit
    );

    int countUsers(@Param("keyword") String keyword, @Param("status") Integer status);

    List<User> findUsersByIds(List<Long> userIds);

    List<User> findUsersByRole(int code);
}
