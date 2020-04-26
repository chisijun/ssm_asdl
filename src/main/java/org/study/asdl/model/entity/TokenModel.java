package org.study.asdl.model.entity;

import lombok.Data;

/**
 * @Description: Token的Model类，可以增加字段提高安全性，例如时间戳、url签名
 * @author liangyunlong
 * @date 2017/12/20
 */
@Data
public class TokenModel {
    //用户id
    private Long userId;

    //随机生成的uuid
    private String token;

    // 构造函数
    public TokenModel(Long userId, String token){
        this.userId = userId;
        this.token = token;
    }
}


















