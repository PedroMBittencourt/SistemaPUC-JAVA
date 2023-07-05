package SisPUC;

import javax.swing.JOptionPane;

public class Menus {
    
    public void Primario(){
        int opcao = 0;
        String menu = "";
        String exibe;

        do {
            menu = "\nMenu Principal\n" +
            "1. Estudantes\n" +
            "2. Professores\n" +
            "3. Disciplinas\n\n" +
            "9. Sair\n" +
            "Digite a opção desejada: ";
            exibe = JOptionPane.showInputDialog(menu);
            opcao = retornaInteiro(exibe);
            switch(opcao){
                case 1:
                    this.Secundario("Estudante");
                    break;
                case 2:
                    this.Secundario("Professor");
                    break;
                case 3:
                    this.Secundario("Disciplina");
                case 9:
                    JOptionPane.showMessageDialog(null, "\nObrigado por utilizar o Sistema PUC.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "\nOpção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 9);
    }

    public void Secundario(String parametro){
        int opcao = 0;
        String menu_secundario = "";
        String exibe;
        do{
            menu_secundario = "\nMenu de " + parametro + "\n" +
            "1. Incluir\n" +
            "2. Exibir cadastros\n" +
            "3. Editar\n" +
            "4. Excluir \n\n" +
            "9. Voltar ao menu anterior\n" +
            "\nDigite a opção desejada: ";
            exibe = JOptionPane.showInputDialog(menu_secundario);
            opcao = retornaInteiro(exibe);
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
                    break;
                case 3:
                    switch(parametro){
                        case "Estudante":
                            if (Estudante.estudantes.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Não há estudantes cadastrados no sistema. ");
                            break;
                            } else
                            {int editarE = Estudante.selecionaEstudante();
                            Estudante.editarEstudante(editarE);
                            break;}
                        case "Professor":
                            if (Professor.professores.isEmpty()){
                                JOptionPane.showMessageDialog(null, "Não há professores cadastrados no sistema. ");
                                break;
                            } else
                            {int editarP = Professor.selecionaProfessor();
                            Professor.editarProfessor(editarP);
                            break;}
                        case "Disciplina":
                                if (Disciplina.disciplinas.isEmpty()){
                                    JOptionPane.showMessageDialog(null, "Não há disciplinas cadastradas no sistema. ");
                                    break;
                                } else
                                {int editarD = Disciplina.selecionaDisciplina();
                                Disciplina.editarDisciplina(editarD);
                                break;}
                    }
                    break;
                case 4:
                    switch(parametro){
                        case "Estudante":
                            if (Estudante.estudantes.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Não há estudantes cadastrados no sistema. ");
                            break;
                            } else{
                            int excluirE = Estudante.selecionaEstudante();
                            Estudante.excluirEstudante(excluirE);
                            break;}  
                        case "Professor":
                            if (Professor.professores.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Não há professores cadastrados no sistema. ");
                            break;
                            } else
                            {int excluirP = Professor.selecionaProfessor();
                            Professor.excluirProfessor(excluirP);
                            break;}
                        case "Disciplina":
                            if (Disciplina.disciplinas.isEmpty()){
                                    JOptionPane.showMessageDialog(null, "Não há disciplinas cadastradas no sistema. ");
                                    break;
                                } else
                                {int excluirD = Disciplina.selecionaDisciplina();
                                Disciplina.excluirDisciplina(excluirD);
                                break;}
                    }
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null,"\nVoltando ao menu anterior.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"\nOpção inválida. Tente novamente.");
            }
        } while (opcao != 9);
    }

    	public  static int retornaInteiro(String entrada) { // retorna um valor inteiro
		//Enquanto n�o for poss�vel converter o valor de entrada para inteiro, permanece no loop
		while (!intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um n�mero inteiro.");
		}
		return Integer.parseInt(entrada);
    }

        protected static boolean intValido(String s) {
		try {
			Integer.parseInt(s); // M�todo est�tico, que tenta tranformar uma string em inteiro
			return true;
		} catch (NumberFormatException e) { // N�o conseguiu tranformar em inteiro e gera erro
			return false;
		}
	}
        

}
