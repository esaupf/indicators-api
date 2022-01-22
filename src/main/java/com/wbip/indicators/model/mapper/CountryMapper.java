package com.wbip.indicators.model.mapper;

import com.wbip.indicators.model.Country;
import org.mapstruct.Mapper;

import java.util.LinkedHashMap;

@Mapper(componentModel = "spring")
public interface CountryMapper extends GenericMapper<Country>{

    default Country map(LinkedHashMap<String, ?> map) {

        Country country = new Country();
        country.setCode((String) map.get("id"));
        country.setName((String) map.get("name"));

        return country;
    }

}
