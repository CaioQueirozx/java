/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoeventos;

/**
 *
 * @author caioq
 */
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class projeto {

    private ArrayList<projetoeventos> eventos = new ArrayList<>();
    private ArrayList<usuario> usuarios = new ArrayList<>();

    // usuario

    public void cadastrarUsuario(usuario u) {
        usuarios.add(u);
    }

    public void listarUsuarios() {
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(i + " - " + usuarios.get(i));
        }
    }

    // evento

    public void cadastrarEvento(projetoeventos e) {
        eventos.add(e);
    }

    public void listarEventos() {
        eventos.sort(Comparator.comparing(projetoeventos::getHorario));
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println(i + " - " + eventos.get(i));
            System.out.println("-------------------");
        }
    }

    // participação

    public void participarEvento(int userIndex, int eventoIndex) {
        usuario u = usuarios.get(userIndex);
        projetoeventos e = eventos.get(eventoIndex);

        e.adicionarParticipante(u);
        System.out.println("Participação confirmada!");
    }

    public void cancelarParticipacao(int userIndex, int eventoIndex) {
        usuario u = usuarios.get(userIndex);
        projetoeventos e = eventos.get(eventoIndex);

        e.removerParticipante(u);
        System.out.println("Participação cancelada!");
    }

    // arquivo

    public void salvarEventos() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("events.data"));
            for (projetoeventos e : eventos) {
                writer.write(e.toFileString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar");
        }
    }

    public void carregarEventos() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("events.data"));
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");

                projetoeventos e = new projetoeventos(
                        partes[0],
                        partes[1],
                        partes[2],
                        LocalDateTime.parse(partes[3]),
                        partes[4]
                );

                eventos.add(e);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}