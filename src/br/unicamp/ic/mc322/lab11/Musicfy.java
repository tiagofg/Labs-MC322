package br.unicamp.ic.mc322.lab11;

import br.unicamp.ic.mc322.lab11.playlist.items.Song;
import br.unicamp.ic.mc322.lab11.playlist.Playlist;
import br.unicamp.ic.mc322.lab11.user.GenderEnum;
import br.unicamp.ic.mc322.lab11.user.User;

import java.io.IOException;
import java.util.Scanner;

public class Musicfy {

    public static void main(String[] args) throws IOException, IllegalAccessException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String name = keyboard.nextLine();
        if (name == null) {
            throw new IOException("Você deve preencher o seu nome.");
        } else if (name.matches(".*\\d.*")) {
            throw new IOException("Seu nome não deve conter números");
        }

        System.out.println("Digite seu cpf: ");
        String cpf = keyboard.nextLine();
        if (cpf == null) {
            throw new IOException("Você deve preencher o seu cpf.");
        }

        System.out.println("Digite sua data de nascimento: ");
        String birthDate = keyboard.nextLine();
        if (birthDate == null) {
            throw new IOException("Você deve preencher sua data de nascimento.");
        } else if (birthDate.matches("[a-zA-Z]+")) {
            throw new IOException("Sua data de nascimento não deve conter letras");
        }

        System.out.println("Digite seu genêro: ");
        String gender = keyboard.nextLine();
        if (gender == null) {
            throw new IOException("Você deve preencher seu genêro.");
        }

        User user = new User(name,
                cpf,
                birthDate,
                GenderEnum.getGender(gender),
                false);

        boolean signingUp = true;

        while (signingUp) {
            System.out.println("\n----------------------------------------");
            System.out.println("Selecione uma opção: ");
            System.out.println("1. Criar uma playlist");
            System.out.println("2. Adicionar uma música em uma playlist");
            System.out.println("3. Remover uma música de uma playlist");
            System.out.println("4. Assinar plano premium");
            System.out.println("5. Cancelar plano premium");
            System.out.println("6. Sair");
            System.out.println("----------------------------------------\n");

            Integer opcao = keyboard.nextInt();
            keyboard.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite um nome para playlist: ");
                    String playlistName = keyboard.nextLine();
                    if (playlistName == null) {
                        throw new IOException("Você deve preencher o nome da playlist.");
                    }

                    System.out.println("Digite o tamanho da playlist: ");
                    Integer playlistSize = keyboard.nextInt();
                    keyboard.nextLine();
                    if (playlistSize == 0) {
                        throw new IOException("Você deve preencher o tamanho da playlist.");
                    }

                    Playlist playlist = new Playlist(playlistName,
                            playlistSize);

                    user.addPlaylist(playlist);

                    break;
                case 2:
                    System.out.println("Digite o nome da música que você deseja inserir: ");
                    String songName = keyboard.nextLine();
                    if (songName == null) {
                        throw new IOException("Você deve preencher o nome da música.");
                    }

                    System.out.println("Digite a duração da música que você deseja inserir: ");
                    Integer songDuration = keyboard.nextInt();
                    keyboard.nextLine();
                    if (songDuration == 0) {
                        throw new IOException("Você deve preencher a duração da música.");
                    }

                    System.out.println("Digite o autor da música que você deseja inserir: ");
                    String songAuthor = keyboard.nextLine();
                    if (songAuthor == null) {
                        throw new IOException("Você deve preencher o autor da música.");
                    }

                    Song newSong = new Song(songName, songDuration, songAuthor);

                    System.out.println("Digite o nome da playlist: ");
                    Playlist desiredPlaylist = user.findPlaylist(keyboard.nextLine());
                    if (desiredPlaylist == null) {
                        throw new IOException("Playlist não encontrada.");
                    }

                    desiredPlaylist.addItem(newSong);

                    break;
                case 3:
                    System.out.println("Digite o nome da playlist da música que deseja excluir: ");
                    Playlist playlistSongToRemove = user.findPlaylist(keyboard.nextLine());
                    if (playlistSongToRemove == null) {
                        throw new IOException("Playlist não encontrada.");
                    }

                    System.out.println("Digite o nome da música que deseja excluir: ");
                    Song songToRemove = playlistSongToRemove.findSong(keyboard.nextLine());
                    if (songToRemove == null) {
                        throw new IOException("Música não encontrada.");
                    }

                    break;
                case 4:
                    try {
                        user.subscribePremium();
                    } catch (IllegalStateException e) {
                        System.err.println(e.getMessage());
                    }

                    break;
                case 5:
                    try {
                        user.unsubscribePremium();
                    } catch (IllegalStateException e) {
                        System.err.println(e.getMessage());
                    }

                    break;
                default:
                    signingUp = false;
                    break;
            }
        }
    }

}
