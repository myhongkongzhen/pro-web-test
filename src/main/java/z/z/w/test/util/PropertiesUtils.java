/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Properties;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.util.PropertiesUtils
 *         Desc: 屬性文件讀取工具類
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-10-7 10:43
 *   LastChange: 2015-10-7 10:43
 *      History:
 * </pre>
 **************************************************************************/
public enum PropertiesUtils {
    INSTANCE;

    private PropertiesUtils() {
    }

    /**
     * 获取指定的整型属性值
     * Create by : 2015年9月22日 上午10:34:22
     *
     * @param props      属性集，如果为Null，则从系统属性获取
     * @param propName   属性名
     * @param allowEmpty 是否允许为空
     * @return 整型属性值
     * @throws IllegalArgumentException 当不允许为空且属性值为空或属性值不是整型时
     */
    public int getIntProp(Properties props, String propName, boolean allowEmpty) {
        try {
            return Integer.parseInt(getProp(props, propName, allowEmpty));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(propName + " isn't a integer!");
        }
    }

    /**
     * 获取指定的整型属性值
     * Create by : 2015年9月22日 上午10:34:22
     *
     * @param props      属性集，如果为Null，则从系统属性获取
     * @param propName   属性名
     * @param defaultVal 默认值， 如果属性值为空，则返回默认值
     * @return 整型属性值
     */
    public int getIntProp(Properties props, String propName, int defaultVal) {
        try {
            String val = getProp(props, propName, null);
            if (val == null) return defaultVal;
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(propName + " isn't a integer!");
        }
    }

    /**
     * 获取指定的长整型属性值
     * Create by : 2015年9月22日 上午10:34:22
     *
     * @param props      属性集，如果为Null，则从系统属性获取
     * @param propName   属性名
     * @param allowEmpty 是否允许为空
     * @return 长整型属性值
     * @throws IllegalArgumentException 当不允许为空且属性值为空或属性值不是长整型时
     */
    public long getLongProp(Properties props, String propName, boolean allowEmpty) {
        try {
            return Long.parseLong(getProp(props, propName, allowEmpty));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(propName + " isn't a long!");
        }
    }

    /**
     * 获取指定的长整型属性值
     * Create by : 2015年9月22日 上午10:34:22
     *
     * @param props      属性集，如果为Null，则从系统属性获取
     * @param propName   属性名
     * @param defaultVal 默认值， 如果属性值为空，则返回默认值
     * @return 长整型属性值
     */
    public long getLongProp(Properties props, String propName, long defaultVal) {
        try {
            String val = getProp(props, propName, null);
            if (val == null) return defaultVal;
            return Long.parseLong(val);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(propName + " isn't a long!");
        }
    }

    /**
     * 获取指定的属性值
     * Create by : 2015年9月22日 上午10:34:22
     *
     * @param props      属性集，如果为Null，则从系统属性获取
     * @param propName   属性名
     * @param allowEmpty 是否允许为空，如果为不允许且属性值为空则抛出异常
     * @return 属性值
     * @throws IllegalArgumentException 当不允许为空且属性值为空时
     */
    public String getProp(Properties props, String propName, boolean allowEmpty) {
        String prop = null;
        if (props != null) prop = props.getProperty(propName);
        else prop = System.getProperty(propName);
        if (!allowEmpty && isEmpty(prop)) throw new IllegalArgumentException(propName + " is empty!");
        return prop;
    }

    /**
     * 获取指定的属性值
     * Create by : 2015年9月22日 上午10:34:22
     *
     * @param props      属性集，如果为Null，则从系统属性获取
     * @param propName   属性名
     * @param defaultVal 默认值， 如果属性值为空，则返回默认值
     * @return 属性值
     */
    public String getProp(Properties props, String propName, String defaultVal) {
        String prop = null;
        if (props != null) prop = props.getProperty(propName);
        else prop = System.getProperty(propName);
        if (isEmpty(prop)) prop = defaultVal;
        return prop;
    }

    /**
     * 获取属性集
     * Create by : 2015年9月22日 上午10:34:22
     *
     * @param relativePath 文件相对路径，相对于类路径
     * @return 属性集
     * @throws Exception 当发生异常时
     */
    public Properties getProperties(String relativePath) throws Exception {
        Properties serverProps = new Properties();
        URL url = Thread.currentThread().getContextClassLoader().getResource(relativePath);
        if (url == null) throw new FileNotFoundException(relativePath);
        serverProps.load(new FileInputStream(new File(url.toURI())));
        return serverProps;
    }

    /**
     * Create by : 2015年9月22日 上午10:38:46
     *
     * @param prop
     * @return
     */
    private boolean isEmpty(String prop) {
        return ((prop == null) || (prop.length() == 0));
    }
}
