package br.usp.ime.verao.backend.Memes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/memes")
public class MemeController {
    private MemeService service;

    @Autowired
    public MemeController(MemeService service) {
        this.service = service;
    }

    // Create Meme -> POST /memes (body: Meme)
    // { "name": "...", "media": "...", "keywords": [...] }
    @PostMapping
    public Meme createMeme(@RequestBody Meme meme) {
        return this.service.createMeme(meme);
    }
}
