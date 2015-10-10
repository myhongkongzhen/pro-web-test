/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.server;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Enumeration;
import java.util.Properties;

import static z.z.w.test.util.PropertiesUtils.INSTANCE;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.server.InitializeServerImpl
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-10-7 10:40
 *   LastChange: 2015-10-7 10:40
 *      History:
 * </pre>
 **************************************************************************/
@Service
public class InitializeServerImpl implements IServiceLoader  {

    final static Logger logger = LoggerFactory.getLogger(InitializeServerImpl.class);
    final static String RELATIVE_PATH = "pro/services.properties";
    @Override
    public void destroy() {


    }

    @Override
    public void loadService(ApplicationContext webApplicationContext) {
        logger.info("Starting initialize beans service.....");
        logger.info("======>>>>{}.",webApplicationContext);
        try {
            Properties serviceProps = INSTANCE.getProperties(RELATIVE_PATH);
            if (serviceProps.isEmpty()) {
                logger.warn("沒有要執行的服務。。。。");
                return;
            }
            Enumeration<Object> keys = serviceProps.keys();
            while (keys.hasMoreElements())
                try {
                    String serviceId = keys.nextElement().toString();
                    String serviceName = serviceProps.getProperty(serviceId);
                    if (StringUtils.isBlank(serviceName)) continue;
//                    Runnable iServer = SpringContextUtil.getBean(Runnable.class, serviceName);
                    Runnable iServer = webApplicationContext.getBean(serviceName, Runnable.class);
                    if (null == iServer) continue;
                    logger.info("服務[{}-{}:{}]開始執行。。。。", serviceId, serviceName, iServer);
                    new Thread(iServer).start();
                } catch (Exception e) {
                    logger.error("Loading initialize beans error : {}.", e.getMessage(), e);
                }
        } catch (Exception e) {
            logger.error("Loading initialize beans error : {}.", e.getMessage(), e);
        }
        logger.info("Loaded initialize beans service.");
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        loadService();
//    }
}
