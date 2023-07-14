package com.dxvalley.project.models;

import java.util.List;

import lombok.Data;

@Data
public class AccountInfo {
    private String AccountNumber;
    private String branch;
    private String district;
    private List<AccountBalance> AccountBalances;
}
