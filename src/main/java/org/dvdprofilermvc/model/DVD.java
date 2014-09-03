package org.dvdprofilermvc.model;

import java.util.Arrays;

public class DVD {

	private String id;
	private String upc;
	private String profileTimeStamp;
	private String parentUpc;
	private String title;
	private String originalTitle;
	private String overview;
	private MediaType[] mediaType;
	private int collectionNumber;
	private String countryOfOrigin;
	private String[] genres;
	private String[] studios;
	private String purchaseDate;
	private String releaseDate;
	private String productionYear;
	private String rating;
	private String ratingAge;
	private int runningTime;
	private int review;

	private Person[] actors;

	private DVD[] childProfiles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getParentUpc() {
		return parentUpc;
	}

	public void setParentUpc(String parentUpc) {
		this.parentUpc = parentUpc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String description) {
		overview = description;
	}

	public MediaType[] getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType[] mediaType) {
		this.mediaType = mediaType;
	}

	public int getCollectionNumber() {
		return collectionNumber;
	}

	public void setCollectionNumber(int collectionNumber) {
		this.collectionNumber = collectionNumber;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String[] getGenres() {
		return genres;
	}

	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	public void setProfileTimeStamp(String profileTimeStamp) {
		this.profileTimeStamp = profileTimeStamp;
	}

	public String getProfileTimeStamp() {
		return profileTimeStamp;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public DVD[] getChildProfiles() {
		return childProfiles;
	}

	public void setChildProfiles(DVD[] childProfiles) {
		this.childProfiles = childProfiles;
	}

	public String[] getStudios() {
		return studios;
	}

	public void setStudios(String[] studios) {
		this.studios = studios;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRatingAge() {
		return ratingAge;
	}

	public void setRatingAge(String ratingAge) {
		this.ratingAge = ratingAge;
	}

	public Person[] getActors() {
		return actors;
	}

	public void setActors(Person[] actors) {
		this.actors = actors;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	@Override
	public String toString() {
		return "DVD [id=" + id + ", upc=" + upc + ", profileTimeStamp=" + profileTimeStamp + ", parentUpc=" + parentUpc
				+ ", title=" + title + ", originalTitle=" + originalTitle + ", overview=" + overview + ", mediaType="
				+ Arrays.toString(mediaType) + ", collectionNumber=" + collectionNumber + ", countryOfOrigin="
				+ countryOfOrigin + ", genres=" + Arrays.toString(genres) + ", studios=" + Arrays.toString(studios)
				+ ", purchaseDate=" + purchaseDate + ", releaseDate=" + releaseDate + ", productionYear=" + productionYear
				+ ", rating=" + rating + ", ratingAge=" + ratingAge + ", runningTime=" + runningTime + ", review=" + review
				+ ", actors=" + Arrays.toString(actors) + ", childProfiles=" + Arrays.toString(childProfiles) + "]";
	}

}
