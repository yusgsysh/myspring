package org.example.myspring.entity;

import lombok.Data;

import java.time.Instant;
@Data

public class Mltemplate {
    public String mlid;

    public String lang;

    public String mlnme;

    public String mlbody;

    public Instant insertdte;

    public String insertid;

    public Instant updatedte;

    public String updateid;

    public Character deleteflg;

    public Instant deletedte;
}