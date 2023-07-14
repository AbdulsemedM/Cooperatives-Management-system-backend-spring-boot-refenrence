package com.dxvalley.project.models;

import java.util.List;

import lombok.Data;

@Data
public class PrPerformanceReportDTO {
    private String prName;
    private String sector;
    private String type;
    private String region;
    private String zone;
    private List<AccountInfo> accountInfos;
    private Double osLoanBalance;
    private List<OsLoanDto> osLoans;
    private List<PaidUpShareDto> paidUpShares;

}
