package com.wbip.indicators.ws;

import com.wbip.indicators.model.Country;
import com.wbip.indicators.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "CountryController")
@RequestMapping(value = "/country")
@Api(value = "Country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    @ApiOperation(value = "List Countries")
    public ResponseEntity<List<Country>> findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

}
