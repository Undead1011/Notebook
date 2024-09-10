import enums.Command;
import interfaces.NotebookService;
import interfaces.UserInputService;
import service.ConsoleUserInputService;
import service.NotebookServiceImp;

public class NotebookApp {
    private NotebookService notebookService;
    private UserInputService userInputService;

    public NotebookApp(NotebookService notebookService, UserInputService userInputService) {
        this.notebookService = notebookService;
        this.userInputService = userInputService;
    }

    public void run() {
        System.out.println("Добро пожаловать в приложение Записная книжка!");

        while (true) {
            System.out.println("\nДоступные команды:");
            for (Command command : Command.values()) {
                System.out.println(command.getCommandName() + " - " + command.getDescription());
            }

            System.out.print("Введите команду: ");
            String input = userInputService.getUserInput();
            Command command = Command.fromString(input);

            if (command == null) {
                System.out.println("Неизвестная команда. Попробуйте еще раз.");
                continue;
            }

            switch (command) {
                case ADD:
                    System.out.print("Введите запись для добавления: ");
                    String noteToAdd = userInputService.getUserInput();
                    notebookService.addNote(noteToAdd);
                    System.out.println("Запись добавлена.");
                    break;
                case DELETE:
                    System.out.print("Введите запись для удаления: ");
                    String noteToDelete = userInputService.getUserInput();
                    notebookService.deleteNote(noteToDelete);
                    System.out.println("Запись удалена (если она существовала).");
                    break;
                case SHOW:
                    System.out.println("Все записи:");
                    System.out.println(notebookService.getAllNotes());
                    break;
                case CHECK:
                    System.out.print("Введите запись для проверки: ");
                    String noteToCheck = userInputService.getUserInput();
                    boolean exists = notebookService.checkNote(noteToCheck);
                    System.out.println(exists ? "Запись найдена." : "Запись не найдена.");
                    break;
                case SORT:
                    notebookService.sortNotes();
                    System.out.println("Записи отсортированы.");
                    break;
                case EXIT:
                    System.out.println("До свидания!");
                    return;
            }
        }
    }

    public static void main(String[] args) {
        NotebookService notebookService = new NotebookServiceImp();
        UserInputService userInputService = new ConsoleUserInputService();
        NotebookApp app = new NotebookApp(notebookService, userInputService);
        app.run();
    }
}