package com.dxvalley.project.models;

import java.util.List;

import lombok.Data;

@Data
public class PrCooperativesExportData {
    
        private String prCooperativeName;
        private Address address;
        private Type type;
        private Sector sector;
        private List<CommodityDto> Commodities;
        private Integer no_of_Male_Individual_Member;
        private Integer no_of_Female_Individual_Member;
        private Integer Total_no_of_Individual_Member;
        private List<AccountInfo> accountInfos;
        private String yearOfStablishment;
        private Double shareCapitalUponEstablishmnet;
        private Integer no_of_Male_Establishing_Member;
        private Integer no_of_Female_Establishing_Member;
        private Integer no_of_Total_Establishing_Member;
        private List<AnnualSellDto> annualSells;
        private List<TotalCapitalDto> totalCapitals;
        private List<AssetDto> assets;
        private List<LiabilityDto> liabilities;
        private List<PaidUpShareDto> paidUpShares;
        private List<OsLoanDto> osLoans;
        


}  
