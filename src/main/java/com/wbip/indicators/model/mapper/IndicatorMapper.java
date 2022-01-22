package com.wbip.indicators.model.mapper;

import com.wbip.indicators.model.IndicatorData;
import org.mapstruct.Mapper;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface IndicatorMapper extends GenericMapper<IndicatorData> {

    default IndicatorData map(LinkedHashMap<String, ?> map) {

        IndicatorData indicatorData = new IndicatorData();

        Map indicatorMap = (Map) map.get("indicator");
        IndicatorData.Indicator indicator = new IndicatorData.Indicator((String) indicatorMap.get("id"), (String) indicatorMap.get("value"));
        indicatorData.setIndicator(indicator);

        Map countryMap = (Map) map.get("country");
        IndicatorData.Country country = new IndicatorData.Country((String) countryMap.get("id"), (String) countryMap.get("value"));
        indicatorData.setCountry(country);

        indicatorData.setCountryiso3code((String) map.get("countryiso3code"));
        int year = Integer.parseInt((String) map.get("date"));
        indicatorData.setDate(LocalDate.ofYearDay(year, 1));

        indicatorData.setValue((Number) map.get("value"));
        indicatorData.setUnit((String) map.get("unit"));
        indicatorData.setObsStatus((String) map.get("obs_status"));
        indicatorData.setDecimal((Integer) map.get("decimal"));


        return indicatorData;
    }

}
