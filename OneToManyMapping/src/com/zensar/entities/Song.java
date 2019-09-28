package com.zensar.entities;
/**
 * @author Aditee Chourasiya
 * @creation-date 27-09-2019 4.39PM
 * @modification-date 27-09-2019 4.39PM
 * @version 2.0
 * @copyright All rights reserved by Zensar technologies
 * @description It is a Bean Class
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Song {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int songId;
		private String name;
		@ManyToOne
		@JoinColumn(name = "Movie_Id")
		private Movie movie;
		public Song(String name) {
			super();
			this.name = name;
		}

		public Song() {
			// TODO Auto-generated constructor stub
		}

		public Song(int songId, String name) {
			super();
			this.songId = songId;
			this.name = name;
		}

		public int getSongId() {
			return songId;
		}

		public void setSongId(int songId) {
			this.songId = songId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public Movie getMovie() {
			return movie;
		}

		public void setMovie(Movie movie) {
			this.movie = movie;
		}

		@Override
		public String toString() {
			return "Song [songId=" + songId + ", name=" + name + "]";
		}
		
}
