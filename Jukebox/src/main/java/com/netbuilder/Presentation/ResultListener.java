package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import com.netbuilder.DataAccess.MoneyController;
import com.netbuilder.DataAccess.Music;
import com.netbuilder.DataAccess.MusicController;
import com.netbuilder.Service.PlayQueueArray;

public class ResultListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		ClientView.clientControl.dispose();
		System.out.println("Result button has been pressed\n");
		PlayQueueArray pqa = new PlayQueueArray();

		System.out.println(MusicController.searchByTitle(ClientView.search
				.getText()));
		pqa.addMultipleToQueue(SearchFunctionListener.titles);
		pqa.addMultipleToQueue(SearchFunctionListener.artists);
		pqa.addMultipleToQueue(SearchFunctionListener.albums);
		pqa.playEntirePlaylist();
		ClientView.SetupClient();
		
//		int count = 0;
//		for (int x = 0;x<SearchFunctionListener.titles.size();x++){
//			//this is a trial to get the program to wait for one song to finish before starting the next
//			Timer songTimer = new Timer (SearchFunctionListener.titles.get(count).getLength(), ClientView.searchInput);
//			pqa.playEntirePlaylist();
//			count++;
//		}
		

	}

}
