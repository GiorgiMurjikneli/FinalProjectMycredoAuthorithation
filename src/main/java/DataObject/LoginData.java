package DataObject;

import com.github.javafaker.Faker;

public interface LoginData {

    Faker faker = new Faker();
    String
        incorrectUserData = "Test1234",
        emptyUserData = "",
        emptyPasswordData = "",
        incorrectPasswordData = faker.bothify("?????###"),
        correctUserData = "GMurjikneli",
        personalNumLength = "12345678912345678900";

}
