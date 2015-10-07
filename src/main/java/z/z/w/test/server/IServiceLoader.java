/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.server;

import org.springframework.context.ApplicationContext;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.server.IServiceLoader
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-10-7 10:39
 *   LastChange: 2015-10-7 10:39
 *      History:
 * </pre>
 **************************************************************************/
public interface IServiceLoader {
    void destroy();

    void loadService(ApplicationContext applicationContext);
}
