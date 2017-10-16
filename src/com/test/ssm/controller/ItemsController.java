package com.test.ssm.controller;

import com.test.ssm.pojo.Items;
import com.test.ssm.service.ItemService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin2.util.NativeLibLoader;

import java.util.List;

/**
 * Created by 陈志华 on 2017-10-15.
 */
@Controller
@RequestMapping("/item")
public class ItemsController {

    @Autowired
    private ItemService itemService;

    /**
     * 默认访问
     * @return
     */
    @RequestMapping
    public  String execute(){
        System.out.println("hello");
        return null;
    }

    /**
     * params 是请求参数
     * method 请求方法
     * @return
     */
    @RequestMapping(value = "/test",params = "list",method = RequestMethod.GET)
    @ResponseBody
    public List<Items> test(){

        List<Items> itemList = itemService.findAll();

        System.out.println("123");
        return itemList;
    }

    @RequestMapping("/loger")
    @ResponseBody
    public Items items(Items items){

        System.out.println(items.getName());
        return items;
    }


    @RequestMapping("/name")
    @ResponseBody
    public String name(@RequestParam String name){

        System.out.println(name);
        return name;
    }
    /**
     * 查询所有的商品
     */
    @RequestMapping("/list")
    public String  findItemList(Model model){

        List<Items> itemList = itemService.findAll();


        model.addAttribute("itemList", itemList);

        return "itemList";
    }




}
