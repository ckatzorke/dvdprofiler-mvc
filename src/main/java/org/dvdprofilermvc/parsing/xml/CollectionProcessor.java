package org.dvdprofilermvc.parsing.xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dvdprofilermvc.model.DVD;

public interface CollectionProcessor {
	/** Handled elements */
	public static final String COLLECTION_ELEMENT_TITLE = "Title";
	public static final String COLLECTION_ELEMENT_ORIGINAL_TITLE = "OriginalTitle";
	public static final String COLLECTION_ELEMENT_ID = "ID";
	public static final String COLLECTION_ELEMENT_UPC = "UPC";
	public static final String COLLECTION_ELEMENT_PROFILE_TIMESTAMP = "ProfileTimestamp";
	public static final String COLLECTION_ELEMENT_COLLECTION = "Collection";
	public static final String COLLECTION_ELEMENT_DVD = "DVD";
	public static final String COLLECTION_ELEMENT_ACTORS = "Actors";
	public static final String COLLECTION_ELEMENT_ACTOR = "Actor";
	public static final String COLLECTION_ELEMENT_OVERVIEW = "Overview";
	public static final String COLLECTION_ELEMENT_MEDIA_TYPES = "MediaTypes";
	public static final String COLLECTION_ELEMENT_COLLECTIONNUMBER = "CollectionNumber";
	public static final String COLLECTION_ELEMENT_COUNTRYOFORIGIN = "CountryOfOrigin";
	public static final String COLLECTION_ELEMENT_GENRES = "Genres";
	public static final String COLLECTION_ELEMENT_STUDIOS = "Studios";
	public static final String COLLECTION_ELEMENT_BOXSET = "BoxSet";
	public static final String COLLECTION_ELEMENT_PARENT = "Parent";
	public static final String COLLECTION_ELEMENT_PURCHASE_DATE = "PurchaseDate";
	public static final String COLLECTION_ELEMENT_PRODUCTION_YEAR = "ProductionYear";
	public static final String COLLECTION_ELEMENT_RATING = "Rating";
	public static final String COLLECTION_ELEMENT_RATING_AGE = "RatingAge";
	public static final String COLLECTION_ELEMENT_RELEASE_DATE = "Released";
	public static final String COLLECTION_ELEMENT_REVIEW = "Review";
	public static final String COLLECTION_ELEMENT_RUNNINGTIME = "RunningTime";

	/** helper */
	public static final String COLLECTION_ELEMENT_MEDIA_TYPE = "MediaType";
	public static final String COLLECTION_ELEMENT_LOCKS = "Locks";

	public final List<DVDEventListener> listeners = new ArrayList<DVDEventListener>();

	public default void addDVDEventListener(DVDEventListener listener) {
		listeners.add(listener);
	}

	public default void sendEvent(DVD dvd) {
		final DVDEvent event = new DVDEvent(dvd);
		for (final DVDEventListener listener : listeners) {
			listener.onEvent(event);
		}
	}

	void process(InputStream stream);
}
