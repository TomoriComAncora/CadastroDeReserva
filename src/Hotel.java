import com.reserva.entity.Reserva;

import java.util.Scanner;

public class Hotel {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    Reserva[] reservas = new Reserva[10];
    int opcao = 0;
    int contatdorDeReservas = 0;
    do {
      System.out.println("Escolha uma opção: ");
      System.out.println(
          "1 - Nova reserva \n2 - Listar reserva \n3 - Buscar reserva por nome do hóspede \n4 - Ordernar reserva por número de dias \n5 - Sair\n");
      if (scanner.hasNextInt()) {
        opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao < 0 || opcao > 5) {
          System.out.println("Por favor, escolha um número entre 1 e 5");
        } else {
          switch (opcao) {
            case 1:
              System.out.println("------Reservar quarto------");
              if (contatdorDeReservas > 9) {
                System.out.println("Não há mais vagas a serem reservadas");
              } else {
                System.out.println("Digite seu nome:");
                String nome = scanner.nextLine().toLowerCase();
                System.out.println("Quantos dias de estadia: ");
                int numeroDeDias = scanner.nextInt();
                scanner.nextLine();
                System.out.println(
                    "Qual tipo de quarto? Standard - 110,80 R$, Luxo - 290, 30 R$ ou Presidencial - 459,99 R$");
                String tipoQuarto = scanner.nextLine().toLowerCase();
                Reserva reserva = new Reserva(nome, tipoQuarto, numeroDeDias);
                reservas[contatdorDeReservas] = reserva;
                contatdorDeReservas++;
                reserva.setValorDiaria(numeroDeDias, tipoQuarto);
                System.out.println(
                    "Restam: " + (reservas.length - contatdorDeReservas) + " vagas");
              }
              System.out.println("------------------------------------");
              break;
            case 2:
              System.out.println("------Lista de reservas------");
              for (int i = 0; i < contatdorDeReservas; i++) {
                System.out.println(reservas[i]);
                System.out.println("------------------------------------");
              }
              break;
            case 3:
              System.out.println("------Buscar reserva por nome------");
              System.out.println("Digite o nome do titular para buscar a reserva");
              String nomeTitular = scanner.nextLine().toLowerCase();
              boolean encontrado = false;
              for (int i = 0; i < contatdorDeReservas; i++) {
                if (reservas[i].getNome().equalsIgnoreCase(nomeTitular)) {
                  System.out.println(reservas[i]);
                  System.out.println("------------------------------------");
                  encontrado = true;
                  break;
                }
              }
              if (!encontrado) {
                System.out.println("Não existe reserva no nome de " + nomeTitular + ".");
              }
              break;
            case 4:
              System.out.println("------Ordenar as reservas------");
              for (int i = 0; i < contatdorDeReservas - 1; i++) {
                for (int j = 0; j < contatdorDeReservas - i - 1; j++) {
                  if (reservas[j].compareTo(reservas[j + 1]) > 0) {
                    Reserva temp = reservas[j];
                    reservas[j] = reservas[j + 1];
                    reservas[j + 1] = temp;
                  }
                }
              }
              for (int i = 0; i < contatdorDeReservas; i++) {
                System.out.println(reservas[i]);
                System.out.println("------------------------------------");
              }
              break;
            case 5:
              System.out.println("------Saindo------");
              break;
            default:
              System.out.println("opção inválida");
              break;
          }
        }
      } else {
        System.out.println("Por favor, digite um número de 1 a 5!");
        scanner.nextLine();
      }

    } while (opcao != 5);
  }
}
