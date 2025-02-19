package com.sb.mybatis.postgre.web;

import com.sb.mybatis.postgre.dto.ReferralDTO;
import com.sb.mybatis.postgre.service.ReferralService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/referrals")
public class ReferralController {

    @Autowired
    private ReferralService referralService;

    @GetMapping("/status")
    public String getStatus() {
        log.info("ReferralController.getStatus() is invoked");
        return "Referral Service is Up";
    }

    @GetMapping
    public List<ReferralDTO> getTransactions() throws Exception {
        log.info("ReferralController.getTransactions() is invoked");
        return referralService.findAllReferralRecords();
    }

    @PostMapping
    public ReferralDTO createTransaction(@Valid @RequestBody ReferralDTO referralDTO) throws Exception {
        log.info("ReferralController.createTransactions() is invoked");
        if(referralService.insertReferral(referralDTO) == 1) {
            //Success
            return referralDTO;
        }
        else throw new Exception("Error in creating new Referral record");
    }
}