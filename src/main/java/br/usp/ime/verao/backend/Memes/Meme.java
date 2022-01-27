package br.usp.ime.verao.backend.Memes;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Meme {
    @Id
    @SequenceGenerator(
            name = "meme_seq_generator",
            sequenceName = "meme_seq_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "meme_seq_generator"
    )
    private Long id;

    private String name;

    @ElementCollection
    /*@CollectionTable(
            name = "memekeyword",
            joinColumns = @JoinColumn(name = "id")
    )
    @Column(name = "keyword")*/
    private Set<String> keywords;

    private String media;

    public Meme() {
    }

    public Meme(String name, Set<String> keywords, String media) {
        this.name = name;
        this.keywords = keywords;
        this.media = media;
    }

    public Meme(Long id, String name, Set<String> keywords, String media) {
        this.id = id;
        this.name = name;
        this.keywords = keywords;
        this.media = media;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Meme{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keywords=" + keywords +
                ", media='" + media + '\'' +
                '}';
    }
}
