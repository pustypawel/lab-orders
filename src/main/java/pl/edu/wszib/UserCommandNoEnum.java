package pl.edu.wszib;

/**
 * Klasa tłumacząca czym jest enum
 */
public class UserCommandNoEnum {
    public final static UserCommandNoEnum CREATE = new UserCommandNoEnum("1");
    public final static UserCommandNoEnum PRINT_ALL = new UserCommandNoEnum("2");

    private final String representation;

    private UserCommandNoEnum(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public UserCommandNoEnum[] values() {
        return new UserCommandNoEnum[] { CREATE, PRINT_ALL };
    }
}
