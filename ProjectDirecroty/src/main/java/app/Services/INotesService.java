package app.Services;

import app.Entities.Notes;

public interface INotesService {
    void addNotes(Notes notes);
    Iterable<Notes> getAllNotes();
    Notes getNotesById(int id);
    void updateNotes(int id, String key, String description, int temp );
    void deleteNotesById(int id);
}
