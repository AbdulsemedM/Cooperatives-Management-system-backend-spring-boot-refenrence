package com.dxvalley.project.models;

import java.util.List;


import lombok.Data;

@Data
public class UnionsExportData {
    private String unionName;
    private Address address;
    private Type type;
    private Sector sector;
    private List<CommodityDto> Commodities;
    private Integer no_of_ActivePrCooperatives;
    private Integer no_of_Non_ActivePrCooperatives;
    private Integer total_No_of_PrCooperatives;
    private Integer no_of_Female_Individual_Member;
    private Integer no_of_Male_Individual_Member;
    private Integer Total_no_of_Individual_Member;
    //private List<Job> jobs;
    private List<AccountInfo> accountInfos;
    private String yearOfStablishment;
    private Integer no_of_Female_Stablishing_Member;
    private Integer no_of_Male_Stablishing_Member;
    private Integer no_of_Total_Stablishing_Member;
    private Double shareCapitalUponEstablishmnet;
    private List<AnnualTurnOverDto> annualTurnOvers;
    private List<AssetDto> assets;
    private List<LiabilityDto> liabilities;
    private List<PaidUpShareDto> paidUpShares;
    private List<OsLoanDto> osLoans;
    
}

