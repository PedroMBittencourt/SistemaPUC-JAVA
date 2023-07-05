package SisPUC;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Pessoa extends Cadastro{
    protected String cpf;
    protected static Scanner leitor = new Scanner(System.in);

    public Pessoa(String nome, int codigo, String cpf){
        super(nome, codigo);
        this.cpf = cpf;
    }

    @Override
    protected void imprimir(){
        JOptionPane.showMessageDialog(null,"Código de matrícula: " + this.codigo + 
                            " Nome: " + this.nome + " CPF: " + this.cpf);

    }

    protected static <T extends Pessoa> void imprimirPessoas(ArrayList<T> pessoas){
        String listaTotal = "";
        if (pessoas.isEmpty()){
            JOptionPane.showMessageDialog(null,"\nNão há cadastros no sistema. ");
        } else for(T pessoa : pessoas){
            String lista = "Código de matrícula: " + pessoa.codigo + " Nome: " + pessoa.nome + " CPF: " + pessoa.cpf;
            listaTotal += lista + "\n";
        }
        JOptionPane.showMessageDialog(null, listaTotal);
    }

    protected static <T extends Pessoa> void editarPessoa(T pessoa){
        JOptionPane.showMessageDialog(null,"Confira o cadastro para ser editado: \n");
        pessoa.imprimir();
        pessoa.nome = JOptionPane.showInputDialog("\nDigite o novo nome: ");
        pessoa.cpf = JOptionPane.showInputDialog("\nDigite o novo CPF: ");
        pessoa.imprimir();
    }


    protected static String inputCPF(){
        String cpf;
        cpf = JOptionPane.showInputDialog("\nDigite o novo CPF: ");
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
