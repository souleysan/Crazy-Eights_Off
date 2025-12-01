package items;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class TestItems {

    /**
     * Classe de Test du package items
     */


    static Carte tOne = new Carte(0, 3); static Carte tTwo = new Carte(6, 1);
    static Carte tThree = new Carte(6, 1); static Carte tFour = new Carte(0, 0);
    static Carte tFive = new Carte(0, 2); Packet testing = new Packet();



    @Test void classCarteJava() {

        /**
         * Test d'initialisation (Constructeur - Assignation d'attributs)
         */
        assertEquals(Carte.Value.AS, tOne.getValue());
        assertEquals(Carte.Color.COEUR, tTwo.getColor());
        assertTrue(Carte.Value.SEPT.equals(tThree.getValue()));
        assertTrue(Carte.Color.COEUR.equals(tThree.getColor()));


        /**
         * Test des getters (getValue()/getColor())
         */
        assertEquals(tTwo.getValue(), tThree.getValue()); assertEquals(tTwo.getColor(), tThree.getColor());
        assertFalse(tOne.getValue().equals(tThree.getValue())); assertFalse(tOne.getColor().equals(tThree.getColor()));

        /**
         * Test de comparaison (sameValue()/sameColor()/equals())
         */
        assertTrue(tTwo.sameValue(tThree)); assertFalse(tOne.sameValue(tThree));
        assertTrue(tTwo.sameColor(tThree)); assertFalse(tTwo.sameColor(tOne));
        assertFalse(tThree.equals(tOne)); assertTrue(tThree.equals(tTwo));
        assertFalse(tTwo.equals(tOne)); assertFalse(tOne.equals(tThree));
        assertFalse(tFive.equals(tFour));

        /** 
         * Test de conformité des descriptions descr()
         */
        assertDoesNotThrow(() -> tOne.descr()); assertDoesNotThrow(() -> tTwo.descr() );
        assertDoesNotThrow(() -> tThree.descr()); assertDoesNotThrow(() -> tFour.descr() );
        assertDoesNotThrow(() -> tFive.descr());
    }

    /**
     * Test du constructeur - Packet/Packet entier/Deck
     */
    @Test void classPacket() {

        Packet playerTestONE = new Packet(); playerTestONE = testing.deckPlayer(8);
        Packet playerTestTHREE = new Packet(); playerTestTHREE = testing.deckPlayer(72);
        Packet playerTestFOUR = new Packet();
        final Packet playerTestTWO = testing.deckPlayer(-6);


        /**
         * Test de génération d'un packet entier (72);vérification de la taille)
         */
        assertDoesNotThrow(() -> testing.packetComplet.size());

        /**
         * Test de conformité des descriptions (contenu())
         */
        assertDoesNotThrow(() -> testing.contenu());

        /**
         * Test de conformité de la description ciblée (contenu(int index)) pour chaque carte du  jeu
         */
        for (int i = 0; i < testing.packetComplet.size() - 1; i++) {
            int p = i; assertDoesNotThrow(() -> testing.contenu(p));
        }
        assertDoesNotThrow(() -> testing.contenu());

        /**
         * Test de génération d'un deck de joueur
         */
        assertEquals(8, playerTestONE.packetComplet.size());
        assertEquals(1, playerTestTWO.packetComplet.size());
        assertEquals(9, playerTestTHREE.packetComplet.size());
    
    }

}
