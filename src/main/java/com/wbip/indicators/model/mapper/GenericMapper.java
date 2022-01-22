package com.wbip.indicators.model.mapper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public interface GenericMapper<T> {

    T map(LinkedHashMap<String, ?> map);

    default List<T> mapToList(ArrayList<?> list) {
        List<T> indicatorDataList = new ArrayList<>();
        list.forEach(countryMap -> {
            LinkedHashMap<String, ?> c = (LinkedHashMap<String, ?>) countryMap;
            indicatorDataList.add((T) this.map(c));
        });

        return indicatorDataList;
    }

}
