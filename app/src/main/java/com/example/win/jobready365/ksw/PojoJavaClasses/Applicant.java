package com.example.win.jobready365.ksw.PojoJavaClasses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Win on 2/6/2017.
 */

public class Applicant implements Serializable {
    @SerializedName("id")
    private String id;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("marital_status")
    private String maritalStatus;

    @SerializedName("gender")
    private String gender;

    @SerializedName("date_of_birth")
    private String dateOfBirth;

    @SerializedName("mobile_no")
    private String mobileNo;

    @SerializedName("email")
    private String email;

    @SerializedName("address")
    private String address;

    @SerializedName("township_id")
    private String townshipId;

    @SerializedName("postal_code")
    private String postalCode;

    @SerializedName("city_id")
    private String cityId;

    @SerializedName("country_id")
    private String countryId;

    @SerializedName("cv_views")
    private int cvViews;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("update_at")
    private String updateAt;
    @SerializedName("hdnEdu")
    private List<Education> education = null;
    @SerializedName("hdnSkill")
    private List<Skill> skill = null;
    @SerializedName("hdnExp")
    private List<Experience> exp = null;
    @SerializedName("hdnRefree")
    private List<Refree> refree = null;


    public Applicant() {
    }

    public Applicant(String id, String userId, String firstName, String lastName, String maritalStatus, String gender, String dateOfBirth, String mobileNo, String email, String address, String townshipId, String postalCode, String cityId, String countryId, int cvViews, String createdAt, String updateAt, List<Education> education, List<Skill> skill, List<Experience> exp, List<Refree> refree) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.mobileNo = mobileNo;
        this.email = email;
        this.address = address;
        this.townshipId = townshipId;
        this.postalCode = postalCode;
        this.cityId = cityId;
        this.countryId = countryId;
        this.cvViews = cvViews;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.education = education;
        this.skill = skill;
        this.exp = exp;
        this.refree = refree;
    }

    public Applicant(String userId, String firstName, String lastName, String maritalStatus, String gender, String dateOfBirth, String mobileNo,
                     String email, String address, String township, String postalCode, String city, String country, List<Education> educationList, List<Skill> skillList, List<Experience> experienceList, List<Refree> refreeList) {
    this.id = userId;
        this.firstName = firstName;
        this.lastName =lastName;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.mobileNo = mobileNo;
        this.email = email;
        this.address = address;
        this.townshipId = township;
        this.postalCode = postalCode;
        this.cityId = city;
        this.countryId = country;
        this.education = educationList;
        this.skill = skillList;
        this.exp = experienceList;
        this.refree = refreeList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String  getTownshipId() {
        return townshipId;
    }

    public void setTownshipId(String townshipId) {
        this.townshipId = townshipId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public int getCvViews() {
        return cvViews;
    }

    public void setCvViews(int cvViews) {
        this.cvViews = cvViews;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    public List<Experience> getExp() {
        return exp;
    }

    public void setExp(List<Experience> exp) {
        this.exp = exp;
    }

    public List<Refree> getRefree() {
        return refree;
    }

    public void setRefree(List<Refree> refree) {
        this.refree = refree;
    }
}
