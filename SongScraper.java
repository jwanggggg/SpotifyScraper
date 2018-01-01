import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.*;
import java.io.*;

public class SongScraper {

	public static void main(String[] args) throws Exception {
		final Document document = Jsoup.connect("https://spotifycharts.com/regional/").get();
		SongsList allSongs = new SongsList();
		for (Element row: document.select("table.chart-table tr")) {
			// Skip the first row
			if (!row.select(".chart-table-streams").text().equals("Streams")) {
				int position = Integer.parseInt(row.select(".chart-table-position").text());
				// Split song and artist, using "by"
				String[] line = row.select(".chart-table-track").text().split("by ");
				String title = line[0];
				String artist = line[1];
				
				int streams = Integer.parseInt(row.select(".chart-table-streams").text().replaceAll(",", ""));
				
				// Print the elements
				
				System.out.println(position + ") " + title + "by " + artist +  "  |  Streams: " + streams);
				
				Song currentSong = new Song(position, title, artist, streams);
				allSongs.add(currentSong);	
			}
		}
		
		while (true) {
			System.out.println();
			System.out.println("Search by (a)rtist, (t)itle, or (q)uit.");
			Scanner input = new Scanner(System.in);
			String option = input.nextLine();
			if (option.equals("t")) {
				System.out.println("Search by title: ");
				String search = input.nextLine();
				searchTitle(search, allSongs);
			}
			
			else if (option.equals("a")) {
				System.out.println("Search by artist: ");
				String search = input.nextLine();
				searchArtist(search, allSongs);
			}
			
			else if (option.equals("q")) {
				break;
			}
		}
		
	}
	
	
	public static void searchTitle(String search, SongsList allSongs) {
		SongsList matchingSongs = allSongs.getSongByTitle(search);
		for (int i = 0; i < matchingSongs.size(); i++) {
			System.out.println(matchingSongs.get(i));
		}
	}
	
	public static void searchArtist(String search, SongsList allSongs) {
		SongsList matchingSongs = allSongs.getSongByArtist(search);
		for (int i = 0; i < matchingSongs.size(); i++) {
			System.out.println(matchingSongs.get(i));
		}
	}
	
}
