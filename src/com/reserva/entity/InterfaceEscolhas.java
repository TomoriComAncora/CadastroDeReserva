package com.reserva.entity;

import java.util.Scanner;

public class InterfaceEscolhas {
  private Scanner scanner = new Scanner(System.in);

  public void exibirMenu() {
    System.out.println("=== Bem vindo ao Hotel ===");
    System.out.println(
        "1 - Nova reserva \n2 - Listar reserva \n3 - Buscar reserva por nome do hóspede \n4 - Ordernar reserva por dias \n5 - Sair\n");
    System.out.println("================================");
  }

  public int lerOpcoes() {
    int opcao = 0;
    System.out.println("Escolha uma opção: ");
    if (scanner.hasNextInt()) {
      opcao = scanner.nextInt();
    } else {
      System.out.println("Entrada inválida. Por favor digite um número");
    }
    scanner.nextLine();
    return opcao;
  }

  public Reserva coletarDadosNovaReserva() throws Exception {
    System.out.println("=== Nova Reserva ===");
    System.out.println("Digite seu nome: ");
    String nome = scanner.nextLine().toLowerCase();
    System.out.println("Quantos dias de estadia: ");
    int numeroDeDias = Integer.parseInt(scanner.nextLine());
    System.out.println("Qual o tipo do quarto: \nStandard - 110,80 R$\nLuxo - 290,30 R$\nPresidencial - 459,99 R$");
    String tipoQuarto = scanner.nextLine().toLowerCase();

    Reserva reserva = new Reserva(nome, tipoQuarto, numeroDeDias);
    reserva.setValorDiaria(numeroDeDias, tipoQuarto);
    return reserva;
  }

  public String pedirNomeParaBuscar(){
    System.out.println("Digite o nome do titular para buscar");
    return scanner.nextLine().toLowerCase();
  }


}
