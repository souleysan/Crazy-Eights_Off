package game;
import java.util.ArrayList;
import java.util.Scanner;

public class Actions {

    /**
     * Cette classe implémenta la "gestion" des actions possibles pour les joueurs
     * 
     * 1 : Piocher - le deck du joueur reçoit une carte aléatoire de la pioche
     * 
     * 2 : Poser une carte - le joueur pose une carte de son choix
     * 
     * 3 : Consulter l'état du deck de ses adversaires (nombre de carte uniquement)
     * 
     * 4 : Abandonner - le joeur actuel peut quitter la partie
     */


    static ArrayList <Integer> actions;
    static Scanner actionScanner;


    /**
     * Constructeur du gestionnaire d'actions pour la partie
     */
    public Actions() {Actions.actions = new ArrayList<>(4); Actions.actionScanner = new Scanner(System.in);}


    /**
     * Controle des entrée Utilisateur pour savoir quelle actions
     * 
     * @param actionScanner - Le scanner static de la classe Actions
     */
    public int actionsPossibles(Scanner actionScanner) {
        System.out.println("INFORMATION : Votre choix sera sélectionné mod 4"); int act = 0;

        while (true) {
            if (actionScanner.hasNextInt()) { act = actionScanner.nextInt()%4;
                switch (act) {
                    case 1 -> {System.out.println("Vous avez pioché une carte"); break;}
                    case 2 -> {System.out.println("Vous avez posé une carte"); break;}
                    case 0 -> {System.out.println("Vous voulez vraiment abandonner ?"); break;}
                    default -> {System.out.println("Vous avez consulté les decks"); break;}
                }
                break;
            }
            else {
                if (true) {System.out.println("Veuillez selectionner un entier svp (MAJ + chiffre/nombre");}
            }

        }
        return act;
    }
}
