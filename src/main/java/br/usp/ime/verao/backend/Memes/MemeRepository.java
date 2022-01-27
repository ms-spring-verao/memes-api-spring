package br.usp.ime.verao.backend.Memes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {
    @Query("SELECT * FROM Meme m WHERE m.name = ?1 LIMIT 1")
    Optional<Meme> findOneByName(String name);

    Optional<Meme> findOneByMedia(String media);
}
