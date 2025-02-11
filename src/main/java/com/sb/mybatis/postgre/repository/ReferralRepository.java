package com.sb.mybatis.postgre.repository;

import com.sb.mybatis.postgre.model.Referral;
import com.sb.mybatis.postgre.model.ReferralMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//JPA component that uses MyBatis mapper (MyBatis component) & interacts with the database
@Repository
public class ReferralRepository {

    private final ReferralMapper referralMapper;

    public ReferralRepository(ReferralMapper referralMapper)
    {
        this.referralMapper = referralMapper;
    }

    public int insertReferral(Referral referral) throws Exception
    {
        return referralMapper.insertReferral(referral.getId(), referral.getName());
    }

    public Referral selectReferral(String id) throws Exception
    {
        return referralMapper.selectReferral(id);
    }

    public int updateReferral(Referral referral) throws Exception
    {
        return referralMapper.updateReferral(referral.getId(), referral.getName());
    }

    public int deleteReferral(String id) throws Exception
    {
        return referralMapper.deleteReferral(id);
    }

    public List<Referral> findAllReferrals() throws Exception
    {
        return referralMapper.findAllReferrals();
    }
}
