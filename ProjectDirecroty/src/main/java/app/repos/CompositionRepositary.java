package app.repos;

import app.Entities.Composition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompositionRepositary extends JpaRepository <Composition, Integer>{


}
