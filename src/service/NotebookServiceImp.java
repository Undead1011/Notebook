package service;

import interfaces.NotebookService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class NotebookServiceImp implements NotebookService {
    private ArrayList<String> notes;

    public NotebookServiceImp() {
        this.notes = new ArrayList<>();
    }

    @Override
    public void addNote(String note) {
        notes.add(note);
    }


    @Override
    public void deleteNote(String note) {


        notes.remove(note);
    }

    @Override
    public String getAllNotes() {
        return notes.stream().distinct().filter(i -> !" ".equals(i)).filter(x -> !isNumeric(x)).collect(Collectors.joining("\n"));


        //        List<String> collect = notes.stream()
//                .distinct()
//                .filter(i -> !" ".equals(i))
//                .filter(x -> !isNumeric(x))
//                .toList();
        // StringBuilder numberedNotes = new StringBuilder();

      //  collect.forEach(element -> numberedNotes.append(element).append("\n"));

      //  return numberedNotes.toString();

    }


    @Override
    public boolean checkNote(String note) {
        return notes.contains(note);
    }

    @Override
    public void sortNotes() {
        Collections.sort(notes);
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}