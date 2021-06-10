package classes;

import classes.NoArvore;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        NoArvore abb = new NoArvore();

        Scanner input = new Scanner(System.in);
        //ATRIBUTOS
        int menu = 99;
        int rgm;

        //PROGRAMA
        while(menu != 0) {

            //MENSAGEM PARA ENTRAR NO MENU PRINCIPAL
            System.out.println("Digite 1 e aperte enter para inserir um novo aluno. \n" +
                    "Digite 2 e aperte enter para remover um nó. \n" +
                    "Digite 3 e aperte enter para pesquisar um aluno. \n" +
                    "Digite 4 e aperte enter para esvaziar a árvore. \n" +
                    "Digite 5 e aperte enter para exibir a árvore \n" +
                    "Digite 0 e aperte enter para finalizar o programa. \n");
            menu = input.nextInt();

            //MENU PRINCIPAL
            switch (menu) {
                //CADASTRO
                case 1:
                    System.out.println("Digite o RGM do aluno que deseja cadastrar: ");
                    rgm = input.nextInt();
                    abb.insere(abb, rgm);
                    break;

                case 2:
                    System.out.println("Digite o RGM que deseja remover: ");
                    rgm = input.nextInt();
                    abb.remove(abb, rgm);
                    break;

                case 3:
                    System.out.println("Digite o RGM que deseja pesquisar: ");
                    rgm = input.nextInt();
                    System.out.println(abb.busca(abb, rgm));
                    break;

                case 4:
                    System.out.println("case4");
                    break;

                case 5:
                    abb.imprime(abb);
                    break;
            }

        }
        System.out.println("Programa encerrado");
    }

}