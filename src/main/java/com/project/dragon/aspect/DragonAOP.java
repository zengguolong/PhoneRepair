package com.project.dragon.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DragonAOP {

    //切面校验

   /** @Pointcut("execution(public * com.project.dragon.controller.Admin*.*(..))" +
    "&& !execution(public * com.project.dragon.controller.AdminController.*(..))")
    public void verify() {}

    @Before("verify()")
    public void doVerifyBefore(){
       ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       HttpServletRequest request =  attributes.getRequest();

       //查询session
        HttpSession session = request.getSession();
        Object object =  session.getAttribute("admin");
        if(object == null)//可以将抛出的异常在一个异常类处理
            throw new DragonException(ResultEnum.ADMIN_LOGIN);

    }*/

}
