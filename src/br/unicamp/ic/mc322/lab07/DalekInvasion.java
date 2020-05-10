package br.unicamp.ic.mc322.lab07;

import br.unicamp.ic.mc322.lab07.agents.daleks.EliteGuardDalek;
import br.unicamp.ic.mc322.lab07.agents.daleks.WorkerDalek;
import br.unicamp.ic.mc322.lab07.agents.doctor.Tower;
import br.unicamp.ic.mc322.lab07.game.Game;
import br.unicamp.ic.mc322.lab07.game.Wave;

import java.util.Scanner;

public class DalekInvasion {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Game game = new Game();

        // Solicitando as informações do jogo para o usuário
        System.out.println("Digite quantas waves você vai querer no jogo: ");
        int numberOfWaves = keyboard.nextInt();

        for (int currentWave = 0; currentWave < numberOfWaves; currentWave++) {
            Wave wave = new Wave();

            int startTime = 1;

            System.out.println("Digite quantos Worker Daleks você vai querer na wave " + (currentWave + 1) + ": ");
            int numberOfWorkerDaleks = keyboard.nextInt();

            for (int currentWorkerDalek = 0; currentWorkerDalek < numberOfWorkerDaleks; currentWorkerDalek++) {
                WorkerDalek workerDalek = new WorkerDalek(startTime++);
                wave.addDalek(workerDalek);
            }

            System.out.println("Digite quantos Elite Guard Daleks você vai querer na wave " + (currentWave + 1) + ": ");
            int numberOfEliteGuardDaleks = keyboard.nextInt();

            for (int currentEliteGuardDalek = 0; currentEliteGuardDalek < numberOfEliteGuardDaleks; currentEliteGuardDalek++) {
                EliteGuardDalek eliteGuardDalek = new EliteGuardDalek(startTime++);
                wave.addDalek(eliteGuardDalek);
            }

            System.out.println("Digite quantas Torres você vai querer na wave " + (currentWave + 1) + ": ");
            int numberOfTowers = keyboard.nextInt();

            for (int currentTower = 0; currentTower < numberOfTowers; currentTower++) {
                System.out.println("Digite a posição que você quer a torre " + (currentTower + 1) + ": ");
                int position = keyboard.nextInt();

                Tower tower = new Tower(position);
                wave.addTower(tower);
            }

            game.addWave(wave);
        }

        game.play();
    }

}
