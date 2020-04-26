package org.study.asdl.service.impl;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.study.asdl.model.entity.TokenModel;
import org.study.asdl.service.TokenManager;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 通过Redis存储和验证token的实现类
 * @author liangyunlong
 * @date 2017/12/20
 */
@Service("tokenManager")
public class TokenManagerImpl implements TokenManager {
    //@Resource(name = "redisTemplate")
    //private RedisTemplate<String, String> redis;
	ConcurrentHashMap<Long, String> tokenMap = new ConcurrentHashMap<Long, String>();
	
    public TokenManagerImpl(){
    	
    	tokenMap.put(1l, "516194bf34054e1a92579c2e458056b6");
    	System.out.println("-----chisj:token init 1");
    }

    public TokenManagerImpl(RedisTemplate<String, String> redis) {
        //this.redis = redis;
        //redis.setKeySerializer(new JdkSerializationRedisSerializer());
    	tokenMap.put(1l, "1_516194bf34054e1a92579c2e458056b6");
    	System.out.println("-----chisj:token init 2");
    }

    @Override
    public TokenModel createToken(Long userId) {
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(userId, token);
        //存储到redis并设置过期时间
        //redis.boundValueOps(String.valueOf(userId)).set(token, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        tokenMap.put(userId, token);
        return model;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        //String token = redis.boundValueOps(String.valueOf(model.getUserId())).get();
        String token = tokenMap.get(model.getUserId());
        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        //redis.boundValueOps(String.valueOf(model.getUserId())).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }

    /**
     * 非单点登录-通过userId获取token
     */
    @Override
    public TokenModel get(Long userId) {
    	System.out.println("userId = " + userId);
        //ValueOperations<String, String> value = redis.opsForValue();
        //String token = value.get(String.valueOf(userId));
    	String token = tokenMap.get(userId);
        if (token == null) {
            return null;
        }
        TokenModel model = new TokenModel(userId, token);
        return model;
    }
    @Override
    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        Long userId = Long.parseLong(param[0]);
        String token = param[1];
        return new TokenModel(userId, token);
    }

    @Override
    public void deleteToken(Long userId) {
        //redis.delete(String.valueOf(userId));
    	tokenMap.remove(userId);
    }
}
