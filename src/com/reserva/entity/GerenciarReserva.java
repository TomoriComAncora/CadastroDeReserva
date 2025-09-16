package com.reserva.entity;

import java.util.Arrays;

public class GerenciarReserva {
  private Reserva[] reservas = new Reserva[10];
  private int contadorDeReservas = 0;

  public void adicionarReserva(Reserva reserva) {
    if (contadorDeReservas > 9) {
      System.out.println("Não há mais vagas a serem reservadas");
    } else {
      reservas[contadorDeReservas] = reserva;
      contadorDeReservas++;
    }
  }

  public Reserva[] listarReservas() {
    return Arrays.copyOf(reservas, contadorDeReservas);
  }

  public Reserva buscarPorNome(String nome) {
    for (int i = 0; i < contadorDeReservas; i++) {
      if (reservas[i].getNome().equalsIgnoreCase(nome)) {
        return (reservas[i]);
      }
    }
    return null;
  }

  public void ordenarReservasPorDia() {
    for (int i = 0; i < contadorDeReservas - 1; i++) {
      for (int j = 0; j < contadorDeReservas - i - 1; j++) {
        if (reservas[j].compareTo(reservas[j + 1]) > 0) {
          Reserva temp = reservas[j];
          reservas[j] = reservas[j + 1];
          reservas[j + 1] = temp;
        }
      }
    }
    for (int i = 0; i < contadorDeReservas; i++) {
      System.out.println(reservas[i]);
      System.out.println("---------------------------");
    }
  }

  public int getContadorDeReservas() {
    return reservas.length - contadorDeReservas;
  }
}
