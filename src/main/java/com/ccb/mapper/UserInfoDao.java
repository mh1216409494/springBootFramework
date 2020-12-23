package com.ccb.mapper;

import com.ccb.bean.Role;
import com.ccb.bean.Student;
import com.ccb.bean.UserInfo;
import com.ccb.bean.UserRole;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

public interface UserInfoDao {

    /**
     * @Author maHuan
     * @Description 查询用户信息
     * @Date 2020/12/12 22:26
     * @Patam [userName]
     * @return java.util.List<com.ccb.bean.UserInfo>
     **/
    @SelectProvider(type = InnerClass.class ,method = "findByName")
    @Results(id="userInfo" , value={
            @Result(id = true,column = "user_id",property = "userId"),
            @Result(column = "group_id",property = "groupId"),
            @Result(column = "nick_name",property = "nickName"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "user_code",property = "userCode"),
            @Result(column = "user_pwd",property = "userPwd"),
            @Result(column = "user_type",property = "userType"),
            @Result(column = "user_state",property = "userState"),
            @Result(column = "is_delete",property = "isDelete"),
            @Result(column = "create_by",property = "createBy"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_by",property = "updateBy"),
            @Result(column = "update_time",property = "updateTime")
    })
    List<UserInfo> findName(@Param("userName") String userName);


    /**
     * @Author maHuan
     * @Description 存储过程查询用户信息
     * @Date 2020/12/12 22:27
     * @Patam [userId]
     * @return com.ccb.bean.UserInfo
     **/
    @Select({"call findById(#{userId,mode=IN,jdbcType=INTEGER})"})
    @Options(statementType= StatementType.CALLABLE)
    @ResultMap("userInfo")
    UserInfo findById(int userId);


    /**
     * @Author maHuan
     * @Description 函数查询用户表信息
     * @Date 2020/12/12 23:12
     * @Patam [userName]
     * @return com.ccb.bean.UserInfo
     **/
    @Select("select * from user_info where user_id=function2(#{userName,mode=IN})")
    @Options(statementType= StatementType.CALLABLE)
    @ResultMap("userInfo")
    UserInfo findNameById(String userName);

    /**
     * @Author maHuan
     * @Description 多对多
     * @Date 2020/12/13 17:56
     * @Patam [userId]
     * @return java.util.List<com.ccb.bean.UserInfo>
     **/
    @Select("select ur.user_id,user_name,user_code from user_role ur left join user_info u on ur.user_id=u.user_id where role_id=#{roleId}")
    @Results(id="users",value = {
            @Result(id = true,column = "user_id",property = "userId"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "user_code",property = "userCode"),
            @Result(column = "user_id" ,property = "rList", many = @Many(select="com.ccb.mapper.UserInfoDao.findRoles",fetchType = FetchType.LAZY)),
    })
    List<UserInfo> findUsers(int roleId);


    @Select("select ur.role_id,role_name,role_code from user_role ur left join role r on ur.role_id=r.role_id where user_id=#{userId}")
    @Results(id = "userToRole",value = {
            @Result(id = true,column = "role_id",property = "roleId"),
            @Result(column = "role_name",property = "roleName"),
            @Result(column = "role_code",property = "roleCode"),
           // @Result(column = "role_id",property = "uList",many = @Many(select = "com.ccb.mapper.UserInfoDao.findUsers",fetchType = FetchType.LAZY)),
    })
    List<Role> findRoles(int userId);


    /**
     * @Author maHuan
     * @Description 内部类
     * @Date 2020/12/12 19:41
     * @Patam
     * @return
     **/
    class InnerClass{
        public String findByName(String userName){
            StringBuilder str=new StringBuilder();
            str.append("select * from user_info where user_id<10 ");
            if(null!=userName && ""!=userName){
                str.append(" and user_name like concat('%',#{userName},'%')");
            }
            System.out.println(str.toString());
            return str.toString();
        }
    }


}
