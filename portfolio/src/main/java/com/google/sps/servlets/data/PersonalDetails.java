package com.google.sps.data;
import java.util.Random;

public final class PersonalDetails {

  private final String firstName;
  private final String lastName;
  private final int currentAge;
  private final String[] randomFacts;

  public PersonalDetails(String firstName, String lastName, int currentAge, String[] randomFacts) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.currentAge = currentAge;
    this.randomFacts = randomFacts;
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

  public String getRandomFact() {
    int idx = new Random().nextInt(randomFacts.length);
    String randomFact = (randomFacts[idx]);
    return randomFact;
  }
}
