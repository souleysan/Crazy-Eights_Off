package players;
import game.Plateau;
import items.*;
import java.util.Scanner;

public class Player {

    /**
     * Cette classe implémente les players [joueurs] du jeu
     * 
     * @author SANÉ Souleymane
     * 
     * @version console
     * 
     */


    private String nom;
    public Packet deck = new Packet();
    //  private int score; // Pour le mode compétition - règles expliquées prochainement dans le README.md */


    /**
     * Constructeur de Playeur [Joueur], avec arguments
     * 
     * @param name - nom souhaité pour le joueur
     * 
     * @param packetGeneral - Packet à partir duquel on génerera le deck de ce joueur
     * 
     * @param nombreCarte - Nombre de carte souhaité pour le deck de ce joueur
     * 
     */
    public Player(String name, Packet packetGeneral, int nombreCarte) {this.nom = name; this.deck = packetGeneral.deckPlayer(nombreCarte);}


    /**
     * Constructeur de Player (sans argument)
     * 
     * Pour pouvoir tout set soi-même
     * 
     */
    public Player() {}


    /**
     * Getter de la classe player - nom
     * 
     * @return - Le nom du joueur appelant
     * 
     */
    public String getName() {return this.nom;}


    /**
     * Getter de la classe player - deck
     * 
     * @return - Le nom du joueur appelant
     * 
     */
    public Packet getDeck() {return this.deck;}


    // public int getScore() {return this.score;}


    /**
     * Setter de la classe player - nom
     * 
     */
    public void setName(String n) {this.nom = n;}


    /**
     * Setter de la classe player - deck
     * 
     * @param p - packet à partir duquel le deck du joueur est initialisé
     * 
     * @param nc - Nombre de carte souhaité pour le deck du joueur
     * 
     */
    public void setDeck(Packet p, int nc) {this.deck = p.deckPlayer(nc);}


    /**
     * Méthode de description du deck pour le joueur appelant
     * 
     */
    public void descrDeck() {System.out.print("\n" + this.nom + " : "); this.deck.contenu();}


    /**
     * Méthode pour poser une carte sur la table (l'ajouter à la pile)
     * 
     * Liée à la classe Plateau
     * 
     * On demande de sélectionner une carte de son deck à partir de sa position, affichée dans le terminal grâce au Scanner
     * 
     * Scanner passé en argument : facilite les tests; facilitera la mise en jeu et les conditions
     */
    public void poserCarte(Scanner i) {

        while (true) {
            System.out.println("Quelle carte choisissez-vous, tapez le chiffre, puis 'Entrez'\n");
            int index; index = i.nextInt(); System.out.println("\n");

            if ((index >= 1) && (index <= this.deck.packetComplet.size())) {
                Plateau.table.packetComplet.add(this.deck.packetComplet.get(index - 1));
                this.deck.packetComplet.remove(this.deck.packetComplet.get(index - 1)); break;
            } else {
                System.out.println("Choix impossible, choisissez une autre carte...\n");
            }
        } // Remonter le terminal après que le joueur ait deposé sa carte
    }


    /**
     * Méthode pour piocher une carte
     * 
     * La carte est choisie et distribuée de manière aléatoire
     * 
     */
    public void piocher() {
        System.out.println("Oh bah... vous souhaitez piocher... Tenez !");
        int def = (int)((Math.random())*(Plateau.pioche.packetComplet.size() - 1));
        this.deck.packetComplet.add(Plateau.pioche.packetComplet.get(def));
        Plateau.pioche.packetComplet.remove(def);
    }


    /**
     * Méthode pour le choix de la couleur à imposer
     * 
     * Dès qu'un joueur pose un 8, il choisit la couleur du prochain joueur, et ce dernier devra s'y soumettre
     * 
     */
    public int choixCouleur(Scanner col) {
         int couleur;

        while (true) {
        System.out.println("\nQuelle couleur souhaitez-vous imposer ?\n\n1 : CARREAU        2 : COEUR       3 : PIQUE       4 : TREFLE \n");
            if (col.hasNextInt()) { couleur = col.nextInt() -1;

                if ((couleur >= 0) && (couleur <=3)) {break;}
                else {System.out.println("\nChoix imposible... Entrez une des valeurs proposées");}
            } else {
                System.out.println("\nChoix imposible... Entrez une des valeurs proposées");
                col.next();
            }
        } System.out.println("\nLe joueur précédent vient de vous imposer le " + Carte.Color.values()[couleur] + "\n");
        return couleur;
    }


    /**
     * Methode pour le mode ranked, avec les scores
     * 
    */
    // public void initScore() {}


}