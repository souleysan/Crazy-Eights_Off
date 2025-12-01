package game;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import items.Packet;
import players.Player;

public class TestGame {
    
    /**
     * Classe de test pour le package game
     */


    Plateau i = new Plateau();
    Packet k = new Packet();



    /**
     * Test des getters
     */
    @Test void construct() {
        k.initPacketEntier(); Player p = new Player("p", k, 6);
        p.poserCarte(new Scanner("1\n")); p.poserCarte(new Scanner("1\n"));
        p.poserCarte(new Scanner("1\n")); p.poserCarte(new Scanner("1\n"));

        assertDoesNotThrow(() -> i.contenuTable());
        assertDoesNotThrow(() -> i.initMAJPioche());
        assertDoesNotThrow(() -> i.contenuPioche());
    }


}
