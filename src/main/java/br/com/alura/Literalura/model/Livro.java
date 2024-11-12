package br.com.alura.Literalura.model;

import jakarta.persistence.*;

@Entity
@Table
public class Livro {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String autor;
    private Integer datadeNascimento;
    private Integer dataDeFalecimento;
    private String linguagem;
    private Integer totalBaixado;

    public Livro(DadosLivro dadosLivro) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public Integer getTotalBaixado() {
        return totalBaixado;
    }

    public void setTotalBaixado(Integer totalBaixado) {
        this.totalBaixado = totalBaixado;
    }

    public Integer getDatadeNascimento() {
        return datadeNascimento;
    }

    public void setDatadeNascimento(Integer datadeNascimento) {
        this.datadeNascimento = datadeNascimento;
    }

    public Integer getDataDeFalecimento() {
        return dataDeFalecimento;
    }

    public void setDataDeFalecimento(Integer dataDeFalecimento) {
        this.dataDeFalecimento = dataDeFalecimento;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", linguagem='" + linguagem + '\'' +
                ", totalBaixado=" + totalBaixado;
    }
}
