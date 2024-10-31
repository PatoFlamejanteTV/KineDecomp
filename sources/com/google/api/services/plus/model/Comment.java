package com.google.api.services.plus.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes.dex */
public final class Comment extends GenericJson {

    @Key
    private Actor actor;

    @Key
    private String etag;

    @Key
    private String id;

    @Key
    private List<InReplyTo> inReplyTo;

    @Key
    private String kind;

    @Key(a = "object")
    private PlusObject object__;

    @Key
    private Plusoners plusoners;

    @Key
    private DateTime published;

    @Key
    private String selfLink;

    @Key
    private DateTime updated;

    @Key
    private String verb;

    static {
        Data.a((Class<?>) InReplyTo.class);
    }

    public Actor getActor() {
        return this.actor;
    }

    public Comment setActor(Actor actor) {
        this.actor = actor;
        return this;
    }

    public String getEtag() {
        return this.etag;
    }

    public Comment setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Comment setId(String str) {
        this.id = str;
        return this;
    }

    public List<InReplyTo> getInReplyTo() {
        return this.inReplyTo;
    }

    public Comment setInReplyTo(List<InReplyTo> list) {
        this.inReplyTo = list;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public Comment setKind(String str) {
        this.kind = str;
        return this;
    }

    public PlusObject getObject() {
        return this.object__;
    }

    public Comment setObject(PlusObject plusObject) {
        this.object__ = plusObject;
        return this;
    }

    public Plusoners getPlusoners() {
        return this.plusoners;
    }

    public Comment setPlusoners(Plusoners plusoners) {
        this.plusoners = plusoners;
        return this;
    }

    public DateTime getPublished() {
        return this.published;
    }

    public Comment setPublished(DateTime dateTime) {
        this.published = dateTime;
        return this;
    }

    public String getSelfLink() {
        return this.selfLink;
    }

    public Comment setSelfLink(String str) {
        this.selfLink = str;
        return this;
    }

    public DateTime getUpdated() {
        return this.updated;
    }

    public Comment setUpdated(DateTime dateTime) {
        this.updated = dateTime;
        return this;
    }

    public String getVerb() {
        return this.verb;
    }

    public Comment setVerb(String str) {
        this.verb = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Comment set(String str, Object obj) {
        return (Comment) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Comment clone() {
        return (Comment) super.clone();
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
    public static final class InReplyTo extends GenericJson {

        @Key
        private String id;

        @Key
        private String url;

        public String getId() {
            return this.id;
        }

        public InReplyTo setId(String str) {
            this.id = str;
            return this;
        }

        public String getUrl() {
            return this.url;
        }

        public InReplyTo setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public InReplyTo set(String str, Object obj) {
            return (InReplyTo) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public InReplyTo clone() {
            return (InReplyTo) super.clone();
        }
    }

    /* loaded from: classes.dex */
    public static final class PlusObject extends GenericJson {

        @Key
        private String content;

        @Key
        private String objectType;

        @Key
        private String originalContent;

        public String getContent() {
            return this.content;
        }

        public PlusObject setContent(String str) {
            this.content = str;
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

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public PlusObject set(String str, Object obj) {
            return (PlusObject) super.set(str, obj);
        }

        @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public PlusObject clone() {
            return (PlusObject) super.clone();
        }
    }

    /* loaded from: classes.dex */
    public static final class Plusoners extends GenericJson {

        @Key
        private Long totalItems;

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
}
