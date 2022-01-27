package br.usp.ime.verao.backend.Memes;

import br.usp.ime.verao.backend.Memes.Exceptions.EntityValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemeService {
    private MemeRepository repository;

    @Autowired
    public MemeService(MemeRepository repository) {
        this.repository = repository;
    }

    // CRUD - Create, Read (one and all), Update e Delete

    public Meme createMeme(Meme meme) {
        Optional<Meme> oneByName = this.repository.findOneByName(meme.getName());
        if (oneByName.isPresent()) {
            throw new EntityValidationException("name");
        }

        Optional<Meme> oneByMedia = this.repository.findOneByMedia(meme.getMedia());
        if (oneByMedia.isPresent()) {
            throw new EntityValidationException("media");
        }

        return this.repository.save(meme);
    }
}
