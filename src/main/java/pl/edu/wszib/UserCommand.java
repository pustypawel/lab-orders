package pl.edu.wszib;

public enum UserCommand {
    CREATE("1"),
    PRINT("2"),
    EDIT("3"),
    DELETE("4"),
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
        for (UserCommand command : UserCommand.values()) {
            if (line.equalsIgnoreCase(command.representation)) {
                return command;
            }
        }
        return UNKNOWN;
    }
}
