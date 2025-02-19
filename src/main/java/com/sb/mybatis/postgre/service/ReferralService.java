package com.sb.mybatis.postgre.service;

import com.sb.mybatis.postgre.dto.ReferralDTO;
import com.sb.mybatis.postgre.mapper.ReferralEntityDTOMapper;
import com.sb.mybatis.postgre.repository.ReferralRepository;
import com.sb.mybatis.postgre.model.Referral;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ReferralService {

    private final ReferralRepository referralRepository;
    private final ReferralEntityDTOMapper referralEntityDTOMapper;

    public ReferralService(ReferralRepository referralRepository) {
        this.referralRepository = referralRepository;
        this.referralEntityDTOMapper = ReferralEntityDTOMapper.INSTANCE;
    }

    public int insertReferral(ReferralDTO referralDTO) throws Exception {

        //Assign UUID to the new referral
        referralDTO.setId(UUID.randomUUID().toString());

        //Convert DTO to Entity
        Referral referral = referralEntityDTOMapper.dtoToEntity(referralDTO);

        //Call Repository to insert
        return referralRepository.insertReferral(referral);
    }

    public int updateReferral(ReferralDTO referralDTO) throws Exception {

        //Convert DTO to Entity
        Referral referral = referralEntityDTOMapper.dtoToEntity(referralDTO);

        //Call Repository to update
        return referralRepository.updateReferral(referral);
    }

    public int deleteReferral(ReferralDTO referralDTO) throws Exception {

        //Convert DTO to Entity
        Referral referral = referralEntityDTOMapper.dtoToEntity(referralDTO);

        //Call Repository to delete
        return referralRepository.deleteReferral(referral.getId());
    }

    public List<ReferralDTO> findAllReferralRecords() throws Exception {

        List <ReferralDTO> dtoList = new ArrayList <> ();

        //Call Repository to get all Referrals
        for (Referral referral: referralRepository.findAllReferrals())
        {
            //Use MapStruct for converting Entity to DTOs
            ReferralDTO dto = referralEntityDTOMapper.entityToDto(referral);
            dtoList.add(dto);
        }

        return dtoList;
    }

    public Optional<ReferralDTO> selectReferral(String id) throws Exception {

        Optional<ReferralDTO> dto = Optional.empty();

        //Call Repository to get all Referrals
        Referral referral = referralRepository.selectReferral(id);

        if(!Optional.ofNullable(referral).isEmpty())
        {
            //Use MapStruct for converting Entity to DTOs
            dto = Optional.ofNullable(referralEntityDTOMapper.entityToDto(referral));
        }

        return dto;
    }
}
