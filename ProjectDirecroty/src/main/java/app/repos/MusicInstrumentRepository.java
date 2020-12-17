package app.repos;

import app.Entities.MusicInstrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicInstrumentRepository extends JpaRepository<MusicInstrument, Integer> {

    @Query("select m from MusicInstrument m inner join Notes n on m.notes.idNote= n.idNote where n.temp = :temp")
    List<MusicInstrument> findByTempQuery(@Param("temp") Integer temp);
}
