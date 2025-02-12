package com.sb.mybatis.postgre;

import com.sb.mybatis.postgre.dto.ReferralDTO;
import com.sb.mybatis.postgre.service.ReferralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.UUID;

@Slf4j
@SpringBootApplication
public class Application { //implements CommandLineRunner {

//	@Autowired
//	private ReferralService referralService;
//
//	private ReferralDTO newReferralDTO()
//	{
//		return new ReferralDTO(UUID.randomUUID().toString(), "Programmer");
//	}
//
//	private ReferralDTO updatedReferralDTO(String id)
//	{
//		return new ReferralDTO(id, "Software Engineer");
//	}
//
//	@Override
//	public void run(String...args) throws Exception {
//
//		log.info("Existing referral count = {}", referralService.findAllReferralRecords().size());
//		log.info("Attempting to save new referral record ..... {}", (referralService.insertReferral(newReferralDTO()) == 1 ? "Successful" : "Failed"));
//		log.info("Revised referral count = {}", referralService.findAllReferralRecords().size());
//		log.info("Printing all referral records ..... ");
//		referralService.findAllReferralRecords().forEach(referral -> log.info(referral.toString()));
//		log.info("-------------------------------------------------------------------");
//
//		//Update a record and re-fetch its data
//		String updateableReferralId = referralService.findAllReferralRecords().get(referralService.findAllReferralRecords().size()-1).getId();
//		log.info("Attempting to update the last inserted referral record {} and the outcome is {}", updateableReferralId,  referralService.updateReferral(updatedReferralDTO(updateableReferralId)) == 1 ? "Successful" : "Failed");
//		//Fetch the updated record
//		log.info("Fetching the last updated referral record {}", referralService.selectReferral(updateableReferralId).get());
//		log.info("-------------------------------------------------------------------");
//
//		//Delete a record and re-fetch its data
//		log.info("Attempting to delete the last updated referral record {} and the outcome is {}", updateableReferralId,  referralService.deleteReferral(updatedReferralDTO(updateableReferralId)) == 1 ? "Successful" : "Failed");
//		log.info("Printing all referral records AGAIN ..... ");
//		referralService.findAllReferralRecords().forEach(referral -> log.info(referral.toString()));
//		log.info("-------------------------------------------------------------------");
//	}

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
