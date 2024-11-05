package br.com.alura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("title") String titulo,
                         @JsonAlias("authors") String autor,
                         @JsonAlias("name") String nomeAutor,
                         @JsonAlias("birth_year") Integer dataDeNascimento,
                         @JsonAlias("death_year") Integer dataDeFalecimento,
                         @JsonAlias("languages") String linguagem,
                         @JsonAlias("download_count") Integer totalBaixado) {
}
