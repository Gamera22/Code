import java.util.Arrays;

public class Playlist {
	
	private Song[] songs;
	
	private int numSongs;
	
	final private static int MIN_CAPACITY = 3;
	
	public Playlist(){
		this(MIN_CAPACITY);
	}
	public Playlist(int capacity){
		
		if(capacity < MIN_CAPACITY) {
			capacity = MIN_CAPACITY;
		}
		this.songs = new Song[capacity];
		this.numSongs = 0;
	}
	
	
	public int getCapacity() {
		return songs.length;
	}
	public int getNumSongs() {
		return numSongs;
	}
	
	public Song getSong(int index) {
		
		if(index < 0 || index >= numSongs) {
			return null;
		}
		
		return songs[index];
	}
	
	public Song[] getSongs() {
		return Arrays.copyOf(songs,numSongs);
	}
	public boolean addSong(Song song) {
		return addSong(numSongs, song);
	}
	public boolean addSong(int index, Song song) {
		if(numSongs == songs.length || index < 0 || index > numSongs || song == null) {
			return false;
		}
		for(int i = numSongs - 1; i >= index; i--) {
			songs[i+1] = songs[i];
		}
		songs[index] = song;
		
		numSongs++;
		
		return true;
	}
	
	public int addSongs(Playlist playlist) {
		
		int add = 0;
		
		int i;
		
		if(playlist == null || playlist.numSongs == 0) {
			return 0;
		}
		
		else {
			for(i = numSongs; i< this.songs.length && add < playlist.numSongs; ++i) {
				this.songs[i] = playlist.songs[add];
				add++;
			}
			numSongs = i;
			}
		return add;
		}
	public Song removeSong() {
		if (numSongs == 0) {
            
			return null;
        }
        Song remove = songs[numSongs - 1];
        
        songs[numSongs - 1] = null;
        
        numSongs--;
       
        return remove;
	}
	public Song removeSong(int index) {
		 if (index < 0 || index >= numSongs) {
	            return null;
	        }
		  Song removeSong = songs[index];

	        for (int i = index; i < numSongs - 1; i++) {
	            songs[i] = songs[i + 1];
	        }

	        songs[numSongs - 1] = null;
	       
	        numSongs--;

	        return removeSong;
		
	}
}
	

