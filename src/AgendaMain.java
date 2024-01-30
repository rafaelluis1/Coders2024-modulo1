import Agenda.*;
import Contato.*;
import java.util.*;

public class AgendaMain {
    public static void main (String[] args){
        Agenda agenda = new Agenda();
        System.out.println(Agenda.listarContatos());
        Scanner sc = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(sc);
            comando(escolha, agenda, sc);
        }
    }

    private static String menu(Scanner scanner) {
        System.out.println("""
                >>>> Menu <<<<
                1 - Adicionar Contato
                2 - Remover Contato
                3 - Editar Contato
                4 - Sair
                """);
        return scanner.next();
    }

    private static void comando(String opcao, Agenda agenda, Scanner scanner) {
        switch (opcao) {
            case "1":
                adicionaContato(agenda, scanner);
                break;
            case "2":
                removeContato(agenda, scanner);
                break;
            case "3":
                //editaContato(agenda, scanner);
                break;
            case "4":
                sai();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void adicionaContato(Agenda agenda, Scanner scanner) {
        System.out.println("Qual o id?");
        int id = scanner.nextInt();
        while (!Agenda.validaId(id)) {
            System.out.println("Id Inválido! Qual o id?");
            id = scanner.nextInt();
        }
        System.out.println("Qual o nome?");
        String nome = scanner.next();
        System.out.println("Qual o sobrenome?");
        String sobrenome = scanner.next();
        System.out.println("Qual o telefone?");
        System.out.println("DDD:");
        String ddd = scanner.next();
        System.out.println("Numero:");
        String numero = scanner.next();
        Telefone telefone = new Telefone(ddd, numero);
        while (!Agenda.validaTelefone(telefone)){
            System.out.println("Telefone já cadastrado! Qual o telefone?");
            System.out.println("DDD:");
            ddd = scanner.next();
            System.out.println("Numero:");
            numero = scanner.next();
            telefone = new Telefone(ddd, numero);
        }
        Agenda.adicionarContato(id, nome, sobrenome, telefone);
    }

    public static void removeContato(Agenda agenda, Scanner scanner){
        System.out.println("Qual o id do contato a ser removido?");

    }

    public stativ void sai(){
        System.exit(0);
    }


}
