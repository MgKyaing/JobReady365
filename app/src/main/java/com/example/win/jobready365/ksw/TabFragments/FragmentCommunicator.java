package com.example.win.jobready365.ksw.TabFragments;

/**
 * Created by Win on 2/13/2017.
 */

public interface FragmentCommunicator {
    void setCommunication( String firstName, String lastName,
                          String maritalStatus, String gender, String dateOfBirth,
                          String mobileNo, String email, String address, String township,
                          String postalCode, String city, String country);

    void setCommunication(String educUniversity,String educDegree,String educYear);

    void setCommunication(String expOrganization,String expRank,String expStartDate,String expEndDate);

    void setCommunication(String skillType,String skillLevel);

    void setCommunication(String refFirstName,String refLastName, String refOrganization, String refRank, String refEmail, String refMobileNo);



    void respondStartDate(String clicked);

    void respondEndDate(String clicked);
}
