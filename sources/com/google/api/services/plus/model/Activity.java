package com.google.api.services.plus.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes.dex */
public final class Activity extends GenericJson {

    @Key
    private Acl access;

    @Key
    private Actor actor;

    @Key
    private String address;

    @Key
    private String annotation;

    @Key
    private String crosspostSource;

    @Key
    private String etag;

    @Key
    private String geocode;

    @Key
    private String id;

    @Key
    private String kind;

    @Key
    private Place location;

    @Key(a = "object")
    private PlusObject object__;

    @Key
    private String placeId;

    @Key
    private String placeName;

    @Key
    private Provider provider;

    @Key
    private DateTime published;

    @Key
    private String radius;

    @Key
    private String title;

    @Key
    private DateTime updated;

    @Key
    private String url;

    @Key
    private String verb;

    public Acl getAccess() {
        return this.access;
    }

    public Activity setAccess(Acl acl) {
        this.access = acl;
        return this;
    }

    public Actor getActor() {
        return this.actor;
    }

    public Activity setActor(Actor actor) {
        this.actor = actor;
        return this;
    }

    public String getAddress() {
        return this.address;
    }

    public Activity setAddress(String str) {
        this.address = str;
        return this;
    }

    public String getAnnotation() {
        return this.annotation;
    }

    public Activity setAnnotation(String str) {
        this.annotation = str;
        return this;
    }

    public String getCrosspostSource() {
        return this.crosspostSource;
    }

    public Activity setCrosspostSource(String str) {
        this.crosspostSource = str;
        return this;
    }

    public String getEtag() {
        return this.etag;
    }

    public Activity setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getGeocode() {
        return this.geocode;
    }

    public Activity setGeocode(String str) {
        this.geocode = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Activity setId(String str) {
        this.id = str;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Activity setKind(String str) {
        this.kind = str;
        return this;
    }

    public Place getLocation() {
        return this.location;
    }

    public Activity setLocation(Place place) {
        this.location = place;
        return this;
    }

    public PlusObject getObject() {
        return this.object__;
    }

    public Activity setObject(PlusObject plusObject) {
        this.object__ = plusObject;
        return this;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public Activity setPlaceId(String str) {
        this.placeId = str;
        return this;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public Activity setPlaceName(String str) {
        this.placeName = str;
        return this;
    }

    public Provider getProvider() {
        return this.provider;
    }

    public Activity setProvider(Provider provider) {
        this.provider = provider;
        return this;
    }

    public DateTime getPublished() {
        return this.published;
    }

    public Activity setPublished(DateTime dateTime) {
        this.published = dateTime;
        return this;
    }

    public String getRadius() {
        return this.radius;
    }

    public Activity setRadius(String str) {
        this.radius = str;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public Activity setTitle(String str) {
        this.title = str;
        return this;
    }

    public DateTime getUpdated() {
        return this.updated;
    }

    public Activity setUpdated(DateTime dateTime) {
        this.updated = dateTime;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public Activity setUrl(String str) {
        this.url = str;
        return this;
    }

    public String getVerb() {
        return this.verb;
    }

    public Activity setVerb(String str) {
        this.verb = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Activity set(String str, Object obj) {
        return (Activity) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Activity clone() {
        return (Activity) super.clone();
    }

    /* loaded from: classes.dex */
    public static final class Actor extends GenericJson {

        @Key
        private ClientSpecificActorInfo clientSpecificActorInfo;

        @Key
        private String displayName;

        @Key
        private String id;

        @Key
        private Image image;

        @Key
        private Name name;

        @Key
        private String url;

        @Key
        private Verification verification;

        public ClientSpecificActorInfo getClientSpecificActorInfo() {
            return this.clientSpecificActorInfo;
        }

        public Actor setClientSpecificActorInfo(ClientSpecificActorInfo clientSpecificActorInfo) {
            this.clientSpecificActorInfo = clientSpecificActorInfo;
            return this;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public Actor setDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public String getId() {
            return this.id;
        }

        public Actor setId(String str) {
            this.id = str;
            return this;
        }

        public Image getImage() {
            return this.image;
        }

        public Actor setImage(Image image) {
            this.image = image;
            return this;
        }

        public Name getName() {
            return this.name;
        }

        public Actor setName(Name name) {
            this.name = name;
            return this;
        }

        public String getUrl() {
            return this.url;
        }

        public Actor setUrl(String str) {
            this.url = str;
            return this;
        }

        public Verification getVerification() {
            return this.verification;
        }

        public Actor setVerification(Verification verification) {
            this.verification = verification;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Actor set(String str, Object obj) {
            return (Actor) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Actor clone() {
            return (Actor) super.clone();
        }

        /* loaded from: classes.dex */
        public static final class ClientSpecificActorInfo extends GenericJson {

            @Key
            private YoutubeActorInfo youtubeActorInfo;

            public YoutubeActorInfo getYoutubeActorInfo() {
                return this.youtubeActorInfo;
            }

            public ClientSpecificActorInfo setYoutubeActorInfo(YoutubeActorInfo youtubeActorInfo) {
                this.youtubeActorInfo = youtubeActorInfo;
                return this;
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
            public ClientSpecificActorInfo set(String str, Object obj) {
                return (ClientSpecificActorInfo) super.set(str, obj);
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
            public ClientSpecificActorInfo clone() {
                return (ClientSpecificActorInfo) super.clone();
            }

            /* loaded from: classes.dex */
            public static final class YoutubeActorInfo extends GenericJson {

                @Key
                private String channelId;

                public String getChannelId() {
                    return this.channelId;
                }

                public YoutubeActorInfo setChannelId(String str) {
                    this.channelId = str;
                    return this;
                }

                @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
                public YoutubeActorInfo set(String str, Object obj) {
                    return (YoutubeActorInfo) super.set(str, obj);
                }

                @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
                public YoutubeActorInfo clone() {
                    return (YoutubeActorInfo) super.clone();
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class Image extends GenericJson {

            @Key
            private String url;

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
            private String givenName;

            public String getFamilyName() {
                return this.familyName;
            }

            public Name setFamilyName(String str) {
                this.familyName = str;
                return this;
            }

            public String getGivenName() {
                return this.givenName;
            }

            public Name setGivenName(String str) {
                this.givenName = str;
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
        public static final class Verification extends GenericJson {

            @Key
            private String adHocVerified;

            public String getAdHocVerified() {
                return this.adHocVerified;
            }

            public Verification setAdHocVerified(String str) {
                this.adHocVerified = str;
                return this;
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
            public Verification set(String str, Object obj) {
                return (Verification) super.set(str, obj);
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
            public Verification clone() {
                return (Verification) super.clone();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class PlusObject extends GenericJson {

        @Key
        private Actor actor;

        @Key
        private List<Attachments> attachments;

        @Key
        private String content;

        @Key
        private String id;

        @Key
        private String objectType;

        @Key
        private String originalContent;

        @Key
        private Plusoners plusoners;

        @Key
        private Replies replies;

        @Key
        private Resharers resharers;

        @Key
        private String url;

        static {
            Data.a((Class<?>) Attachments.class);
        }

        public Actor getActor() {
            return this.actor;
        }

        public PlusObject setActor(Actor actor) {
            this.actor = actor;
            return this;
        }

        public List<Attachments> getAttachments() {
            return this.attachments;
        }

        public PlusObject setAttachments(List<Attachments> list) {
            this.attachments = list;
            return this;
        }

        public String getContent() {
            return this.content;
        }

        public PlusObject setContent(String str) {
            this.content = str;
            return this;
        }

        public String getId() {
            return this.id;
        }

        public PlusObject setId(String str) {
            this.id = str;
            return this;
        }

        public String getObjectType() {
            return this.objectType;
        }

        public PlusObject setObjectType(String str) {
            this.objectType = str;
            return this;
        }

        public String getOriginalContent() {
            return this.originalContent;
        }

        public PlusObject setOriginalContent(String str) {
            this.originalContent = str;
            return this;
        }

        public Plusoners getPlusoners() {
            return this.plusoners;
        }

        public PlusObject setPlusoners(Plusoners plusoners) {
            this.plusoners = plusoners;
            return this;
        }

        public Replies getReplies() {
            return this.replies;
        }

        public PlusObject setReplies(Replies replies) {
            this.replies = replies;
            return this;
        }

        public Resharers getResharers() {
            return this.resharers;
        }

        public PlusObject setResharers(Resharers resharers) {
            this.resharers = resharers;
            return this;
        }

        public String getUrl() {
            return this.url;
        }

        public PlusObject setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public PlusObject set(String str, Object obj) {
            return (PlusObject) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public PlusObject clone() {
            return (PlusObject) super.clone();
        }

        /* loaded from: classes.dex */
        public static final class Actor extends GenericJson {

            @Key
            private ClientSpecificActorInfo clientSpecificActorInfo;

            @Key
            private String displayName;

            @Key
            private String id;

            @Key
            private Image image;

            @Key
            private String url;

            @Key
            private Verification verification;

            public ClientSpecificActorInfo getClientSpecificActorInfo() {
                return this.clientSpecificActorInfo;
            }

            public Actor setClientSpecificActorInfo(ClientSpecificActorInfo clientSpecificActorInfo) {
                this.clientSpecificActorInfo = clientSpecificActorInfo;
                return this;
            }

            public String getDisplayName() {
                return this.displayName;
            }

            public Actor setDisplayName(String str) {
                this.displayName = str;
                return this;
            }

            public String getId() {
                return this.id;
            }

            public Actor setId(String str) {
                this.id = str;
                return this;
            }

            public Image getImage() {
                return this.image;
            }

            public Actor setImage(Image image) {
                this.image = image;
                return this;
            }

            public String getUrl() {
                return this.url;
            }

            public Actor setUrl(String str) {
                this.url = str;
                return this;
            }

            public Verification getVerification() {
                return this.verification;
            }

            public Actor setVerification(Verification verification) {
                this.verification = verification;
                return this;
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
            public Actor set(String str, Object obj) {
                return (Actor) super.set(str, obj);
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
            public Actor clone() {
                return (Actor) super.clone();
            }

            /* loaded from: classes.dex */
            public static final class ClientSpecificActorInfo extends GenericJson {

                @Key
                private YoutubeActorInfo youtubeActorInfo;

                public YoutubeActorInfo getYoutubeActorInfo() {
                    return this.youtubeActorInfo;
                }

                public ClientSpecificActorInfo setYoutubeActorInfo(YoutubeActorInfo youtubeActorInfo) {
                    this.youtubeActorInfo = youtubeActorInfo;
                    return this;
                }

                @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
                public ClientSpecificActorInfo set(String str, Object obj) {
                    return (ClientSpecificActorInfo) super.set(str, obj);
                }

                @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
                public ClientSpecificActorInfo clone() {
                    return (ClientSpecificActorInfo) super.clone();
                }

                /* loaded from: classes.dex */
                public static final class YoutubeActorInfo extends GenericJson {

                    @Key
                    private String channelId;

                    public String getChannelId() {
                        return this.channelId;
                    }

                    public YoutubeActorInfo setChannelId(String str) {
                        this.channelId = str;
                        return this;
                    }

                    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
                    public YoutubeActorInfo set(String str, Object obj) {
                        return (YoutubeActorInfo) super.set(str, obj);
                    }

                    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
                    public YoutubeActorInfo clone() {
                        return (YoutubeActorInfo) super.clone();
                    }
                }
            }

            /* loaded from: classes.dex */
            public static final class Image extends GenericJson {

                @Key
                private String url;

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
            public static final class Verification extends GenericJson {

                @Key
                private String adHocVerified;

                public String getAdHocVerified() {
                    return this.adHocVerified;
                }

                public Verification setAdHocVerified(String str) {
                    this.adHocVerified = str;
                    return this;
                }

                @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
                public Verification set(String str, Object obj) {
                    return (Verification) super.set(str, obj);
                }

                @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
                public Verification clone() {
                    return (Verification) super.clone();
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class Attachments extends GenericJson {

            @Key
            private String content;

            @Key
            private String displayName;

            @Key
            private Embed embed;

            @Key
            private FullImage fullImage;

            @Key
            private String id;

            @Key
            private Image image;

            @Key
            private String objectType;

            @Key
            private List<Thumbnails> thumbnails;

            @Key
            private String url;

            static {
                Data.a((Class<?>) Thumbnails.class);
            }

            public String getContent() {
                return this.content;
            }

            public Attachments setContent(String str) {
                this.content = str;
                return this;
            }

            public String getDisplayName() {
                return this.displayName;
            }

            public Attachments setDisplayName(String str) {
                this.displayName = str;
                return this;
            }

            public Embed getEmbed() {
                return this.embed;
            }

            public Attachments setEmbed(Embed embed) {
                this.embed = embed;
                return this;
            }

            public FullImage getFullImage() {
                return this.fullImage;
            }

            public Attachments setFullImage(FullImage fullImage) {
                this.fullImage = fullImage;
                return this;
            }

            public String getId() {
                return this.id;
            }

            public Attachments setId(String str) {
                this.id = str;
                return this;
            }

            public Image getImage() {
                return this.image;
            }

            public Attachments setImage(Image image) {
                this.image = image;
                return this;
            }

            public String getObjectType() {
                return this.objectType;
            }

            public Attachments setObjectType(String str) {
                this.objectType = str;
                return this;
            }

            public List<Thumbnails> getThumbnails() {
                return this.thumbnails;
            }

            public Attachments setThumbnails(List<Thumbnails> list) {
                this.thumbnails = list;
                return this;
            }

            public String getUrl() {
                return this.url;
            }

            public Attachments setUrl(String str) {
                this.url = str;
                return this;
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
            public Attachments set(String str, Object obj) {
                return (Attachments) super.set(str, obj);
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
            public Attachments clone() {
                return (Attachments) super.clone();
            }

            /* loaded from: classes.dex */
            public static final class Embed extends GenericJson {

                @Key
                private String type;

                @Key
                private String url;

                public String getType() {
                    return this.type;
                }

                public Embed setType(String str) {
                    this.type = str;
                    return this;
                }

                public String getUrl() {
                    return this.url;
                }

                public Embed setUrl(String str) {
                    this.url = str;
                    return this;
                }

                @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
                public Embed set(String str, Object obj) {
                    return (Embed) super.set(str, obj);
                }

                @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
                public Embed clone() {
                    return (Embed) super.clone();
                }
            }

            /* loaded from: classes.dex */
            public static final class FullImage extends GenericJson {

                @Key
                private Long height;

                @Key
                private String type;

                @Key
                private String url;

                @Key
                private Long width;

                public Long getHeight() {
                    return this.height;
                }

                public FullImage setHeight(Long l) {
                    this.height = l;
                    return this;
                }

                public String getType() {
                    return this.type;
                }

                public FullImage setType(String str) {
                    this.type = str;
                    return this;
                }

                public String getUrl() {
                    return this.url;
                }

                public FullImage setUrl(String str) {
                    this.url = str;
                    return this;
                }

                public Long getWidth() {
                    return this.width;
                }

                public FullImage setWidth(Long l) {
                    this.width = l;
                    return this;
                }

                @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
                public FullImage set(String str, Object obj) {
                    return (FullImage) super.set(str, obj);
                }

                @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
                public FullImage clone() {
                    return (FullImage) super.clone();
                }
            }

            /* loaded from: classes.dex */
            public static final class Image extends GenericJson {

                @Key
                private Long height;

                @Key
                private String type;

                @Key
                private String url;

                @Key
                private Long width;

                public Long getHeight() {
                    return this.height;
                }

                public Image setHeight(Long l) {
                    this.height = l;
                    return this;
                }

                public String getType() {
                    return this.type;
                }

                public Image setType(String str) {
                    this.type = str;
                    return this;
                }

                public String getUrl() {
                    return this.url;
                }

                public Image setUrl(String str) {
                    this.url = str;
                    return this;
                }

                public Long getWidth() {
                    return this.width;
                }

                public Image setWidth(Long l) {
                    this.width = l;
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
            public static final class Thumbnails extends GenericJson {

                @Key
                private String description;

                @Key
                private Image image;

                @Key
                private String url;

                public String getDescription() {
                    return this.description;
                }

                public Thumbnails setDescription(String str) {
                    this.description = str;
                    return this;
                }

                public Image getImage() {
                    return this.image;
                }

                public Thumbnails setImage(Image image) {
                    this.image = image;
                    return this;
                }

                public String getUrl() {
                    return this.url;
                }

                public Thumbnails setUrl(String str) {
                    this.url = str;
                    return this;
                }

                @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
                public Thumbnails set(String str, Object obj) {
                    return (Thumbnails) super.set(str, obj);
                }

                @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
                public Thumbnails clone() {
                    return (Thumbnails) super.clone();
                }

                /* loaded from: classes.dex */
                public static final class Image extends GenericJson {

                    @Key
                    private Long height;

                    @Key
                    private String type;

                    @Key
                    private String url;

                    @Key
                    private Long width;

                    public Long getHeight() {
                        return this.height;
                    }

                    public Image setHeight(Long l) {
                        this.height = l;
                        return this;
                    }

                    public String getType() {
                        return this.type;
                    }

                    public Image setType(String str) {
                        this.type = str;
                        return this;
                    }

                    public String getUrl() {
                        return this.url;
                    }

                    public Image setUrl(String str) {
                        this.url = str;
                        return this;
                    }

                    public Long getWidth() {
                        return this.width;
                    }

                    public Image setWidth(Long l) {
                        this.width = l;
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
            }
        }

        /* loaded from: classes.dex */
        public static final class Plusoners extends GenericJson {

            @Key
            private String selfLink;

            @Key
            private Long totalItems;

            public String getSelfLink() {
                return this.selfLink;
            }

            public Plusoners setSelfLink(String str) {
                this.selfLink = str;
                return this;
            }

            public Long getTotalItems() {
                return this.totalItems;
            }

            public Plusoners setTotalItems(Long l) {
                this.totalItems = l;
                return this;
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
            public Plusoners set(String str, Object obj) {
                return (Plusoners) super.set(str, obj);
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
            public Plusoners clone() {
                return (Plusoners) super.clone();
            }
        }

        /* loaded from: classes.dex */
        public static final class Replies extends GenericJson {

            @Key
            private String selfLink;

            @Key
            private Long totalItems;

            public String getSelfLink() {
                return this.selfLink;
            }

            public Replies setSelfLink(String str) {
                this.selfLink = str;
                return this;
            }

            public Long getTotalItems() {
                return this.totalItems;
            }

            public Replies setTotalItems(Long l) {
                this.totalItems = l;
                return this;
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
            public Replies set(String str, Object obj) {
                return (Replies) super.set(str, obj);
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
            public Replies clone() {
                return (Replies) super.clone();
            }
        }

        /* loaded from: classes.dex */
        public static final class Resharers extends GenericJson {

            @Key
            private String selfLink;

            @Key
            private Long totalItems;

            public String getSelfLink() {
                return this.selfLink;
            }

            public Resharers setSelfLink(String str) {
                this.selfLink = str;
                return this;
            }

            public Long getTotalItems() {
                return this.totalItems;
            }

            public Resharers setTotalItems(Long l) {
                this.totalItems = l;
                return this;
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
            public Resharers set(String str, Object obj) {
                return (Resharers) super.set(str, obj);
            }

            @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
            public Resharers clone() {
                return (Resharers) super.clone();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Provider extends GenericJson {

        @Key
        private String title;

        public String getTitle() {
            return this.title;
        }

        public Provider setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Provider set(String str, Object obj) {
            return (Provider) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Provider clone() {
            return (Provider) super.clone();
        }
    }
}
