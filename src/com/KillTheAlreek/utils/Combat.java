package com.KillTheAlreek.utils;

import com.KillTheAlreek.characters.Player;
import com.KillTheAlreek.characters.Monster;

import java.util.Random;

public class Combat {


    public void startCombat() {
        GameLogic.printHeading("Rozpoczęła się walka!");
        GameLogic.anythingToContinue();

        while (playerIsAlive() && monsterIsAlive()) {
            playerTurn();
            if (!monsterIsAlive()) {
                break;
            }

            monsterTurn();
        }

        endCombat();
    }

    private void playerTurn() {
        GameLogic.printHeading("Twój ruch:");
        player.info();
        player.attack(monster);
        int damageDealt = calculateDamage(player.getStatistics().getPower());
        monster.getMonsterStatistics().getHealthPoints().decreaseCurrent((short) damageDealt);
        GameLogic.printStringLBL("Zadałeś " + damageDealt + " obrażeń potworowi!");

        // Załóżmy, że potwór atakuje gracza po ruchu gracza.
        if (monsterIsAlive()) {
            GameLogic.anythingToContinue();
            GameLogic.printHeading("Ruch potwora:");
            monster.info();
            // Tutaj możesz dodać logikę dla ruchu potwora, np. atak gracza.
            monster.attack(player);
            int damageTaken = calculateDamage(monster.getMonsterStatistics().getPower());
            player.getStatistics().getHealthPoints().decreaseCurrent((short) damageTaken);
            GameLogic.printStringLBL("Potwór zadał Ci " + damageTaken + " obrażeń!");
            GameLogic.anythingToContinue();
        }
    }

    private void monsterTurn() {
        if (monsterIsAlive()) {
            GameLogic.printHeading("Ruch potwora:");
            monster.info();
            // Tutaj możesz dodać logikę dla ruchu potwora, np. atak gracza.
            // Przykładowo: monster.attack(player);
            int damageTaken = calculateDamage(monster.getMonsterStatistics().getPower());
            player.getStatistics().getHealthPoints().decreaseCurrent((short) damageTaken);
            GameLogic.printStringLBL("Potwór zadał Ci " + damageTaken + " obrażeń!");
            GameLogic.anythingToContinue();
        }
    }

    private boolean playerIsAlive() {
        return player.getStatistics().getHealthPoints().getCurrent() > 0;
    }

    private boolean monsterIsAlive() {
        return monster.getMonsterStatistics().getHealthPoints().getCurrent() > 0;
    }

    private void endCombat() {
        GameLogic.printHeading("Walka zakończona!");

        if (playerIsAlive()) {
            GameLogic.printStringLBL("Gratulacje! Wygrałeś walkę!");
        } else {
            GameLogic.printStringLBL("Niestety, przegrałeś. Spróbuj ponownie.");
        }
    }

    private int calculateDamage(int attackerPower) {
        // Prosta logika obliczania obrażeń na podstawie siły atakującego.
        Random rand = new Random();
        int baseDamage = rand.nextInt(10) + 1;  // Losowa liczba od 1 do 10.
        return baseDamage + attackerPower;
    }


    private Player player;
    private Monster monster;

}