package com.project.dragon.controller;


import com.github.pagehelper.PageInfo;
import com.project.dragon.dao.UserDAOMapper;
import com.project.dragon.dataobject.AdminDO;
import com.project.dragon.dataobject.UserDAO;
import com.project.dragon.enums.ResultEnum;
import com.project.dragon.exception.DragonException;
import com.project.dragon.service.AdminService;
import com.project.dragon.utils.KeyUtils;
import com.project.dragon.utils.ResultVOUtils;
import com.project.dragon.viewobject.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserDAOMapper userDAOMapper;

    //管理员登录
    @PostMapping("/login")
    public ResultVO login(@RequestParam("username") String name,
                          @RequestParam("password") String password,
                          HttpServletRequest httpServletRequest) {
        ResultVO resultVO = new ResultVO();
        AdminDO adminDO = new AdminDO();
        adminDO.setName(name);
        adminDO.setPassword(password);
        AdminDO admin = adminService.adminLogin(adminDO);
        if (admin == null)
            throw new DragonException(ResultEnum.ERROR);
        httpServletRequest.getSession().setAttribute("admin", admin);
        httpServletRequest.getSession().setMaxInactiveInterval(36000);//设置session存储时间，以秒为单位
        resultVO.setCode(20000);
        resultVO.setMessage("登录成功");
        Map<String,String> map = new HashMap<>();
        map.put("token","asd5ad4a54da5ds4d5sadsad");
        resultVO.setData(map);
        return resultVO; //返回信息暂时写死
    }

    //查询所有用户信息接口
    @GetMapping("/get")
    public ResultVO getAllUser() {
        List<UserDAO> userDAOList = userDAOMapper.queryAllUser();
        return ResultVOUtils.success(userDAOList);
    }

    //删除用户信息接口
    @GetMapping("/deleteUser")
    public ResultVO deleteUser(@RequestParam("userId") String userId) {
        UserDAO userDAO = userDAOMapper.selectByPrimaryKey(userId);
        if (userDAO == null)
            throw new DragonException(ResultEnum.USER_NOT_EXIST);
        userDAOMapper.deleteByPrimaryKey(userId);
        return ResultVOUtils.success(userDAO.getUsername());
    }

    //更改用户信息接口
    @GetMapping("/updateUser")
    public ResultVO updateUser(@RequestParam("userId") String userId,
                               @RequestParam("username") String username,
                               @RequestParam(value = "password",required = false) String password,
                               @RequestParam("address") String address,
                               @RequestParam("phone") String phone,
                               @RequestParam("money") Double money) {
        UserDAO userDAO = userDAOMapper.selectByPrimaryKey(userId);
        if (userDAO == null)
            throw new DragonException(ResultEnum.USER_NOT_EXIST);
        userDAO.setPhone(phone);
        userDAO.setUsername(username);

        if(password!=null)
            userDAO.setPassword(password);

        userDAO.setAddress(address);
        userDAO.setMoney(money);
        userDAOMapper.updateByPrimaryKey(userDAO);
        return ResultVOUtils.success("修改成功");
    }

    //管理员添加一个个用户接口
    @GetMapping("/addUser")
    public ResultVO addUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("phone") String phone,
                            @RequestParam("address") String address) {
        //查下用户表该用户是否存在
        UserDAO userDAO = new UserDAO();
        userDAO.setUsername(username);
        UserDAO user = userDAOMapper.selectByUserName(userDAO);
        if (user != null)
            throw new DragonException(ResultEnum.USER_EXIST);
        userDAO.setUserId(KeyUtils.genUniqueKey());
        userDAO.setPassword(password);
        userDAO.setPhone(phone);
        userDAO.setAddress(address);
        userDAOMapper.insertSelective(userDAO);
        return ResultVOUtils.success("添加成功");
    }

    //或取管理员登录信息接口 返回token
    @GetMapping("/getInfo")
    public ResultVO userInfo(){  //暂时写死
        Map<String,String> map = new HashMap<>();
        map.put("code","20000");
        map.put("name","admin1");
        map.put("avatar","avatar");
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(20000);
        resultVO.setMessage("获取信息成功");
        resultVO.setData(map);
        return resultVO;
    }

    //登出接口
    @GetMapping("/logout")
    public ResultVO logout(HttpServletRequest request) {
        ResultVO resultVO = new ResultVO();
        HttpSession session = request.getSession();
        session.invalidate();//停用session
        resultVO.setCode(20000);
        resultVO.setMessage("登出成功");
        return resultVO;
    }

    //分页查询用户
    @GetMapping("/pageQueryUser")
    public ResultVO pages(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "8") Integer size) {
        PageInfo<UserDAO> pageInfo = adminService.queryAllUser(page, size);
        return ResultVOUtils.success(pageInfo);
    }

}
