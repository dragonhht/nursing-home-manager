package com.github.dragonhht.manager.controller;

import com.github.dragonhht.manager.controller.base.BaseController;
import com.github.dragonhht.manager.model.LogRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description.
 * User: huang
 * Date: 18-10-13
 */
@RestController
@RequestMapping("/logRecord")
public class LogRecordController extends BaseController<LogRecord, Integer> {
}
