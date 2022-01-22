package com.wbip.indicators.service;

import com.wbip.indicators.component.client.WorldBankApiClient;
import com.wbip.indicators.model.Country;
import com.wbip.indicators.model.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private WorldBankApiClient worldBankApiClient;

    public List<Country> findAll() {
        return countryMapper.mapToList((ArrayList<?>) worldBankApiClient.findAllCountries().get(1));
    }


}
