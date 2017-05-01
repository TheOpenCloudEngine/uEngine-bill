package org.uengine.garuda.model.catalog;

import org.uengine.garuda.model.Vendor;

import java.util.List;

/**
 * Created by uengine on 2017. 2. 3..
 */
public class Usage {
    private String name;
    private String display_name;
    private String billingMode;
    private String usageType;
    private String billingPeriod;
    private List<Tier> tiers;
    private List<Vendor> overwriteVendors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getBillingMode() {
        return billingMode;
    }

    public void setBillingMode(String billingMode) {
        this.billingMode = billingMode;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    public String getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(String billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public List<Tier> getTiers() {
        return tiers;
    }

    public void setTiers(List<Tier> tiers) {
        this.tiers = tiers;
    }

    public List<Vendor> getOverwriteVendors() {
        return overwriteVendors;
    }

    public void setOverwriteVendors(List<Vendor> overwriteVendors) {
        this.overwriteVendors = overwriteVendors;
    }
}
