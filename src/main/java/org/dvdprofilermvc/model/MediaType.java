package org.dvdprofilermvc.model;

import java.util.HashMap;
import java.util.Map;

public enum MediaType {
	DVD, HDDVD, BluRay;
	private static Map<String, MediaType> mapping = new HashMap<String, MediaType>();
	static {
		mapping.put("dvd", DVD);
		mapping.put("hddvd", HDDVD);
		mapping.put("bluray", BluRay);
	}

	public static MediaType get(String mediatype) {
		if (mediatype != null) {
			return mapping.get(mediatype.toLowerCase());
		}
		return null;
	}
}
