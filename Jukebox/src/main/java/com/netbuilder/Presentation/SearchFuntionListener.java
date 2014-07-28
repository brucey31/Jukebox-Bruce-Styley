package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.netbuilder.DataAccess.*;
import javax.swing.AbstractAction;

/**
 * This class will deal with all action listeners and subsequent business logic coming from text being entered to the search bar
 * @author Bruce Pannaman
 * @version1.0
 *
 */
public class SearchFuntionListener extends AbstractAction{

	public void actionPerformed(ActionEvent evt) {

		String inputFromSearchBar = com.netbuilder.Presentation.ClientView.search.getText();

		System.out.println(inputFromSearchBar + "was entered into searchbar");
		
		MusicController.searchByTitle(inputFromSearchBar);
		MusicController.searchByArtist(inputFromSearchBar);
		MusicController.searchByAlbum(inputFromSearchBar);
		
		
		I have now searched for music by using the search bar
		
		
		

		
	}
}
