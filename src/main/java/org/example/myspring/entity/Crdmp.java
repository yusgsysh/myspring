package org.example.myspring.entity;

import lombok.Data;

import java.time.Instant;
@Data

public class Crdmp {
    public String cstid;

    public Character id;

    public String newcrded;

    public String crded;

    public Instant insertdte;

    public String insertid;

    public Instant updatedte;

    public String updateid;

    public Character deleteflg;

    public Instant deldtedte;

}