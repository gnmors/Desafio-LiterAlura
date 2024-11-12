package br.com.alura.Literalura.model;

public enum Linguagens {
    PORTUGUES("pt", "português"),
    INGLES("en", "inglês"),
    ESPANHOL("es", "espanhol"),
    FRANCES("fr", "francês");

    private String linguagemAPI;
    private String linguagemConvertida;

    Linguagens(String linguagemAPI, String linguagemConvertida) {
        this.linguagemAPI = linguagemAPI;
        this.linguagemConvertida = linguagemConvertida;
    }
}
