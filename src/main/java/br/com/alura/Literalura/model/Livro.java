package br.com.alura.Literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {
    private String titulo;
    private String name;
    private int downloads;
    private String languages;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autor autor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Livro() {}

    public Livro(String titulo, List<String> languages, int downloads, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.name = autor.getNome();
        this.languages = languages.get(0);
        this.downloads = downloads;
    }

    public Livro(Livro livroEncontrado) {
        this.titulo = livroEncontrado.titulo;
        this.name = livroEncontrado.getAutor().getNome();
        this.languages = livroEncontrado.languages;
        this.downloads = livroEncontrado.downloads;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return""" 
                ******** LIVRO ********
                Título: %s
                Nome do Autor: %s
                Linguagem: %s
                Downloads: %d
                ***********************
                """.formatted(titulo, name, languages, downloads);
    }
}