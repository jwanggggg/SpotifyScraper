import java.util.*;

public class SongsList extends ArrayList<Song> {
	
	public SongsList () {
		
	}
	
	public SongsList getSongByTitle(String title) {
		SongsList matchingSongs = new SongsList();
		for (int i = 0; i < size(); i++) {
			Song currentSong = get(i);
			if (currentSong.getTitle().toLowerCase().contains(title.toLowerCase())) {
				matchingSongs.add(currentSong);
			}
		}
		return matchingSongs;
	}
	
	public SongsList getSongByArtist(String artist) {
		SongsList matchingSongs = new SongsList();
		for (int i = 0; i < size(); i++) {
			Song currentSong = get(i);
			if (currentSong.getArtist().toLowerCase().contains(artist.toLowerCase())) {
				matchingSongs.add(currentSong);
			}
		}
		return matchingSongs;
	}
	
	
}
