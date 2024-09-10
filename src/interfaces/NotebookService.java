package interfaces;

public interface NotebookService {
    void addNote(String note);
    void deleteNote(String note);
    String getAllNotes();
    boolean checkNote(String note);
    void sortNotes();
}