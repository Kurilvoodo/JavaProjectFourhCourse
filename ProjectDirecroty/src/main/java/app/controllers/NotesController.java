package app.controllers;

import app.Entities.Notes;
import app.Services.Impl.NotesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.Services.Impl.MusicInstrumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/api")
public class NotesController {
    private final NotesService notesService;
    @Autowired
    public NotesController(NotesService notesService){
        this.notesService =notesService;
    }

    @RequestMapping(value = "Notes/getAllNotes", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Notes> getAllNotes(){
        return notesService.getAllNotes();
    }

    @RequestMapping(value = "Notes/getNotesById/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Notes getNotesById(@PathVariable int id){
        return notesService.getNotesById(id);
    }

    @RequestMapping(value = "Notes/addNotes", method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_VALUE)
    public void addNotes(@RequestParam String key, @RequestParam String description, @RequestParam int temp){
        notesService.addNotes(new Notes(key, description, temp));
    }

    @RequestMapping(value="Notes/removeNotes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeNotes(@RequestParam int id){
        notesService.deleteNotesById(id);
    }

    @RequestMapping(value = "Notes/updateNotes", method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_VALUE)
    public void updateNotes(@RequestParam int id, @RequestParam String key, @RequestParam  String description, @RequestParam int temp ){
        notesService.updateNotes(id, key, description, temp);
    }

}
