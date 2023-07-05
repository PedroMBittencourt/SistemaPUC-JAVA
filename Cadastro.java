package SisPUC;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Cadastro {
    protected String nome;
    protected int codigo;
    protected static Scanner leitor = new Scanner(System.in);

    public Cadastro(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }

    protected void imprimir(){
        JOptionPane.showMessageDialog(null, "Nome: " + this.nome + " Código: " + this.codigo);
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
        String listaTotal = "";
        if (cadastros.isEmpty()){
            JOptionPane.showMessageDialog(null,"\nNão há cadastros no sistema. ");
        } else for (T cadastro : cadastros){
            String lista = "Nome: " + cadastro.nome + " Código: " + cadastro.codigo;
            listaTotal += lista + "\n";
        } JOptionPane.showMessageDialog(null, listaTotal);
    }

    protected static <T extends Cadastro> void verificarCadastro(ArrayList<T> cadastros, T cadastro){
    boolean cadastrado = false;
    for(T c : cadastros){
        if(c.codigo == cadastro.codigo){
            cadastrado = true;
            JOptionPane.showMessageDialog(null,"\nCódigo já cadastrado no sistema. Confira os dados: ");
            c.imprimir();
            break;
        }
    }
    if (!cadastrado){
        cadastros.add(cadastro);
        JOptionPane.showMessageDialog(null,"\nCadastro realizado com sucesso.");
    }
    }

    protected static <T extends Cadastro> void editarCadastro(T cadastro){
        JOptionPane.showMessageDialog(null,"Confira o cadastro para ser editado: \n");
        cadastro.imprimir();
        cadastro.nome = JOptionPane.showInputDialog("\nDigite o novo nome: ");
        cadastro.imprimir();
    }

    protected static <T extends Cadastro> void excluirCadastro(ArrayList<T> cadastros, T cadastro){
        JOptionPane.showMessageDialog(null,"\nConfira o cadastro para ser excluído: ");
        cadastro.imprimir();
        String confirma = JOptionPane.showInputDialog("\nDeseja excluir? (s/n)");
        if (confirma.equalsIgnoreCase("s")){
            cadastros.remove(cadastro);
            JOptionPane.showMessageDialog(null,"\nCadastro removido com sucesso.");
        } else{
            JOptionPane.showMessageDialog(null,"Retornando ao menu anterior. ");
        }
    }

    protected static String inputNome(){
    String nome;
    nome = JOptionPane.showInputDialog("\nDigite o nome para adicionar ao cadastro: ");
    return nome;
    }

    protected static int inputCodigo(){
        String input;
        int codigo;
        input = JOptionPane.showInputDialog("Digite o código: ");
        codigo = Menus.retornaInteiro(input);    
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
