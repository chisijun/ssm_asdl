/**  
 * @Title: UserVo.java
 * @Package org.study.heat.vo
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年6月11日
 */
package org.study.asdl.model.vo;

import lombok.Data;
import org.study.asdl.base.BaseVo;

import java.util.Date;

/**
 * ClassName: UserVo 
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2019年6月11日
 */
@Data
public class UserVo extends BaseVo {

	/**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * 工号
     */
    private String userCode;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 手机号
     */
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
    private String userSource;

    /**
     * 操作员类型（2000伙伴，3000客户，1000运营）
     */
    private String type;

    /**
     * 最后登录IP地址
     */
    private String lastLoginIp;

    /**
     * 最后登录位置
     */
    private String lastLoginLocation;

    /**
     * 描述
     */
    private String remark;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 是否更改过密码
     */
    private Short isChangedPwd;

    /**
     * 连续输错密码次数（连续5次输错就冻结帐号）
     */
    private Short pwdErrorCount;

    /**
     * 最后输错密码时间
     */
    private Date pwdErrorTime;

}
