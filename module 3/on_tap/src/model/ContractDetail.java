package model;

public class ContractDetail {
    private int id;
    private Contract contractId;
    private AttachService attachServiceId;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int id, Contract contractId, AttachService attachServiceId, int quantity) {
        this.id = id;
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContractId() {
        return contractId;
    }

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }

    public AttachService getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(AttachService attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
