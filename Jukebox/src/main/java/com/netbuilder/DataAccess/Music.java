package com.netbuilder.DataAccess;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//this is the java map of my Database
/**
 * This class my POJO for the music table in the database
 * 
 * @author Bruce Pannaman
 * @version 1.0
 * @Entity
 * @Table
 * 
 */
@Entity
@Table(name = "Music")
public class Music {

	@Id
	@Column(name = "idMusic")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMusic;

	@Column(name = "Title")
	@NotNull
	@Size(min = 1, max = 45)
	private String title;

	@Column(name = "Length")
	@NotNull
	private long length;

	@Column(name = "Artist")
	@NotNull
	@Size(min = 1, max = 45)
	private String artist;

	@Column(name = "Additional_Artist")
	@Size(min = 1, max = 45)
	private String additional_Artist;

	@Column(name = "Album")
	@NotNull
	@Size(min = 1, max = 45)
	private String album;

	@Column(name = "Genre")
	@NotNull
	@Size(min = 1, max = 45)
	private String genre;

	@Column(name = "Year")
	private int year;

	@Column(name = "File_Path")
	@NotNull
	@Size(min = 1, max = 150)
	private String file_Path;

	/**
	 * This is a blank constructor
	 */
	public Music() {
	}

	/**
	 * This method makes a copy of the class to be overwritten when its called
	 * 
	 * @param title
	 * @param length
	 * @param artist
	 * @param additional_Artist
	 * @param album
	 * @param genres
	 * @param year
	 * @param file_Path
	 */
	public Music(String title, Long length, String artist,
			String additional_Artist, String album, String genre, int year,
			String file_Path) {

		this.title = title;
		this.length = length;
		this.artist = artist;
		this.additional_Artist = additional_Artist;
		this.album = album;
		this.genre = genre;
		this.year = year;
		this.file_Path = file_Path;
	}

	// This creates a template for the "list what is persisted" method to print
	// out what it has persisted
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Music Database Id: " + idMusic + "\n");
		sb.append("Title: " + title + "\n");
		sb.append("Song Duration: " + length + "\n");
		sb.append("Artist: " + artist + "\n");
		sb.append("Additional Artist: " + additional_Artist + "\n");
		sb.append("Album: " + album + "\n");
		sb.append("Genre: " + genre + "\n");
		sb.append("Year Released: " + year + "\n");
		sb.append("File Path on Bruce's Laptop: " + file_Path + "\n");

		return sb.toString();

	}

	// GETTERS AND SETTERS
	public int getIdMusic() {
		return idMusic;
	}

	public void setIdMusic(int idMusic) {
		this.idMusic = idMusic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAdditional_Artist() {
		return additional_Artist;
	}

	public void setAdditional_Artist(String additional_Artist) {
		this.additional_Artist = additional_Artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFile_Path() {
		return file_Path;
	}

	public void setFile_Path(String file_Path) {
		this.file_Path = file_Path;
	}

}
