package com.macro.mall.portal.service;

/**
 * redis operation Service,
 * Objects and arrays are stored in json
 * Created by macro on 2018/8/7.
 */
public interface RedisService {
    /**
     * Storing data
     */
    void set(String key, String value);

    /**
     * retrieve data
     */
    String get(String key);

    /**
     * Set expiration time
     */
    boolean expire(String key, long expire);

    /**
     * delete data
     */
    void remove(String key);

    /**
     * Increment operation
     * @param delta Increment step size
     */
    Long increment(String key, long delta);

}
