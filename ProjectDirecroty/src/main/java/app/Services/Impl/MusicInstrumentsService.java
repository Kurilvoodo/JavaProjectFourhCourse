package app.Services.Impl;

import app.Entities.MusicInstrument;
import app.Services.IMusicInstrumentsService;
import app.repos.MusicInstrumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Service
public class MusicInstrumentsService implements IMusicInstrumentsService {
    @Autowired
    private MusicInstrumentRepository musicInstrumentRepository;

    @Override
    @Transactional
    public void addMusicInstrument(MusicInstrument musicInstrument) {
        musicInstrumentRepository.save(musicInstrument);
    }

    @Override
    public Iterable<MusicInstrument> getAllMusicInstruments() {
        return musicInstrumentRepository.findAll();
    }

    @Override
    public MusicInstrument getMusicInstrumentById(int id) {
        return musicInstrumentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateMusicInstrument(int id, String soundBankReference) {
        MusicInstrument musicInstrument = musicInstrumentRepository.findById(id).get();
        musicInstrument.setSoundBankReference(soundBankReference);
        musicInstrumentRepository.save(musicInstrument);
    }

    @Override
    @Transactional
    public void deleteMusicInstrument(int id) {
        musicInstrumentRepository.deleteById(id);
    }

    @Override
    public Iterable<MusicInstrument> searchMusicInstrumentByTemp(int temp) {
        return musicInstrumentRepository.findByTempQuery(temp);
    }
}
