package com.hakim.pipijiu.model.data.remote;

import com.google.gson.reflect.TypeToken;
import com.hakim.pipijiu.model.entities.Order;
import com.hakim.pipijiu.model.leancloud.LeanCloudRemoteDataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * OKLine(ShenZhen) co.,Ltd.<br/>
 * 作者 : Shi Haijun <br/>
 * 邮箱 : haijun@okline.cn<br/>
 * 日期 : 2017/2/15 <br/>
 * 描述 : 在这里描述Class的主要功能
 */
public class RemoteDataSourceTest {
    private RemoteDataSource<Order> dataSource;
    private final LeanCloudRemoteDataSource<Order> remoteDataSource = new LeanCloudRemoteDataSource<>("Order");

    @Before
    public void setUp() throws Exception {


        dataSource = new RemoteDataSource<>(remoteDataSource);
    }

    @After
    public void tearDown() throws Exception {
        dataSource = null;

    }

    @Test
    public void insert() throws Exception {
        long id = dataSource.insert(new Order("20170215AC")).toBlocking().single();
        assertTrue(id != -1);
    }

    @Test
    public void delete() throws Exception{
        long id = dataSource.delete("58a3d222b123db00545eaabd").toBlocking().single();
        assertTrue(id!= 0);
    }

    @Test
    public void detail() throws Exception{
        Order order = dataSource.detail("58a43fcb128fe10058c8c52f", new TypeToken<Order>(){}.getType()).toBlocking().single();
        assertNotNull(order);
    }
}