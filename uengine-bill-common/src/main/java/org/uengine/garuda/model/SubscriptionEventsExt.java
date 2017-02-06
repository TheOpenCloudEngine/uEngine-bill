package org.uengine.garuda.model;

import java.sql.Date;

/**
 * Created by uengine on 2017. 1. 25..
 */
public class SubscriptionEventsExt {

    private Long id;
    private String event_type;
    private String user_type;
    private String plan_name;
    private String product_id;
    private Long version;
    private String account_id;
    private String organization_id;
    private String tenant_id;
    private Long account_record_id;
    private Long tenant_record_id;
    private Date reg_dt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(String organization_id) {
        this.organization_id = organization_id;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public Long getAccount_record_id() {
        return account_record_id;
    }

    public void setAccount_record_id(Long account_record_id) {
        this.account_record_id = account_record_id;
    }

    public Long getTenant_record_id() {
        return tenant_record_id;
    }

    public void setTenant_record_id(Long tenant_record_id) {
        this.tenant_record_id = tenant_record_id;
    }

    public Date getReg_dt() {
        return reg_dt;
    }

    public void setReg_dt(Date reg_dt) {
        this.reg_dt = reg_dt;
    }
}
