package app.Services.Impl;

import app.Entities.Composition;
import app.Entities.MusicInstrument;
import app.Services.ICompositionService;
import app.repos.CompositionRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
@Service
public class CompositionService implements ICompositionService {
    private final CompositionRepositary compositionRepositary;
    @Autowired
    public CompositionService(CompositionRepositary compositionRepositary){
        this.compositionRepositary = compositionRepositary;
    }

    @Override
    @Transactional
    public void addComposition(Composition composition) {
        compositionRepositary.save(composition);
    }

    @Override
    public Iterable<Composition> getAllCompositions() {
        return compositionRepositary.findAll();
    }

    @Override
    public Composition getCompositionById(int id) {
        return compositionRepositary.findById(id).get();
    }

    @Override
    @Transactional
    public void updateComposition(int id, String compositionName, Set<MusicInstrument> musicInstrumentSet) {
        Composition composition = compositionRepositary.findById(id).get();
        composition.setCompositionName(compositionName);
        composition.setMusicInstruments(musicInstrumentSet);
        compositionRepositary.save(composition);
    }

    @Override
    @Transactional
    public void deleteComposition(int id) {
        compositionRepositary.deleteById(id);
    }
}
