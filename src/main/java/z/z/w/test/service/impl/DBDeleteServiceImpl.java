/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import z.z.w.test.service.IService;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.service.impl.DBDeleteServiceImpl
 *         Desc: 測試實現類
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-10-7 11:06
 *   LastChange: 2015-10-7 11:06
 *      History:
 * </pre>
 **************************************************************************/
//@Service
public class DBDeleteServiceImpl implements IService {

    final static Logger logger = LoggerFactory.getLogger(DBDeleteServiceImpl.class);


    @Override
    public void execute() throws Exception {
        logger.info("開始刪除數據庫數據...");
        Thread.sleep(1000);
        logger.info("刪除數據操作完成....");
    }

    @Override
    public void run() {
        try {
            execute();
        } catch (Exception e) {
            logger.error("刪除數據出错:" + e.getMessage(), e);
        }
    }
}
