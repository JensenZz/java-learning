package zookeeper.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company:人人行科技 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 2017/2/17
 */

public class LogUtils {
    private static final Logger perfLogger = LoggerFactory.getLogger("PERF");

    public LogUtils() {
    }

    public static void dumpPerf(String dumpValue) {
        if(perfLogger.isInfoEnabled()) {
            perfLogger.info(dumpValue);
        }

    }

    public static void debug(Logger logger, String msg, Object... params) {
        if(logger.isDebugEnabled()) {
            logger.debug(String.format(msg, params));
        }

    }

    public static void debug(Logger logger, String msg) {
        if(logger.isDebugEnabled()) {
            logger.debug(msg);
        }

    }

    public static void info(Logger logger, String msg, Object... params) {
        if(logger.isInfoEnabled()) {
            logger.info(String.format(msg, params));
        }

    }

    public static void info(Logger logger, String msg) {
        if(logger.isInfoEnabled()) {
            logger.info(msg);
        }

    }

    public static void warn(Logger logger, String msg, Object... params) {
        if(logger.isWarnEnabled()) {
            logger.warn(String.format(msg, params));
        }

    }

    public static void warn(Logger logger, Throwable e, String msg, Object... params) {
        if(logger.isWarnEnabled()) {
            logger.warn(String.format(msg, params), e);
        }

    }

    public static void error(Logger logger, Throwable e, String msg, Object... params) {
        logger.error(String.format(msg, params), e);
    }

    public static void error(Logger logger, String msg, Object... params) {
        logger.error(String.format(msg, params));
    }

    public static void debug(String metric, String errorcode, Logger logger, String msg, Object... params) {
        msg = " [monitor][" + metric + "][" + errorcode + "]" + msg;
        debug(logger, msg, params);
    }

    public static void info(String metric, String errorcode, Logger logger, String msg, Object... params) {
        msg = " [monitor][" + metric + "][" + errorcode + "]" + msg;
        info(logger, msg, params);
    }

    public static void warn(String metric, String errorcode, Logger logger, String msg, Object... params) {
        msg = " [monitor][" + metric + "][" + errorcode + "]" + msg;
        warn(logger, msg, params);
    }

    public static void error(String metric, String errorcode, Logger logger, String msg, Object... params) {
        msg = " [monitor][" + metric + "][" + errorcode + "]" + msg;
        error(logger, msg, params);
    }

    public static void error(String metric, String errorcode, Logger logger, Throwable e, String msg, Object... params) {
        msg = " [monitor][" + metric + "][" + errorcode + "]" + msg;
        error(logger, e, msg, params);
    }

    public static String getStackTrace(Throwable throwable) {
        if(throwable == null) {
            return "";
        } else {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }
}
