package com.macro.mall.common.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis operation Service
 * Created by macro on 2020/3/3.
 */
public interface RedisService {

    /**
     * Save properties
     */
    void set(String key, Object value, long time);

    /**
     * Save properties
     */
    void set(String key, Object value);

    /**
     * Get attributes
     */
    Object get(String key);

    /**
     * Delete attribute
     */
    Boolean del(String key);

    /**
     * Delete attributes in bulk
     */
    Long del(List<String> keys);

    /**
     * Set expiration time
     */
    Boolean expire(String key, long time);

    /**
     * Get expiration time
     */
    Long getExpire(String key);

    /**
     * Determine whether there is this attribute
     */
    Boolean hasKey(String key);

    /**
     * Increment by delta
     */
    Long incr(String key, long delta);

    /**
     * Decrease by delta
     */
    Long decr(String key, long delta);

    /**
     * Get the attributes in the Hash structure
     */
    Object hGet(String key, String hashKey);

    /**
     * Put an attribute into the Hash structure
     */
    Boolean hSet(String key, String hashKey, Object value, long time);

    /**
     * Put an attribute into the Hash structure
     */
    void hSet(String key, String hashKey, Object value);

    /**
     * Get the entire Hash structure directly
     */
    Map<Object, Object> hGetAll(String key);

    /**
     * Set the entire Hash structure directly
     */
    Boolean hSetAll(String key, Map<String, Object> map, long time);

    /**
     * Set the entire Hash structure directly
     */
    void hSetAll(String key, Map<String, ?> map);

    /**
     * Delete the attributes in the Hash structure
     */
    void hDel(String key, Object... hashKey);

    /**
     * Determine whether there is this attribute in the Hash structure
     */
    Boolean hHasKey(String key, String hashKey);

    /**
     * Incremental attributes in the Hash structure
     */
    Long hIncr(String key, String hashKey, Long delta);

    /**
     * Attribute decreasing in Hash structure
     */
    Long hDecr(String key, String hashKey, Long delta);

    /**
     * Get the Set structure
     */
    Set<Object> sMembers(String key);

    /**
     * Add attributes to the Set structure
     */
    Long sAdd(String key, Object... values);

    /**
     * Add attributes to the Set structure
     */
    Long sAdd(String key, long time, Object... values);

    /**
     * Is it an attribute in Set
     */
    Boolean sIsMember(String key, Object value);

    /**
     * Get the length of the Set structure
     */
    Long sSize(String key);

    /**
     * Delete the attributes in the Set structure
     */
    Long sRemove(String key, Object... values);

    /**
     * Get the attributes in the List structure
     */
    List<Object> lRange(String key, long start, long end);

    /**
     * Get the length of the List structure
     */
    Long lSize(String key);

    /**
     * Get the attributes in the List according to the index
     */
    Object lIndex(String key, long index);

    /**
     * Add attributes to the List structure
     */
    Long lPush(String key, Object value);

    /**
     * Add attributes to the List structure
     */
    Long lPush(String key, Object value, long time);

    /**
     * Add attributes to the List structure in bulk
     */
    Long lPushAll(String key, Object... values);

    /**
     * Add attributes to the List structure in bulk
     */
    Long lPushAll(String key, Long time, Object... values);

    /**
     * Remove attributes from List structure
     */
    Long lRemove(String key, long count, Object value);
}