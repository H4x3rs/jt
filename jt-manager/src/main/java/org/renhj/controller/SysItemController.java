package org.renhj.controller;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.renhj.common.PageObject;
import org.renhj.common.Result;
import org.renhj.service.SysItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("items")
public class SysItemController {
    @Autowired
    private SysItemService itemService;

    @RequestMapping(value = "")
    public Result<PageObject> itemsList(@RequestParam("pageCurrent")Integer pageCurrent,
                                        @RequestParam("pageSize")Integer pageSize,
                                        @RequestParam("title")String title){
        return new Result<PageObject>(itemService.findItemByTitleWithPage(title, pageCurrent, pageSize));
    }

}
