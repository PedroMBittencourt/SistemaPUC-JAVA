package SisPUC;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected int codigo;
    protected static Scanner leitor = new Scanner(System.in);

    public Pessoa(String nome, String cpf, int codigo){
        this.nome = nome;
        this.cpf = cpf;
        this.codigo = codigo;
    }

    protected void imprimir(){
        System.out.println("Código de matrícula: " + this.codigo + 
                            " Nome: " + this.nome + " CPF: " + this.cpf);

    }

    protected static <T extends Pessoa> T getPessoa(ArrayList<T> pessoas, int codigo){
        for (T pessoa : pessoas){
            if (pessoa.codigo == codigo){
                return pessoa;
            }
        }
        return null;
    }

    protected static <T extends Pessoa> void imprimirLista(ArrayList<T> pessoas){
        if (pessoas.isEmpty()){
            System.out.println("\nNão há cadastros no sistema. ");
        } else for(T pessoa : pessoas){
            System.out.println("Código de matrícula: " + pessoa.codigo + 
            " Nome: " + pessoa.nome + " CPF: " + pessoa.cpf);
        }
    }

    protected static <T extends Pessoa> void verificarCadastro(ArrayList<T> pessoas, T pessoa){
        boolean cadastrado = false;
        for(T p : pessoas){
            if(p.codigo == pessoa.codigo){
                cadastrado = true;
                System.out.println("\nCódigo de Matrícula já cadastrado no sistema. Confira os dados: ");
                p.imprimir();
                System.out.println("\nAperte ENTER para continuar. ");
                leitor.nextLine();
                leitor.nextLine();
                break;
            }
        }
        if (!cadastrado){
            pessoas.add(pessoa);
            System.out.println("\nCadastro realizado com sucesso.");
            System.out.println("\nAperte ENTER para continuar. ");
            leitor.nextLine();
            leitor.nextLine();

        }
    }

    protected static <T extends Pessoa> void editarPessoa(T pessoa){
        System.out.println("Confira o estudante para ser editado: \n");
        pessoa.imprimir();
        System.out.println("\nDigite o novo nome do aluno: ");
        leitor.nextLine();
        pessoa.nome = leitor.nextLine();
        System.out.println("Digite o novo CPF do aluno: ");
        pessoa.cpf = leitor.nextLine();
        pessoa.imprimir();
    }

    protected static <T extends Pessoa> void excluirPessoa(ArrayList<T> pessoas, T pessoa){
        System.out.println("Confira o estudante para ser excluido: ");
        pessoa.imprimir();
        System.out.println("Deseja excluir? (s/n)");
        String confirma = leitor.nextLine();
        if (confirma.equalsIgnoreCase("s")){
            pessoas.remove(pessoa);
            System.out.println("\nEstudante removido com sucesso.");
            System.out.println("\nAperte ENTER para continuar. ");
            leitor.nextLine();
        } else{
            System.out.println("Retornando ao menu anterior. ");
            System.out.println("\nAperte ENTER para continuar. ");
            leitor.nextLine();
        }

    }

    private static String inputNome(){
        String nome;
        System.out.println("Digite o nome para adicionar ao cadastrado: ");
        nome = leitor.nextLine();
        return nome;
    }

    private static String inputCPF(){
        String cpf;
        System.out.println("Digite o CPF: ");
        cpf = leitor.nextLine();
        return cpf;
    }

    protected static int inputCodigo(){
        int codigo = 0;
        boolean entradaValida = false;
        while (!entradaValida){
        System.out.println("Digite o código de matrícula: ");        
        try {
            codigo = leitor.nextInt();
            entradaValida = true;
        }
        catch (InputMismatchException ime){
            System.out.println("\nDigite um número inteiro para o código de matrícula. ");
            leitor.nextLine();
        }
        }
        return codigo;
    }

    protected static void inputDados(String parametro){
        String nome = inputNome();
        String cpf = inputCPF();
        int codigo = inputCodigo();
        switch (parametro){
            case "Estudante":
                Estudante novoE = new Estudante(nome, cpf, codigo);
                break;
            case "Professor":
                Professor novoP = new Professor(nome, cpf, codigo);
                break;
            }
    }

}
