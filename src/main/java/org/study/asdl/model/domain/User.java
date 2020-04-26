package org.study.asdl.model.domain;

import lombok.Data;
import org.study.asdl.base.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_user")
public class User extends BaseEntity {

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 登录密码
     */
    @Column(name = "login_pwd")
    private String loginPwd;

    /**
     * 工号
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 手机号
     */
    @Column(name = "mobile_no")
    private String mobileNo;

    /**
     * 邮件地址
     */
    private String email;

    /**
     * 状态
     */
    private String status;

    /**
     * 用户来源
     */
    @Column(name = "user_source")
    private String userSource;

    /**
     * 操作员类型（2000伙伴，3000客户，1000运营）
     */
    private String type;

    /**
     * 最后登录IP地址
     */
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 最后登录位置
     */
    @Column(name = "last_login_location")
    private String lastLoginLocation;

    /**
     * 描述
     */
    private String remark;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 是否更改过密码
     */
    @Column(name = "is_changed_pwd")
    private Short isChangedPwd;

    /**
     * 连续输错密码次数（连续5次输错就冻结帐号）
     */
    @Column(name = "pwd_error_count")
    private Short pwdErrorCount;

    /**
     * 最后输错密码时间
     */
    @Column(name = "pwd_error_time")
    private Date pwdErrorTime;

}