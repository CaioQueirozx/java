/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoeventos;

/**
 *
 * @author caioq
 */
public class usuario {
    private final String nome;
    private final String email;
    private final int idade;

    public usuario(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return nome + " - " + email + " - " + idade;
    }
}