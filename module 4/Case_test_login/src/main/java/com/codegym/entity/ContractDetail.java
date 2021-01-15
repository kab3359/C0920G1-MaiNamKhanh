package com.codegym.entity;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false, referencedColumnName = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id", nullable = false, referencedColumnName = "attach_service_id")
    private AttachService attachService;
}
