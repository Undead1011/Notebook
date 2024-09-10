package enums;

public enum Command {
    ADD("add", "Добавить запись"),
    DELETE("delete", "Удалить запись"),
    SHOW("show", "Показать все записи"),
    CHECK("check", "Проверить наличие записи"),
    SORT("sort", "Отсортировать записи"),
    EXIT("exit", "Выйти из программы");

    private String commandName;
    private String description;

    Command(String commandName, String description) {
        this.commandName = commandName;
        this.description = description;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getDescription() {
        return description;
    }

    public static Command fromString(String text) {
        for (Command command : Command.values()) {
            if (command.getCommandName().equalsIgnoreCase(text)) {
                return command;
            }
        }
        return null;
    }
}