package com.example.carrot.web.trading;

import com.example.carrot.web.filter.CheckThreadLog;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/trading")
public class TradingControllerImpl implements TradingController {

    @Override
    @GetMapping("/itemList")
    public String mainTradingPage() {
        log.debug("[{}] get in",MDC.get(CheckThreadLog.LOG_ID));
        return "trading/itemList";
    }
}
