package com.sringproject.springbackendapi.common;

import java.sql.Date;

public class SearchCriteria {
    private String status;
    private String type;
    private Date endDate;
    private Date startDate;

    public SearchCriteria(String status, String type, Date endDate, Date startDate) {
        this.status = status;
        this.type = type;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }
}
