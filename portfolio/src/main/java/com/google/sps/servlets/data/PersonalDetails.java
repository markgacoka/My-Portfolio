package com.google.sps.data;

import java.util.Date;

public final class PersonalDetails {

  private final String firstName;
  private final String lastName;
  private final int currentAge;
  private final String schoolYear;

  public PersonalDetails(String firstName, String lastName, int currentAge, String schoolYear) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.currentAge = currentAge;
    this.schoolYear = schoolYear;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getCurrentAge() {
    return currentAge;
  }

  public String getSchoolYear() {
    return schoolYear;
  }
}
