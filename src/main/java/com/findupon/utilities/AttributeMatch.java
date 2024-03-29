
/*
 * Copyright 2015-2019 Connor Van Elswyk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.findupon.utilities;

import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;


public class AttributeMatch implements Comparable<AttributeMatch> {

	private final String attribute;
	private final List<String> allowedMatches;
	private final List<Element> matchingElements;


	public AttributeMatch(String attribute, List<String> allowedMatches) {
		this.attribute = attribute;
		this.allowedMatches = new ArrayList<>(allowedMatches);
		this.matchingElements = new ArrayList<>();
	}

	public String getAttribute() {
		return attribute;
	}

	public List<String> getAllowedMatches() {
		return allowedMatches;
	}

	public List<Element> getMatchingElements() {
		return matchingElements;
	}

	@Override
	public int compareTo(AttributeMatch o) {
		int x = o.getAttribute() == null ? 0 : o.getAttribute().length();
		int y = this.attribute == null ? 0 : this.attribute.length();
		return Integer.compare(x, y);
	}
}
