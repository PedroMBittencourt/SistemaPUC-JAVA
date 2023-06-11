package SisPUC;

import java.util.Scanner;

public class Menus {

    private static Scanner leitor = new Scanner(System.in);
    
    static void Primario(){
        int opcao = 0;

        while (opcao != 9){
            System.out.println("\nMenu Principal\n" +
            "1. Estudantes\n" +
            "2. Professores\n\n" +
            "9. Sair");
            System.out.println("\nDigite a opção desejada: ");
            opcao = leitor.nextInt();
            switch(opcao){
                case 1:
                    Secundario("Estudante");
                    break;
                case 2:
                    Secundario("Professor");
                break;
                case 9:
                    System.out.println("\nObrigado por utilizar o Sistema PUC.");
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente.");
                    break;
            }
        }
    }

    static void Secundario(String parametro){
        int opcao = 0;

        while (opcao != 9){
            System.out.println("\nMenu de " + parametro + "\n" +
            "1. Incluir\n" +
            "2. Exibir cadastros\n" +
            "3. Editar\n" +
            "4. Excluir \n\n" +
            "9. Voltar ao menu anterior");
            System.out.println("\nDigite a opção desejada: ");
            opcao = leitor.nextInt();
            switch (opcao){
                case 1:
                    Pessoa.inputDados(parametro);
                    break;
                case 2:
                    switch(parametro){
                        case "Estudante":
                            Estudante.imprimirLista();
                            break;
                        case "Professor":
                            Professor.imprimirLista();
                            break;
                    }
                    System.out.println("\nAperte ENTER para continuar. ");
                    leitor.nextLine();
                    leitor.nextLine();
                    break;
                case 3:
                    switch(parametro){
                        case "Estudante":
                            if (Estudante.estudantes.isEmpty()){
                            System.out.println("Não há estudantes cadastrados no sistema. ");
                            break;
                            } else
                            {int editarE = Estudante.selecionaEstudante();
                            Estudante.editarEstudante(editarE);
                            break;}
                        case "Professor":
                            if (Professor.professores.isEmpty()){
                                System.out.println("Não há professores cadastrados no sistema. ");
                                break;
                            } else
                            {int editarP = Professor.selecionaProfessor();
                            Professor.editarProfessor(editarP);
                            break;}
                    }
                    System.out.println("\nAperte ENTER para continuar. ");
                    leitor.nextLine();
                    leitor.nextLine();
                    break;
                case 4:
                    switch(parametro){
                        case "Estudante":
                            if (Estudante.estudantes.isEmpty()){
                            System.out.println("Não há estudantes cadastrados no sistema. ");
                            break;
                            } else{
                            int excluirE = Estudante.selecionaEstudante();
                            Estudante.excluirEstudante(excluirE);
                            break;}  
                        case "Professor":
                            if (Professor.professores.isEmpty()){
                            System.out.println("Não há professores cadastrados no sistema. ");
                            break;
                            } else
                            {int excluirP = Professor.selecionaProfessor();
                            Professor.excluirProfessor(excluirP);
                            break;}
                    }
                    System.out.println("\nAperte ENTER para continuar. ");
                    leitor.nextLine();
                    leitor.nextLine();
                    break;
                case 9:
                    System.out.println("\nVoltando ao menu anterior.");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }


}
}
