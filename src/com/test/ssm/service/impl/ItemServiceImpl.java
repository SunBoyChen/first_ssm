package com.test.ssm.service.impl;

import com.test.ssm.mapper.ItemsMapper;
import com.test.ssm.pojo.Items;
import com.test.ssm.pojo.ItemsExample;
import com.test.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 陈志华 on 2017-10-15.
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemsMapper itemsMapper;

    public List<Items> findAll(){
        List<Items> items = itemsMapper.selectByExample(null);
        return  items;
    }
}
