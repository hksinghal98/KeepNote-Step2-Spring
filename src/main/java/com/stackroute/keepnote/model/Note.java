package com.stackroute.keepnote.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
 * The class "Note" will be acting as the data model for the note Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */

@Entity
@Component
@Scope("prototype")
public class Note {
	@Id
	@Column(name = "noteId")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int NoteID;
	@Column(name = "noteTitle")
	private String NoteTitle;
	@Column(name = "noteContent")
	private String NoteContent;
	@Column(name = "noteStatus")
	private String NoteStatus;
	@Column(name = "createdAt")
	private LocalDateTime CreatedAt;

	public LocalDateTime getCreatedAt() {
		return CreatedAt;
	}

	public Note() {

	}

	public Note(int i, String string, String string2, String string3, LocalDateTime localDate) {
		setNoteId(i);
		setNoteTitle(string);
		setNoteContent(string2);
		setNoteStatus(string3);
		setCreatedAt(localDate);
	}

	public int getNoteId() {

		return this.NoteID;
	}

	public String getNoteTitle() {

		return this.NoteTitle;
	}

	public String getNoteContent() {

		return this.NoteContent;
	}

	public String getNoteStatus() {

		return this.NoteStatus;
	}

	public void setNoteId(int parseInt) {
		this.NoteID = parseInt;
	}

	public void setNoteTitle(String parameter) {
		this.NoteTitle = parameter;
	}

	public void setNoteContent(String parameter) {
		this.NoteContent = parameter;
	}

	public void setNoteStatus(String parameter) {
		this.NoteStatus = parameter;
	}

	public void setCreatedAt(LocalDateTime now) {
		this.CreatedAt = now;
	}

	@Override
	public String toString() {
		return "Note{" +
				"NoteID=" + NoteID +
				", NoteTitle='" + NoteTitle + '\'' +
				", NoteContent='" + NoteContent + '\'' +
				", NoteStatus='" + NoteStatus + '\'' +
				", CreatedAt=" + CreatedAt +
				"}";
	}

}
