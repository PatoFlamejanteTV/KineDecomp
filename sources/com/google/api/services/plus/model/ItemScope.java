package com.google.api.services.plus.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes.dex */
public final class ItemScope extends GenericJson {

    @Key
    private ItemScope about;

    @Key
    private List<String> additionalName;

    @Key
    private ItemScope address;

    @Key
    private String addressCountry;

    @Key
    private String addressLocality;

    @Key
    private String addressRegion;

    @Key(a = "associated_media")
    private List<ItemScope> associatedMedia;

    @Key
    private Integer attendeeCount;

    @Key
    private List<ItemScope> attendees;

    @Key
    private ItemScope audio;

    @Key
    private List<ItemScope> author;

    @Key
    private String bestRating;

    @Key
    private String birthDate;

    @Key
    private ItemScope byArtist;

    @Key
    private String caption;

    @Key
    private String contentSize;

    @Key
    private String contentUrl;

    @Key
    private List<ItemScope> contributor;

    @Key
    private String dateCreated;

    @Key
    private String dateModified;

    @Key
    private String datePublished;

    @Key
    private String description;

    @Key
    private String duration;

    @Key
    private String embedUrl;

    @Key
    private String endDate;

    @Key
    private String familyName;

    @Key
    private String gender;

    @Key
    private ItemScope geo;

    @Key
    private String givenName;

    @Key
    private String height;

    @Key
    private String id;

    @Key
    private String image;

    @Key
    private ItemScope inAlbum;

    @Key
    private String kind;

    @Key
    private Double latitude;

    @Key
    private ItemScope location;

    @Key
    private Double longitude;

    @Key
    private String name;

    @Key
    private ItemScope partOfTVSeries;

    @Key
    private List<ItemScope> performers;

    @Key
    private String playerType;

    @Key
    private String postOfficeBoxNumber;

    @Key
    private String postalCode;

    @Key
    private String ratingValue;

    @Key
    private ItemScope reviewRating;

    @Key
    private String startDate;

    @Key
    private String streetAddress;

    @Key
    private String text;

    @Key
    private ItemScope thumbnail;

    @Key
    private String thumbnailUrl;

    @Key
    private String tickerSymbol;

    @Key
    private String type;

    @Key
    private String url;

    @Key
    private String width;

    @Key
    private String worstRating;

    public ItemScope getAbout() {
        return this.about;
    }

    public ItemScope setAbout(ItemScope itemScope) {
        this.about = itemScope;
        return this;
    }

    public List<String> getAdditionalName() {
        return this.additionalName;
    }

    public ItemScope setAdditionalName(List<String> list) {
        this.additionalName = list;
        return this;
    }

    public ItemScope getAddress() {
        return this.address;
    }

    public ItemScope setAddress(ItemScope itemScope) {
        this.address = itemScope;
        return this;
    }

    public String getAddressCountry() {
        return this.addressCountry;
    }

    public ItemScope setAddressCountry(String str) {
        this.addressCountry = str;
        return this;
    }

    public String getAddressLocality() {
        return this.addressLocality;
    }

    public ItemScope setAddressLocality(String str) {
        this.addressLocality = str;
        return this;
    }

    public String getAddressRegion() {
        return this.addressRegion;
    }

    public ItemScope setAddressRegion(String str) {
        this.addressRegion = str;
        return this;
    }

    public List<ItemScope> getAssociatedMedia() {
        return this.associatedMedia;
    }

    public ItemScope setAssociatedMedia(List<ItemScope> list) {
        this.associatedMedia = list;
        return this;
    }

    public Integer getAttendeeCount() {
        return this.attendeeCount;
    }

    public ItemScope setAttendeeCount(Integer num) {
        this.attendeeCount = num;
        return this;
    }

    public List<ItemScope> getAttendees() {
        return this.attendees;
    }

    public ItemScope setAttendees(List<ItemScope> list) {
        this.attendees = list;
        return this;
    }

    public ItemScope getAudio() {
        return this.audio;
    }

    public ItemScope setAudio(ItemScope itemScope) {
        this.audio = itemScope;
        return this;
    }

    public List<ItemScope> getAuthor() {
        return this.author;
    }

    public ItemScope setAuthor(List<ItemScope> list) {
        this.author = list;
        return this;
    }

    public String getBestRating() {
        return this.bestRating;
    }

    public ItemScope setBestRating(String str) {
        this.bestRating = str;
        return this;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public ItemScope setBirthDate(String str) {
        this.birthDate = str;
        return this;
    }

    public ItemScope getByArtist() {
        return this.byArtist;
    }

    public ItemScope setByArtist(ItemScope itemScope) {
        this.byArtist = itemScope;
        return this;
    }

    public String getCaption() {
        return this.caption;
    }

    public ItemScope setCaption(String str) {
        this.caption = str;
        return this;
    }

    public String getContentSize() {
        return this.contentSize;
    }

    public ItemScope setContentSize(String str) {
        this.contentSize = str;
        return this;
    }

    public String getContentUrl() {
        return this.contentUrl;
    }

    public ItemScope setContentUrl(String str) {
        this.contentUrl = str;
        return this;
    }

    public List<ItemScope> getContributor() {
        return this.contributor;
    }

    public ItemScope setContributor(List<ItemScope> list) {
        this.contributor = list;
        return this;
    }

    public String getDateCreated() {
        return this.dateCreated;
    }

    public ItemScope setDateCreated(String str) {
        this.dateCreated = str;
        return this;
    }

    public String getDateModified() {
        return this.dateModified;
    }

    public ItemScope setDateModified(String str) {
        this.dateModified = str;
        return this;
    }

    public String getDatePublished() {
        return this.datePublished;
    }

    public ItemScope setDatePublished(String str) {
        this.datePublished = str;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public ItemScope setDescription(String str) {
        this.description = str;
        return this;
    }

    public String getDuration() {
        return this.duration;
    }

    public ItemScope setDuration(String str) {
        this.duration = str;
        return this;
    }

    public String getEmbedUrl() {
        return this.embedUrl;
    }

    public ItemScope setEmbedUrl(String str) {
        this.embedUrl = str;
        return this;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public ItemScope setEndDate(String str) {
        this.endDate = str;
        return this;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public ItemScope setFamilyName(String str) {
        this.familyName = str;
        return this;
    }

    public String getGender() {
        return this.gender;
    }

    public ItemScope setGender(String str) {
        this.gender = str;
        return this;
    }

    public ItemScope getGeo() {
        return this.geo;
    }

    public ItemScope setGeo(ItemScope itemScope) {
        this.geo = itemScope;
        return this;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public ItemScope setGivenName(String str) {
        this.givenName = str;
        return this;
    }

    public String getHeight() {
        return this.height;
    }

    public ItemScope setHeight(String str) {
        this.height = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public ItemScope setId(String str) {
        this.id = str;
        return this;
    }

    public String getImage() {
        return this.image;
    }

    public ItemScope setImage(String str) {
        this.image = str;
        return this;
    }

    public ItemScope getInAlbum() {
        return this.inAlbum;
    }

    public ItemScope setInAlbum(ItemScope itemScope) {
        this.inAlbum = itemScope;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public ItemScope setKind(String str) {
        this.kind = str;
        return this;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public ItemScope setLatitude(Double d) {
        this.latitude = d;
        return this;
    }

    public ItemScope getLocation() {
        return this.location;
    }

    public ItemScope setLocation(ItemScope itemScope) {
        this.location = itemScope;
        return this;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public ItemScope setLongitude(Double d) {
        this.longitude = d;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public ItemScope setName(String str) {
        this.name = str;
        return this;
    }

    public ItemScope getPartOfTVSeries() {
        return this.partOfTVSeries;
    }

    public ItemScope setPartOfTVSeries(ItemScope itemScope) {
        this.partOfTVSeries = itemScope;
        return this;
    }

    public List<ItemScope> getPerformers() {
        return this.performers;
    }

    public ItemScope setPerformers(List<ItemScope> list) {
        this.performers = list;
        return this;
    }

    public String getPlayerType() {
        return this.playerType;
    }

    public ItemScope setPlayerType(String str) {
        this.playerType = str;
        return this;
    }

    public String getPostOfficeBoxNumber() {
        return this.postOfficeBoxNumber;
    }

    public ItemScope setPostOfficeBoxNumber(String str) {
        this.postOfficeBoxNumber = str;
        return this;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public ItemScope setPostalCode(String str) {
        this.postalCode = str;
        return this;
    }

    public String getRatingValue() {
        return this.ratingValue;
    }

    public ItemScope setRatingValue(String str) {
        this.ratingValue = str;
        return this;
    }

    public ItemScope getReviewRating() {
        return this.reviewRating;
    }

    public ItemScope setReviewRating(ItemScope itemScope) {
        this.reviewRating = itemScope;
        return this;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public ItemScope setStartDate(String str) {
        this.startDate = str;
        return this;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public ItemScope setStreetAddress(String str) {
        this.streetAddress = str;
        return this;
    }

    public String getText() {
        return this.text;
    }

    public ItemScope setText(String str) {
        this.text = str;
        return this;
    }

    public ItemScope getThumbnail() {
        return this.thumbnail;
    }

    public ItemScope setThumbnail(ItemScope itemScope) {
        this.thumbnail = itemScope;
        return this;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public ItemScope setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
        return this;
    }

    public String getTickerSymbol() {
        return this.tickerSymbol;
    }

    public ItemScope setTickerSymbol(String str) {
        this.tickerSymbol = str;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public ItemScope setType(String str) {
        this.type = str;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public ItemScope setUrl(String str) {
        this.url = str;
        return this;
    }

    public String getWidth() {
        return this.width;
    }

    public ItemScope setWidth(String str) {
        this.width = str;
        return this;
    }

    public String getWorstRating() {
        return this.worstRating;
    }

    public ItemScope setWorstRating(String str) {
        this.worstRating = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ItemScope set(String str, Object obj) {
        return (ItemScope) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ItemScope clone() {
        return (ItemScope) super.clone();
    }
}
