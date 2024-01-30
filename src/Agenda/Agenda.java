package Agenda;

import Contato.*;
import java.io.*;
public class Agenda {

    private static File contato = new File("C:/Users/rafae/Agenda/src/Database/Contatos.txt");
    private static  File telefones = new File("C:/Users/rafae/Agenda/src/Database/Telefones.txt");
    public static String listarContatos(){
        String contatos = """
                        >>>> Contatos <<<<
                        Id | Nome
                        """;
        try {
            FileReader fileReader = new FileReader(contato);
            BufferedReader bf = new BufferedReader(fileReader);
            String linha = bf.readLine();
            while (linha != null) {
                if (linha.length() > 0) {
                    contatos += processaLinha(linha) + "\n";
                }
                linha = bf.readLine();
            }
            bf.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contatos;
    }


    public static void adicionarContato(int id, String nome, String sobrenome, Telefone telefone){

        try {
            String linhaContato = String.format("%d;%s;%s", id, nome, sobrenome);
            FileWriter fileWriter = new FileWriter(contato, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.newLine();
            bw.write(linhaContato);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            String linhaTelefone = String.format("%d;%s", id, telefone.toString());
            FileWriter fileWriter = new FileWriter(telefones, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.newLine();
            bw.write(linhaTelefone);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void removerContato(int idContato){

    }

    public void editarContato(String novoNome, String novoSobrenome){

    }

    public static boolean validaId(int id){
        int idCadastrado = 0;
        try {
            FileReader fileReader = new FileReader(contato);
            BufferedReader bf = new BufferedReader(fileReader);
            String linha = bf.readLine();
            while (linha != null) {
                if (linha.length() > 0) {
                    idCadastrado = Integer.parseInt(processaLinhaId(linha));
                    if(id == idCadastrado){
                        return false;
                    }
                }
                linha = bf.readLine();
            }
            bf.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static boolean validaTelefone(Telefone telefone){
        String telefoneCadastrado = "";
        try {
            FileReader fileReader = new FileReader(telefones);
            BufferedReader bf = new BufferedReader(fileReader);
            String linha = bf.readLine();
            while (linha != null) {
                if (linha.length() > 0) {
                    telefoneCadastrado = processaLinhaTelefone(linha);
                    if(telefoneCadastrado.equals(telefone.getDdd() + telefone.getNumero())){
                        return false;
                    }
                }
                linha = bf.readLine();
            }
            bf.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    private static String processaLinha(String linha) {
        String out = "";
        String[] campos = linha.split(";");
        String id = campos[0];
        String nome = campos[1];
        String sobrenome = campos[2];
        out += id + " | " + nome + " " + sobrenome;
        return out;
    }
    private static String processaLinhaId(String linha) {
        String[] campos = linha.split(";");
        String id = campos[0];
        return id;

    }

    private static String processaLinhaTelefone(String linha) {
        String out = "";
        String[] campos = linha.split(";");
        String id = campos[0];
        String ddd = campos[1];
        String numero = campos[2];
        out += ddd + numero;
        return out;

    }









}
