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


    /** Méthode pour initialiser et mettre à jour la pioche
     * 
     * @return - La pioche du jeu
     */
    public static Packet initMAJPioche() {
        // Plateau.pioche.packetComplet.clear();
    
        while (Plateau.table.packetComplet.size() - 2 >= 0) { // On fait le size() - 2 car on ne veur pas récupérer la dernière carte posée (qui correspond à packetC.siza()-1), comme on veut pas le size - 1, on prend le precedant, size() - 2
            Plateau.pioche.packetComplet.add(table.packetComplet.get(Plateau.table.packetComplet.size() - 2)); // On ajoute la carte à la nouvelle pioche
            Plateau.table.packetComplet.remove(Plateau.table.packetComplet.size() - 2); //    On enleve du table les carte ajouté à la pioche
        }   return Plateau.pioche;
    }

}