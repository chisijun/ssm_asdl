package org.study.asdl.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.study.asdl.annotation.CurrentUser;
import org.study.asdl.config.Constants;
import org.study.asdl.model.domain.User;
import org.study.asdl.service.UserService;

/**
 * ClassName: CurrentUserMethodArgumentResolver 
 * @Description: 用spring自带的拦截器来处理@CurrentUser
 * @date 2017年9月12日
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserService userService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //如果参数类型是User并且有CurrentUser注解则支持
        if (methodParameter.getParameterType().isAssignableFrom(User.class) &&
                methodParameter.hasParameterAnnotation(CurrentUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        //取出鉴权时存入的登录用户Id
        Long currentUserId = (Long) nativeWebRequest.getAttribute(Constants.CURRENT_USER_ID, RequestAttributes.SCOPE_REQUEST);
        if (currentUserId != null) {
            //从数据库中查询并返回
            //查询单个用户信息（根据id）
        	User user = userService.selectUserById(currentUserId);
            return user;
        }
        throw new MissingServletRequestPartException(Constants.CURRENT_USER_ID);
    }
}
