package com.reserva.entity;

public class Reserva implements Comparable<Reserva>{
  private String nome;
  private String tipoDeQuarto;
  private int numeroDeDias;
  private double valorDiaria;

  public Reserva(String nome, String tipoDeQuarto, int numeroDeDias ) throws Exception {
    this.nome = validarNome(nome);
    this.tipoDeQuarto = validarQuartos(tipoDeQuarto);
    this.numeroDeDias = validarDias(numeroDeDias);
  }


  private String validarNome(String nome) throws Exception {
    if (nome.isEmpty()) {
      throw new Exception("Nome inválido!");
    }
    return nome;
  }

  private int validarDias(int numeroDeDias) throws Exception {
    if (numeroDeDias <= 0) {
      throw new Exception("Dias de estadias inválidos");
    }
    return numeroDeDias;
  }

  private String validarQuartos(String tipoDeQuarto) throws Exception {
    if (tipoDeQuarto.equalsIgnoreCase("standard")
        || tipoDeQuarto.equalsIgnoreCase("luxo")
        || tipoDeQuarto.equalsIgnoreCase("presidencial")) {
      return tipoDeQuarto;
    } else {
      throw new Exception("Quarto não encotrado!");
    }
  }

  private double calcularValorTotal(int numeroDeDias, String tipoDeQuarto) throws Exception {
    return switch (tipoDeQuarto) {
      case "standard" -> this.valorDiaria = numeroDeDias * 110.80;
      case "luxo" -> this.valorDiaria = numeroDeDias * 290.30;
      case "presidencial" -> this.valorDiaria = numeroDeDias * 459.99;
      default -> throw new Exception("Quarto inválido");
    };
  }

  public double getValorDiaria() {
    return valorDiaria;
  }

  public void setValorDiaria(int numeroDeDias, String tipoDeQuarto) throws Exception {
    this.valorDiaria = calcularValorTotal(numeroDeDias, tipoDeQuarto);
  }

    public String getNome() {
        return nome;
    }

    public int getNumeroDeDias() {
        return numeroDeDias;
    }

    @Override
  public String toString() {
    return "Nome do cliente: "
        + nome
        + "\nQuarto escolhido: "
        + tipoDeQuarto
        + "\nNúmero de dias de estadia: "
        + numeroDeDias
            + "\nValor total da diária: " + valorDiaria;
  }

    @Override
    public int compareTo(Reserva reserva) {
        return this.numeroDeDias - reserva.getNumeroDeDias();
    }
}
