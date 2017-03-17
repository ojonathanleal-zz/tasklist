package br.com.supero;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	private Long id;
	
	private String text;
	
	private boolean completed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
}
