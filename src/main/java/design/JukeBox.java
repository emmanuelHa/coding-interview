package design;

import java.util.Queue;
import java.util.Set;

/**
 * Modelisation of a JukeBox
 */
public class JukeBox {

    private CDPlayer cdPlayer;

    private User user;

    private Set<CD> cdCollection;

    private TrackSelector ts;

    public JukeBox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, TrackSelector ts) {

    }

    public Song getCurrentTrack() {
        return ts.getCurrentSong();
    }

    public void processOneUser(User u) {
        this.user = u;
    }

    public class CD { }

    public class CDPlayer {

        private Playlist p;
        private CD c;

        public Playlist getPlaylist() {
            return p;
        }
        public void setPlaylist(Playlist p) {
            this.p = p;
        }
        public CD getCD() {
            return c;
        }
        public void setCD(CD c) {
            this.c = c;
        }
        public CDPlayer(Playlist p) {
            this.p = p;
        }
        public CDPlayer(CD c, Playlist p) {

        }
        public CDPlayer(CD c) {
            this.c = c;
        }
        public void playTrack(Song s) {

        }
    }

    public class Playlist {

        private Song track;
        private Queue<Song> queue;
        public Playlist(Song track, Queue<Song> queue) {

        }
        public Song getNextTrackToPlay(){
            return queue.peek();
        }
        public void queueUpTrack(Song s){
            queue.add(s);
        }
    }
    public class Song {
        private String songName;
    }

    public class TrackSelector {

        private Song currentSong;

        public TrackSelector(Song s) {
            currentSong=s;
        }
        public void setTrack(Song s) {
            currentSong = s;
        }
        public Song getCurrentSong() {
            return currentSong;
        }
    }

    public class User {

        private String name;
        private long ID;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public long getID() { return ID; }
        public void setID(long iD) { ID = iD; }

        public User(String name, long iD) {

        }
        public User getUser() {
            return this;
        }

        // TODO create helper class for this method
        public User addUser(String name, long id) {
            return new User(name, id);
        }
    }
}


