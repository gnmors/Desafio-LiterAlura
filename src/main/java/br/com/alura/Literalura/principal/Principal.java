package br.com.alura.Literalura.principal;

import br.com.alura.Literalura.model.Autor;
import br.com.alura.Literalura.model.DadosLivro;
import br.com.alura.Literalura.model.DadosResult;
import br.com.alura.Literalura.model.Livro;
import br.com.alura.Literalura.repository.AutorRepository;
import br.com.alura.Literalura.repository.LivroRepository;
import br.com.alura.Literalura.service.ConsumoApi;
import br.com.alura.Literalura.service.ConverteDados;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.awt.print.Book;
import java.util.*;

public class Principal {

    private final Scanner leitura = new Scanner(System.in);
    private final ConverteDados conversor = new ConverteDados();
    private final ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autor;
    private LivroRepository repository;
    private AutorRepository autorRepository;

    public Principal(LivroRepository repository, AutorRepository autorRepository) {
        this.repository = repository;
        this.autorRepository = autorRepository;
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

    private void buscarAutorPorNome() {
    }

    private void buscarLivroPorAutor() {
    }

    private void top10MaisBaixados() {
    }

    private void listarLivroPorIdioma() {
        System.out.println("Encontar livro em qual idioma?");
        var idioma = leitura.nextLine();
        List<Livro> livros = repository.findAll();
        List<Livro> livrosEncontrados = livros.stream()
                .filter(livro -> Objects.equals(livro.getLanguages(), idioma))
                .toList();
        if (livrosEncontrados.isEmpty()){
            System.out.println("Nenhum livro encontrado nesse idioma!");
        } else { livrosEncontrados.forEach(System.out::println); }
    }

    private void listarAutoresVivosPorAno() {
        System.out.println("Encontar autor vivo em determinado ano?");
        var ano = leitura.nextInt();
        autor = autorRepository.findAll();
        autor.stream()
                .filter(d-> d.getAnoDeNascimento() <= ano && d.getAnoDeFalecimento() >= ano)
                .forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        autor = autorRepository.findAll();
        autor.forEach(System.out::println);
    }

    private void listarLivrosBuscados() {
        livros = repository.findAll();
        livros.stream()
                .sorted(Comparator.comparing(Livro::getTitulo))
                .sorted(Comparator.comparing(Livro::getName)).forEach(System.out::println);
    }

    private void buscarLivro() {
        var dadoslivro = getDadosLivro().result().stream()
                .flatMap(livro -> livro.autor().stream()
                        .map(autho ->
                                new Livro(livro.titulo(), Collections.singletonList((String) livro.languages().get(0)),livro.downloads(),
                                        new Autor(autho.nome(),
                                                Optional.ofNullable(autho.anoDeNascimento()).orElse(0),
                                                Optional.ofNullable(autho.anoDeFalecimento()).orElse(0),
                                                livro.titulo()))))
                .toList();

        Livro livroEncontrado = dadoslivro.get(0);
        Livro livro = new Livro(livroEncontrado);

        Autor autor = new Autor(dadoslivro.get(0).getName(),
                dadoslivro.get(0).getAutor().getAnoDeNascimento(),
                dadoslivro.get(0).getAutor().getAnoDeFalecimento(),
                dadoslivro.get(0).getTitulo()
        );

        try {
            livro.setAutor(autor);
            autor.setLivro(livros);
            repository.save(livro);
            System.out.println(livro);
        } catch (InvalidDataAccessApiUsageException e){
            System.out.println("erro ao criar" + e);
        }

    }
    private DadosResult getDadosLivro() {
        System.out.println("Digite o nome do livro para busca");
        var nomeLivro = leitura.nextLine().replace(" ", "+");;
        var json = consumo.obterDados(ENDERECO + nomeLivro);
        return conversor.obterDados(json, DadosResult.class);
    }

    }

 