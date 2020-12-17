package app.controllers;

import app.Entities.Composition;
import app.Entities.MusicInstrument;
import app.Services.Impl.CompositionService;
import app.Services.Impl.MusicInstrumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class CompositionController {
    private final CompositionService compositionService;
    private final MusicInstrumentsService musicInstrumentsService;
    @Autowired
    public CompositionController(CompositionService compositionService, MusicInstrumentsService musicInstrumentsService){
        this.compositionService = compositionService;
        this.musicInstrumentsService = musicInstrumentsService;
    }

    @RequestMapping(value = "Composition/getAllCompositions", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Composition> getAllCompositions(){
        return compositionService.getAllCompositions();
    }

    @RequestMapping(value = "Composition/getCompositionById/{id}", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Composition getCompositionById(@PathVariable int id){
        return compositionService.getCompositionById(id);
    }

    @RequestMapping(value = "Composition/addComposition", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void addComposition(@RequestParam String compositionName, @RequestParam String authorName, @RequestParam double duration){
        compositionService.addComposition(new Composition(compositionName, authorName, duration));
    }

    @RequestMapping(value = "Composition/removeComposition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeCompositionById(@RequestParam int id){
        compositionService.deleteComposition(id);
    }
    @RequestMapping(value = "Composition/updateComposition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateComposition(@RequestParam int id, @RequestParam String compositonName, @RequestParam Set<MusicInstrument> musicInstrumentSet){
        compositionService.updateComposition(id,compositonName, musicInstrumentSet);
    }


}
