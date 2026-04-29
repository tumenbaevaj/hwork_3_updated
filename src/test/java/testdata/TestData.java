package testdata;

import net.datafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String userName = faker.name().fullName();
    public String userEmail = faker.internet().emailAddress();
    public String currentAddress = faker.address().fullAddress();
    public String permanentAddress = faker.address().fullAddress();
    public String invalidEmail = faker.options().option(
            faker.name().firstName(),
            faker.name().lastName(),
            "invalid",
            "test@",
            "@gmail.com");

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String mobileNumber = faker.number().digits(10);
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String yearOfBirth = String.valueOf(faker.number().numberBetween(1970, 2010));
    public String monthOfBirth = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 29));
    public String subject = faker.options().option(
            "Maths", "Accounting", "Arts", "Social Studies", "Biology",
            "Physics", "Chemistry", "Computer Science", "Commerce", "Economics",
            "Civics", "Hindi", "English", "History");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String uploadImage = faker.options().option("img.jpg", "photo.png", "test.jpeg");
    public String state = faker.options().option(
            "NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = selectCity(state);

    public String selectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

    public String invalidPhone = faker.number().digits(faker.options().option(5, 7, 9));
}
