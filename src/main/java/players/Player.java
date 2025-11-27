package players;
import items.*;

public class Player {

    /** Cette classe implémente les players [joueurs] du jeu
     * 
     * @author SANÉ Souleymane
     * 
     * @version console
     */


    private String nom;
    public Packet deck = new Packet();
    //  private int score; // Pour le mode compétition - règles expliquées prochainement dans le README.md */


    /** Constructeur de Playeur [Joueur], avec arguments
     * 
     * @param name - nom souhaité pour le joueur
     * 
     * @param packetGeneral - Packet à partir duquel on génerera le deck de ce joueur
     * 
     * @param nombreCarte - Nombre de carte souhaité pour le deck de ce joueur
     */
    public Player(String name, Packet packetGeneral, int nombreCarte) {this.nom = name; this.deck = packetGeneral.deckPlayer(nombreCarte);}


    /** Constructeur de Player (sans argument)
     * Pour pouvoir tout set soi-même
     * 
     */
    public Player() {}


    /** Getter de la classe player - nom
     * 
     * @return - Le nom du joueur appelant
     */
    public String getName() {return this.nom;}


    /** Getter de la classe player - deck
     * 
     * @return - Le nom du joueur appelant
     */
    public Packet getDeck() {return this.deck;}


    // public int getScore() {return this.score;}


    /** Setter de la classe player - nom
     * 
     */
    public void setName(String n) {this.nom = n;}


    /** Setter de la classe player - deck
     * 
     * @param p - packet à partir duquel le deck du joueur est initialisé
     * 
     * @param nc - Nombre de carte souhaité pour le deck du joueur
     * 
     */
    public void setDeck(Packet p, int nc) {this.deck = p.deckPlayer(nc);}


    /** Méthode de description du deck pour le joueur appelant
     * 
     */
    public void descrDeck() {System.out.print("\n" + this.nom + " : "); this.deck.contenu();}


}