package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.Bed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description.
 * User: huang
 * Date: 18-9-20
 */
@RestController
@RequestMapping("/bed")
public class BedController extends BaseController<Bed, String> {
}
