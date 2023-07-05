package SisPUC;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Professor extends Pessoa{
    public static ArrayList<Professor> professores = new ArrayList<Professor>();

    public Professor(String nome, int codigo, String cpf){
        super(nome, codigo, cpf);
        this.imprimir();
        verificarCadastro(professores, this);
    }

    static void imprimirLista(){
        imprimirPessoas(professores);
    }

    private static Professor getProfessor(int codigo){
        return getCadastro(professores, codigo);
    }

    protected static int selecionaProfessor(){
        JOptionPane.showMessageDialog(null, "Confira a lista de professores cadastrados: ");
        Professor.imprimirLista();
        int codigo = inputCodigo();
        return codigo;
    }

    static void editarProfessor(int codigo){
        Professor editar = getProfessor(codigo);
        if (editar == null){
            JOptionPane.showMessageDialog(null,"\nProfessor não encontrado no sistema. ");
        } else
        editarPessoa(editar);
    }

    static void excluirProfessor(int codigo){
        Professor excluir = getProfessor(codigo);
        if (excluir == null){
            JOptionPane.showMessageDialog(null,"\nProfessor não encontrado no sistema. ");
        } else
        excluirCadastro(professores, excluir);
    }

}
