package items;

public class Carte {

    /**
     * Cette classe implémente les cartes du jeu
     * 
     * @author SANÉ Souleymane
     * 
     * @version console
     * 
     */


    public static enum Value {AS, DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI};
    public static enum Color {CARREAU, COEUR, PIQUE, TREFLE};
    private final Value value;
    private final Color color;


    /**
     * Unique constructeur de Carte
     * 
     * @param val - valeur de la carte
     * 
     * @param indexColor - couleur de la carte
     * 
     */
    public Carte(int val, int indexColor) {this.value = Value.values()[val]; this.color = Color.values()[indexColor];}


    /**
     * Getter de la classe carte - valeur
     * 
     * @return - la valeur de la carte
     * 
     */
    public Value getValue() {return this.value;}


    /**
     * Getter de la classe carte - couleur
     * 
     * @return - la couleur de la carte
     * 
     */
    public Color getColor() {return this.color;}


    /**
     * Métthode de description de la cartte
     * 
     * Affichage en ligne des carte d'un même groupe/Packet
     * 
     */
    public void descr() {
        switch (color) {
            case CARREAU -> System.out.print(this.value + " de ♦️   |  ");
            case COEUR -> System.out.print(this.value + " de ♥️   |  ");
            case PIQUE -> System.out.print(this.value + " de ♠️   |  ");
            default-> System.out.print(this.value + " de ♣️  |  ");
        }        
    }


    /**
     * Méthode de comparaison des valeurs de carte
     * 
     * @param c - Une carte à tester
     * 
     * @return - Un booléen renvoyant l'égalité [de la valeur] entre la carte d'appel et la carte cible
     * 
     */
    public boolean sameValue(Carte c) {return this.value == c.value;}


    /**
     * Méthode de comparaison des couleurs de carte
     * 
     * @param c - Une carte à tester
     * 
     * @return - Un booléen renvoyant l'égalité [de la couleur] entre la carte d'appel et la carte cible
     * 
     */
    public boolean sameColor(Carte c) {return this.color == c.color;}


    /**
     * Méthode de comparaison totale des cartes
     * 
     * @param c - Une carte à tester
     * 
     * @return - Un booléen renvoyant l'égalité complète [de la valeur et de la couleur] entre la carte d'appel et la carte cible
     * 
     */
    public boolean equals(Carte c) {return (this.sameValue(c) && this.sameColor(c));}


}