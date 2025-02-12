package com.sb.mybatis.postgre.web;

import com.sb.mybatis.postgre.dto.ReferralDTO;
import com.sb.mybatis.postgre.service.ReferralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/referrals")
public class ReferralController {

    @Autowired
    private ReferralService referralService;

    private ReferralDTO newReferralDTO()
    {
        return new ReferralDTO(UUID.randomUUID().toString(), "Programmer");
    }

    private ReferralDTO updatedReferralDTO(String id)
    {
        return new ReferralDTO(id, "Software Engineer");
    }

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
    public String createTransactions() throws Exception {
        log.info("ReferralController.createTransactions() is invoked");
        return (referralService.insertReferral(newReferralDTO()) == 1 ? "Successful" : "Failed");
    }
}
