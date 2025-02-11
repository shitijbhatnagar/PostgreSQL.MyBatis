package com.sb.mybatis.postgre.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//Entity class
public class Referral
{
    @Id
    private String id;

    @NotNull
    String name;
}