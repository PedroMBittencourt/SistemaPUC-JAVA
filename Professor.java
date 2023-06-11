package SisPUC;

import java.util.ArrayList;

public class Professor extends Pessoa{
    public static ArrayList<Professor> professores = new ArrayList<Professor>();

    public Professor(String nome, String cpf, int codigo){
        super(nome, cpf, codigo);
        this.imprimir();
        verificarCadastro(this);
    }

    private void verificarCadastro(Professor professor){
        verificarCadastro(professores, professor);
    }

    static void imprimirLista(){
        Pessoa.imprimirLista(professores);
    }

    private static Professor getProfessor(int codigo){
        return Pessoa.getPessoa(professores, codigo);
    }

    static void editarProfessor(int codigo){
        Professor editar = getProfessor(codigo);
        if (editar == null){
            System.out.println("\nProfessor não encontrado no sistema. ");
        } else
        editarPessoa(editar);
    }

    static void excluirProfessor(int codigo){
        Professor excluir = getProfessor(codigo);
        if (excluir == null){
            System.out.println("\nProfessor não encontrado no sistema. ");
        } else
        excluirPessoa(professores, excluir);
    }

    protected static int selecionaProfessor(){
        System.out.println("Confira a lista de professores cadastrados: ");
        Professor.imprimirLista();
        int codigo = inputCodigo();
        return codigo;
    }

}
