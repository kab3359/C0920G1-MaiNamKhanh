package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private int id;

    @OneToMany(mappedBy = "attachService", cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetails;

    @Column(name = "attach_service_name")
    private String name;

    @Column(name = "attach_service_cost")
    private double cost;

    @Column(name = "attach_service_unit")
    private String unit;

    @Column(name = "attach_service_status")
    private String status;
}
