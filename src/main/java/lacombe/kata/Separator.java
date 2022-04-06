package lacombe.kata;

public record Separator(String value) {
    public static final Separator DEFAULT_SEPARATOR = new Separator(",");
    public static final Separator NEWLINE_SEPARATOR = new Separator("\n");
}
