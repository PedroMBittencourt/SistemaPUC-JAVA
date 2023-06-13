package SisPUC;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {

    private static Scanner leitor = new Scanner(System.in);
    
    static void Primario(){
        int opcao = 0;

        while (opcao != 9){
            System.out.println("\nMenu Principal\n" +
            "1. Estudantes\n" +
            "2. Professores\n" +
            "3. Disciplinas\n\n" +
            "9. Sair");
            System.out.println("\nDigite a opção desejada: ");
            opcao = validaEntrada();
            switch(opcao){
                case 1:
                    Secundario("Estudante");
                    break;
                case 2:
                    Secundario("Professor");
                    break;
                case 3:
                    Secundario("Disciplina");
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
            opcao = validaEntrada();
            switch (opcao){
                case 1:
                    switch(parametro){
                        case "Estudante":
                            Pessoa.inputDados(parametro);
                            break;
                        case "Professor":
                            Pessoa.inputDados(parametro);
                            break;
                        case "Disciplina":
                            Cadastro.inputDados(parametro);
                            break;
                    }
                    break;
                case 2:
                    switch(parametro){
                        case "Estudante":
                            Estudante.imprimirLista();
                            break;
                        case "Professor":
                            Professor.imprimirLista();
                            break;
                        case "Disciplina":
                            Disciplina.imprimirLista();
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
                        case "Disciplina":
                                if (Disciplina.disciplinas.isEmpty()){
                                    System.out.println("Não há disciplinas cadastradas no sistema. ");
                                    break;
                                } else
                                {int editarD = Disciplina.selecionaDisciplina();
                                Disciplina.editarDisciplina(editarD);
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
                        case "Disciplina":
                            if (Disciplina.disciplinas.isEmpty()){
                                    System.out.println("Não há disciplinas cadastradas no sistema. ");
                                    break;
                                } else
                                {int excluirD = Disciplina.selecionaDisciplina();
                                Disciplina.excluirDisciplina(excluirD);
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

        private static int validaEntrada(){
        int codigo = 0;
        boolean entradaValida = false;
        while(!entradaValida){
                try{
                codigo = leitor.nextInt();
                entradaValida = true;}
                catch (InputMismatchException ime){
                    System.out.println("Digite um número inteiro, por favor. ");
                    leitor.nextLine();
                }
            }
        return codigo;
    }

}
