package com.example.fiscodemo3.client;




import com.example.fiscodemo3.common.CommonClient;
import com.example.fiscodemo3.contract.Register;
import com.example.fiscodemo3.utils.SpringUtils;
import org.fisco.bcos.sdk.v3.BcosSDK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname CRUDClient
 * @Description sdk客户端，可以不使用ApplicationRunner，这里是让spring容器启动部署合约
 * @Date 2021/3/25 21:45
 * @Created by zyt
 */
@Service
public class UserClient extends CommonClient implements ApplicationRunner {

    public static final Logger logger = LoggerFactory.getLogger(UserClient.class.getName());


    public void register(String username, String password) {

        Register register = (Register) getContractMap().get("Register");
        register.registerUser(username, password);

    }

    public void Login(String username,String password)  {

        Register register = (Register) getContractMap().get("Register");
        register.loginUser(username, password);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BcosSDK sdk = SpringUtils.getBean("bcosSDK");
        deploy("Register", Register.class, sdk);
    }
}
