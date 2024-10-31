package com.google.api.services.plus.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes.dex */
public final class Person extends GenericJson {

    @Key
    private String aboutMe;

    @Key
    private AgeRange ageRange;

    @Key
    private String birthday;

    @Key
    private String braggingRights;

    @Key
    private Integer circledByCount;

    @Key
    private Cover cover;

    @Key
    private String currentLocation;

    @Key
    private String displayName;

    @Key
    private String domain;

    @Key
    private List<Emails> emails;

    @Key
    private String etag;

    @Key
    private String gender;

    @Key
    private String id;

    @Key
    private Image image;

    @Key
    private Boolean isPlusUser;

    @Key
    private String kind;

    @Key
    private String language;

    @Key
    private Name name;

    @Key
    private String nickname;

    @Key
    private String objectType;

    @Key
    private String occupation;

    @Key
    private List<Organizations> organizations;

    @Key
    private List<PlacesLived> placesLived;

    @Key
    private Integer plusOneCount;

    @Key
    private String relationshipStatus;

    @Key
    private String skills;

    @Key
    private String tagline;

    @Key
    private String url;

    @Key
    private List<Urls> urls;

    @Key
    private Boolean verified;

    static {
        Data.a((Class<?>) Emails.class);
        Data.a((Class<?>) Organizations.class);
        Data.a((Class<?>) PlacesLived.class);
        Data.a((Class<?>) Urls.class);
    }

    public String getAboutMe() {
        return this.aboutMe;
    }

    public Person setAboutMe(String str) {
        this.aboutMe = str;
        return this;
    }

    public AgeRange getAgeRange() {
        return this.ageRange;
    }

    public Person setAgeRange(AgeRange ageRange) {
        this.ageRange = ageRange;
        return this;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public Person setBirthday(String str) {
        this.birthday = str;
        return this;
    }

    public String getBraggingRights() {
        return this.braggingRights;
    }

    public Person setBraggingRights(String str) {
        this.braggingRights = str;
        return this;
    }

    public Integer getCircledByCount() {
        return this.circledByCount;
    }

    public Person setCircledByCount(Integer num) {
        this.circledByCount = num;
        return this;
    }

    public Cover getCover() {
        return this.cover;
    }

    public Person setCover(Cover cover) {
        this.cover = cover;
        return this;
    }

    public String getCurrentLocation() {
        return this.currentLocation;
    }

    public Person setCurrentLocation(String str) {
        this.currentLocation = str;
        return this;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Person setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public String getDomain() {
        return this.domain;
    }

    public Person setDomain(String str) {
        this.domain = str;
        return this;
    }

    public List<Emails> getEmails() {
        return this.emails;
    }

    public Person setEmails(List<Emails> list) {
        this.emails = list;
        return this;
    }

    public String getEtag() {
        return this.etag;
    }

    public Person setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getGender() {
        return this.gender;
    }

    public Person setGender(String str) {
        this.gender = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Person setId(String str) {
        this.id = str;
        return this;
    }

    public Image getImage() {
        return this.image;
    }

    public Person setImage(Image image) {
        this.image = image;
        return this;
    }

    public Boolean getIsPlusUser() {
        return this.isPlusUser;
    }

    public Person setIsPlusUser(Boolean bool) {
        this.isPlusUser = bool;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Person setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getLanguage() {
        return this.language;
    }

    public Person setLanguage(String str) {
        this.language = str;
        return this;
    }

    public Name getName() {
        return this.name;
    }

    public Person setName(Name name) {
        this.name = name;
        return this;
    }

    public String getNickname() {
        return this.nickname;
    }

    public Person setNickname(String str) {
        this.nickname = str;
        return this;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public Person setObjectType(String str) {
        this.objectType = str;
        return this;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public Person setOccupation(String str) {
        this.occupation = str;
        return this;
    }

    public List<Organizations> getOrganizations() {
        return this.organizations;
    }

    public Person setOrganizations(List<Organizations> list) {
        this.organizations = list;
        return this;
    }

    public List<PlacesLived> getPlacesLived() {
        return this.placesLived;
    }

    public Person setPlacesLived(List<PlacesLived> list) {
        this.placesLived = list;
        return this;
    }

    public Integer getPlusOneCount() {
        return this.plusOneCount;
    }

    public Person setPlusOneCount(Integer num) {
        this.plusOneCount = num;
        return this;
    }

    public String getRelationshipStatus() {
        return this.relationshipStatus;
    }

    public Person setRelationshipStatus(String str) {
        this.relationshipStatus = str;
        return this;
    }

    public String getSkills() {
        return this.skills;
    }

    public Person setSkills(String str) {
        this.skills = str;
        return this;
    }

    public String getTagline() {
        return this.tagline;
    }

    public Person setTagline(String str) {
        this.tagline = str;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public Person setUrl(String str) {
        this.url = str;
        return this;
    }

    public List<Urls> getUrls() {
        return this.urls;
    }

    public Person setUrls(List<Urls> list) {
        this.urls = list;
        return this;
    }

    public Boolean getVerified() {
        return this.verified;
    }

    public Person setVerified(Boolean bool) {
        this.verified = bool;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Person set(String str, Object obj) {
        return (Person) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Person clone() {
        return (Person) super.clone();
    }

    /* loaded from: classes.dex */
    public static final class AgeRange extends GenericJson {

        @Key
        private Integer max;

        @Key
        private Integer min;

        public Integer getMax() {
            return this.max;
        }

        public AgeRange setMax(Integer num) {
            this.max = num;
            return this;
        }

        public Integer getMin() {
            return this.min;
        }

        public AgeRange setMin(Integer num) {
            this.min = num;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public AgeRange set(String str, Object obj) {
            return (AgeRange) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public AgeRange clone() {
            return (AgeRange) super.clone();
        }
    }

    /* loaded from: classes.dex */
    public static final class Cover extends GenericJson {

        @Key
        private CoverInfo coverInfo;

        @Key
        private CoverPhoto coverPhoto;

        @Key
        private String layout;

        public CoverInfo getCoverInfo() {
            return this.coverInfo;
        }

        public Cover setCoverInfo(CoverInfo coverInfo) {
            this.coverInfo = coverInfo;
            return this;
        }

        public CoverPhoto getCoverPhoto() {
            return this.coverPhoto;
        }

        public Cover setCoverPhoto(CoverPhoto coverPhoto) {
            this.coverPhoto = coverPhoto;
            return this;
        }

        public String getLayout() {
            return this.layout;
        }

        public Cover setLayout(String str) {
            this.layout = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Cover set(String str, Object obj) {
            return (Cover) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Cover clone() {
            return (Cover) super.clone();
        }

        /* loaded from: classes.dex */
        public static final class CoverInfo extends GenericJson {

            @Key
            private Integer leftImageOffset;

            @Key
            private Integer topImageOffset;

            public Integer getLeftImageOffset() {
                return this.leftImageOffset;
            }

            public CoverInfo setLeftImageOffset(Integer num) {
                this.leftImageOffset = num;
                return this;
            }

            public Integer getTopImageOffset() {
                return this.topImageOffset;
            }

            public CoverInfo setTopImageOffset(Integer num) {
                this.topImageOffset = num;
                return this;
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
            public CoverInfo set(String str, Object obj) {
                return (CoverInfo) super.set(str, obj);
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
            public CoverInfo clone() {
                return (CoverInfo) super.clone();
            }
        }

        /* loaded from: classes.dex */
        public static final class CoverPhoto extends GenericJson {

            @Key
            private Integer height;

            @Key
            private String url;

            @Key
            private Integer width;

            public Integer getHeight() {
                return this.height;
            }

            public CoverPhoto setHeight(Integer num) {
                this.height = num;
                return this;
            }

            public String getUrl() {
                return this.url;
            }

            public CoverPhoto setUrl(String str) {
                this.url = str;
                return this;
            }

            public Integer getWidth() {
                return this.width;
            }

            public CoverPhoto setWidth(Integer num) {
                this.width = num;
                return this;
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
            public CoverPhoto set(String str, Object obj) {
                return (CoverPhoto) super.set(str, obj);
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
            public CoverPhoto clone() {
                return (CoverPhoto) super.clone();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Emails extends GenericJson {

        @Key
        private String type;

        @Key
        private String value;

        public String getType() {
            return this.type;
        }

        public Emails setType(String str) {
            this.type = str;
            return this;
        }

        public String getValue() {
            return this.value;
        }

        public Emails setValue(String str) {
            this.value = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Emails set(String str, Object obj) {
            return (Emails) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Emails clone() {
            return (Emails) super.clone();
        }
    }

    /* loaded from: classes.dex */
    public static final class Image extends GenericJson {

        @Key
        private Boolean isDefault;

        @Key
        private String url;

        public Boolean getIsDefault() {
            return this.isDefault;
        }

        public Image setIsDefault(Boolean bool) {
            this.isDefault = bool;
            return this;
        }

        public String getUrl() {
            return this.url;
        }

        public Image setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Image set(String str, Object obj) {
            return (Image) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Image clone() {
            return (Image) super.clone();
        }
    }

    /* loaded from: classes.dex */
    public static final class Name extends GenericJson {

        @Key
        private String familyName;

        @Key
        private String formatted;

        @Key
        private String givenName;

        @Key
        private String honorificPrefix;

        @Key
        private String honorificSuffix;

        @Key
        private String middleName;

        public String getFamilyName() {
            return this.familyName;
        }

        public Name setFamilyName(String str) {
            this.familyName = str;
            return this;
        }

        public String getFormatted() {
            return this.formatted;
        }

        public Name setFormatted(String str) {
            this.formatted = str;
            return this;
        }

        public String getGivenName() {
            return this.givenName;
        }

        public Name setGivenName(String str) {
            this.givenName = str;
            return this;
        }

        public String getHonorificPrefix() {
            return this.honorificPrefix;
        }

        public Name setHonorificPrefix(String str) {
            this.honorificPrefix = str;
            return this;
        }

        public String getHonorificSuffix() {
            return this.honorificSuffix;
        }

        public Name setHonorificSuffix(String str) {
            this.honorificSuffix = str;
            return this;
        }

        public String getMiddleName() {
            return this.middleName;
        }

        public Name setMiddleName(String str) {
            this.middleName = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Name set(String str, Object obj) {
            return (Name) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Name clone() {
            return (Name) super.clone();
        }
    }

    /* loaded from: classes.dex */
    public static final class Organizations extends GenericJson {

        @Key
        private String department;

        @Key
        private String description;

        @Key
        private String endDate;

        @Key
        private String location;

        @Key
        private String name;

        @Key
        private Boolean primary;

        @Key
        private String startDate;

        @Key
        private String title;

        @Key
        private String type;

        public String getDepartment() {
            return this.department;
        }

        public Organizations setDepartment(String str) {
            this.department = str;
            return this;
        }

        public String getDescription() {
            return this.description;
        }

        public Organizations setDescription(String str) {
            this.description = str;
            return this;
        }

        public String getEndDate() {
            return this.endDate;
        }

        public Organizations setEndDate(String str) {
            this.endDate = str;
            return this;
        }

        public String getLocation() {
            return this.location;
        }

        public Organizations setLocation(String str) {
            this.location = str;
            return this;
        }

        public String getName() {
            return this.name;
        }

        public Organizations setName(String str) {
            this.name = str;
            return this;
        }

        public Boolean getPrimary() {
            return this.primary;
        }

        public Organizations setPrimary(Boolean bool) {
            this.primary = bool;
            return this;
        }

        public String getStartDate() {
            return this.startDate;
        }

        public Organizations setStartDate(String str) {
            this.startDate = str;
            return this;
        }

        public String getTitle() {
            return this.title;
        }

        public Organizations setTitle(String str) {
            this.title = str;
            return this;
        }

        public String getType() {
            return this.type;
        }

        public Organizations setType(String str) {
            this.type = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Organizations set(String str, Object obj) {
            return (Organizations) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Organizations clone() {
            return (Organizations) super.clone();
        }
    }

    /* loaded from: classes.dex */
    public static final class PlacesLived extends GenericJson {

        @Key
        private Boolean primary;

        @Key
        private String value;

        public Boolean getPrimary() {
            return this.primary;
        }

        public PlacesLived setPrimary(Boolean bool) {
            this.primary = bool;
            return this;
        }

        public String getValue() {
            return this.value;
        }

        public PlacesLived setValue(String str) {
            this.value = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public PlacesLived set(String str, Object obj) {
            return (PlacesLived) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public PlacesLived clone() {
            return (PlacesLived) super.clone();
        }
    }

    /* loaded from: classes.dex */
    public static final class Urls extends GenericJson {

        @Key
        private String label;

        @Key
        private String type;

        @Key
        private String value;

        public String getLabel() {
            return this.label;
        }

        public Urls setLabel(String str) {
            this.label = str;
            return this;
        }

        public String getType() {
            return this.type;
        }

        public Urls setType(String str) {
            this.type = str;
            return this;
        }

        public String getValue() {
            return this.value;
        }

        public Urls setValue(String str) {
            this.value = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Urls set(String str, Object obj) {
            return (Urls) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Urls clone() {
            return (Urls) super.clone();
        }
    }
}
