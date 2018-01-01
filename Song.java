
public class Song {
	
	private int position;
	private String title;
	private String artist;
	private int streams;
	
	public Song(int position, String title, String artist, int streams) {
		this.position = position;
		this.title = title;
		this.artist = artist;
		this.streams = streams;
	}
	
	public int getPosition() {
		return position;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int getStreams() {
		return streams;
	}
	
	public String toString() {
		return position + ") " + title + "by " + artist + "  |  " + streams + " Streams";
	}
	
}
