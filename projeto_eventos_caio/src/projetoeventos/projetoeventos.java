/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoeventos;

/**
 *
 * @author caioq
 */
import java.time.LocalDateTime;
import java.util.ArrayList;

public class projetoeventos {
    private final String nome;
    private final String endereco;
    private final String categoria;
    private final LocalDateTime horario;
    private final String descricao;
    private ArrayList<usuario> participantes;

    public projetoeventos(String nome, String endereco, String categoria,
                  LocalDateTime horario, String descricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
        this.descricao = descricao;
        this.participantes = new ArrayList<>();
    }

    public void adicionarParticipante(usuario u) {
        participantes.add(u);
    }

    public void removerParticipante(usuario u) {
        participantes.remove(u);
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public String toFileString() {
        return nome + ";" + endereco + ";" + categoria + ";" + horario + ";" + descricao;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return nome + " | " + categoria + " | " + horario + "\n" + descricao;
    }
}