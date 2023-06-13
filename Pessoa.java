package SisPUC;

import java.util.ArrayList;
import java.util.Scanner;

public class Pessoa extends Cadastro{
    protected String cpf;
    protected static Scanner leitor = new Scanner(System.in);

    public Pessoa(String nome, int codigo, String cpf){
        super(nome, codigo);
        this.cpf = cpf;
    }

    @Override
    protected void imprimir(){
        System.out.println("Código de matrícula: " + this.codigo + 
                            " Nome: " + this.nome + " CPF: " + this.cpf);

    }

    protected static <T extends Pessoa> void imprimirPessoas(ArrayList<T> pessoas){
        if (pessoas.isEmpty()){
            System.out.println("\nNão há cadastros no sistema. ");
        } else for(T pessoa : pessoas){
            System.out.println("Código de matrícula: " + pessoa.codigo + 
            " Nome: " + pessoa.nome + " CPF: " + pessoa.cpf);
        }
    }

    protected static <T extends Pessoa> void editarPessoa(T pessoa){
        System.out.println("Confira o cadastro para ser editado: \n");
        pessoa.imprimir();
        System.out.println("\nDigite o novo nome: ");
        pessoa.nome = leitor.nextLine();
        System.out.println("Digite o novo CPF: ");
        pessoa.cpf = leitor.nextLine();
        pessoa.imprimir();
    }


    protected static String inputCPF(){
        String cpf;
        System.out.println("Digite o CPF: ");
        cpf = leitor.nextLine();
        return cpf;
    }


    protected static void inputDados(String parametro){
        String nome = inputNome();
        String cpf = inputCPF();
        int codigo = inputCodigo();
        switch (parametro){
            case "Estudante":
                Estudante novoE = new Estudante(nome, codigo, cpf);
                novoE.vazio();
                break;
            case "Professor":
                Professor novoP = new Professor(nome, codigo, cpf);
                novoP.vazio();
                break;
            }
    }

}
