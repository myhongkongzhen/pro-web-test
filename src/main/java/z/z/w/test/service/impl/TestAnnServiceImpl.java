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
import z.z.w.test.service.IBussOper;
import z.z.w.test.service.IService;

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
public class TestAnnServiceImpl implements IBussOper, IService
{
	Logger logger = LoggerFactory.getLogger( TestAnnServiceImpl.class );

	@Override public void taskList()
	{
		logger.info( "taskList....." );
	}

	@Override public void execute() throws Exception
	{
		logger.info( "execute...." );
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
	@Override public void run()
	{

	}
}
