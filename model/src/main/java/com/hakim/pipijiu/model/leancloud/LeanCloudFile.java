package com.hakim.pipijiu.model.leancloud;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/3 17:39 <br/>
 * Desc  : 上传的文件属性
 */
public class LeanCloudFile {
    /**
     * size : 13
     * bucket : 1qdney6b
     * url : http://ac-1qdney6b.qiniudn.com/3zLG4o0d27MsCQ0qHGRg4JUKbaXU2fiE35HdhC8j.txt
     * name : hello.txt
     * createdAt : 2014-10-14T05:55:57.455Z
     * objectId : 543cbaede4b07db196f50f3c
     */

    private int size;
    private String bucket;
    private String url;
    private String name;
    private String createdAt;
    private String objectId;

    public int getSize() {
        return size;
    }

    public String getBucket() {
        return bucket;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getObjectId() {
        return objectId;
    }
}
