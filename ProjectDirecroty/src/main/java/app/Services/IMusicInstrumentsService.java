package app.Services;

import app.Entities.MusicInstrument;

public interface IMusicInstrumentsService {
    void addMusicInstrument(MusicInstrument musicInstrument);
    Iterable<MusicInstrument>getAllMusicInstruments();
    MusicInstrument getMusicInstrumentById(int id);
    void updateMusicInstrument(int id, String soundBankReference);
    void deleteMusicInstrument(int id);
    Iterable<MusicInstrument> searchMusicInstrumentByTemp(int temp);

}
