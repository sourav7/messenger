package org.koushik.javabrains.messenger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	private long id;
	private String message;
	private Date created;
	private String author;
	private Map<Long, Comment> comments = new HashMap<>();

	public Message() {
	}

	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// when pulling up message it should not pull the comments.
	// while converting into xml or json it should be ignored
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", created=" + created + ", author=" + author + "]";
	}

}
