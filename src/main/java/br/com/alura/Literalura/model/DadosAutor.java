package br.com.alura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosAutor(@JsonAlias("name") String nomeAutor,
                         @JsonAlias("birth_year") Integer dataDeNascimento,
                         @JsonAlias("death_year") Integer dataDeFalecimento) {
}
