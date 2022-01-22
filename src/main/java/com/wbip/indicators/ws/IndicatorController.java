package com.wbip.indicators.ws;

import com.wbip.indicators.service.IndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "IndicatorController")
@RequestMapping(value = "/indicator")
public class IndicatorController {

    @Autowired
    private IndicatorService indicatorService;

    @GetMapping(value = "/{countryCode}")
    public ResponseEntity findById(@PathVariable("countryCode") String countryCode) {
        return ResponseEntity.ok(indicatorService.findByCountryCode(countryCode));
    }

}
