package com.wbip.indicators.service;

import com.wbip.indicators.component.client.WorldBankApiClient;
import com.wbip.indicators.model.IndicatorData;
import com.wbip.indicators.model.mapper.IndicatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndicatorService {

    @Autowired
    private IndicatorMapper indicatorMapper;

    @Autowired
    private WorldBankApiClient worldBankApiClient;

    public List<IndicatorData> findByCountryCode(String countryCode) {
        return indicatorMapper.mapToList((ArrayList<?>) worldBankApiClient.findIndicatorsByCountryCode(countryCode).get(1));
    }


}
