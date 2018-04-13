package com.kobe.mall.common.utils;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Jedis操作工具类
 * Created by zhongcy on 2016/6/6.
 */
public class JedisUtils {

    private static final Logger logger = LoggerFactory.getLogger(JedisUtils.class);

    private static String redisIp;

    private static int redisPort;

    private static int database;

    private static int timeout;

    public String getRedisIp() {
        return redisIp;
    }

    public void setRedisIp(String redisIp) {
        JedisUtils.redisIp = redisIp;
    }

    public int getRedisPort() {
        return redisPort;
    }

    public void setRedisPort(int redisPort) {
        JedisUtils.redisPort = redisPort;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        JedisUtils.database = database;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        JedisUtils.timeout = timeout;
    }

    private static JedisPool jedisPool;


    public static void initPool() {
        if (jedisPool == null) {
            jedisPool = new JedisPool(new GenericObjectPoolConfig(), redisIp, redisPort, timeout, null, 1);
        }
    }

    public static Jedis getInstance() {
        return jedisPool.getResource();
    }

    public static String getStringValue(String key) {
        Jedis jedis = null;
        try {
            if (isExists(key)) {
                jedis = jedisPool.getResource();
                return jedis.get(key);
            }
        } catch (Exception e) {
            logger.error("jedisException", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    public static void setStringValue(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            logger.error("jedisException", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public static boolean isExists(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis.exists(key)) {
                return true;
            }
        } catch (Exception e) {
            logger.error("jedisException", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    public static void setObjValue(byte[] key, byte[] value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e1) {
            logger.error("jedisException", e1);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
