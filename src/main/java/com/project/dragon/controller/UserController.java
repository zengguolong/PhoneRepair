package com.project.dragon.controller;

import com.project.dragon.converter.UserConvert;
import com.project.dragon.dataobject.OrderDO;
import com.project.dragon.dataobject.UserDAO;
import com.project.dragon.dto.UserDTO;
import com.project.dragon.enums.ResultEnum;
import com.project.dragon.exception.DragonException;
import com.project.dragon.service.OrderService;
import com.project.dragon.service.UserService;
import com.project.dragon.utils.KeyUtils;
import com.project.dragon.utils.ResultVOUtils;
import com.project.dragon.viewobject.ResultVO;
import com.project.dragon.viewobject.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    //用户登录
    @PostMapping("/login")
    public ResultVO login(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          HttpServletRequest httpServletRequest) {
        ResultVO resultVO = new ResultVO();
        UserDAO userDAO = new UserDAO();
        userDAO.setUsername(username);
        userDAO.setPassword(password);
        UserDAO user = userService.login(userDAO);
        if (user == null)
            throw new DragonException(ResultEnum.ERROR);
        httpServletRequest.getSession().setAttribute(userDAO.getUsername(), user.getUserId());
        httpServletRequest.getSession().setMaxInactiveInterval(36000);//设置session存储时间，以秒为单位
        HttpSession session =  httpServletRequest.getSession();
        Object object =  session.getAttribute(userDAO.getUsername());
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMessage("登录成功");
        //返回的是用户的id
        resultVO.setData(user.getUserId());
        return resultVO;
    }

    //用户登出
    @GetMapping("/logout")
    public ResultVO logout(HttpServletRequest request) {
        ResultVO resultVO = new ResultVO();
        HttpSession session = request.getSession();
        session.invalidate();//停用session
        resultVO.setCode(20000);
        resultVO.setMessage("登出成功");
        return resultVO;
    }

    //用户注册
    @PostMapping("/register")
    public ResultVO Register(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("phone") String phone,
                             @RequestParam("address") String address) {
        ResultVO resultVO = new ResultVO();
        UserDAO userDAO = new UserDAO();
        userDAO.setUsername(username);
        userDAO.setPassword(password);
        userDAO.setPhone(phone);
        userDAO.setAddress(address);
        userDAO.setUserId(KeyUtils.genUniqueKey());
        //查看该用户是否存在
        UserDAO findUser = userService.byFindUser(userDAO);
        if (findUser == null) {
            userService.register(userDAO);
            resultVO.setCode(20000);
            resultVO.setData(username);
            resultVO.setMessage("注册成功");
        } else {
            throw new DragonException(ResultEnum.USER_EXIST);
        }
        return resultVO;
    }

    //用户下单接口
    @PostMapping("/buyerUser")
    public ResultVO buyerUser(@RequestParam("username") String username,
                              @RequestParam("amount") Double amount,
                              @RequestParam("detail") String detail,
                              @RequestParam("remark") String remark) {
        userService.buyerUser(username,amount,detail,remark);
        return ResultVOUtils.success("下单成功");
    }

    //用户充值接口
    @PostMapping("/userCharge")
    public ResultVO userCharge(@RequestParam("username") String username,
                               @RequestParam("money")Double money){
        userService.userCharge(username,money);
        return ResultVOUtils.success("充值成功");
    }


    //2. 根据用户ID 查询出来这个用户的所有字段（除密码以外）信息
    @GetMapping("/byUserId")
    public ResultVO byUserId(@RequestParam("userId")String userId){
        UserDTO userDTO =  userService.byUserId(userId);
        UserVO userVO = UserConvert.UserDTO2UserVO(userDTO);
        return ResultVOUtils.success(userVO);
    }

    //取消订单
    @GetMapping("/cancelOrder")
    public ResultVO cancelOrder(@RequestParam("order_id") String orderId) {
        orderService.cancelOrder(orderId);
        return ResultVOUtils.success("取消订单成功");
    }

    //根据用户名查询该用户的所有订单
    @GetMapping("byUsernameOrder")
    public ResultVO byUsernameOrder(@RequestParam("order_username")String orderUsername){
       List<OrderDO> orderDOList =  userService.byUsernameOrder(orderUsername);
       return ResultVOUtils.success(orderDOList);
    }

    //扣除金额
    @PostMapping("modifyMoney")
    public ResultVO modifyMoney(@RequestParam("username")String username,
                                @RequestParam("money")Double money){
        userService.modifyMoney(username,money);
        return ResultVOUtils.success("付款成功");
    }

    
}

