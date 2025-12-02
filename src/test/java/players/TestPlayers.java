package players;
import items.*;
import game.Plateau;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.desktop.AppHiddenEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

public class TestPlayers {

    /**
     * Test de construction d'un joueur - getters/setters
     */
    @Test void testDeclarationPlayers() {
        Packet k = new Packet(); k.initPacketEntier();

        Player tOne = new Player("tOne", k, 0);
        Player tTwo = new Player("tTwo", k, 15);
        Player tTH = new Player("tTH", k, 5);
        Player tF = new Player();

        assertAll(
            "check getters and setter",
            () -> assertTrue(tOne.getName().equals("tOne")),
            () -> assertEquals(1, tOne.deck.packetComplet.size()),
            () -> assertEquals(9, tTwo.deck.packetComplet.size())
        );

        assertDoesNotThrow(() -> {tF.setDeck(k, 5); tF.setName("tTH");});
        assertFalse(tF.getDeck().packetComplet.isEmpty());
        assertDoesNotThrow(() -> {tOne.descrDeck(); tTwo.descrDeck(); tTH.descrDeck(); tF.descrDeck();});
    }

    /**
     * Test d'actions de joueurs - poserCarte()/piocher()
     */
    @Test void playersActions() {
        Plateau p = new Plateau(); 
        Packet k = new Packet(); k.initPacketEntier();
        Player playTest = new Player("playTest", k, 15);

        assertDoesNotThrow(() -> {
            playTest.descrDeck();
            Scanner fake1 = new Scanner("1\n") ; playTest.poserCarte(fake1);
            Scanner fake3 = new Scanner("1\n") ; playTest.poserCarte(fake3);
            Scanner fake4 = new Scanner("1\n") ; playTest.poserCarte(fake4);
            playTest.descrDeck();
        });

        assertDoesNotThrow(() -> Plateau.initMAJPioche());
        assertDoesNotThrow(() -> playTest.piocher());

        // assertThrows(NoSuchElementException.class, () -> {
        //     Scanner fake1 = new Scanner("13\n"); playTest.poserCarte(fake1);
        // });

        assertDoesNotThrow(() -> {
            Scanner fake1 = new Scanner("2\n"); playTest.choixCouleur(fake1);
        });

    }
}
