import com.reserva.entity.GerenciarReserva;
import com.reserva.entity.InterfaceEscolhas;
import com.reserva.entity.Reserva;

import java.util.Scanner;

public class Hotel {
  public static void main(String[] args) throws Exception {
    GerenciarReserva gerenciarReserva = new GerenciarReserva();
    InterfaceEscolhas ui = new InterfaceEscolhas();

    int opcao = 0;

    do {
      ui.exibirMenu();
      opcao = ui.lerOpcoes();

      switch (opcao) {
        case 1:
          Reserva reserva = ui.coletarDadosNovaReserva();
          gerenciarReserva.adicionarReserva(reserva);
          System.out.println("Restam: " + gerenciarReserva.getContadorDeReservas() + " vagas.");
          break;
        case 2:
          System.out.println("------Lista de Reservas ------");
          for (Reserva r : gerenciarReserva.listarReservas()) {
            System.out.println(r);
            System.out.println("---------------------------");
          }
          break;
        case 3:
          String nome = ui.pedirNomeParaBuscar();
          Reserva encontrada = gerenciarReserva.buscarPorNome(nome);
          if (encontrada != null) {
            System.out.println("Reserva encontrada:\n" + encontrada);
          } else {
            System.out.println("Nenhuma reserva encontrada no nome de: " + nome);
          }
          break;
        case 4:
          System.out.println("Reservas ordenadas por número de dias");
          gerenciarReserva.ordenarReservasPorDia();
          System.out.println("---------------------------");
          break;
        case 5:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção inválida, tente novamente");
      }
    } while (opcao != 5);
  }
}
