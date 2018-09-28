package com.endava.junit.model;

import java.time.LocalDateTime;

public class ArchiveEntry {

	private LocalDateTime date;

	private Item item;

	private Operation operation;

	public ArchiveEntry(LocalDateTime date, Item item, Operation operation) {
		this.date = date;
		this.item = item;
		this.operation = operation;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
}
