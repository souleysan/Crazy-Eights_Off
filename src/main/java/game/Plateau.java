package game;
import items.Packet;

public class Plateau {

    /** Cette classe implémente le Plateau du jeu.BIl contiendra la pile de carte posées ainsi que la pioche
     * 
     * @author SANÉ Souleymane
     * 
     * @version console
     */
    public static Packet table;
    public static Packet pioche;


    /** Constructeur de Plateau (sans argument)
     * 
     */
    public Plateau() {this.table = new Packet(); this.pioche = new Packet();}


    /** Méthode de description de la table
     * 
     */
    public void contenuTable() {
        System.out.print("TABLE : "); this.table.contenu();
    }


    /** Méthode de description de la pioche
     * 
     */
    public void contenuPioche() {
        System.out.print("PIOCHE : "); this.pioche.contenu();
    }

}