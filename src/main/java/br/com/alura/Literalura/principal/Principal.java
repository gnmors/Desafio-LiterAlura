package br.com.alura.Literalura.principal;

import br.com.alura.Literalura.service.ConsumoApi;

import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO = "https://gutendex.com/books?search="; //nome do livro aqui;
}
