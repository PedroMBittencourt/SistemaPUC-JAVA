package SisPUC;
import java.util.ArrayList;

public class Disciplina extends Cadastro{
    public static ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public Disciplina(String nome, int codigo){
        super(nome, codigo);
        this.imprimir();
        verificarCadastro(disciplinas, this);
    }
    
    protected static void imprimirLista(){
        imprimirLista(disciplinas);
    }

    private static Disciplina getDisciplina(int codigo){
        return getCadastro(disciplinas, codigo);
    }

    protected static int selecionaDisciplina(){
        System.out.println("\nConfira a lista de disciplinas cadastradas: ");
        Disciplina.imprimirLista();
        int codigo = inputCodigo();
        return codigo;
    }

    static void editarDisciplina(int codigo){
        Disciplina editar = getDisciplina(codigo);
        if (editar == null){
            System.out.println("\nDisciplina não encontrada no sistema. ");
        } else
        editarCadastro(editar);
    }

    static void excluirDisciplina(int codigo){
        Disciplina excluir = getDisciplina(codigo);
        if (excluir == null){
            System.out.println("\nDisciplina não encontrada no sistema. ");
        } else
        excluirCadastro(disciplinas, excluir);
    }

}
