package com.project.java.models;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class SchoolDirectory implements Parcelable {
    @SerializedName("dbn")
    @Expose
    private String dbn;
    @SerializedName("school_name")
    @Expose
    private String schoolName;
    @SerializedName("boro")
    @Expose
    private String boro;
    @SerializedName("overview_paragraph")
    @Expose
    private String overviewParagraph;
    @SerializedName("school_10th_seats")
    @Expose
    private String school10thSeats;
    @SerializedName("academicopportunities1")
    @Expose
    private String academicopportunities1;
    @SerializedName("academicopportunities2")
    @Expose
    private String academicopportunities2;
    @SerializedName("ell_programs")
    @Expose
    private String ellPrograms;
    @SerializedName("neighborhood")
    @Expose
    private String neighborhood;
    @SerializedName("building_code")
    @Expose
    private String buildingCode;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("fax_number")
    @Expose
    private String faxNumber;
    @SerializedName("school_email")
    @Expose
    private String schoolEmail;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("subway")
    @Expose
    private String subway;
    @SerializedName("bus")
    @Expose
    private String bus;
    @SerializedName("grades2018")
    @Expose
    private String grades2018;
    @SerializedName("finalgrades")
    @Expose
    private String finalgrades;
    @SerializedName("total_students")
    @Expose
    private String totalStudents;
    @SerializedName("extracurricular_activities")
    @Expose
    private String extracurricularActivities;
    @SerializedName("school_sports")
    @Expose
    private String schoolSports;
    @SerializedName("attendance_rate")
    @Expose
    private String attendanceRate;
    @SerializedName("pct_stu_enough_variety")
    @Expose
    private String pctStuEnoughVariety;
    @SerializedName("pct_stu_safe")
    @Expose
    private String pctStuSafe;
    @SerializedName("school_accessibility_description")
    @Expose
    private String schoolAccessibilityDescription;
    @SerializedName("directions1")
    @Expose
    private String directions1;
    @SerializedName("requirement1_1")
    @Expose
    private String requirement11;
    @SerializedName("requirement2_1")
    @Expose
    private String requirement21;
    @SerializedName("requirement3_1")
    @Expose
    private String requirement31;
    @SerializedName("requirement4_1")
    @Expose
    private String requirement41;
    @SerializedName("requirement5_1")
    @Expose
    private String requirement51;
    @SerializedName("offer_rate1")
    @Expose
    private String offerRate1;
    @SerializedName("program1")
    @Expose
    private String program1;
    @SerializedName("code1")
    @Expose
    private String code1;
    @SerializedName("interest1")
    @Expose
    private String interest1;
    @SerializedName("method1")
    @Expose
    private String method1;
    @SerializedName("seats9ge1")
    @Expose
    private String seats9ge1;
    @SerializedName("grade9gefilledflag1")
    @Expose
    private String grade9gefilledflag1;
    @SerializedName("grade9geapplicants1")
    @Expose
    private String grade9geapplicants1;
    @SerializedName("seats9swd1")
    @Expose
    private String seats9swd1;
    @SerializedName("grade9swdfilledflag1")
    @Expose
    private String grade9swdfilledflag1;
    @SerializedName("grade9swdapplicants1")
    @Expose
    private String grade9swdapplicants1;
    @SerializedName("seats101")
    @Expose
    private String seats101;
    @SerializedName("admissionspriority11")
    @Expose
    private String admissionspriority11;
    @SerializedName("admissionspriority21")
    @Expose
    private String admissionspriority21;
    @SerializedName("admissionspriority31")
    @Expose
    private String admissionspriority31;
    @SerializedName("grade9geapplicantsperseat1")
    @Expose
    private String grade9geapplicantsperseat1;
    @SerializedName("grade9swdapplicantsperseat1")
    @Expose
    private String grade9swdapplicantsperseat1;
    @SerializedName("primary_address_line_1")
    @Expose
    private String primaryAddressLine1;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("state_code")
    @Expose
    private String stateCode;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("community_board")
    @Expose
    private String communityBoard;
    @SerializedName("council_district")
    @Expose
    private String councilDistrict;
    @SerializedName("census_tract")
    @Expose
    private String censusTract;
    @SerializedName("bin")
    @Expose
    private String bin;
    @SerializedName("bbl")
    @Expose
    private String bbl;
    @SerializedName("nta")
    @Expose
    private String nta;
    @SerializedName("borough")
    @Expose
    private String borough;
    @SerializedName("academicopportunities3")
    @Expose
    private String academicopportunities3;
    @SerializedName("language_classes")
    @Expose
    private String languageClasses;
    @SerializedName("addtl_info1")
    @Expose
    private String addtlInfo1;
    @SerializedName("transfer")
    @Expose
    private String transfer;
    @SerializedName("eligibility1")
    @Expose
    private String eligibility1;
    public final static Parcelable.Creator<SchoolDirectory> CREATOR = new Creator<SchoolDirectory>() {
        @SuppressWarnings({"unchecked"})
        public SchoolDirectory createFromParcel(Parcel in) {
            return new SchoolDirectory(in);
        }
        public SchoolDirectory[] newArray(int size) {
            return (new SchoolDirectory[size]);
        }
    };

    protected SchoolDirectory(Parcel in) {
        this.dbn = ((String) in.readValue((String.class.getClassLoader())));
        this.schoolName = ((String) in.readValue((String.class.getClassLoader())));
        this.boro = ((String) in.readValue((String.class.getClassLoader())));
        this.overviewParagraph = ((String) in.readValue((String.class.getClassLoader())));
        this.school10thSeats = ((String) in.readValue((String.class.getClassLoader())));
        this.academicopportunities1 = ((String) in.readValue((String.class.getClassLoader())));
        this.academicopportunities2 = ((String) in.readValue((String.class.getClassLoader())));
        this.ellPrograms = ((String) in.readValue((String.class.getClassLoader())));
        this.neighborhood = ((String) in.readValue((String.class.getClassLoader())));
        this.buildingCode = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.phoneNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.faxNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.schoolEmail = ((String) in.readValue((String.class.getClassLoader())));
        this.website = ((String) in.readValue((String.class.getClassLoader())));
        this.subway = ((String) in.readValue((String.class.getClassLoader())));
        this.bus = ((String) in.readValue((String.class.getClassLoader())));
        this.grades2018 = ((String) in.readValue((String.class.getClassLoader())));
        this.finalgrades = ((String) in.readValue((String.class.getClassLoader())));
        this.totalStudents = ((String) in.readValue((String.class.getClassLoader())));
        this.extracurricularActivities = ((String) in.readValue((String.class.getClassLoader())));
        this.schoolSports = ((String) in.readValue((String.class.getClassLoader())));
        this.attendanceRate = ((String) in.readValue((String.class.getClassLoader())));
        this.pctStuEnoughVariety = ((String) in.readValue((String.class.getClassLoader())));
        this.pctStuSafe = ((String) in.readValue((String.class.getClassLoader())));
        this.schoolAccessibilityDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.directions1 = ((String) in.readValue((String.class.getClassLoader())));
        this.requirement11 = ((String) in.readValue((String.class.getClassLoader())));
        this.requirement21 = ((String) in.readValue((String.class.getClassLoader())));
        this.requirement31 = ((String) in.readValue((String.class.getClassLoader())));
        this.requirement41 = ((String) in.readValue((String.class.getClassLoader())));
        this.requirement51 = ((String) in.readValue((String.class.getClassLoader())));
        this.offerRate1 = ((String) in.readValue((String.class.getClassLoader())));
        this.program1 = ((String) in.readValue((String.class.getClassLoader())));
        this.code1 = ((String) in.readValue((String.class.getClassLoader())));
        this.interest1 = ((String) in.readValue((String.class.getClassLoader())));
        this.method1 = ((String) in.readValue((String.class.getClassLoader())));
        this.seats9ge1 = ((String) in.readValue((String.class.getClassLoader())));
        this.grade9gefilledflag1 = ((String) in.readValue((String.class.getClassLoader())));
        this.grade9geapplicants1 = ((String) in.readValue((String.class.getClassLoader())));
        this.seats9swd1 = ((String) in.readValue((String.class.getClassLoader())));
        this.grade9swdfilledflag1 = ((String) in.readValue((String.class.getClassLoader())));
        this.grade9swdapplicants1 = ((String) in.readValue((String.class.getClassLoader())));
        this.seats101 = ((String) in.readValue((String.class.getClassLoader())));
        this.admissionspriority11 = ((String) in.readValue((String.class.getClassLoader())));
        this.admissionspriority21 = ((String) in.readValue((String.class.getClassLoader())));
        this.admissionspriority31 = ((String) in.readValue((String.class.getClassLoader())));
        this.grade9geapplicantsperseat1 = ((String) in.readValue((String.class.getClassLoader())));
        this.grade9swdapplicantsperseat1 = ((String) in.readValue((String.class.getClassLoader())));
        this.primaryAddressLine1 = ((String) in.readValue((String.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.zip = ((String) in.readValue((String.class.getClassLoader())));
        this.stateCode = ((String) in.readValue((String.class.getClassLoader())));
        this.latitude = ((String) in.readValue((String.class.getClassLoader())));
        this.longitude = ((String) in.readValue((String.class.getClassLoader())));
        this.communityBoard = ((String) in.readValue((String.class.getClassLoader())));
        this.councilDistrict = ((String) in.readValue((String.class.getClassLoader())));
        this.censusTract = ((String) in.readValue((String.class.getClassLoader())));
        this.bin = ((String) in.readValue((String.class.getClassLoader())));
        this.bbl = ((String) in.readValue((String.class.getClassLoader())));
        this.nta = ((String) in.readValue((String.class.getClassLoader())));
        this.borough = ((String) in.readValue((String.class.getClassLoader())));
        this.academicopportunities3 = ((String) in.readValue((String.class.getClassLoader())));
        this.languageClasses = ((String) in.readValue((String.class.getClassLoader())));
        this.addtlInfo1 = ((String) in.readValue((String.class.getClassLoader())));
        this.transfer = ((String) in.readValue((String.class.getClassLoader())));
        this.eligibility1 = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SchoolDirectory() {

    }

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getBoro() {
        return boro;
    }

    public void setBoro(String boro) {
        this.boro = boro;
    }

    public String getOverviewParagraph() {
        return overviewParagraph;
    }

    public void setOverviewParagraph(String overviewParagraph) {
        this.overviewParagraph = overviewParagraph;
    }

    public String getSchool10thSeats() {
        return school10thSeats;
    }

    public void setSchool10thSeats(String school10thSeats) {
        this.school10thSeats = school10thSeats;
    }

    public String getAcademicopportunities1() {
        return academicopportunities1;
    }

    public void setAcademicopportunities1(String academicopportunities1) {
        this.academicopportunities1 = academicopportunities1;
    }

    public String getAcademicopportunities2() {
        return academicopportunities2;
    }

    public void setAcademicopportunities2(String academicopportunities2) {
        this.academicopportunities2 = academicopportunities2;
    }

    public String getEllPrograms() {
        return ellPrograms;
    }

    public void setEllPrograms(String ellPrograms) {
        this.ellPrograms = ellPrograms;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSubway() {
        return subway;
    }

    public void setSubway(String subway) {
        this.subway = subway;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getGrades2018() {
        return grades2018;
    }

    public void setGrades2018(String grades2018) {
        this.grades2018 = grades2018;
    }

    public String getFinalgrades() {
        return finalgrades;
    }

    public void setFinalgrades(String finalgrades) {
        this.finalgrades = finalgrades;
    }

    public String getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(String totalStudents) {
        this.totalStudents = totalStudents;
    }

    public String getExtracurricularActivities() {
        return extracurricularActivities;
    }

    public void setExtracurricularActivities(String extracurricularActivities) {
        this.extracurricularActivities = extracurricularActivities;
    }

    public String getSchoolSports() {
        return schoolSports;
    }

    public void setSchoolSports(String schoolSports) {
        this.schoolSports = schoolSports;
    }

    public String getAttendanceRate() {
        return attendanceRate;
    }

    public void setAttendanceRate(String attendanceRate) {
        this.attendanceRate = attendanceRate;
    }

    public String getPctStuEnoughVariety() {
        return pctStuEnoughVariety;
    }

    public void setPctStuEnoughVariety(String pctStuEnoughVariety) {
        this.pctStuEnoughVariety = pctStuEnoughVariety;
    }

    public String getPctStuSafe() {
        return pctStuSafe;
    }

    public void setPctStuSafe(String pctStuSafe) {
        this.pctStuSafe = pctStuSafe;
    }

    public String getSchoolAccessibilityDescription() {
        return schoolAccessibilityDescription;
    }

    public void setSchoolAccessibilityDescription(String schoolAccessibilityDescription) {
        this.schoolAccessibilityDescription = schoolAccessibilityDescription;
    }

    public String getDirections1() {
        return directions1;
    }

    public void setDirections1(String directions1) {
        this.directions1 = directions1;
    }

    public String getRequirement11() {
        return requirement11;
    }

    public void setRequirement11(String requirement11) {
        this.requirement11 = requirement11;
    }

    public String getRequirement21() {
        return requirement21;
    }

    public void setRequirement21(String requirement21) {
        this.requirement21 = requirement21;
    }

    public String getRequirement31() {
        return requirement31;
    }

    public void setRequirement31(String requirement31) {
        this.requirement31 = requirement31;
    }

    public String getRequirement41() {
        return requirement41;
    }

    public void setRequirement41(String requirement41) {
        this.requirement41 = requirement41;
    }

    public String getRequirement51() {
        return requirement51;
    }

    public void setRequirement51(String requirement51) {
        this.requirement51 = requirement51;
    }

    public String getOfferRate1() {
        return offerRate1;
    }

    public void setOfferRate1(String offerRate1) {
        this.offerRate1 = offerRate1;
    }

    public String getProgram1() {
        return program1;
    }

    public void setProgram1(String program1) {
        this.program1 = program1;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getInterest1() {
        return interest1;
    }

    public void setInterest1(String interest1) {
        this.interest1 = interest1;
    }

    public String getMethod1() {
        return method1;
    }

    public void setMethod1(String method1) {
        this.method1 = method1;
    }

    public String getSeats9ge1() {
        return seats9ge1;
    }

    public void setSeats9ge1(String seats9ge1) {
        this.seats9ge1 = seats9ge1;
    }

    public String getGrade9gefilledflag1() {
        return grade9gefilledflag1;
    }

    public void setGrade9gefilledflag1(String grade9gefilledflag1) {
        this.grade9gefilledflag1 = grade9gefilledflag1;
    }

    public String getGrade9geapplicants1() {
        return grade9geapplicants1;
    }

    public void setGrade9geapplicants1(String grade9geapplicants1) {
        this.grade9geapplicants1 = grade9geapplicants1;
    }

    public String getSeats9swd1() {
        return seats9swd1;
    }

    public void setSeats9swd1(String seats9swd1) {
        this.seats9swd1 = seats9swd1;
    }

    public String getGrade9swdfilledflag1() {
        return grade9swdfilledflag1;
    }

    public void setGrade9swdfilledflag1(String grade9swdfilledflag1) {
        this.grade9swdfilledflag1 = grade9swdfilledflag1;
    }

    public String getGrade9swdapplicants1() {
        return grade9swdapplicants1;
    }

    public void setGrade9swdapplicants1(String grade9swdapplicants1) {
        this.grade9swdapplicants1 = grade9swdapplicants1;
    }

    public String getSeats101() {
        return seats101;
    }

    public void setSeats101(String seats101) {
        this.seats101 = seats101;
    }

    public String getAdmissionspriority11() {
        return admissionspriority11;
    }

    public void setAdmissionspriority11(String admissionspriority11) {
        this.admissionspriority11 = admissionspriority11;
    }

    public String getAdmissionspriority21() {
        return admissionspriority21;
    }

    public void setAdmissionspriority21(String admissionspriority21) {
        this.admissionspriority21 = admissionspriority21;
    }

    public String getAdmissionspriority31() {
        return admissionspriority31;
    }

    public void setAdmissionspriority31(String admissionspriority31) {
        this.admissionspriority31 = admissionspriority31;
    }

    public String getGrade9geapplicantsperseat1() {
        return grade9geapplicantsperseat1;
    }

    public void setGrade9geapplicantsperseat1(String grade9geapplicantsperseat1) {
        this.grade9geapplicantsperseat1 = grade9geapplicantsperseat1;
    }

    public String getGrade9swdapplicantsperseat1() {
        return grade9swdapplicantsperseat1;
    }

    public void setGrade9swdapplicantsperseat1(String grade9swdapplicantsperseat1) {
        this.grade9swdapplicantsperseat1 = grade9swdapplicantsperseat1;
    }

    public String getPrimaryAddressLine1() {
        return primaryAddressLine1;
    }

    public void setPrimaryAddressLine1(String primaryAddressLine1) {
        this.primaryAddressLine1 = primaryAddressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCommunityBoard() {
        return communityBoard;
    }

    public void setCommunityBoard(String communityBoard) {
        this.communityBoard = communityBoard;
    }

    public String getCouncilDistrict() {
        return councilDistrict;
    }

    public void setCouncilDistrict(String councilDistrict) {
        this.councilDistrict = councilDistrict;
    }

    public String getCensusTract() {
        return censusTract;
    }

    public void setCensusTract(String censusTract) {
        this.censusTract = censusTract;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getBbl() {
        return bbl;
    }

    public void setBbl(String bbl) {
        this.bbl = bbl;
    }

    public String getNta() {
        return nta;
    }

    public void setNta(String nta) {
        this.nta = nta;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getAcademicopportunities3() {
        return academicopportunities3;
    }

    public void setAcademicopportunities3(String academicopportunities3) {
        this.academicopportunities3 = academicopportunities3;
    }

    public String getLanguageClasses() {
        return languageClasses;
    }

    public void setLanguageClasses(String languageClasses) {
        this.languageClasses = languageClasses;
    }

    public String getAddtlInfo1() {
        return addtlInfo1;
    }

    public void setAddtlInfo1(String addtlInfo1) {
        this.addtlInfo1 = addtlInfo1;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getEligibility1() {
        return eligibility1;
    }

    public void setEligibility1(String eligibility1) {
        this.eligibility1 = eligibility1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SchoolDirectory)) return false;
        SchoolDirectory that = (SchoolDirectory) o;
        return getDbn().equals(that.getDbn()) &&
                getSchoolName().equals(that.getSchoolName()) &&
                getBoro().equals(that.getBoro());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(getDbn(), getSchoolName(), getBoro());
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dbn);
        dest.writeValue(schoolName);
        dest.writeValue(boro);
        dest.writeValue(overviewParagraph);
        dest.writeValue(school10thSeats);
        dest.writeValue(academicopportunities1);
        dest.writeValue(academicopportunities2);
        dest.writeValue(ellPrograms);
        dest.writeValue(neighborhood);
        dest.writeValue(buildingCode);
        dest.writeValue(location);
        dest.writeValue(phoneNumber);
        dest.writeValue(faxNumber);
        dest.writeValue(schoolEmail);
        dest.writeValue(website);
        dest.writeValue(subway);
        dest.writeValue(bus);
        dest.writeValue(grades2018);
        dest.writeValue(finalgrades);
        dest.writeValue(totalStudents);
        dest.writeValue(extracurricularActivities);
        dest.writeValue(schoolSports);
        dest.writeValue(attendanceRate);
        dest.writeValue(pctStuEnoughVariety);
        dest.writeValue(pctStuSafe);
        dest.writeValue(schoolAccessibilityDescription);
        dest.writeValue(directions1);
        dest.writeValue(requirement11);
        dest.writeValue(requirement21);
        dest.writeValue(requirement31);
        dest.writeValue(requirement41);
        dest.writeValue(requirement51);
        dest.writeValue(offerRate1);
        dest.writeValue(program1);
        dest.writeValue(code1);
        dest.writeValue(interest1);
        dest.writeValue(method1);
        dest.writeValue(seats9ge1);
        dest.writeValue(grade9gefilledflag1);
        dest.writeValue(grade9geapplicants1);
        dest.writeValue(seats9swd1);
        dest.writeValue(grade9swdfilledflag1);
        dest.writeValue(grade9swdapplicants1);
        dest.writeValue(seats101);
        dest.writeValue(admissionspriority11);
        dest.writeValue(admissionspriority21);
        dest.writeValue(admissionspriority31);
        dest.writeValue(grade9geapplicantsperseat1);
        dest.writeValue(grade9swdapplicantsperseat1);
        dest.writeValue(primaryAddressLine1);
        dest.writeValue(city);
        dest.writeValue(zip);
        dest.writeValue(stateCode);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeValue(communityBoard);
        dest.writeValue(councilDistrict);
        dest.writeValue(censusTract);
        dest.writeValue(bin);
        dest.writeValue(bbl);
        dest.writeValue(nta);
        dest.writeValue(borough);
        dest.writeValue(academicopportunities3);
        dest.writeValue(languageClasses);
        dest.writeValue(addtlInfo1);
        dest.writeValue(transfer);
        dest.writeValue(eligibility1);
    }

    public int describeContents() {
        return 0;
    }

}
