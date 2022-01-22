package com.wbip.indicators.component.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface WorldBankApiClient {

    @RequestLine("GET /country?format=json&per_page=500")
    @Headers({"Content-Type: application/json"})
    List findAllCountries();

    @RequestLine("GET /country/{code}/indicator/SI.POV.DDAY?format=json")
    @Headers({"Content-Type: application/json"})
    List findIndicatorsByCountryCode(@Param(value = "code") String code);

}
