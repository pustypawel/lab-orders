package pl.edu.wszib;

public enum UserCommand {
    CREATE("1"),
    PRINT_ALL("2"),
    EDIT("3"),
    DELETE("4"),
    SEND_EMAIL("5"),
    EXIT("0"),

    UNKNOWN(null);

    private final String representation;

    UserCommand(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public static UserCommand parseUserCommand(String line) {
        UserCommand[] values = UserCommand.values();
        return null;
    }
}
