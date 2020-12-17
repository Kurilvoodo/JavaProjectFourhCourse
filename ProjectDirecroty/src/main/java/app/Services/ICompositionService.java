package app.Services;

import app.Entities.Composition;
import app.Entities.MusicInstrument;

import java.util.Set;

public interface ICompositionService {
    void addComposition(Composition composition);
    Iterable<Composition> getAllCompositions();
    Composition getCompositionById(int id);
    void updateComposition(int id, String compositionName, Set<MusicInstrument> musicInstrumentSet);
    void deleteComposition(int id);
}
