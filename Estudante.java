package SisPUC;

import java.util.ArrayList;

public class Estudante extends Pessoa{
    public static ArrayList<Estudante> estudantes = new ArrayList<>();

    public Estudante(String nome, String cpf, int codigo){
        super(nome, cpf, codigo);
        this.imprimir();
        verificarCadastro(this);
    }

    private void verificarCadastro(Estudante estudante){
        verificarCadastro(estudantes, estudante);
    }

    static void imprimirLista(){
        imprimirLista(estudantes);
    }

    private static Estudante getEstudante(int codigo){
        return getPessoa(estudantes, codigo);
    }

    protected static int selecionaEstudante(){
        System.out.println("\nConfira a lista de estudantes cadastrados: ");
        Estudante.imprimirLista();
        int codigo = inputCodigo();
        return codigo;
    }

    static void editarEstudante(int matricula){
        Estudante editar = getEstudante(matricula);
        if (editar == null){
            System.out.println("\nEstudante não encontrado no sistema. ");
        } else
        editarPessoa(editar);
    }

    static void excluirEstudante(int codigo){
        Estudante excluir = getEstudante(codigo);
        if (excluir == null){
            System.out.println("\nEstudante não encontrado no sistema. ");
        } else
        excluirPessoa(estudantes, excluir);
    }

    void vazio(){

    }

}

//         for (Estudante e : estudantes){
//    if(e.codigo == codigo){
//        return e;
//    }            
//}
//return null;

