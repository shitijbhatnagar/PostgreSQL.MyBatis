package com.sb.mybatis.postgre.model;

import org.apache.ibatis.annotations.Param;
import java.util.List;

//MyBatis component: Mapper Interface that mentions operations (note the actual operations/actions are defined in the mapper.xml file)
public interface ReferralMapper {
    int insertReferral(
            @Param("id") String id,
            @Param("name") String name);
    Referral selectReferral(@Param("id") String id);

    int updateReferral(
            @Param("id") String id,
            @Param("name") String name);
    int deleteReferral(@Param("id") String id);

    List<Referral> findAllReferrals();
}