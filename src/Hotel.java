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
          "1 - Nova reserva \n2 - Listar reserva \n3 - Buscar reserva por nome do hóspede \n4 - Ordernar reserva por número de dias \n5 - Sair");
      opcao = scanner.nextInt();
      scanner.nextLine();
      if (opcao < 0 || opcao > 5) {
        System.out.println("Por favor, escolha um número entre 1 e 5");
      } else {
        switch (opcao) {
          case 1:
            if(contatdorDeReservas > 9){
                throw new Exception("Não há mais vagas a serem reservadas");
            }else {
                System.out.println("Digite seu nome:");
                String nome = scanner.nextLine();
                System.out.println("Quantos dias de estadia: ");
                int numeroDeDias = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Qual tipo de quarto? Standard - 110,80 R$, Luxo - 290, 30 R$ ou Presidencial - 459,99 R$");
                String tipoQuarto = scanner.nextLine();
                Reserva reserva = new Reserva(nome, numeroDeDias, tipoQuarto);
                reservas[contatdorDeReservas] = reserva;
                contatdorDeReservas++;
                Reserva.setQuantidadeReservas(1);
                reserva.setValorDiaria(numeroDeDias, tipoQuarto);
                System.out.println("Restam: " + (reservas.length - reserva.getQuantidadeReservas()) + " vagas");
            }
            break;
          case 2:
            System.out.println("Lista de reservas");
            for (int i = 0; i < contatdorDeReservas; i++) {
              System.out.println(reservas[i]);
              System.out.println("Valor total da diária: " + reservas[i].getValorDiaria());
              System.out.println("------------------------------------");
            }
            break;
          case 3:
            System.out.println("Buscar reserva por nome");
            break;
          case 4:
            System.out.println("Ordenar as reservas");
            break;
          case 5:
            System.out.println("Sair");
            break;
          default:
            System.out.println("opção inválida");
            break;
        }
      }

    } while (opcao != 5);
  }
}
