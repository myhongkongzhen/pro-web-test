/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/*********************************************************************************************
 * <pre>
 *     FileName: z.z.w.test.service.impl.TestAnnServiceImpl
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-10-10 17:55
 *   LastChange: 2015-10-10 17:55
 *      History:
 * </pre>
 *********************************************************************************************/
@Service
public class TestAnnServiceImpl extends TestAnnServiceFactory {


    @Override
    public void taskList() {
        logger.info("taskList.....");
    }

    @Async
    @Override
    public void execute() throws Exception {
        logger.info("execute....");
        Thread.sleep(4000);
        taskList();
        logger.info("execute........end.....");
    }

    @Async
    @Override
    public Future<String> aysnFuter() throws Exception {
        logger.info("aysnFuter....");
        Thread.sleep(5000);
        taskList();
        logger.info("aysnFuter........end.....");

        return new AsyncResult<String>("OKKKKKKKKKKKKK");
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

    }
}
