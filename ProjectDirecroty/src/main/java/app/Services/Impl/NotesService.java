package app.Services.Impl;

import app.Entities.Notes;
import app.Services.INotesService;
import app.repos.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class NotesService implements INotesService {

    private NotesRepository notesRepository;
    @Autowired
    public NotesService(NotesRepository notesRepository){
        this.notesRepository = notesRepository;
    }

    @Override
    @Transactional
    public void addNotes(Notes notes) {
        notesRepository.save(notes);
    }

    @Override
    public Iterable<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    @Override
    public Notes getNotesById(int id) {
        return notesRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateNotes(int id, String key, String description, int temp) {
        Notes notes = notesRepository.findById(id).get();
        notes.setKey(key);
        notes.setDescription(description);
        notes.setTemp(temp);
        notesRepository.save(notes);
    }

    @Override
    @Transactional
    public void deleteNotesById(int id) {
        notesRepository.deleteById(id);
    }
}
