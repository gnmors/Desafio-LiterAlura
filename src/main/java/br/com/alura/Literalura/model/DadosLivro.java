package br.com.alura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("title") String titulo,
                         @JsonAlias("authors") List<DadosAutor> autor,
                         @JsonAlias("languages") ArrayList languages,
                         @JsonAlias("download_count") int downloads) {
}
