package br.unicamp.ic.mc322.lab07.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Wave> waves;
    private Integer currentWave;
    private Integer pointsDoctor;
    private Integer pointsDaleks;

    public Game() {
        this.waves = new ArrayList<>();
        this.currentWave = 0;
        this.pointsDoctor = 0;
        this.pointsDaleks = 0;
    }

    private void nextWave() {
        this.currentWave++;
    }

    public void addWave(Wave wave) {
        waves.add(wave);
    }

    public void play() {
        while (currentWave < waves.size()) {
            Wave wave = waves.get(currentWave);

            // Executando Wave
            while (!wave.hasWinner()) {
                wave.moveAgents();
                wave.executeAttacks();

                printStatus(wave, currentWave);

                wave.checkDestroyedAgents();
                wave.nextStep();
            }

            String winner = wave.getWinner();

            // Verificando vencedor da Wave
            if (winner.equals("Daleks")) {
                pointsDaleks++;
                System.out.println("Os Daleks venceram essa Wave!!");
                printScore();
            } else if (winner.equals("Doctor")) {
                pointsDoctor++;
                System.out.println("O Doutor venceu essa Wave!!");
                printScore();
            }

            nextWave();
        }

        finishGame();
    }

    private void printStatus(Wave wave, Integer currentWave) {
        // Imprimindo o status do jogo após cada step
        System.out.println(" --------Wave " + (currentWave + 1) + ", Step " + wave.getCurrentStep() + "--------");
        wave.printStep();
        printScore();
    }

    private void printScore() {
        System.out.println(" ------Doutor " + pointsDoctor + " x " + pointsDaleks + " Daleks------ \n");
    }

    public void finishGame() {
        // Verificando o vencedor do jogo
        if (pointsDoctor > pointsDaleks) {
            System.out.println("O Doutor venceu o jogo!!");
        } else if (pointsDaleks > pointsDoctor) {
            System.out.println("Os Daleks venceram o jogo!!");
        } else {
            System.out.println("O jogo terminou empatado!!");
        }
    }
}
