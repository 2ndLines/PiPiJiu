package com.hakim.pipijiu.model.leancloud;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/3 11:52 <br/>
 * Desc  :
 */
public class Counter {
    public static final String OP_INCREMENT = "increment";
    public static final String OP_DECREMENT = "decrement";
    private String __op;
    private int amount;

    public Counter(String op, int amount) {
        this.__op = op;
        this.amount = amount;
    }

    public String buildBody(String field) {
        try {
            JSONObject object = new JSONObject();
            object.put(field, this);
            return object.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

}
