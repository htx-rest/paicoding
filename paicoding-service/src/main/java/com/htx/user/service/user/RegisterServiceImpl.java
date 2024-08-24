package com.htx.user.service.user;

import com.htx.enums.NotifyTypeEnum;
import com.htx.enums.user.LoginTypeEnum;
import com.htx.exception.ExceptionUtil;
import com.htx.vo.constants.StatusEnum;
import com.htx.vo.notify.NotifyMsgEvent;
import com.htx.vo.user.UserPwdLoginReq;
import com.htx.util.SpringUtil;
import com.htx.util.TransactionUtil;
import com.htx.user.converter.UserAiConverter;
import com.htx.user.repository.dao.UserAiDao;
import com.htx.user.repository.dao.UserDao;
import com.htx.user.repository.entity.UserAiDO;
import com.htx.user.repository.entity.UserDO;
import com.htx.user.repository.entity.UserInfoDO;
import com.htx.user.service.RegisterService;
import com.htx.user.service.help.UserPwdEncoder;
import com.htx.user.service.help.UserRandomGenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 微信搜索「二哈学习之路」
 * 用户注册服务
 * @author htx
 * @date 2024/8/24 15:37
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserPwdEncoder userPwdEncoder;
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserAiDao userAiDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long registerByUserNameAndPassword(UserPwdLoginReq loginReq) {
        // 1. 判断用户名是否准确
        UserDO user = userDao.getUserByUserName(loginReq.getUsername());
        if (user != null) {
            throw ExceptionUtil.of(StatusEnum.USER_LOGIN_NAME_REPEAT, loginReq.getUsername());
        }

        // 2. 保存用户登录信息
        user = new UserDO();
        user.setUserName(loginReq.getUsername());
        user.setPassword(userPwdEncoder.encPwd(loginReq.getPassword()));
        user.setThirdAccountId("");
        // 用户名密码注册
        user.setLoginType(LoginTypeEnum.USER_PWD.getType());
        userDao.saveUser(user);

        // 3. 保存用户信息
        UserInfoDO userInfo = new UserInfoDO();
        userInfo.setUserId(user.getId());
        userInfo.setUserName(loginReq.getUsername());
        userInfo.setPhoto(UserRandomGenHelper.genAvatar());
        userDao.save(userInfo);

        // 4. 保存ai相互信息
        UserAiDO userAiDO = UserAiConverter.initAi(user.getId(), loginReq.getStarNumber());
        userAiDao.saveOrUpdateAiBindInfo(userAiDO, loginReq.getInvitationCode());
        processAfterUserRegister(user.getId());
        return user.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long registerByWechat(String thirdAccount) {
        // 用户不存在，则需要注册
        // 1. 保存用户登录信息
        UserDO user = new UserDO();
        user.setThirdAccountId(thirdAccount);
        user.setLoginType(LoginTypeEnum.WECHAT.getType());
        userDao.saveUser(user);


        // 2. 初始化用户信息，随机生成用户昵称 + 头像
        UserInfoDO userInfo = new UserInfoDO();
        userInfo.setUserId(user.getId());
        userInfo.setUserName(UserRandomGenHelper.genNickName());
        userInfo.setPhoto(UserRandomGenHelper.genAvatar());
        userDao.save(userInfo);

        // 3. 保存ai相互信息
        UserAiDO userAiDO = UserAiConverter.initAi(user.getId());
        userAiDao.saveOrUpdateAiBindInfo(userAiDO, null);
        processAfterUserRegister(user.getId());
        return user.getId();
    }


    /**
     * 用户注册完毕之后触发的动作
     *
     * @param userId
     */
    private void processAfterUserRegister(Long userId) {
        TransactionUtil.registryAfterCommitOrImmediatelyRun(new Runnable() {
            @Override
            public void run() {
                // 用户注册事件
                SpringUtil.publishEvent(new NotifyMsgEvent<>(this, NotifyTypeEnum.REGISTER, userId));
            }
        });
    }
}
