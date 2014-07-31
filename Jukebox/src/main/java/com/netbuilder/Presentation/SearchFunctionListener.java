package com.netbuilder.Presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.netbuilder.DataAccess.*;
import com.netbuilder.Service.PlayQueueArray;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * This class will deal with all action listeners and subsequent business logic
 * coming from text being entered to the search bar
 * 
 * @author Bruce Pannaman
 * @version1.0
 * 
 */
public class SearchFunctionListener extends AbstractAction {

	/**
	 * A list of title results
	 */
	static List<Music> titles;
	/**
	 * A list of artists results
	 */
	static List<Music> artists;
	/**
	 * A list of albums results
	 */
	static List<Music> albums;

	public void actionPerformed(ActionEvent evt) {
		ClientView.getClientControl().dispose();

		String inputFromSearchBar = com.netbuilder.Presentation.ClientView.getSearch()
				.getText();

		System.out.println(inputFromSearchBar + "was entered into searchbar");
		// here i am saving the search results to the relevent lists
		titles = MusicController.searchByTitle(inputFromSearchBar);
		artists = MusicController.searchByArtist(inputFromSearchBar);
		albums = MusicController.searchByAlbum(inputFromSearchBar);

		
		 
		
		// if there is a result for titles
		if (!titles.isEmpty()) {
			System.out.println("I found\n" + titles);
			ClientView.resultString = titles.get(0).getTitle().toString();
			System.out.println(ClientView.resultString);
			// refresh clientView
			ClientView.setupClient();

		}
		// if there is a result for artist
		if (!artists.isEmpty()) {
			System.out.println("I found\n" + artists);
			ClientView.resultString = artists.get(0).getArtist().toString();
			System.out.println(ClientView.resultString);
			// refresh clientView
			ClientView.setupClient();

		}
		// if there is a result for album
		if (!albums.isEmpty()) {
			System.out.println("I found\n" + albums);
			ClientView.resultString = (albums.get(0).getAlbum().toString());
			System.out.println(ClientView.resultString);
			// refresh clientView
			ClientView.setupClient();

		}
		// if there are no results
		if (titles.isEmpty() && artists.isEmpty() && albums.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"I'm Sorry\nThere are no songs\nthat match your criteria",
					"No Results Found", JOptionPane.ERROR_MESSAGE);
			System.out.println("User typed in a bad search");
			// refresh clientView
			ClientView.setupClient();
		}

	}
}
