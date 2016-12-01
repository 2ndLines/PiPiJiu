package com.hakim.pipijiu.data.rest;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/29 16:55 <br/>
 * Desc  : LeanCloud session cache
 */
public class LeanCloudCache {
    private static final String KEY_TOKEN = "token";
    private static final String KEY_OBJECT_ID = "object_id";
    private static LeanCloudCache instance;
    private final Cache<String, String> cache;

    public static LeanCloudCache getInstance() {
        if (instance == null) {
            synchronized (LeanCloudCache.class) {
                LeanCloudCache cache = instance;
                if (cache == null) {
                    cache = new LeanCloudCache();
                }
                instance = cache;
            }
        }

        return instance;
    }

    private LeanCloudCache() {
        this.cache = CacheBuilder.newBuilder().build();
    }

    public String getToken() {
        return cache.getIfPresent(KEY_TOKEN);
    }

    public void setToken(String token) {
        cache.put(KEY_TOKEN, token);
    }

    public String getObjectId() {
        return cache.getIfPresent(KEY_OBJECT_ID);
    }

    public void setObjectId(String objectId) {
        cache.put(KEY_OBJECT_ID, objectId);
    }
}
