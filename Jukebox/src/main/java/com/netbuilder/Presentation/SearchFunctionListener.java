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
	static List<Music> titles;
	static List<Music> artists;
	static List<Music> albums;

	public void actionPerformed(ActionEvent evt) {
		ClientView.clientControl.dispose();

		String inputFromSearchBar = com.netbuilder.Presentation.ClientView.search
				.getText();

		System.out.println(inputFromSearchBar + "was entered into searchbar");

		titles = MusicController.searchByTitle(inputFromSearchBar);
		artists = MusicController.searchByArtist(inputFromSearchBar);
		albums = MusicController.searchByAlbum(inputFromSearchBar);

		if (!titles.isEmpty()) {
			System.out.println("I found\n" + titles);
			ClientView.resultString = titles.get(0).getTitle().toString();
			System.out.println(ClientView.resultString);
			ClientView.SetupClient();
			
	
		}

		if (!artists.isEmpty()) {
			System.out.println("I found\n" + artists);
			ClientView.resultString = artists.get(0).getArtist().toString();
			System.out.println(ClientView.resultString);
			ClientView.SetupClient();
		
		
		}
		if (!albums.isEmpty()) {
			System.out.println("I found\n" + albums);
			ClientView.resultString = (albums.get(0).getAlbum().toString());
			System.out.println(ClientView.resultString);
			ClientView.SetupClient();
			
			
		}
		
		if(titles.isEmpty() && artists.isEmpty() && albums.isEmpty() ){
			JOptionPane.showMessageDialog(null,
				    "I'm Sorry\nThere are no songs\nthat match your criteria",
				    "No Results Found",
				    JOptionPane.ERROR_MESSAGE);
			System.out.println("User typed in a bad search");
			ClientView.SetupClient();
		}

		

	}
}
