package utilities.faker;

public interface TestDataGenerator {
    // Personal
    String generateFirstName();
    String generateLastName();
    String generateFullName();
    String generateEmail();
    String generateUsername();
    String generatePassword();
    String generatePhoneNumber();
    
    // Address
    String generateStreetAddress();
    String generateCity();
    String generateState();
    String generateZipCode();
    String generateCountry();
    String generateFullAddress();
    
    // Finance
    String generateCreditCardNumber();
    String generateCreditCardExpiry();
    String generateCreditCardCVV();
    String generateIBAN();
    String generateAccountNumber();
    String generateCurrency();
    String generateAmount(double min, double max);
    
    // Job
    String generateCompanyName();
    String generateJobTitle();
    String generateDepartment();
    
    // Contact
    String generateWebsite();
    String generateIPAddress();
    String generateMACAddress();
    
    // Personal Id
    String generateSSN();
    String generatePassportNumber();
    String generateDriverLicense();
    
    // Time
    String generatePastDate();
    String generateFutureDate();
    String generateBirthDate();
    
    // Other
    String generateUUID();
    String generateCustomPattern(String pattern);

    // Messager
    String genareteMessage();
} 