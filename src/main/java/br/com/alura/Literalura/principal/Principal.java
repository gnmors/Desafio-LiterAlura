package br.com.alura.Literalura.principal;

import br.com.alura.Literalura.model.DadosLivro;
import br.com.alura.Literalura.model.Livro;
import br.com.alura.Literalura.service.ConsumoApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO = "https://gutendex.com/books?search=";
    private List<DadosLivro> dadosLivros = new ArrayList<>();

    private Optional<Livro> livroBusca;

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - listar livros em um determinado idioma
                    6 - Top 10 livros mais baixados
                    7 - Buscar livro por nome de autor
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivro();
                    break;
                case 2:
                    listarLivrosBuscados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosPorAno();
                    break;
                case 5:
                    listarLivroPorIdioma();
                    break;
                case 6:
                    top10MaisBaixados();
                    break;
                case 7:
                    buscarLivroPorAutor();
                    break;
            }

        }
    }

    private void buscarLivro() {
    }

    private void listarLivrosBuscados() {
    }

    private void listarAutoresRegistrados() {
    }

    private void listarAutoresVivosPorAno() {
    }

    private void listarLivroPorIdioma() {
    }

    private void top10MaisBaixados() {
    }

    private void buscarLivroPorAutor() {
    }
}