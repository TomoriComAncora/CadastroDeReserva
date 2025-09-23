package com.reserva.entity;

import java.util.Set;
import java.util.TreeSet;

public class GerenciarReserva {
    Set<Reserva> reservas = new TreeSet<>();
  private final int CAPACIDADE_MAX = 10;

  public void adicionarReserva(Reserva reserva) {
      if(reservas.size() < CAPACIDADE_MAX){
          reservas.add(reserva);
      }else {
          System.out.println("Não há mais vagas a serem reservadas");
      }
  }

  public Set<Reserva> listarReservas() {
    return new TreeSet<>(this.reservas);
  }

  public Reserva buscarPorNome(String nome) {
    for(Reserva reserva : this.reservas){
        if (reserva.getNome().equalsIgnoreCase(nome)){
            return reserva;
        }
    }
    return null;
  }

  public int getContadorDeReservas() {
    return CAPACIDADE_MAX - reservas.size();
  }
}
