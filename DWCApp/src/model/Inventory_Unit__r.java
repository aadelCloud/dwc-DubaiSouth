package model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by Abanoub Wagdy on 8/31/2015.
 */
public class Inventory_Unit__r implements Serializable {

//    public model.attributes getAttributes() {
//        return attributes;
//    }
//
//    public void setAttributes(model.attributes attributes) {
//        this.attributes = attributes;
//    }
//
//    @JsonProperty("attributes")
//    attributes attributes;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Area_in_sq_m__c")
    private String area_in_sq_m__c;
    @JsonProperty("Unit_ID__c")
    private String unit_ID__c;
    @JsonProperty("Zone__c")
    private String zone__c;
    @JsonProperty("Product_Type__c")
    private String product_Type__c;

    Product_Type__r product_Type__r;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea_in_sq_m__c() {
        return area_in_sq_m__c;
    }

    public void setArea_in_sq_m__c(String area_in_sq_m__c) {
        this.area_in_sq_m__c = area_in_sq_m__c;
    }

    public String getUnit_ID__c() {
        return unit_ID__c;
    }

    public void setUnit_ID__c(String unit_ID__c) {
        this.unit_ID__c = unit_ID__c;
    }

    public String getZone__c() {
        return zone__c;
    }

    public void setZone__c(String zone__c) {
        this.zone__c = zone__c;
    }

    public String getProduct_Type__c() {
        return product_Type__c;
    }

    public void setProduct_Type__c(String product_Type__c) {
        this.product_Type__c = product_Type__c;
    }

    public Product_Type__r getProduct_Type__r() {
        return product_Type__r;
    }

    public void setProduct_Type__r(Product_Type__r product_Type__r) {
        this.product_Type__r = product_Type__r;
    }
}
