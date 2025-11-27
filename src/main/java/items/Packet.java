package items;
import java.util.ArrayList;

public class Packet {

    /** Cette classe implémente les cartes du jeu
     * 
     * @author SANÉ Souleymane
     * 
     * @see ArrayList#getClass()
     * 
     * @version console
     */


    public ArrayList <Carte> packetComplet;


    /** Unique constructeur de Packet - groupe de Cartes
     * 
     */
    public Packet() {this.packetComplet = new ArrayList<>();}


    /** Méthode de description d'un Objet de type Packet
     * Affichera le conntenu d'un Packet en ligne avec délimitations [cleanage], ainsi qu'un chiffre associé pour la sélection
     */
    public void contenu() {
        System.out.print("Voici l'état du packet : \n\n|  "); int f = 1;
        for (Carte c : this.packetComplet) {
            System.out.print(f + " : "); c.descr(); f++;
        } System.out.println("\n__________________________________________________");
        System.out.println("\n");
    }


    /** Méthode de description d'un Objet de type Packet, de manière plus précise.
     * Décrit en réalité une Carte, dans un Packet, grâce à un index donné en paramètre
     * Il s'agit d'une surcharge de la fonction précédante
     * 
     * @param index - position de la carte à décrire
     */
    public void contenu(int index) {this.packetComplet.get(index).descr();}


    /** Méthode permettant d'initialiser le packet entier, qui nous servira pour le jeu
     * Pas de packet entier, pas de jeu
     */
    public ArrayList <Carte> initPacketEntier() {
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 13; i++) {
                this.packetComplet.add(new Carte(i, j));
            }
        } return this.packetComplet;
    }


    /** Méthode d'initialisation de sous-packets
     * Principalement utilisée pour générer les decks des joueurs, de manière aléatoire
     * Le nombre de carte valide pour un sous packet va de 1 à 9 cartes - Liberté pour l'utilisateur
     * 
     * La boucle while me servira à demander directement à l'utilisateur depuis le terminal
     * 
     * @param nc - Indique le nombre de carte souhaité pour le sous-packet
     * @return - Un sous-packet de nc cartes 
     */
    public Packet deckPlayer(int nc) {
        Packet deck = new Packet();

        /*
        while (true) {
            System.out.println("Combien de carte voulez-vous ? (Entrez une valeur entre 1 et 9)\n");
            if (num.hasNextInt()) { nbCarte = num.nextInt();
                if ((nbCarte >= 1) && (nbCarte <= 9)) { break; }
                else {System.out.println("\nInitialisation imposible... Entrez une valeur entre 1 et 9");}
            } else {
                System.out.println("\n\nInitialisation imposible... Entrez une valeur entre 1 et 9"); num.next();
            }
        }
        */

        while (true) {
            if ((nc >= 1) && (nc <= 9)) { int f = 0;
                while (f < nc) {
                    int def = (int)((Math.random())*(this.packetComplet.size() - 1 - f));
                    if (this.packetComplet.contains(this.packetComplet.get(def))) {f++;
                        deck.packetComplet.add(this.packetComplet.get(def));
                        this.packetComplet.remove(this.packetComplet.get(def));
                    } else {}
                } break;
            } else {
                if (nc < 1) {nc = 1;}
                else if (nc > 9) {nc = 9;}
            }
        } return deck;
    }


}