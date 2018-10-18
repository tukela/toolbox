package com.hl.kit.web.utils.session;

import java.util.*;

public class Enumerator implements Enumeration<String> {

	public Enumerator(Collection<String> collection) {
		this(collection.iterator());
	}

	public Enumerator(Collection<String> collection, boolean clone) {
		this(collection.iterator(), clone);
	}

	public Enumerator(Iterator<String> iterator) {
		super();
		this.iterator = iterator;
	}

	public Enumerator(Iterator<String> iterator, boolean clone) {
		super();
		if (!clone) {
			this.iterator = iterator;
		}
		else {
			List<String> list = new ArrayList<String>();
			while (iterator.hasNext()) {
				list.add(iterator.next());
			}
			this.iterator = list.iterator();
		}
	}

	private Iterator<String> iterator = null;

	public boolean hasMoreElements() {
		return (iterator.hasNext());
	}

	public String nextElement() throws NoSuchElementException {
		return (iterator.next());
	}

}
