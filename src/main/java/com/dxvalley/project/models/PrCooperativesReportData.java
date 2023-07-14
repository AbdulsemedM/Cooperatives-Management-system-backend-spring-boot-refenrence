package com.dxvalley.project.models;

import lombok.Data;

@Data
public class PrCooperativesReportData {

    private String prCooperativeName;
    private String yearOfStablishment;
    private Integer no_of_Male_Establishing_Member;
    private Integer no_of_Female_Establishing_Member;
    private Integer no_of_Total_Establishing_Member;
    private Double shareCapitalUponEstablishmnet;
    private String licensingOrgan;
    private Integer no_Of_MaleMembers;
    private Integer no_Of_FemaleMembers;
    private Integer maleMembersUpOnEstablishement;
    private Integer femaleMembersUpOnEstablishement; 
    private Integer jobOpportunityCreated;
}
