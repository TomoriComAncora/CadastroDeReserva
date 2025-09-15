import com.reserva.entity.Reserva;

import java.util.Scanner;

public class Hotel {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int opcao = 0;
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
            System.out.println("Digite seu nome:");
            String nome = scanner.nextLine();
            System.out.println("Quantos dias de estadia: ");
            int numeroDeDias = scanner.nextInt();
            System.out.println("Valor da sua diária: ");
            double valorDiaria = scanner.nextDouble();
            System.out.println("Qual tipo de quarto? Standard-100R$, Luxo-200R$ ou Presidencial-350R$");
            String tipoQuarto = scanner.nextLine();
            Reserva reserva = new Reserva(nome, numeroDeDias, valorDiaria);
            System.out.println(reserva);
            break;
          case 2:
            System.out.println("Lista de reservas");
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
