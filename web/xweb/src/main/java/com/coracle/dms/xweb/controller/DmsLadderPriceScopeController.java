package com.coracle.dms.xweb.controller;

import com.coracle.dms.service.DmsLadderPriceScopeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dmsLadderPriceScope")
public class DmsLadderPriceScopeController extends BaseController {
    private static final Logger logger = Logger.getLogger(DmsLadderPriceScopeController.class);

    @Autowired
    private DmsLadderPriceScopeService dmsLadderPriceScopeService;
}