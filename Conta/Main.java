import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Conta buscarConta(ArrayList<Conta> vetor, String numero){

        Conta contaEncontrada = null;
        for(int i = 0; i < vetor.size(); i++){
                
            Conta c = vetor.get(i);

            if(c.getNroConta().equals(numero)){
                contaEncontrada = c;
                break;
            }
        }
        return contaEncontrada;
    }

    public static void main(String[] args) {
        
        ArrayList<Conta> vetor = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        int opcao = 0;
        while(opcao != 6){
            System.out.println("\n========== MENU ==========");
            System.out.println("(1) Criar uma nova Conta");
            System.out.println("(2) Exibir Saldo");
            System.out.println("(3) Sacar");
            System.out.println("(4) Depositar");
            System.out.println("(5) Transferir");
            System.out.println("(6) Encerrar Programa");
            System.out.println("==========================\n");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            switch(opcao){
                case 1:
                    System.out.print("Nome do titular: ");
                    String titular = sc.nextLine();

                    System.out.print("Numero da agência: ");
                    String agencia = sc.nextLine();

                    System.out.print("Qual banco: ");
                    String banco = sc.nextLine();

                    System.out.print("Numero da conta: ");
                    String nroConta = sc.nextLine();

                    Conta novaConta = new Conta(titular, agencia, banco, nroConta);
                    vetor.add(novaConta);
                    break;

                case 2:
                    System.out.print("Digite o numero da conta: ");
                    String numero = sc.nextLine();

                    Conta encontrada = buscarConta(vetor, numero);

                    if(encontrada != null){
                        System.out.println("\n=====================");
                        System.out.println("Saldo: R$" + encontrada.getSaldo());
                        System.out.println("=====================");
                        System.out.println(encontrada);
                    } 
                    else{
                        System.out.println("Conta não encontrada!");
                    }

                    break;

                case 3:
                    System.out.print("Digite o numero da conta: ");
                    numero = sc.nextLine();

                    encontrada = buscarConta(vetor, numero);

                    if(encontrada != null){
                        System.out.print("Valor a sacar: R$");
                        double valor = sc.nextDouble();

                        if(encontrada.sacar(valor)){
                            System.out.println("Saque realizado com sucesso!");
                        }
                        else{
                            System.out.println("Saldo insuficiente / Valor inválido");
                        }
                    }
                    else{
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 4:
                    System.out.print("Digite o numero da conta: ");
                    numero = sc.nextLine();

                    encontrada = buscarConta(vetor, numero);

                    if(encontrada != null){
                        System.out.print("Valor a depositar: R$");
                        double valor = sc.nextDouble();

                        if(encontrada.depositar(valor)){
                            System.out.println("Valor depositado com sucesso!");
                        }
                        else{
                            System.out.println("Saldo insuficiente / Valor inválido");
                        }
                    }
                    else{
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 5:
                    System.out.print("Digite o numero da conta: ");
                    numero = sc.nextLine();

                    encontrada = buscarConta(vetor, numero);

                    if(encontrada != null){
                        System.out.print("Valor a transferir: R$");
                        double valor = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Conta a receber a transferencia: ");
                        numero = sc.nextLine();
                        Conta destino = buscarConta(vetor, numero);
                        if(destino != null){
                            if(encontrada.transferir(valor, destino)){
                                System.out.println("Transferencia realizada com sucesso!");
                            }
                            else{
                                System.out.println("Saldo insuficiente / Valor inválido");
                            }
                        }
                        else{
                            System.out.println("Conta não encontrada!");
                        } 
                    }
                    else{
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 6:
                    System.out.println("Encerrando Programa...\n");
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }
        }
        sc.close();
    }
}
