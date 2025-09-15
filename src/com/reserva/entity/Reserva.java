package com.reserva.entity;

public class Reserva {
  private String nome;
  private String tipoDeQuarto;
  private int numeroDeDias;
  private double valorDiaria;
  private static int quantidadeReservas = 0;

  public Reserva(String nome, int numeroDeDias, double valorDiaria) {
    this.nome = nome;
    this.numeroDeDias = numeroDeDias;
    this.valorDiaria = valorDiaria;
  }

  @Override
  public String toString() {
    return "Nome do cliente: "
        + nome
        + "\nQuarto do cliente: "
        + tipoDeQuarto
        + "\nValor da diária: "
        + valorDiaria
        + "\nNúmero de dias de estadia: "
        + numeroDeDias;
  }
}
