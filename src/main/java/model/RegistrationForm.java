package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationForm {

    @SerializedName("id")
    @Expose
    String id;

    @SerializedName("firstName")
    @Expose
    String firstName;

    @SerializedName("middleNames")
    @Expose
    String middleNames;

    @SerializedName("lastName")
    @Expose
    String lastName;

    @SerializedName("dietaryPreferance")
    @Expose
    String dietaryPreferance;

    @SerializedName("howHeard")
    @Expose
    String howHeard;

    @SerializedName("loginID")
    @Expose
    String loginID;

    @SerializedName("contactNumber")
    @Expose
    String contactNumber;

    @SerializedName("degree")
    @Expose
    String degree;

    @SerializedName("studyProgramme")
    @Expose
    String studyProgramme;

    @SerializedName("stage")
    @Expose
    String stage;

    @SerializedName("school")
    @Expose
    String school;

    @SerializedName("universityEmail")
    @Expose
    String universityEmail;

    @SerializedName("preferredEmail")
    @Expose
    String preferredEmail;

    @SerializedName("UUID")
    @Expose
    String uuid;

    public RegistrationForm(String id, String firstName, String middleNames, String lastName,
                            String  dietaryPreference, String howHeard, String loginID,
                            String contactNumber, String  degree, String  studyProgramme, String  stage,
                            String school, String universityEmail, String preferredEmail, String uuid) {
        this.id = id;
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.dietaryPreferance = dietaryPreference;
        this.howHeard = howHeard;
        this.loginID = loginID;
        this.contactNumber = contactNumber;
        this.degree = degree;
        this.studyProgramme = studyProgramme;
        this.stage = stage;
        this.school = school;
        this.universityEmail = universityEmail;
        this.preferredEmail = preferredEmail;
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(String middleNames) {
        this.middleNames = middleNames;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String  getDietaryPreferance() {
        return dietaryPreferance;
    }

    public void setDietaryPreferance(String  dietaryPreferance) {
        this.dietaryPreferance = dietaryPreferance;
    }

    public String getHowHeard() {
        return howHeard;
    }

    public void setHowHeard(String howHeard) {
        this.howHeard = howHeard;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getStudyProgramme() {
        return studyProgramme;
    }

    public void setStudyProgramme(String  studyProgramme) {
        this.studyProgramme = studyProgramme;
    }

    public String  getStage() {
        return stage;
    }

    public void setStage(String  stage) {
        this.stage = stage;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUniversityEmail() {
        return universityEmail;
    }

    public void setUniversityEmail(String universityEmail) {
        this.universityEmail = universityEmail;
    }

    public String getPreferredEmail() {
        return preferredEmail;
    }

    public void setPreferredEmail(String preferredEmail) {
        this.preferredEmail = preferredEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
