package week_7.assignment_problems;

import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Playlist size must be greater than 0.");
        }
        this.songs = new String[maxSize];
    }

    public void addSong(String song) {
        if (song == null || songCount >= songs.length) {
            return;
        }
        songs[songCount] = song;
        songCount++;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Playlist count: " + p.getSongCount());
        System.out.println("First song: " + p.getSongs()[0]);
    }
}
