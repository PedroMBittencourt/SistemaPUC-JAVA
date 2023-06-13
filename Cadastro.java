package SisPUC;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Cadastro {
    protected String nome;
    protected int codigo;
    protected static Scanner leitor = new Scanner(System.in);

    public Cadastro(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }

    protected void imprimir(){
        System.out.println("Nome: " + this.nome + " Código: " + this.codigo);
    }

    protected static <T extends Cadastro> T getCadastro(ArrayList<T> cadastros, int codigo){
        for (T cadastro : cadastros){
            if (cadastro.codigo == codigo){
                return cadastro;
            }
        }
        return null;
    }

    protected static <T extends Cadastro> void imprimirLista(ArrayList<T> cadastros){
        if (cadastros.isEmpty()){
            System.out.println("\nNão há cadastros no sistema. ");
        } else for (T cadastro : cadastros){
            System.out.println("Nome: " + cadastro.nome + " Código: " + cadastro.codigo);
        }
    }

    protected static <T extends Cadastro> void verificarCadastro(ArrayList<T> cadastros, T cadastro){
    boolean cadastrado = false;
    for(T c : cadastros){
        if(c.codigo == cadastro.codigo){
            cadastrado = true;
            System.out.println("\nCódigo já cadastrado no sistema. Confira os dados: ");
            c.imprimir();
            System.out.println("\nAperte ENTER para continuar. ");
            leitor.nextLine();
            leitor.nextLine();
            break;
        }
    }
    if (!cadastrado){
        cadastros.add(cadastro);
        System.out.println("\nCadastro realizado com sucesso.");
        System.out.println("\nAperte ENTER para continuar. ");
        leitor.nextLine();
        leitor.nextLine();

    }
    }

    protected static <T extends Cadastro> void editarCadastro(T cadastro){
        System.out.println("Confira o cadastro para ser editado: \n");
        cadastro.imprimir();
        System.out.println("\nDigite o novo nome: ");
        leitor.nextLine();
        cadastro.nome = leitor.nextLine();
        cadastro.imprimir();
    }

    protected static <T extends Cadastro> void excluirCadastro(ArrayList<T> cadastros, T cadastro){
        System.out.println("\nConfira o cadastro para ser excluído: ");
        cadastro.imprimir();
        System.out.println("\nDeseja excluir? (s/n)");
        leitor.nextLine();
        String confirma = leitor.nextLine();
        if (confirma.equalsIgnoreCase("s")){
            cadastros.remove(cadastro);
            System.out.println("\nCadastro removido com sucesso.");
        } else{
            System.out.println("Retornando ao menu anterior. ");
        }
    }

    protected static String inputNome(){
    String nome;
    System.out.println("Digite o nome para adicionar ao cadastro: ");
    nome = leitor.nextLine();
    return nome;
    }

    protected static int inputCodigo(){
        int codigo = 0;
        boolean entradaValida = false;
        while (!entradaValida){
        System.out.println("\nDigite o código de matrícula: ");        
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

    protected void vazio(){

    }

    protected static void inputDados(String parametro){
        String nome = inputNome();
        int codigo = inputCodigo();
        switch(parametro){
            case "Disciplina":
                Disciplina novaD = new Disciplina(nome, codigo);
                novaD.vazio();
                break;
        }
    }


}
