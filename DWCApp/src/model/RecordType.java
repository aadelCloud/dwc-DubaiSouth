package model;

import com.google.gson.annotations.SerializedName;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by Abanoub on 6/16/2015.
 */
public class RecordType implements Serializable{

    public model.attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(model.attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("attributes")
    attributes attributes;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @SerializedName("Id")
    @JsonProperty("Id")
    String Id;

    private String businessProcessId;

    private User createdBy;

    private String createdById;

    private java.util.Calendar createdDate;

    private String description;

    @SerializedName("DeveloperName")
    @JsonProperty("DeveloperName")
    private String developerName;

    private Boolean isActive;

    private Boolean isPersonType;

    private User lastModifiedBy;

    private String lastModifiedById;

    private java.util.Calendar lastModifiedDate;

    @JsonProperty("Name")
    @SerializedName("Name")
    private String name;

    private String namespacePrefix;

    @SerializedName("SobjectType")
    @JsonProperty("SobjectType")
    private String sobjectType;

    private java.util.Calendar systemModstamp;

    public RecordType() {
    }


    /**
     * Gets the businessProcessId value for this RecordType.
     *
     * @return businessProcessId
     */
    public String getBusinessProcessId() {
        return businessProcessId;
    }


    /**
     * Sets the businessProcessId value for this RecordType.
     *
     * @param businessProcessId
     */
    public void setBusinessProcessId(String businessProcessId) {
        this.businessProcessId = businessProcessId;
    }


    /**
     * Gets the createdBy value for this RecordType.
     *
     * @return createdBy
     */
    public User getCreatedBy() {
        return createdBy;
    }


    /**
     * Sets the createdBy value for this RecordType.
     *
     * @param createdBy
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }


    /**
     * Gets the createdById value for this RecordType.
     *
     * @return createdById
     */
    public String getCreatedById() {
        return createdById;
    }


    /**
     * Sets the createdById value for this RecordType.
     *
     * @param createdById
     */
    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }


    /**
     * Gets the createdDate value for this RecordType.
     *
     * @return createdDate
     */
    public java.util.Calendar getCreatedDate() {
        return createdDate;
    }


    /**
     * Sets the createdDate value for this RecordType.
     *
     * @param createdDate
     */
    public void setCreatedDate(java.util.Calendar createdDate) {
        this.createdDate = createdDate;
    }


    /**
     * Gets the description value for this RecordType.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this RecordType.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Gets the developerName value for this RecordType.
     *
     * @return developerName
     */
    public String getDeveloperName() {
        return developerName;
    }


    /**
     * Sets the developerName value for this RecordType.
     *
     * @param developerName
     */
    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }


    /**
     * Gets the isActive value for this RecordType.
     *
     * @return isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }


    /**
     * Sets the isActive value for this RecordType.
     *
     * @param isActive
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }


    /**
     * Gets the isPersonType value for this RecordType.
     *
     * @return isPersonType
     */
    public Boolean getIsPersonType() {
        return isPersonType;
    }


    /**
     * Sets the isPersonType value for this RecordType.
     *
     * @param isPersonType
     */
    public void setIsPersonType(Boolean isPersonType) {
        this.isPersonType = isPersonType;
    }


    /**
     * Gets the lastModifiedBy value for this RecordType.
     *
     * @return lastModifiedBy
     */
    public User getLastModifiedBy() {
        return lastModifiedBy;
    }


    /**
     * Sets the lastModifiedBy value for this RecordType.
     *
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }


    /**
     * Gets the lastModifiedById value for this RecordType.
     *
     * @return lastModifiedById
     */
    public String getLastModifiedById() {
        return lastModifiedById;
    }


    /**
     * Sets the lastModifiedById value for this RecordType.
     *
     * @param lastModifiedById
     */
    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }


    /**
     * Gets the lastModifiedDate value for this RecordType.
     *
     * @return lastModifiedDate
     */
    public java.util.Calendar getLastModifiedDate() {
        return lastModifiedDate;
    }


    /**
     * Sets the lastModifiedDate value for this RecordType.
     *
     * @param lastModifiedDate
     */
    public void setLastModifiedDate(java.util.Calendar lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }


    /**
     * Gets the name value for this RecordType.
     *
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name value for this RecordType.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the namespacePrefix value for this RecordType.
     *
     * @return namespacePrefix
     */
    public String getNamespacePrefix() {
        return namespacePrefix;
    }


    /**
     * Sets the namespacePrefix value for this RecordType.
     *
     * @param namespacePrefix
     */
    public void setNamespacePrefix(String namespacePrefix) {
        this.namespacePrefix = namespacePrefix;
    }


    /**
     * Gets the sobjectType value for this RecordType.
     *
     * @return sobjectType
     */
    public String getSobjectType() {
        return sobjectType;
    }


    /**
     * Sets the sobjectType value for this RecordType.
     *
     * @param sobjectType
     */
    public void setSobjectType(String sobjectType) {
        this.sobjectType = sobjectType;
    }


    /**
     * Gets the systemModstamp value for this RecordType.
     *
     * @return systemModstamp
     */
    public java.util.Calendar getSystemModstamp() {
        return systemModstamp;
    }


    /**
     * Sets the systemModstamp value for this RecordType.
     *
     * @param systemModstamp
     */
    public void setSystemModstamp(java.util.Calendar systemModstamp) {
        this.systemModstamp = systemModstamp;
    }


}
