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
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        projeto sistema = new projeto();

        sistema.carregarEventos();

        int opcao;

        do {
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Cadastrar Evento");
            System.out.println("3 - Listar Eventos");
            System.out.println("4 - Participar de Evento");
            System.out.println("5 - Cancelar Participação");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    sistema.cadastrarUsuario(new usuario(nome, email, idade));
                }

                case 2 -> {
                    System.out.print("Nome: ");
                    String nomeEvento = sc.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();

                    System.out.print("Data (DD-MM-AAAA, HH:MM): ");
                    String data = sc.nextLine();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy, hh:mm");
                    LocalDateTime horario = LocalDateTime.parse(data, formatter);

                    sistema.cadastrarEvento(new projetoeventos(nomeEvento, endereco, categoria, horario, descricao));
                }

                case 3 -> sistema.listarEventos();

                case 4 -> {
                    System.out.println("Escolha o usuário:");
                    sistema.listarUsuarios();
                    int uIndex = sc.nextInt();

                    System.out.println("Escolha o evento:");
                    sistema.listarEventos();
                    int eIndex = sc.nextInt();

                    sistema.participarEvento(uIndex, eIndex);
                }

                case 5 -> {
                    System.out.println("Escolha o usuário:");
                    sistema.listarUsuarios();
                    int uIndexCancel = sc.nextInt();

                    System.out.println("Escolha o evento:");
                    sistema.listarEventos();
                    int eIndexCancel = sc.nextInt();

                    sistema.cancelarParticipacao(uIndexCancel, eIndexCancel);
                }
            }

        } while (opcao != 0);

        sistema.salvarEventos();
        sc.close();
    }
}
