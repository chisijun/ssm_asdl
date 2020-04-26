package org.study.asdl.netty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2020-04-26 14:40
 * @Description:
 */
@Slf4j
@Service
public class NettyExecutorService {

    public NettyExecutorService() {

        //为了颜色一致，我们用管理Err输出
        log.info("=====> netty : Spring自动加载");
        log.info("=====> netty : 启动Netty线程池");

        /* 说明
         * 如果此处不用线程池，直接用server.run()启动【直接调用方法而已】
         * 那么你会看到tomcat启动过程中，在启动了Netty后就会一直等待连接
         */
        NettyServer server = new NettyServer();
        //线程池
        ExecutorService es = Executors.newCachedThreadPool();
        //启动线程池
        es.execute(server);

    }

}
