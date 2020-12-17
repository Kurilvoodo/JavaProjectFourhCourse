package app.controllers;


import app.Entities.MusicInstrument;
import app.Entities.Notes;
import app.Services.Impl.MusicInstrumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MusicInstrumentController {
    private  final MusicInstrumentsService musicInstrumentsService;
    @Autowired
    public MusicInstrumentController(MusicInstrumentsService musicInstrumentsService){
        this.musicInstrumentsService = musicInstrumentsService;
    }

    @RequestMapping(value = "MusicInstrument/addMusicInstrument", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addMusicInstrument(@RequestParam String name, @RequestParam String soundBankReference, @RequestParam Notes notes){
        musicInstrumentsService.addMusicInstrument(new MusicInstrument(name, soundBankReference, notes));
    }
    @RequestMapping(value = "MusicInstrument/getAllMusicInstruments", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MusicInstrument> getAllInstruments(){
        return musicInstrumentsService.getAllMusicInstruments();
    }

    @RequestMapping(value = "MusicInstrument/getMusicInstrument/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public MusicInstrument getMusicInstrument(@PathVariable int id){
        return musicInstrumentsService.getMusicInstrumentById(id);
    }

    @RequestMapping(value = "MusicInstrument/removeMusicInstrument", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeMusicInstrument(@RequestParam int id){
        musicInstrumentsService.deleteMusicInstrument(id);
    }

    @RequestMapping(value = "MusicInstrument/updateMusicInstrument", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateMusicInstrument(@RequestParam int id, @RequestParam String soundbankReference){
        musicInstrumentsService.updateMusicInstrument(id,soundbankReference);
    }

    @RequestMapping(value = "MusicInstrument/searchMusicInstruments/{temp}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MusicInstrument> searchMusicInstruments(@PathVariable int temp ){
        return musicInstrumentsService.searchMusicInstrumentByTemp(temp);
    }
}
