package com.sb.mybatis.postgre.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReferralDTO
{
    @Id
    private String id;

    @NotNull
    String givenName;
}