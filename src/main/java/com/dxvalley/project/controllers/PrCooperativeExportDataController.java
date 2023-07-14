    package com.dxvalley.project.controllers;

import java.util.ArrayList;
import java.util.List;
    
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
    
import com.dxvalley.project.models.Account;
import com.dxvalley.project.models.AccountBalance;
import com.dxvalley.project.models.AccountInfo;
import com.dxvalley.project.models.AnnualSell;
import com.dxvalley.project.models.AnnualSellDto;
import com.dxvalley.project.models.Asset;
import com.dxvalley.project.models.AssetDto;
import com.dxvalley.project.models.Commodity;
import com.dxvalley.project.models.CommodityDto;
import com.dxvalley.project.models.LiabilityDto;
import com.dxvalley.project.models.Liabilty;
import com.dxvalley.project.models.Member;
import com.dxvalley.project.models.OsLoan;
import com.dxvalley.project.models.OsLoanDto;
import com.dxvalley.project.models.PaidUpShare;
import com.dxvalley.project.models.PaidUpShareDto;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.PrCooperativesExportData;
import com.dxvalley.project.models.PrCooperativesReportData;
import com.dxvalley.project.models.PrPerformanceReportDTO;
import com.dxvalley.project.models.TotalCapital;
import com.dxvalley.project.models.TotalCapitalDto;
import com.dxvalley.project.services.AccountBalanceService;
import com.dxvalley.project.services.AccountService;
import com.dxvalley.project.services.AnnualSellService;
import com.dxvalley.project.services.AssetService;
import com.dxvalley.project.services.CommodityService;
import com.dxvalley.project.services.LiabilityService;
import com.dxvalley.project.services.MemberService;
import com.dxvalley.project.services.OsLoanService;
import com.dxvalley.project.services.PaidUpShareService;
import com.dxvalley.project.services.PrCooperativeService;
import com.dxvalley.project.services.TotalCapitalService;

    
    import lombok.RequiredArgsConstructor;

    @RequiredArgsConstructor
    @RestController
    @RequestMapping("/api/prCooperativeExport")
    public class PrCooperativeExportDataController {
        @Autowired

        private final PrCooperativeService prCooperativeService;
        private final CommodityService commodityService;
        private final MemberService memberService;
        private final AccountService accountService;
        private final AccountBalanceService accountBalanceService;
        private final TotalCapitalService totalCapitalService;
        private final AssetService assetService;
        private final AnnualSellService annualSellService;
        private final LiabilityService liabilityService;
        private final PaidUpShareService paidUpShareService;
        private final OsLoanService osLoanService;
        
        private int no_of_Male_Establishing_Member=0;
        private int no_of_Female_Establishing_Member=0;
        private int no_of_Total_Establishing_Member=0;
    
        @GetMapping("/getPrCooperativesExport")
        List<PrCooperativesExportData> getPrCooperatives() {
        List<PrCooperativesExportData> prCooperativesExportDatas= new ArrayList<PrCooperativesExportData>();
        List<PrCooperative> prCooperatives=prCooperativeService.getPrCooperative();  
        prCooperatives.stream().forEach(pr->{
            PrCooperativesExportData prCooperativesExportData= new PrCooperativesExportData();
            prCooperativesExportData.setPrCooperativeName(pr.getName());
            prCooperativesExportData.setAddress(pr.getAddress());
            prCooperativesExportData.setType(pr.getType());
            prCooperativesExportData.setSector(pr.getSector());
            List<Commodity> commodities=commodityService.getCommodityByPrCooperative(pr);
            List<CommodityDto> commodityDtos=new ArrayList<CommodityDto>();
            commodities.stream().forEach(c->{
                CommodityDto commodityDto= new CommodityDto();
                commodityDto.setCommodityName(c.getCommodityName());
                commodityDto.setType(c.getType());
                commodityDtos.add(commodityDto);
            });
            prCooperativesExportData.setCommodities(commodityDtos);
            List<Member> maleMembers=memberService.getMembersByPrCooperativeAndGender(pr, "MALE"); 
            prCooperativesExportData.setNo_of_Male_Individual_Member(maleMembers.size());
            List<Member> femaleMembers=memberService.getMembersByPrCooperativeAndGender(pr, "FEMALE");
            prCooperativesExportData.setNo_of_Female_Individual_Member(femaleMembers.size());
            List<Member> totalMembers=memberService.getMemberByPrCooperative(pr);
            prCooperativesExportData.setTotal_no_of_Individual_Member(totalMembers.size());
            List<Account> accounts=accountService.getAccountByPrCooperative(pr);
            List<AccountInfo> accountInfos= new ArrayList<AccountInfo>();
            accounts.stream().forEach(y->{
                AccountInfo accountInfo= new AccountInfo();
                accountInfo.setAccountNumber(y.getAccountNumber());
                accountInfo.setBranch(y.getBranch());
                accountInfo.setDistrict(y.getDistrict());
                List<AccountBalance> accountBalances=accountBalanceService.getAccountBalancesByAccount(y);
                accountInfo.setAccountBalances(accountBalances);
                accountInfos.add(accountInfo);
            });
            prCooperativesExportData.setAccountInfos(accountInfos);
            prCooperativesExportData.setYearOfStablishment(pr.getDateOfEstablishmnet());
            no_of_Male_Establishing_Member=0;
            maleMembers.stream().forEach(z->{
                if(z.getIsFounder()==true){
                    no_of_Male_Establishing_Member++;
                }
            });
            prCooperativesExportData.setNo_of_Male_Establishing_Member(no_of_Male_Establishing_Member);
    
            no_of_Female_Establishing_Member=0;
            femaleMembers.stream().forEach(a->{
                if(a.getIsFounder()==true)
                {
                    no_of_Female_Establishing_Member++;
                }
            });
            prCooperativesExportData.setNo_of_Female_Establishing_Member(no_of_Female_Establishing_Member);
            no_of_Total_Establishing_Member=0;
            totalMembers.stream().forEach(b->{
                if(b.getIsFounder()==true){
                    no_of_Total_Establishing_Member++;
                }
            });
            prCooperativesExportData.setNo_of_Total_Establishing_Member(no_of_Total_Establishing_Member);
            prCooperativesExportData.setShareCapitalUponEstablishmnet(pr.getShareCapitalUponEstablishmnet());
            List<AnnualSell> annualSells=annualSellService.getAnnualSellByPrCooperative(pr); 
            List<AnnualSellDto> annualSellDtos= new ArrayList<AnnualSellDto>();
            annualSells.stream().forEach(an->{
                AnnualSellDto annualSellDto = new AnnualSellDto(); 
                annualSellDto.setAnnualSellValue(an.getAnnualSellValue());   
                annualSellDto.setDateGenerated(an.getDateGenerated());
                annualSellDtos.add(annualSellDto);
            });
            prCooperativesExportData.setAnnualSells(annualSellDtos);
            
            List<TotalCapital> totalCapitals=totalCapitalService.getTotalCapitalByPrCooperative(pr) ;
            List<TotalCapitalDto> totalCapitalDtos= new ArrayList<TotalCapitalDto>();
            totalCapitals.stream().forEach(tc->{
                TotalCapitalDto totalCapitalDto= new TotalCapitalDto();
              totalCapitalDto.setTotalCapitalValue(tc.getTotalCapitalValue());
              totalCapitalDto.setDateGenerated(tc.getDateGenerated());
              totalCapitalDtos.add(totalCapitalDto);
            });
            prCooperativesExportData.setTotalCapitals(totalCapitalDtos);


            List<Asset> assets=assetService.getAssetByPrCooperative(pr);
            List<AssetDto> assetDtos= new ArrayList<AssetDto>();
            assets.stream().forEach(as->{
                AssetDto assetDto= new AssetDto();
                assetDto.setAssetName(as.getAssetName());
                assetDto.setType(as.getType());
                assetDto.setValue(as.getValue());
                assetDtos.add(assetDto);
            });
            prCooperativesExportData.setAssets(assetDtos);
            List<Liabilty> liabilties=liabilityService.getLiabiltyByPrCooperative(pr);
            List<LiabilityDto> liabilityDtos= new ArrayList<LiabilityDto>();
            liabilties.stream().forEach(l->{
                LiabilityDto liabilityDto= new LiabilityDto();
                liabilityDto.setLiabilityValue(l.getLiabilityValue());
                liabilityDto.setDateGenerated(l.getDateGenerated());
                liabilityDtos.add(liabilityDto);
            });
            prCooperativesExportData.setLiabilities(liabilityDtos);
            List<PaidUpShare> paidUpShares=paidUpShareService.getPaidUpShareByPrCooperative(pr);
            List<PaidUpShareDto> paidUpShareDtos= new ArrayList<PaidUpShareDto>();
            paidUpShares.stream().forEach(p->{
                PaidUpShareDto paidUpShareDto= new PaidUpShareDto();
                paidUpShareDto.setPaidUpValue(p.getPaidUpValue());
                paidUpShareDto.setDateGenerated(p.getDateGenerated());
                paidUpShareDtos.add(paidUpShareDto);
            });
            prCooperativesExportData.setPaidUpShares(paidUpShareDtos);
            List<OsLoan> osLoans=osLoanService.getOsLoanByPrCooperative(pr);
            List<OsLoanDto> osLoanDtos= new ArrayList<OsLoanDto>();
            osLoans.stream().forEach(os->{
                OsLoanDto osLoanDto= new OsLoanDto();
                osLoanDto.setOsLoanValue(os.getOsLoanValue());
                osLoanDto.setDateGenerated(os.getDateGenerated());
                osLoanDtos.add(osLoanDto);
            });
            prCooperativesExportData.setOsLoans(osLoanDtos);
            prCooperativesExportDatas.add(prCooperativesExportData);   
        });
        return prCooperativesExportDatas;
      }
    
      @GetMapping("/prPerformanceReport")
      List<PrPerformanceReportDTO> getPrPerformanceReport() {
        List<PrPerformanceReportDTO> prPerformanceReportDTOs= new ArrayList<PrPerformanceReportDTO>();
        List<PrCooperative> prCooperatives=prCooperativeService.getPrCooperative(); 
        prCooperatives.stream().forEach(pr->{
            PrPerformanceReportDTO prPerformanceReportDTO= new PrPerformanceReportDTO();
            prPerformanceReportDTO.setPrName(pr.getName());
            prPerformanceReportDTO.setSector(pr.getSector().getName());
            prPerformanceReportDTO.setType(pr.getType().getTypeName());
            prPerformanceReportDTO.setRegion(pr.getAddress().getRegion());
            prPerformanceReportDTO.setZone(pr.getAddress().getZone());
            List<Account> accounts=accountService.getAccountByPrCooperative(pr);
            List<AccountInfo> accountInfos= new ArrayList<AccountInfo>();
            accounts.stream().forEach(y->{
                AccountInfo accountInfo= new AccountInfo();
                accountInfo.setAccountNumber(y.getAccountNumber());
                accountInfo.setBranch(y.getBranch());
                accountInfo.setDistrict(y.getDistrict());
                List<AccountBalance> accountBalances=accountBalanceService.getAccountBalancesByAccount(y);
                accountInfo.setAccountBalances(accountBalances);
                accountInfos.add(accountInfo);
            });
            prPerformanceReportDTO.setAccountInfos(accountInfos);
            List<PaidUpShare> paidUpShares=paidUpShareService.getPaidUpShareByPrCooperative(pr);
            List<PaidUpShareDto> paidUpShareDtos= new ArrayList<PaidUpShareDto>();
            paidUpShares.stream().forEach(p->{
                PaidUpShareDto paidUpShareDto= new PaidUpShareDto();
                paidUpShareDto.setPaidUpValue(p.getPaidUpValue());
                paidUpShareDto.setDateGenerated(p.getDateGenerated());
                paidUpShareDtos.add(paidUpShareDto);
            });
            prPerformanceReportDTO.setPaidUpShares(paidUpShareDtos);
            List<OsLoan> osLoans=osLoanService.getOsLoanByPrCooperative(pr);
            List<OsLoanDto> osLoanDtos= new ArrayList<OsLoanDto>();
            osLoans.stream().forEach(os->{
                OsLoanDto osLoanDto= new OsLoanDto();
                osLoanDto.setOsLoanValue(os.getOsLoanValue());
                osLoanDto.setDateGenerated(os.getDateGenerated());
                osLoanDtos.add(osLoanDto);
            });
            prPerformanceReportDTO.setOsLoans(osLoanDtos);
            prPerformanceReportDTOs.add(prPerformanceReportDTO);
        });
        return prPerformanceReportDTOs;
      }

      @GetMapping("/getprCooperativesReport")
      List<PrCooperativesReportData> getPrCooperativesReportData() {
          List<PrCooperativesReportData> prCooperativesReportDatas= new ArrayList<PrCooperativesReportData>();
          List<PrCooperative> prCooperatives=prCooperativeService.getPrCooperative();  
          prCooperatives.stream().forEach(pr->{
              PrCooperativesReportData prCooperativesReportData= new PrCooperativesReportData();
              prCooperativesReportData.setPrCooperativeName(pr.getName());
              prCooperativesReportData.setYearOfStablishment(pr.getDateOfEstablishmnet());
             // prCooperativesReportData.setLicensingOrgan(pr.getLicensingOrgan());
              prCooperativesReportData.setNo_Of_MaleMembers(pr.getNo_Of_MaleMembers());
              prCooperativesReportData.setNo_Of_FemaleMembers(pr.getNo_Of_FemaleMembers());
              prCooperativesReportData.setFemaleMembersUpOnEstablishement(pr.getFemaleMembersUpOnEstablishement());
              prCooperativesReportData.setMaleMembersUpOnEstablishement(pr.getMaleMembersUpOnEstablishement());
              prCooperativesReportData.setJobOpportunityCreated(pr.getJobOpportunityCreated());
              List<Member> maleMembers=memberService.getMembersByPrCooperativeAndGender(pr, "MALE"); 
              no_of_Male_Establishing_Member=0;
              maleMembers.stream().forEach(z->{
                  if(z.getIsFounder()==true){
                      no_of_Male_Establishing_Member++;
                  }
              });
              List<Member> femaleMembers=memberService.getMembersByPrCooperativeAndGender(pr, "FEMALE");
              no_of_Female_Establishing_Member=0;
              femaleMembers.stream().forEach(a->{
                  if(a.getIsFounder()==true)
                  {
                      no_of_Female_Establishing_Member++;
                  }
              });
              List<Member> totalMembers=memberService.getMemberByPrCooperative(pr);
              prCooperativesReportData.setNo_of_Male_Establishing_Member(no_of_Male_Establishing_Member);
      
            
              prCooperativesReportData.setNo_of_Female_Establishing_Member(no_of_Female_Establishing_Member);
              no_of_Total_Establishing_Member=0;
              totalMembers.stream().forEach(b->{
                  if(b.getIsFounder()==true){
                      no_of_Total_Establishing_Member++;
                  }
              });
              prCooperativesReportData.setNo_of_Total_Establishing_Member(no_of_Total_Establishing_Member);
              prCooperativesReportData.setShareCapitalUponEstablishmnet(pr.getShareCapitalUponEstablishmnet());

                prCooperativesReportDatas.add(prCooperativesReportData);
          });
          return prCooperativesReportDatas;
        }

}
    







    

