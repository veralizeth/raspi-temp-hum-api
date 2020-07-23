package com.tempo.tempehum.accessingdatapostgres.utils;

import java.util.Date;
import java.util.List;

public class DataSummary <T> {
    public List<T> summarizeData(Date startDate, Date endDate, List<T> data) {
        System.out.println(data);
        return data;
    }
}
