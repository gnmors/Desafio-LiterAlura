package br.com.alura.Literalura.principal;

import br.com.alura.Literalura.model.DadosLivro;
import br.com.alura.Literalura.model.Livro;
import br.com.alura.Literalura.repository.LivroRepository;
import br.com.alura.Literalura.service.ConsumoApi;
import br.com.alura.Literalura.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConverteDados conversor = new ConverteDados();
    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO = "https://gutendex.com/books?search=";
    private List<DadosLivro> dadosLivros = new ArrayList<>();

    private LivroRepository repositorio;
    private List<Livro> livros = new ArrayList<>();

    private Optional<Livro> livroBusca;

    public Principal(LivroRepository repositorio) {
        this.repositorio = repositorio;
    }

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
                    8 - Buscar autor por nome
                    
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
                case 8:
                    buscarAutorPorNome();
                    break;
            }

        }
    }

    private void buscarLivro() {
        DadosLivro dadosLivro = getDadosLivro();
        Livro livro = new Livro(dadosLivro);
        repositorio.save(livro);
        System.out.println(dadosLivro);
    }

    private DadosLivro getDadosLivro() {
        System.out.println("Digite o nome do livro para busca");
        var nomeLivro = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeLivro.replace(" ", "+"));
        DadosLivro dadosLivro = conversor.obterDados(json, DadosLivro.class);
        return dadosLivro;
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

    private void buscarAutorPorNome() {
    }
}