package com.stackroute.keepnote.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.stackroute.keepnote.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;

/*
 * This class is implementing the NoteDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {
	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public NoteDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory =sessionFactory;
	}

	/*
	 * Save the note in the database(note) table.
	 */

	public boolean saveNote(Note note) {
		Session session = sessionFactory.getCurrentSession();
		session.save(note);
		session.flush();
		return true;
	}

	/*
	 * Remove the note from the database(note) table.
	 */

	public boolean deleteNote(int noteId) {
		System.out.println("ion delete note");
		Session session = sessionFactory.getCurrentSession();
		session.delete(getNoteById(noteId));
		session.flush();
		return true;

	}

	/*
	 * retrieve all existing notes sorted by created Date in descending
	 * order(showing latest note first)
	 */
	public List<Note> getAllNotes() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Note");
		List<Note> list = ((org.hibernate.query.Query) query).list();
		return list;
	}

	/*
	 * retrieve specific note from the database(note) table
	 */
	public Note getNoteById(int noteId) {
		Session session = sessionFactory.getCurrentSession();
		Note note = session.get(Note.class, noteId);
		session.flush();
		return note;

	}

	/* Update existing note */

	public boolean UpdateNote(Note note) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(note);
		session.flush();
		return true;

	}


}
