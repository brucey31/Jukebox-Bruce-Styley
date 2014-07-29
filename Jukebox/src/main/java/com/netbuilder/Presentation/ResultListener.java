package com.netbuilder.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.netbuilder.DataAccess.MoneyController;
import com.netbuilder.DataAccess.MusicController;
import com.netbuilder.Service.PlayQueueArray;

public class ResultListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		double moneyValidation = MoneyController.countMoney();
		if(moneyValidation>25){
		ClientView.clientControl.dispose();
		System.out.println("Result button has been pressed\n");
		PlayQueueArray pqa = new PlayQueueArray();

		System.out.println(MusicController.searchByTitle(ClientView.search
				.getText()));
		
		if(!SearchFunctionListener.titles.isEmpty()){
			pqa.addMultipleToQueue(SearchFunctionListener.titles);}
		
		else if(!SearchFunctionListener.artists.isEmpty()){
		pqa.addMultipleToQueue(SearchFunctionListener.artists);}
		
		else if(!SearchFunctionListener.albums.isEmpty()){
		pqa.addMultipleToQueue(SearchFunctionListener.albums);}
	
		pqa.playEntirePlaylist();
		ClientView.SetupClient();}
		else{
			JOptionPane.showMessageDialog(null,
				    "I'm Sorry\nThere isn't enough money\nto play this song",
				    "No Money",
				    JOptionPane.ERROR_MESSAGE);
			
		}
		
//		int count = 0;
//		for (int x = 0;x<SearchFunctionListener.titles.size();x++){
//			//this is a trial to get the program to wait for one song to finish before starting the next using song timers
//			Timer songTimer = new Timer (SearchFunctionListener.titles.get(count).getLength(), ClientView.searchInput);
//			pqa.playEntirePlaylist();
//			count++;
//		}
		

	}

}
