package utilities.faker;

import java.util.Locale;

/**
 * Factory class for creating test data generators.
 * Provides methods to create different types of test data generators with various configurations.
 */
public class TestDataGeneratorFactory {
    private static TestDataGenerator instance;

    /**
     * Private constructor to prevent instantiation.
     * This is a utility class.
     */
    private TestDataGeneratorFactory() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Gets the default test data generator instance.
     * Creates a new instance if none exists.
     * @return TestDataGenerator instance
     */
    public static TestDataGenerator getGenerator() {
        if (instance == null) {
            instance = new JavaFakerGenerator();
        }
        return instance;
    }

    /**
     * Gets a test data generator with specified locale.
     * @param locale Locale for the generator
     * @return TestDataGenerator instance with specified locale
     */
    public static TestDataGenerator getGenerator(Locale locale) {
        return new JavaFakerGenerator(locale);
    }

    /**
     * Gets a test data generator of specified type.
     * @param type Type of generator to create
     * @return TestDataGenerator instance of specified type
     * @throws IllegalArgumentException if generator type is not supported
     */
    public static TestDataGenerator getGenerator(String type) {
        switch (type.toLowerCase()) {
            case "javafaker":
                return new JavaFakerGenerator();
            default:
                throw new IllegalArgumentException("Unsupported test data generator type: " + type);
        }
    }

    /**
     * Gets a test data generator of specified type with locale.
     * @param type Type of generator to create
     * @param locale Locale for the generator
     * @return TestDataGenerator instance of specified type with locale
     * @throws IllegalArgumentException if generator type is not supported
     */
    public static TestDataGenerator getGenerator(String type, Locale locale) {
        switch (type.toLowerCase()) {
            case "javafaker":
                return new JavaFakerGenerator(locale);
            default:
                throw new IllegalArgumentException("Unsupported test data generator type: " + type);
        }
    }
} 