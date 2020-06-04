package com.project.java.a20200522_abulhashemjr_nycschools.fakemodels;

import org.junit.Test;

public class SchoolListDirectory {
    private String dbn;
    private String schoolName;
    private String websites;
    private String destination;

    public SchoolListDirectory(String dbn, String schoolName, String websites, String destination) {
        this.dbn = dbn;
        this.schoolName = schoolName;
        this.websites = websites;
        this.destination = destination;
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

    public String getWebsites() {
        return websites;
    }

    public void setWebsites(String websites) {
        this.websites = websites;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
