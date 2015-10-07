/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.ServiceLoader;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.server.Initialize
 *         Desc: Initialize class
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-10-7 11:42
 *   LastChange: 2015-10-7 11:42
 *      History:
 * </pre>
 **************************************************************************/
@Controller
public class Initialize implements InitializingBean {
    final static Logger logger = LoggerFactory.getLogger(Initialize.class);

    public WebApplicationContext getWebApplicationContext() {
        return webApplicationContext;
    }

    @Resource
    public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    private WebApplicationContext webApplicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        final ServiceLoader<IServiceLoader> loader = ServiceLoader.load(IServiceLoader.class);

        logger.debug("Service will be starting...");
        for (IServiceLoader service : loader)
            service.loadService(webApplicationContext);
        logger.debug("Service is started!");
    }
}
