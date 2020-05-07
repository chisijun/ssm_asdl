package org.study.asdl.model.dto;

import lombok.Data;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2020-04-27 15:38
 * @Description: 校验登录名是否存在传输对象
 */
@Data
public class CheckLoginNameDto {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 登录名
     */
    private String loginName;
}
