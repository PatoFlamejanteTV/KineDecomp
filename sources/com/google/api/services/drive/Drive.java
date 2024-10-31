package com.google.api.services.drive;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.drive.model.App;
import com.google.api.services.drive.model.AppList;
import com.google.api.services.drive.model.Change;
import com.google.api.services.drive.model.ChangeList;
import com.google.api.services.drive.model.Channel;
import com.google.api.services.drive.model.ChildList;
import com.google.api.services.drive.model.ChildReference;
import com.google.api.services.drive.model.Comment;
import com.google.api.services.drive.model.CommentList;
import com.google.api.services.drive.model.CommentReply;
import com.google.api.services.drive.model.CommentReplyList;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.drive.model.GeneratedIds;
import com.google.api.services.drive.model.ParentList;
import com.google.api.services.drive.model.ParentReference;
import com.google.api.services.drive.model.Permission;
import com.google.api.services.drive.model.PermissionId;
import com.google.api.services.drive.model.PermissionList;
import com.google.api.services.drive.model.Property;
import com.google.api.services.drive.model.PropertyList;
import com.google.api.services.drive.model.Revision;
import com.google.api.services.drive.model.RevisionList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class Drive extends AbstractGoogleJsonClient {
    public static final String DEFAULT_BASE_URL = "https://www.googleapis.com/drive/v2/";
    public static final String DEFAULT_ROOT_URL = "https://www.googleapis.com/";
    public static final String DEFAULT_SERVICE_PATH = "drive/v2/";

    static {
        Preconditions.b(GoogleUtils.f2424a.intValue() == 1 && GoogleUtils.b.intValue() >= 15, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.20.0 of the Drive API library.", GoogleUtils.d);
    }

    public Drive(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
        this(new Builder(httpTransport, jsonFactory, httpRequestInitializer));
    }

    Drive(Builder builder) {
        super(builder);
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClient
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        super.initialize(abstractGoogleClientRequest);
    }

    public About about() {
        return new About();
    }

    /* loaded from: classes.dex */
    public class About {
        public About() {
        }

        public Get get() throws IOException {
            Get get = new Get();
            Drive.this.initialize(get);
            return get;
        }

        /* loaded from: classes.dex */
        public class Get extends DriveRequest<com.google.api.services.drive.model.About> {
            private static final String REST_PATH = "about";

            @Key
            private Boolean includeSubscribed;

            @Key
            private Long maxChangeIdCount;

            @Key
            private Long startChangeId;

            protected Get() {
                super(Drive.this, "GET", REST_PATH, null, com.google.api.services.drive.model.About.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<com.google.api.services.drive.model.About> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<com.google.api.services.drive.model.About> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<com.google.api.services.drive.model.About> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<com.google.api.services.drive.model.About> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<com.google.api.services.drive.model.About> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<com.google.api.services.drive.model.About> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<com.google.api.services.drive.model.About> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public Boolean getIncludeSubscribed() {
                return this.includeSubscribed;
            }

            public Get setIncludeSubscribed(Boolean bool) {
                this.includeSubscribed = bool;
                return this;
            }

            public boolean isIncludeSubscribed() {
                if (this.includeSubscribed == null || this.includeSubscribed == Data.f2533a) {
                    return true;
                }
                return this.includeSubscribed.booleanValue();
            }

            public Long getMaxChangeIdCount() {
                return this.maxChangeIdCount;
            }

            public Get setMaxChangeIdCount(Long l) {
                this.maxChangeIdCount = l;
                return this;
            }

            public Long getStartChangeId() {
                return this.startChangeId;
            }

            public Get setStartChangeId(Long l) {
                this.startChangeId = l;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }
    }

    public Apps apps() {
        return new Apps();
    }

    /* loaded from: classes.dex */
    public class Apps {
        public Apps() {
        }

        public Get get(String str) throws IOException {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        /* loaded from: classes.dex */
        public class Get extends DriveRequest<App> {
            private static final String REST_PATH = "apps/{appId}";

            @Key
            private String appId;

            protected Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, App.class);
                this.appId = (String) Preconditions.a(str, "Required parameter appId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<App> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<App> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<App> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<App> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<App> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<App> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<App> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getAppId() {
                return this.appId;
            }

            public Get setAppId(String str) {
                this.appId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public List list() throws IOException {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }

        /* loaded from: classes.dex */
        public class List extends DriveRequest<AppList> {
            private static final String REST_PATH = "apps";

            @Key
            private String appFilterExtensions;

            @Key
            private String appFilterMimeTypes;

            @Key
            private String languageCode;

            protected List() {
                super(Drive.this, "GET", REST_PATH, null, AppList.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<AppList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<AppList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<AppList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<AppList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<AppList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<AppList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<AppList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public String getLanguageCode() {
                return this.languageCode;
            }

            public List setLanguageCode(String str) {
                this.languageCode = str;
                return this;
            }

            public String getAppFilterExtensions() {
                return this.appFilterExtensions;
            }

            public List setAppFilterExtensions(String str) {
                this.appFilterExtensions = str;
                return this;
            }

            public String getAppFilterMimeTypes() {
                return this.appFilterMimeTypes;
            }

            public List setAppFilterMimeTypes(String str) {
                this.appFilterMimeTypes = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }
    }

    public Changes changes() {
        return new Changes();
    }

    /* loaded from: classes.dex */
    public class Changes {
        public Changes() {
        }

        public Get get(String str) throws IOException {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        /* loaded from: classes.dex */
        public class Get extends DriveRequest<Change> {
            private static final String REST_PATH = "changes/{changeId}";

            @Key
            private String changeId;

            protected Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, Change.class);
                this.changeId = (String) Preconditions.a(str, "Required parameter changeId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Change> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Change> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Change> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Change> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Change> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Change> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Change> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getChangeId() {
                return this.changeId;
            }

            public Get setChangeId(String str) {
                this.changeId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public List list() throws IOException {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }

        /* loaded from: classes.dex */
        public class List extends DriveRequest<ChangeList> {
            private static final String REST_PATH = "changes";

            @Key
            private Boolean includeDeleted;

            @Key
            private Boolean includeSubscribed;

            @Key
            private Integer maxResults;

            @Key
            private String pageToken;

            @Key
            private String spaces;

            @Key
            private Long startChangeId;

            protected List() {
                super(Drive.this, "GET", REST_PATH, null, ChangeList.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<ChangeList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<ChangeList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<ChangeList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<ChangeList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<ChangeList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<ChangeList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<ChangeList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public Boolean getIncludeSubscribed() {
                return this.includeSubscribed;
            }

            public List setIncludeSubscribed(Boolean bool) {
                this.includeSubscribed = bool;
                return this;
            }

            public boolean isIncludeSubscribed() {
                if (this.includeSubscribed == null || this.includeSubscribed == Data.f2533a) {
                    return true;
                }
                return this.includeSubscribed.booleanValue();
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public List setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public boolean isIncludeDeleted() {
                if (this.includeDeleted == null || this.includeDeleted == Data.f2533a) {
                    return true;
                }
                return this.includeDeleted.booleanValue();
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public List setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public String getSpaces() {
                return this.spaces;
            }

            public List setSpaces(String str) {
                this.spaces = str;
                return this;
            }

            public Long getStartChangeId() {
                return this.startChangeId;
            }

            public List setStartChangeId(Long l) {
                this.startChangeId = l;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Watch watch(Channel channel) throws IOException {
            Watch watch = new Watch(channel);
            Drive.this.initialize(watch);
            return watch;
        }

        /* loaded from: classes.dex */
        public class Watch extends DriveRequest<Channel> {
            private static final String REST_PATH = "changes/watch";

            @Key
            private Boolean includeDeleted;

            @Key
            private Boolean includeSubscribed;

            @Key
            private Integer maxResults;

            @Key
            private String pageToken;

            @Key
            private String spaces;

            @Key
            private Long startChangeId;

            protected Watch(Channel channel) {
                super(Drive.this, "POST", REST_PATH, channel, Channel.class);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Channel> setAlt2(String str) {
                return (Watch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Channel> setFields2(String str) {
                return (Watch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Channel> setKey2(String str) {
                return (Watch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Channel> setOauthToken2(String str) {
                return (Watch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Channel> setPrettyPrint2(Boolean bool) {
                return (Watch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Channel> setQuotaUser2(String str) {
                return (Watch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Channel> setUserIp2(String str) {
                return (Watch) super.setUserIp2(str);
            }

            public Boolean getIncludeSubscribed() {
                return this.includeSubscribed;
            }

            public Watch setIncludeSubscribed(Boolean bool) {
                this.includeSubscribed = bool;
                return this;
            }

            public boolean isIncludeSubscribed() {
                if (this.includeSubscribed == null || this.includeSubscribed == Data.f2533a) {
                    return true;
                }
                return this.includeSubscribed.booleanValue();
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Watch setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public boolean isIncludeDeleted() {
                if (this.includeDeleted == null || this.includeDeleted == Data.f2533a) {
                    return true;
                }
                return this.includeDeleted.booleanValue();
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public Watch setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public Watch setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public String getSpaces() {
                return this.spaces;
            }

            public Watch setSpaces(String str) {
                this.spaces = str;
                return this;
            }

            public Long getStartChangeId() {
                return this.startChangeId;
            }

            public Watch setStartChangeId(Long l) {
                this.startChangeId = l;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Watch set(String str, Object obj) {
                return (Watch) super.set(str, obj);
            }
        }
    }

    public Channels channels() {
        return new Channels();
    }

    /* loaded from: classes.dex */
    public class Channels {
        public Channels() {
        }

        public Stop stop(Channel channel) throws IOException {
            Stop stop = new Stop(channel);
            Drive.this.initialize(stop);
            return stop;
        }

        /* loaded from: classes.dex */
        public class Stop extends DriveRequest<Void> {
            private static final String REST_PATH = "channels/stop";

            protected Stop(Channel channel) {
                super(Drive.this, "POST", REST_PATH, channel, Void.class);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Stop) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Stop) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Stop) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Stop) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Stop) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Stop) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Stop) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Stop set(String str, Object obj) {
                return (Stop) super.set(str, obj);
            }
        }
    }

    public Children children() {
        return new Children();
    }

    /* loaded from: classes.dex */
    public class Children {
        public Children() {
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        /* loaded from: classes.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{folderId}/children/{childId}";

            @Key
            private String childId;

            @Key
            private String folderId;

            protected Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.folderId = (String) Preconditions.a(str, "Required parameter folderId must be specified.");
                this.childId = (String) Preconditions.a(str2, "Required parameter childId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            public String getFolderId() {
                return this.folderId;
            }

            public Delete setFolderId(String str) {
                this.folderId = str;
                return this;
            }

            public String getChildId() {
                return this.childId;
            }

            public Delete setChildId(String str) {
                this.childId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        /* loaded from: classes.dex */
        public class Get extends DriveRequest<ChildReference> {
            private static final String REST_PATH = "files/{folderId}/children/{childId}";

            @Key
            private String childId;

            @Key
            private String folderId;

            protected Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, ChildReference.class);
                this.folderId = (String) Preconditions.a(str, "Required parameter folderId must be specified.");
                this.childId = (String) Preconditions.a(str2, "Required parameter childId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<ChildReference> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<ChildReference> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<ChildReference> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<ChildReference> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<ChildReference> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<ChildReference> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<ChildReference> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getFolderId() {
                return this.folderId;
            }

            public Get setFolderId(String str) {
                this.folderId = str;
                return this;
            }

            public String getChildId() {
                return this.childId;
            }

            public Get setChildId(String str) {
                this.childId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public Insert insert(String str, ChildReference childReference) throws IOException {
            Insert insert = new Insert(str, childReference);
            Drive.this.initialize(insert);
            return insert;
        }

        /* loaded from: classes.dex */
        public class Insert extends DriveRequest<ChildReference> {
            private static final String REST_PATH = "files/{folderId}/children";

            @Key
            private String folderId;

            protected Insert(String str, ChildReference childReference) {
                super(Drive.this, "POST", REST_PATH, childReference, ChildReference.class);
                this.folderId = (String) Preconditions.a(str, "Required parameter folderId must be specified.");
                checkRequiredParameter(childReference, "content");
                checkRequiredParameter(childReference.getId(), "ChildReference.getId()");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<ChildReference> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<ChildReference> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<ChildReference> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<ChildReference> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<ChildReference> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<ChildReference> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<ChildReference> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            public String getFolderId() {
                return this.folderId;
            }

            public Insert setFolderId(String str) {
                this.folderId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        /* loaded from: classes.dex */
        public class List extends DriveRequest<ChildList> {
            private static final String REST_PATH = "files/{folderId}/children";

            @Key
            private String folderId;

            @Key
            private Integer maxResults;

            @Key
            private String orderBy;

            @Key
            private String pageToken;

            @Key
            private String q;

            protected List(String str) {
                super(Drive.this, "GET", REST_PATH, null, ChildList.class);
                this.folderId = (String) Preconditions.a(str, "Required parameter folderId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<ChildList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<ChildList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<ChildList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<ChildList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<ChildList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<ChildList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<ChildList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public String getFolderId() {
                return this.folderId;
            }

            public List setFolderId(String str) {
                this.folderId = str;
                return this;
            }

            public String getOrderBy() {
                return this.orderBy;
            }

            public List setOrderBy(String str) {
                this.orderBy = str;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public String getQ() {
                return this.q;
            }

            public List setQ(String str) {
                this.q = str;
                return this;
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public List setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }
    }

    public Comments comments() {
        return new Comments();
    }

    /* loaded from: classes.dex */
    public class Comments {
        public Comments() {
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        /* loaded from: classes.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            protected Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.a(str2, "Required parameter commentId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Delete setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        /* loaded from: classes.dex */
        public class Get extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private Boolean includeDeleted;

            protected Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Comment.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.a(str2, "Required parameter commentId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Comment> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Get setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Get setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public boolean isIncludeDeleted() {
                if (this.includeDeleted == null || this.includeDeleted == Data.f2533a) {
                    return false;
                }
                return this.includeDeleted.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public Insert insert(String str, Comment comment) throws IOException {
            Insert insert = new Insert(str, comment);
            Drive.this.initialize(insert);
            return insert;
        }

        /* loaded from: classes.dex */
        public class Insert extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments";

            @Key
            private String fileId;

            protected Insert(String str, Comment comment) {
                super(Drive.this, "POST", REST_PATH, comment, Comment.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                checkRequiredParameter(comment, "content");
                checkRequiredParameter(comment.getContent(), "Comment.getContent()");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Comment> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Insert setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        /* loaded from: classes.dex */
        public class List extends DriveRequest<CommentList> {
            private static final String REST_PATH = "files/{fileId}/comments";

            @Key
            private String fileId;

            @Key
            private Boolean includeDeleted;

            @Key
            private Integer maxResults;

            @Key
            private String pageToken;

            @Key
            private String updatedMin;

            protected List(String str) {
                super(Drive.this, "GET", REST_PATH, null, CommentList.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<CommentList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<CommentList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<CommentList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<CommentList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<CommentList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<CommentList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<CommentList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public String getUpdatedMin() {
                return this.updatedMin;
            }

            public List setUpdatedMin(String str) {
                this.updatedMin = str;
                return this;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public List setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public boolean isIncludeDeleted() {
                if (this.includeDeleted == null || this.includeDeleted == Data.f2533a) {
                    return false;
                }
                return this.includeDeleted.booleanValue();
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public List setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Patch patch(String str, String str2, Comment comment) throws IOException {
            Patch patch = new Patch(str, str2, comment);
            Drive.this.initialize(patch);
            return patch;
        }

        /* loaded from: classes.dex */
        public class Patch extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            protected Patch(String str, String str2, Comment comment) {
                super(Drive.this, "PATCH", REST_PATH, comment, Comment.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.a(str2, "Required parameter commentId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Patch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Patch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Patch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Patch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Patch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Patch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Comment> setUserIp2(String str) {
                return (Patch) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Patch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Patch setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Patch set(String str, Object obj) {
                return (Patch) super.set(str, obj);
            }
        }

        public Update update(String str, String str2, Comment comment) throws IOException {
            Update update = new Update(str, str2, comment);
            Drive.this.initialize(update);
            return update;
        }

        /* loaded from: classes.dex */
        public class Update extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            protected Update(String str, String str2, Comment comment) {
                super(Drive.this, "PUT", REST_PATH, comment, Comment.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.a(str2, "Required parameter commentId must be specified.");
                checkRequiredParameter(comment, "content");
                checkRequiredParameter(comment.getContent(), "Comment.getContent()");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Comment> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Comment> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Comment> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Comment> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Comment> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Update setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }
    }

    public Files files() {
        return new Files();
    }

    /* loaded from: classes.dex */
    public class Files {
        public Files() {
        }

        public Copy copy(String str, File file) throws IOException {
            Copy copy = new Copy(str, file);
            Drive.this.initialize(copy);
            return copy;
        }

        /* loaded from: classes.dex */
        public class Copy extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}/copy";

            @Key
            private Boolean convert;

            @Key
            private String fileId;

            @Key
            private Boolean ocr;

            @Key
            private String ocrLanguage;

            @Key
            private Boolean pinned;

            @Key
            private String timedTextLanguage;

            @Key
            private String timedTextTrackName;

            @Key
            private String visibility;

            protected Copy(String str, File file) {
                super(Drive.this, "POST", REST_PATH, file, File.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Copy) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Copy) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Copy) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Copy) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Copy) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Copy) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Copy) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Copy setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Boolean getConvert() {
                return this.convert;
            }

            public Copy setConvert(Boolean bool) {
                this.convert = bool;
                return this;
            }

            public boolean isConvert() {
                if (this.convert == null || this.convert == Data.f2533a) {
                    return false;
                }
                return this.convert.booleanValue();
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public Copy setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public String getVisibility() {
                return this.visibility;
            }

            public Copy setVisibility(String str) {
                this.visibility = str;
                return this;
            }

            public Boolean getPinned() {
                return this.pinned;
            }

            public Copy setPinned(Boolean bool) {
                this.pinned = bool;
                return this;
            }

            public boolean isPinned() {
                if (this.pinned == null || this.pinned == Data.f2533a) {
                    return false;
                }
                return this.pinned.booleanValue();
            }

            public Boolean getOcr() {
                return this.ocr;
            }

            public Copy setOcr(Boolean bool) {
                this.ocr = bool;
                return this;
            }

            public boolean isOcr() {
                if (this.ocr == null || this.ocr == Data.f2533a) {
                    return false;
                }
                return this.ocr.booleanValue();
            }

            public String getTimedTextTrackName() {
                return this.timedTextTrackName;
            }

            public Copy setTimedTextTrackName(String str) {
                this.timedTextTrackName = str;
                return this;
            }

            public String getTimedTextLanguage() {
                return this.timedTextLanguage;
            }

            public Copy setTimedTextLanguage(String str) {
                this.timedTextLanguage = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Copy set(String str, Object obj) {
                return (Copy) super.set(str, obj);
            }
        }

        public Delete delete(String str) throws IOException {
            Delete delete = new Delete(str);
            Drive.this.initialize(delete);
            return delete;
        }

        /* loaded from: classes.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}";

            @Key
            private String fileId;

            protected Delete(String str) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public EmptyTrash emptyTrash() throws IOException {
            EmptyTrash emptyTrash = new EmptyTrash();
            Drive.this.initialize(emptyTrash);
            return emptyTrash;
        }

        /* loaded from: classes.dex */
        public class EmptyTrash extends DriveRequest<Void> {
            private static final String REST_PATH = "files/trash";

            protected EmptyTrash() {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (EmptyTrash) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (EmptyTrash) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (EmptyTrash) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (EmptyTrash) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (EmptyTrash) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (EmptyTrash) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (EmptyTrash) super.setUserIp2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public EmptyTrash set(String str, Object obj) {
                return (EmptyTrash) super.set(str, obj);
            }
        }

        public GenerateIds generateIds() throws IOException {
            GenerateIds generateIds = new GenerateIds();
            Drive.this.initialize(generateIds);
            return generateIds;
        }

        /* loaded from: classes.dex */
        public class GenerateIds extends DriveRequest<GeneratedIds> {
            private static final String REST_PATH = "files/generateIds";

            @Key
            private Integer maxResults;

            @Key
            private String space;

            protected GenerateIds() {
                super(Drive.this, "GET", REST_PATH, null, GeneratedIds.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<GeneratedIds> setAlt2(String str) {
                return (GenerateIds) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<GeneratedIds> setFields2(String str) {
                return (GenerateIds) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<GeneratedIds> setKey2(String str) {
                return (GenerateIds) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<GeneratedIds> setOauthToken2(String str) {
                return (GenerateIds) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<GeneratedIds> setPrettyPrint2(Boolean bool) {
                return (GenerateIds) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<GeneratedIds> setQuotaUser2(String str) {
                return (GenerateIds) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<GeneratedIds> setUserIp2(String str) {
                return (GenerateIds) super.setUserIp2(str);
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public GenerateIds setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public String getSpace() {
                return this.space;
            }

            public GenerateIds setSpace(String str) {
                this.space = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public GenerateIds set(String str, Object obj) {
                return (GenerateIds) super.set(str, obj);
            }
        }

        public Get get(String str) throws IOException {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        /* loaded from: classes.dex */
        public class Get extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}";

            @Key
            private Boolean acknowledgeAbuse;

            @Key
            private String fileId;

            @Key
            private String projection;

            @Key
            private String revisionId;

            @Key
            private Boolean updateViewedDate;

            protected Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, File.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                initializeMediaDownload();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public InputStream executeMediaAsInputStream() throws IOException {
                return super.executeMediaAsInputStream();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeMedia() throws IOException {
                return super.executeMedia();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Boolean getAcknowledgeAbuse() {
                return this.acknowledgeAbuse;
            }

            public Get setAcknowledgeAbuse(Boolean bool) {
                this.acknowledgeAbuse = bool;
                return this;
            }

            public boolean isAcknowledgeAbuse() {
                if (this.acknowledgeAbuse == null || this.acknowledgeAbuse == Data.f2533a) {
                    return false;
                }
                return this.acknowledgeAbuse.booleanValue();
            }

            public Boolean getUpdateViewedDate() {
                return this.updateViewedDate;
            }

            public Get setUpdateViewedDate(Boolean bool) {
                this.updateViewedDate = bool;
                return this;
            }

            public boolean isUpdateViewedDate() {
                if (this.updateViewedDate == null || this.updateViewedDate == Data.f2533a) {
                    return false;
                }
                return this.updateViewedDate.booleanValue();
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Get setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            public String getProjection() {
                return this.projection;
            }

            public Get setProjection(String str) {
                this.projection = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public Insert insert(File file) throws IOException {
            Insert insert = new Insert(file);
            Drive.this.initialize(insert);
            return insert;
        }

        public Insert insert(File file, AbstractInputStreamContent abstractInputStreamContent) throws IOException {
            Insert insert = new Insert(file, abstractInputStreamContent);
            Drive.this.initialize(insert);
            return insert;
        }

        /* loaded from: classes.dex */
        public class Insert extends DriveRequest<File> {
            private static final String REST_PATH = "files";

            @Key
            private Boolean convert;

            @Key
            private Boolean ocr;

            @Key
            private String ocrLanguage;

            @Key
            private Boolean pinned;

            @Key
            private String timedTextLanguage;

            @Key
            private String timedTextTrackName;

            @Key
            private Boolean useContentAsIndexableText;

            @Key
            private String visibility;

            protected Insert(File file) {
                super(Drive.this, "POST", REST_PATH, file, File.class);
            }

            protected Insert(File file, AbstractInputStreamContent abstractInputStreamContent) {
                super(Drive.this, "POST", "/upload/" + Drive.this.getServicePath() + REST_PATH, file, File.class);
                initializeMediaUpload(abstractInputStreamContent);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            public Boolean getConvert() {
                return this.convert;
            }

            public Insert setConvert(Boolean bool) {
                this.convert = bool;
                return this;
            }

            public boolean isConvert() {
                if (this.convert == null || this.convert == Data.f2533a) {
                    return false;
                }
                return this.convert.booleanValue();
            }

            public Boolean getUseContentAsIndexableText() {
                return this.useContentAsIndexableText;
            }

            public Insert setUseContentAsIndexableText(Boolean bool) {
                this.useContentAsIndexableText = bool;
                return this;
            }

            public boolean isUseContentAsIndexableText() {
                if (this.useContentAsIndexableText == null || this.useContentAsIndexableText == Data.f2533a) {
                    return false;
                }
                return this.useContentAsIndexableText.booleanValue();
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public Insert setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public String getVisibility() {
                return this.visibility;
            }

            public Insert setVisibility(String str) {
                this.visibility = str;
                return this;
            }

            public Boolean getPinned() {
                return this.pinned;
            }

            public Insert setPinned(Boolean bool) {
                this.pinned = bool;
                return this;
            }

            public boolean isPinned() {
                if (this.pinned == null || this.pinned == Data.f2533a) {
                    return false;
                }
                return this.pinned.booleanValue();
            }

            public Boolean getOcr() {
                return this.ocr;
            }

            public Insert setOcr(Boolean bool) {
                this.ocr = bool;
                return this;
            }

            public boolean isOcr() {
                if (this.ocr == null || this.ocr == Data.f2533a) {
                    return false;
                }
                return this.ocr.booleanValue();
            }

            public String getTimedTextTrackName() {
                return this.timedTextTrackName;
            }

            public Insert setTimedTextTrackName(String str) {
                this.timedTextTrackName = str;
                return this;
            }

            public String getTimedTextLanguage() {
                return this.timedTextLanguage;
            }

            public Insert setTimedTextLanguage(String str) {
                this.timedTextLanguage = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        public List list() throws IOException {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }

        /* loaded from: classes.dex */
        public class List extends DriveRequest<FileList> {
            private static final String REST_PATH = "files";

            @Key
            private String corpus;

            @Key
            private Integer maxResults;

            @Key
            private String orderBy;

            @Key
            private String pageToken;

            @Key
            private String projection;

            @Key
            private String q;

            @Key
            private String spaces;

            protected List() {
                super(Drive.this, "GET", REST_PATH, null, FileList.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<FileList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<FileList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<FileList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<FileList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<FileList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<FileList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<FileList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public String getOrderBy() {
                return this.orderBy;
            }

            public List setOrderBy(String str) {
                this.orderBy = str;
                return this;
            }

            public String getProjection() {
                return this.projection;
            }

            public List setProjection(String str) {
                this.projection = str;
                return this;
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public List setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            public String getQ() {
                return this.q;
            }

            public List setQ(String str) {
                this.q = str;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public String getSpaces() {
                return this.spaces;
            }

            public List setSpaces(String str) {
                this.spaces = str;
                return this;
            }

            public String getCorpus() {
                return this.corpus;
            }

            public List setCorpus(String str) {
                this.corpus = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Patch patch(String str, File file) throws IOException {
            Patch patch = new Patch(str, file);
            Drive.this.initialize(patch);
            return patch;
        }

        /* loaded from: classes.dex */
        public class Patch extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}";

            @Key
            private String addParents;

            @Key
            private Boolean convert;

            @Key
            private String fileId;

            @Key
            private String modifiedDateBehavior;

            @Key
            private Boolean newRevision;

            @Key
            private Boolean ocr;

            @Key
            private String ocrLanguage;

            @Key
            private Boolean pinned;

            @Key
            private String removeParents;

            @Key
            private Boolean setModifiedDate;

            @Key
            private String timedTextLanguage;

            @Key
            private String timedTextTrackName;

            @Key
            private Boolean updateViewedDate;

            @Key
            private Boolean useContentAsIndexableText;

            protected Patch(String str, File file) {
                super(Drive.this, "PATCH", REST_PATH, file, File.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Patch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Patch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Patch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Patch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Patch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Patch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Patch) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Patch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getAddParents() {
                return this.addParents;
            }

            public Patch setAddParents(String str) {
                this.addParents = str;
                return this;
            }

            public String getModifiedDateBehavior() {
                return this.modifiedDateBehavior;
            }

            public Patch setModifiedDateBehavior(String str) {
                this.modifiedDateBehavior = str;
                return this;
            }

            public String getRemoveParents() {
                return this.removeParents;
            }

            public Patch setRemoveParents(String str) {
                this.removeParents = str;
                return this;
            }

            public Boolean getUpdateViewedDate() {
                return this.updateViewedDate;
            }

            public Patch setUpdateViewedDate(Boolean bool) {
                this.updateViewedDate = bool;
                return this;
            }

            public boolean isUpdateViewedDate() {
                if (this.updateViewedDate == null || this.updateViewedDate == Data.f2533a) {
                    return true;
                }
                return this.updateViewedDate.booleanValue();
            }

            public Boolean getSetModifiedDate() {
                return this.setModifiedDate;
            }

            public Patch setSetModifiedDate(Boolean bool) {
                this.setModifiedDate = bool;
                return this;
            }

            public boolean isSetModifiedDate() {
                if (this.setModifiedDate == null || this.setModifiedDate == Data.f2533a) {
                    return false;
                }
                return this.setModifiedDate.booleanValue();
            }

            public Boolean getUseContentAsIndexableText() {
                return this.useContentAsIndexableText;
            }

            public Patch setUseContentAsIndexableText(Boolean bool) {
                this.useContentAsIndexableText = bool;
                return this;
            }

            public boolean isUseContentAsIndexableText() {
                if (this.useContentAsIndexableText == null || this.useContentAsIndexableText == Data.f2533a) {
                    return false;
                }
                return this.useContentAsIndexableText.booleanValue();
            }

            public Boolean getConvert() {
                return this.convert;
            }

            public Patch setConvert(Boolean bool) {
                this.convert = bool;
                return this;
            }

            public boolean isConvert() {
                if (this.convert == null || this.convert == Data.f2533a) {
                    return false;
                }
                return this.convert.booleanValue();
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public Patch setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public Boolean getPinned() {
                return this.pinned;
            }

            public Patch setPinned(Boolean bool) {
                this.pinned = bool;
                return this;
            }

            public boolean isPinned() {
                if (this.pinned == null || this.pinned == Data.f2533a) {
                    return false;
                }
                return this.pinned.booleanValue();
            }

            public Boolean getNewRevision() {
                return this.newRevision;
            }

            public Patch setNewRevision(Boolean bool) {
                this.newRevision = bool;
                return this;
            }

            public boolean isNewRevision() {
                if (this.newRevision == null || this.newRevision == Data.f2533a) {
                    return true;
                }
                return this.newRevision.booleanValue();
            }

            public Boolean getOcr() {
                return this.ocr;
            }

            public Patch setOcr(Boolean bool) {
                this.ocr = bool;
                return this;
            }

            public boolean isOcr() {
                if (this.ocr == null || this.ocr == Data.f2533a) {
                    return false;
                }
                return this.ocr.booleanValue();
            }

            public String getTimedTextLanguage() {
                return this.timedTextLanguage;
            }

            public Patch setTimedTextLanguage(String str) {
                this.timedTextLanguage = str;
                return this;
            }

            public String getTimedTextTrackName() {
                return this.timedTextTrackName;
            }

            public Patch setTimedTextTrackName(String str) {
                this.timedTextTrackName = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Patch set(String str, Object obj) {
                return (Patch) super.set(str, obj);
            }
        }

        public Touch touch(String str) throws IOException {
            Touch touch = new Touch(str);
            Drive.this.initialize(touch);
            return touch;
        }

        /* loaded from: classes.dex */
        public class Touch extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}/touch";

            @Key
            private String fileId;

            protected Touch(String str) {
                super(Drive.this, "POST", REST_PATH, null, File.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Touch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Touch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Touch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Touch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Touch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Touch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Touch) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Touch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Touch set(String str, Object obj) {
                return (Touch) super.set(str, obj);
            }
        }

        public Trash trash(String str) throws IOException {
            Trash trash = new Trash(str);
            Drive.this.initialize(trash);
            return trash;
        }

        /* loaded from: classes.dex */
        public class Trash extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}/trash";

            @Key
            private String fileId;

            protected Trash(String str) {
                super(Drive.this, "POST", REST_PATH, null, File.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Trash) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Trash) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Trash) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Trash) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Trash) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Trash) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Trash) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Trash setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Trash set(String str, Object obj) {
                return (Trash) super.set(str, obj);
            }
        }

        public Untrash untrash(String str) throws IOException {
            Untrash untrash = new Untrash(str);
            Drive.this.initialize(untrash);
            return untrash;
        }

        /* loaded from: classes.dex */
        public class Untrash extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}/untrash";

            @Key
            private String fileId;

            protected Untrash(String str) {
                super(Drive.this, "POST", REST_PATH, null, File.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Untrash) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Untrash) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Untrash) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Untrash) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Untrash) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Untrash) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Untrash) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Untrash setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Untrash set(String str, Object obj) {
                return (Untrash) super.set(str, obj);
            }
        }

        public Update update(String str, File file) throws IOException {
            Update update = new Update(str, file);
            Drive.this.initialize(update);
            return update;
        }

        public Update update(String str, File file, AbstractInputStreamContent abstractInputStreamContent) throws IOException {
            Update update = new Update(str, file, abstractInputStreamContent);
            Drive.this.initialize(update);
            return update;
        }

        /* loaded from: classes.dex */
        public class Update extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}";

            @Key
            private String addParents;

            @Key
            private Boolean convert;

            @Key
            private String fileId;

            @Key
            private String modifiedDateBehavior;

            @Key
            private Boolean newRevision;

            @Key
            private Boolean ocr;

            @Key
            private String ocrLanguage;

            @Key
            private Boolean pinned;

            @Key
            private String removeParents;

            @Key
            private Boolean setModifiedDate;

            @Key
            private String timedTextLanguage;

            @Key
            private String timedTextTrackName;

            @Key
            private Boolean updateViewedDate;

            @Key
            private Boolean useContentAsIndexableText;

            protected Update(String str, File file) {
                super(Drive.this, "PUT", REST_PATH, file, File.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            protected Update(String str, File file, AbstractInputStreamContent abstractInputStreamContent) {
                super(Drive.this, "PUT", "/upload/" + Drive.this.getServicePath() + REST_PATH, file, File.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                initializeMediaUpload(abstractInputStreamContent);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<File> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<File> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<File> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<File> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<File> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getAddParents() {
                return this.addParents;
            }

            public Update setAddParents(String str) {
                this.addParents = str;
                return this;
            }

            public String getModifiedDateBehavior() {
                return this.modifiedDateBehavior;
            }

            public Update setModifiedDateBehavior(String str) {
                this.modifiedDateBehavior = str;
                return this;
            }

            public String getRemoveParents() {
                return this.removeParents;
            }

            public Update setRemoveParents(String str) {
                this.removeParents = str;
                return this;
            }

            public Boolean getUpdateViewedDate() {
                return this.updateViewedDate;
            }

            public Update setUpdateViewedDate(Boolean bool) {
                this.updateViewedDate = bool;
                return this;
            }

            public boolean isUpdateViewedDate() {
                if (this.updateViewedDate == null || this.updateViewedDate == Data.f2533a) {
                    return true;
                }
                return this.updateViewedDate.booleanValue();
            }

            public Boolean getSetModifiedDate() {
                return this.setModifiedDate;
            }

            public Update setSetModifiedDate(Boolean bool) {
                this.setModifiedDate = bool;
                return this;
            }

            public boolean isSetModifiedDate() {
                if (this.setModifiedDate == null || this.setModifiedDate == Data.f2533a) {
                    return false;
                }
                return this.setModifiedDate.booleanValue();
            }

            public Boolean getUseContentAsIndexableText() {
                return this.useContentAsIndexableText;
            }

            public Update setUseContentAsIndexableText(Boolean bool) {
                this.useContentAsIndexableText = bool;
                return this;
            }

            public boolean isUseContentAsIndexableText() {
                if (this.useContentAsIndexableText == null || this.useContentAsIndexableText == Data.f2533a) {
                    return false;
                }
                return this.useContentAsIndexableText.booleanValue();
            }

            public Boolean getConvert() {
                return this.convert;
            }

            public Update setConvert(Boolean bool) {
                this.convert = bool;
                return this;
            }

            public boolean isConvert() {
                if (this.convert == null || this.convert == Data.f2533a) {
                    return false;
                }
                return this.convert.booleanValue();
            }

            public String getOcrLanguage() {
                return this.ocrLanguage;
            }

            public Update setOcrLanguage(String str) {
                this.ocrLanguage = str;
                return this;
            }

            public Boolean getPinned() {
                return this.pinned;
            }

            public Update setPinned(Boolean bool) {
                this.pinned = bool;
                return this;
            }

            public boolean isPinned() {
                if (this.pinned == null || this.pinned == Data.f2533a) {
                    return false;
                }
                return this.pinned.booleanValue();
            }

            public Boolean getNewRevision() {
                return this.newRevision;
            }

            public Update setNewRevision(Boolean bool) {
                this.newRevision = bool;
                return this;
            }

            public boolean isNewRevision() {
                if (this.newRevision == null || this.newRevision == Data.f2533a) {
                    return true;
                }
                return this.newRevision.booleanValue();
            }

            public Boolean getOcr() {
                return this.ocr;
            }

            public Update setOcr(Boolean bool) {
                this.ocr = bool;
                return this;
            }

            public boolean isOcr() {
                if (this.ocr == null || this.ocr == Data.f2533a) {
                    return false;
                }
                return this.ocr.booleanValue();
            }

            public String getTimedTextLanguage() {
                return this.timedTextLanguage;
            }

            public Update setTimedTextLanguage(String str) {
                this.timedTextLanguage = str;
                return this;
            }

            public String getTimedTextTrackName() {
                return this.timedTextTrackName;
            }

            public Update setTimedTextTrackName(String str) {
                this.timedTextTrackName = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Watch watch(String str, Channel channel) throws IOException {
            Watch watch = new Watch(str, channel);
            Drive.this.initialize(watch);
            return watch;
        }

        /* loaded from: classes.dex */
        public class Watch extends DriveRequest<Channel> {
            private static final String REST_PATH = "files/{fileId}/watch";

            @Key
            private Boolean acknowledgeAbuse;

            @Key
            private String fileId;

            @Key
            private String projection;

            @Key
            private String revisionId;

            @Key
            private Boolean updateViewedDate;

            protected Watch(String str, Channel channel) {
                super(Drive.this, "POST", REST_PATH, channel, Channel.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                initializeMediaDownload();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public InputStream executeMediaAsInputStream() throws IOException {
                return super.executeMediaAsInputStream();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeMedia() throws IOException {
                return super.executeMedia();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Channel> setAlt2(String str) {
                return (Watch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Channel> setFields2(String str) {
                return (Watch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Channel> setKey2(String str) {
                return (Watch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Channel> setOauthToken2(String str) {
                return (Watch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Channel> setPrettyPrint2(Boolean bool) {
                return (Watch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Channel> setQuotaUser2(String str) {
                return (Watch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Channel> setUserIp2(String str) {
                return (Watch) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Watch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Boolean getAcknowledgeAbuse() {
                return this.acknowledgeAbuse;
            }

            public Watch setAcknowledgeAbuse(Boolean bool) {
                this.acknowledgeAbuse = bool;
                return this;
            }

            public boolean isAcknowledgeAbuse() {
                if (this.acknowledgeAbuse == null || this.acknowledgeAbuse == Data.f2533a) {
                    return false;
                }
                return this.acknowledgeAbuse.booleanValue();
            }

            public Boolean getUpdateViewedDate() {
                return this.updateViewedDate;
            }

            public Watch setUpdateViewedDate(Boolean bool) {
                this.updateViewedDate = bool;
                return this;
            }

            public boolean isUpdateViewedDate() {
                if (this.updateViewedDate == null || this.updateViewedDate == Data.f2533a) {
                    return false;
                }
                return this.updateViewedDate.booleanValue();
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Watch setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            public String getProjection() {
                return this.projection;
            }

            public Watch setProjection(String str) {
                this.projection = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Watch set(String str, Object obj) {
                return (Watch) super.set(str, obj);
            }
        }
    }

    public Parents parents() {
        return new Parents();
    }

    /* loaded from: classes.dex */
    public class Parents {
        public Parents() {
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        /* loaded from: classes.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/parents/{parentId}";

            @Key
            private String fileId;

            @Key
            private String parentId;

            protected Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.parentId = (String) Preconditions.a(str2, "Required parameter parentId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getParentId() {
                return this.parentId;
            }

            public Delete setParentId(String str) {
                this.parentId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        /* loaded from: classes.dex */
        public class Get extends DriveRequest<ParentReference> {
            private static final String REST_PATH = "files/{fileId}/parents/{parentId}";

            @Key
            private String fileId;

            @Key
            private String parentId;

            protected Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, ParentReference.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.parentId = (String) Preconditions.a(str2, "Required parameter parentId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<ParentReference> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<ParentReference> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<ParentReference> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<ParentReference> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<ParentReference> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<ParentReference> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<ParentReference> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getParentId() {
                return this.parentId;
            }

            public Get setParentId(String str) {
                this.parentId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public Insert insert(String str, ParentReference parentReference) throws IOException {
            Insert insert = new Insert(str, parentReference);
            Drive.this.initialize(insert);
            return insert;
        }

        /* loaded from: classes.dex */
        public class Insert extends DriveRequest<ParentReference> {
            private static final String REST_PATH = "files/{fileId}/parents";

            @Key
            private String fileId;

            protected Insert(String str, ParentReference parentReference) {
                super(Drive.this, "POST", REST_PATH, parentReference, ParentReference.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                checkRequiredParameter(parentReference, "content");
                checkRequiredParameter(parentReference.getId(), "ParentReference.getId()");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<ParentReference> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<ParentReference> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<ParentReference> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<ParentReference> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<ParentReference> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<ParentReference> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<ParentReference> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Insert setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        /* loaded from: classes.dex */
        public class List extends DriveRequest<ParentList> {
            private static final String REST_PATH = "files/{fileId}/parents";

            @Key
            private String fileId;

            protected List(String str) {
                super(Drive.this, "GET", REST_PATH, null, ParentList.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<ParentList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<ParentList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<ParentList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<ParentList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<ParentList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<ParentList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<ParentList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }
    }

    public Permissions permissions() {
        return new Permissions();
    }

    /* loaded from: classes.dex */
    public class Permissions {
        public Permissions() {
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        /* loaded from: classes.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";

            @Key
            private String fileId;

            @Key
            private String permissionId;

            protected Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) Preconditions.a(str2, "Required parameter permissionId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Delete setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        /* loaded from: classes.dex */
        public class Get extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";

            @Key
            private String fileId;

            @Key
            private String permissionId;

            protected Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Permission.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) Preconditions.a(str2, "Required parameter permissionId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Permission> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Get setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public GetIdForEmail getIdForEmail(String str) throws IOException {
            GetIdForEmail getIdForEmail = new GetIdForEmail(str);
            Drive.this.initialize(getIdForEmail);
            return getIdForEmail;
        }

        /* loaded from: classes.dex */
        public class GetIdForEmail extends DriveRequest<PermissionId> {
            private static final String REST_PATH = "permissionIds/{email}";

            @Key
            private String email;

            protected GetIdForEmail(String str) {
                super(Drive.this, "GET", REST_PATH, null, PermissionId.class);
                this.email = (String) Preconditions.a(str, "Required parameter email must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<PermissionId> setAlt2(String str) {
                return (GetIdForEmail) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<PermissionId> setFields2(String str) {
                return (GetIdForEmail) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<PermissionId> setKey2(String str) {
                return (GetIdForEmail) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<PermissionId> setOauthToken2(String str) {
                return (GetIdForEmail) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<PermissionId> setPrettyPrint2(Boolean bool) {
                return (GetIdForEmail) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<PermissionId> setQuotaUser2(String str) {
                return (GetIdForEmail) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<PermissionId> setUserIp2(String str) {
                return (GetIdForEmail) super.setUserIp2(str);
            }

            public String getEmail() {
                return this.email;
            }

            public GetIdForEmail setEmail(String str) {
                this.email = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public GetIdForEmail set(String str, Object obj) {
                return (GetIdForEmail) super.set(str, obj);
            }
        }

        public Insert insert(String str, Permission permission) throws IOException {
            Insert insert = new Insert(str, permission);
            Drive.this.initialize(insert);
            return insert;
        }

        /* loaded from: classes.dex */
        public class Insert extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions";

            @Key
            private String emailMessage;

            @Key
            private String fileId;

            @Key
            private Boolean sendNotificationEmails;

            protected Insert(String str, Permission permission) {
                super(Drive.this, "POST", REST_PATH, permission, Permission.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                checkRequiredParameter(permission, "content");
                checkRequiredParameter(permission.getRole(), "Permission.getRole()");
                checkRequiredParameter(permission, "content");
                checkRequiredParameter(permission.getType(), "Permission.getType()");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Permission> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Insert setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getEmailMessage() {
                return this.emailMessage;
            }

            public Insert setEmailMessage(String str) {
                this.emailMessage = str;
                return this;
            }

            public Boolean getSendNotificationEmails() {
                return this.sendNotificationEmails;
            }

            public Insert setSendNotificationEmails(Boolean bool) {
                this.sendNotificationEmails = bool;
                return this;
            }

            public boolean isSendNotificationEmails() {
                if (this.sendNotificationEmails == null || this.sendNotificationEmails == Data.f2533a) {
                    return true;
                }
                return this.sendNotificationEmails.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        /* loaded from: classes.dex */
        public class List extends DriveRequest<PermissionList> {
            private static final String REST_PATH = "files/{fileId}/permissions";

            @Key
            private String fileId;

            protected List(String str) {
                super(Drive.this, "GET", REST_PATH, null, PermissionList.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<PermissionList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<PermissionList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<PermissionList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<PermissionList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<PermissionList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<PermissionList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<PermissionList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Patch patch(String str, String str2, Permission permission) throws IOException {
            Patch patch = new Patch(str, str2, permission);
            Drive.this.initialize(patch);
            return patch;
        }

        /* loaded from: classes.dex */
        public class Patch extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";

            @Key
            private String fileId;

            @Key
            private String permissionId;

            @Key
            private Boolean transferOwnership;

            protected Patch(String str, String str2, Permission permission) {
                super(Drive.this, "PATCH", REST_PATH, permission, Permission.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) Preconditions.a(str2, "Required parameter permissionId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Patch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Patch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Patch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Patch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Patch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Patch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Permission> setUserIp2(String str) {
                return (Patch) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Patch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Patch setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            public Boolean getTransferOwnership() {
                return this.transferOwnership;
            }

            public Patch setTransferOwnership(Boolean bool) {
                this.transferOwnership = bool;
                return this;
            }

            public boolean isTransferOwnership() {
                if (this.transferOwnership == null || this.transferOwnership == Data.f2533a) {
                    return false;
                }
                return this.transferOwnership.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Patch set(String str, Object obj) {
                return (Patch) super.set(str, obj);
            }
        }

        public Update update(String str, String str2, Permission permission) throws IOException {
            Update update = new Update(str, str2, permission);
            Drive.this.initialize(update);
            return update;
        }

        /* loaded from: classes.dex */
        public class Update extends DriveRequest<Permission> {
            private static final String REST_PATH = "files/{fileId}/permissions/{permissionId}";

            @Key
            private String fileId;

            @Key
            private String permissionId;

            @Key
            private Boolean transferOwnership;

            protected Update(String str, String str2, Permission permission) {
                super(Drive.this, "PUT", REST_PATH, permission, Permission.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.permissionId = (String) Preconditions.a(str2, "Required parameter permissionId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Permission> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Permission> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Permission> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Permission> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Permission> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Permission> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Permission> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getPermissionId() {
                return this.permissionId;
            }

            public Update setPermissionId(String str) {
                this.permissionId = str;
                return this;
            }

            public Boolean getTransferOwnership() {
                return this.transferOwnership;
            }

            public Update setTransferOwnership(Boolean bool) {
                this.transferOwnership = bool;
                return this;
            }

            public boolean isTransferOwnership() {
                if (this.transferOwnership == null || this.transferOwnership == Data.f2533a) {
                    return false;
                }
                return this.transferOwnership.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }
    }

    public Properties properties() {
        return new Properties();
    }

    /* loaded from: classes.dex */
    public class Properties {
        public Properties() {
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        /* loaded from: classes.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/properties/{propertyKey}";

            @Key
            private String fileId;

            @Key
            private String propertyKey;

            @Key
            private String visibility;

            protected Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.propertyKey = (String) Preconditions.a(str2, "Required parameter propertyKey must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getPropertyKey() {
                return this.propertyKey;
            }

            public Delete setPropertyKey(String str) {
                this.propertyKey = str;
                return this;
            }

            public String getVisibility() {
                return this.visibility;
            }

            public Delete setVisibility(String str) {
                this.visibility = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        /* loaded from: classes.dex */
        public class Get extends DriveRequest<Property> {
            private static final String REST_PATH = "files/{fileId}/properties/{propertyKey}";

            @Key
            private String fileId;

            @Key
            private String propertyKey;

            @Key
            private String visibility;

            protected Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Property.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.propertyKey = (String) Preconditions.a(str2, "Required parameter propertyKey must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Property> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Property> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Property> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Property> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Property> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Property> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Property> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getPropertyKey() {
                return this.propertyKey;
            }

            public Get setPropertyKey(String str) {
                this.propertyKey = str;
                return this;
            }

            public String getVisibility() {
                return this.visibility;
            }

            public Get setVisibility(String str) {
                this.visibility = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public Insert insert(String str, Property property) throws IOException {
            Insert insert = new Insert(str, property);
            Drive.this.initialize(insert);
            return insert;
        }

        /* loaded from: classes.dex */
        public class Insert extends DriveRequest<Property> {
            private static final String REST_PATH = "files/{fileId}/properties";

            @Key
            private String fileId;

            protected Insert(String str, Property property) {
                super(Drive.this, "POST", REST_PATH, property, Property.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Property> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Property> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Property> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Property> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Property> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Property> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Property> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Insert setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        /* loaded from: classes.dex */
        public class List extends DriveRequest<PropertyList> {
            private static final String REST_PATH = "files/{fileId}/properties";

            @Key
            private String fileId;

            protected List(String str) {
                super(Drive.this, "GET", REST_PATH, null, PropertyList.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<PropertyList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<PropertyList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<PropertyList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<PropertyList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<PropertyList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<PropertyList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<PropertyList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Patch patch(String str, String str2, Property property) throws IOException {
            Patch patch = new Patch(str, str2, property);
            Drive.this.initialize(patch);
            return patch;
        }

        /* loaded from: classes.dex */
        public class Patch extends DriveRequest<Property> {
            private static final String REST_PATH = "files/{fileId}/properties/{propertyKey}";

            @Key
            private String fileId;

            @Key
            private String propertyKey;

            @Key
            private String visibility;

            protected Patch(String str, String str2, Property property) {
                super(Drive.this, "PATCH", REST_PATH, property, Property.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.propertyKey = (String) Preconditions.a(str2, "Required parameter propertyKey must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Property> setAlt2(String str) {
                return (Patch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Property> setFields2(String str) {
                return (Patch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Property> setKey2(String str) {
                return (Patch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Property> setOauthToken2(String str) {
                return (Patch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Property> setPrettyPrint2(Boolean bool) {
                return (Patch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Property> setQuotaUser2(String str) {
                return (Patch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Property> setUserIp2(String str) {
                return (Patch) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Patch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getPropertyKey() {
                return this.propertyKey;
            }

            public Patch setPropertyKey(String str) {
                this.propertyKey = str;
                return this;
            }

            public String getVisibility() {
                return this.visibility;
            }

            public Patch setVisibility(String str) {
                this.visibility = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Patch set(String str, Object obj) {
                return (Patch) super.set(str, obj);
            }
        }

        public Update update(String str, String str2, Property property) throws IOException {
            Update update = new Update(str, str2, property);
            Drive.this.initialize(update);
            return update;
        }

        /* loaded from: classes.dex */
        public class Update extends DriveRequest<Property> {
            private static final String REST_PATH = "files/{fileId}/properties/{propertyKey}";

            @Key
            private String fileId;

            @Key
            private String propertyKey;

            @Key
            private String visibility;

            protected Update(String str, String str2, Property property) {
                super(Drive.this, "PUT", REST_PATH, property, Property.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.propertyKey = (String) Preconditions.a(str2, "Required parameter propertyKey must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Property> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Property> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Property> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Property> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Property> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Property> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Property> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getPropertyKey() {
                return this.propertyKey;
            }

            public Update setPropertyKey(String str) {
                this.propertyKey = str;
                return this;
            }

            public String getVisibility() {
                return this.visibility;
            }

            public Update setVisibility(String str) {
                this.visibility = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }
    }

    public Realtime realtime() {
        return new Realtime();
    }

    /* loaded from: classes.dex */
    public class Realtime {
        public Realtime() {
        }

        public Get get(String str) throws IOException {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        /* loaded from: classes.dex */
        public class Get extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/realtime";

            @Key
            private String fileId;

            @Key
            private Integer revision;

            protected Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                initializeMediaDownload();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeMediaAndDownloadTo(outputStream);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public InputStream executeMediaAsInputStream() throws IOException {
                return super.executeMediaAsInputStream();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeMedia() throws IOException {
                return super.executeMedia();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Integer getRevision() {
                return this.revision;
            }

            public Get setRevision(Integer num) {
                this.revision = num;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public Update update(String str) throws IOException {
            Update update = new Update(str);
            Drive.this.initialize(update);
            return update;
        }

        public Update update(String str, AbstractInputStreamContent abstractInputStreamContent) throws IOException {
            Update update = new Update(str, abstractInputStreamContent);
            Drive.this.initialize(update);
            return update;
        }

        /* loaded from: classes.dex */
        public class Update extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/realtime";

            @Key
            private String baseRevision;

            @Key
            private String fileId;

            protected Update(String str) {
                super(Drive.this, "PUT", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            protected Update(String str, AbstractInputStreamContent abstractInputStreamContent) {
                super(Drive.this, "PUT", "/upload/" + Drive.this.getServicePath() + REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                initializeMediaUpload(abstractInputStreamContent);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getBaseRevision() {
                return this.baseRevision;
            }

            public Update setBaseRevision(String str) {
                this.baseRevision = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }
    }

    public Replies replies() {
        return new Replies();
    }

    /* loaded from: classes.dex */
    public class Replies {
        public Replies() {
        }

        public Delete delete(String str, String str2, String str3) throws IOException {
            Delete delete = new Delete(str, str2, str3);
            Drive.this.initialize(delete);
            return delete;
        }

        /* loaded from: classes.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private String replyId;

            protected Delete(String str, String str2, String str3) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.a(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) Preconditions.a(str3, "Required parameter replyId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Delete setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Delete setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public Get get(String str, String str2, String str3) throws IOException {
            Get get = new Get(str, str2, str3);
            Drive.this.initialize(get);
            return get;
        }

        /* loaded from: classes.dex */
        public class Get extends DriveRequest<CommentReply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private Boolean includeDeleted;

            @Key
            private String replyId;

            protected Get(String str, String str2, String str3) {
                super(Drive.this, "GET", REST_PATH, null, CommentReply.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.a(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) Preconditions.a(str3, "Required parameter replyId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<CommentReply> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<CommentReply> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<CommentReply> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<CommentReply> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<CommentReply> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<CommentReply> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<CommentReply> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Get setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Get setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Get setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public boolean isIncludeDeleted() {
                if (this.includeDeleted == null || this.includeDeleted == Data.f2533a) {
                    return false;
                }
                return this.includeDeleted.booleanValue();
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public Insert insert(String str, String str2, CommentReply commentReply) throws IOException {
            Insert insert = new Insert(str, str2, commentReply);
            Drive.this.initialize(insert);
            return insert;
        }

        /* loaded from: classes.dex */
        public class Insert extends DriveRequest<CommentReply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies";

            @Key
            private String commentId;

            @Key
            private String fileId;

            protected Insert(String str, String str2, CommentReply commentReply) {
                super(Drive.this, "POST", REST_PATH, commentReply, CommentReply.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.a(str2, "Required parameter commentId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<CommentReply> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<CommentReply> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<CommentReply> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<CommentReply> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<CommentReply> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<CommentReply> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<CommentReply> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Insert setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Insert setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        public List list(String str, String str2) throws IOException {
            List list = new List(str, str2);
            Drive.this.initialize(list);
            return list;
        }

        /* loaded from: classes.dex */
        public class List extends DriveRequest<CommentReplyList> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private Boolean includeDeleted;

            @Key
            private Integer maxResults;

            @Key
            private String pageToken;

            protected List(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, CommentReplyList.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.a(str2, "Required parameter commentId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<CommentReplyList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<CommentReplyList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<CommentReplyList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<CommentReplyList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<CommentReplyList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<CommentReplyList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<CommentReplyList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public List setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public List setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public boolean isIncludeDeleted() {
                if (this.includeDeleted == null || this.includeDeleted == Data.f2533a) {
                    return false;
                }
                return this.includeDeleted.booleanValue();
            }

            public Integer getMaxResults() {
                return this.maxResults;
            }

            public List setMaxResults(Integer num) {
                this.maxResults = num;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Patch patch(String str, String str2, String str3, CommentReply commentReply) throws IOException {
            Patch patch = new Patch(str, str2, str3, commentReply);
            Drive.this.initialize(patch);
            return patch;
        }

        /* loaded from: classes.dex */
        public class Patch extends DriveRequest<CommentReply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private String replyId;

            protected Patch(String str, String str2, String str3, CommentReply commentReply) {
                super(Drive.this, "PATCH", REST_PATH, commentReply, CommentReply.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.a(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) Preconditions.a(str3, "Required parameter replyId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<CommentReply> setAlt2(String str) {
                return (Patch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<CommentReply> setFields2(String str) {
                return (Patch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<CommentReply> setKey2(String str) {
                return (Patch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<CommentReply> setOauthToken2(String str) {
                return (Patch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<CommentReply> setPrettyPrint2(Boolean bool) {
                return (Patch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<CommentReply> setQuotaUser2(String str) {
                return (Patch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<CommentReply> setUserIp2(String str) {
                return (Patch) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Patch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Patch setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Patch setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Patch set(String str, Object obj) {
                return (Patch) super.set(str, obj);
            }
        }

        public Update update(String str, String str2, String str3, CommentReply commentReply) throws IOException {
            Update update = new Update(str, str2, str3, commentReply);
            Drive.this.initialize(update);
            return update;
        }

        /* loaded from: classes.dex */
        public class Update extends DriveRequest<CommentReply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @Key
            private String commentId;

            @Key
            private String fileId;

            @Key
            private String replyId;

            protected Update(String str, String str2, String str3, CommentReply commentReply) {
                super(Drive.this, "PUT", REST_PATH, commentReply, CommentReply.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.commentId = (String) Preconditions.a(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) Preconditions.a(str3, "Required parameter replyId must be specified.");
                checkRequiredParameter(commentReply, "content");
                checkRequiredParameter(commentReply.getContent(), "CommentReply.getContent()");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<CommentReply> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<CommentReply> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<CommentReply> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<CommentReply> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<CommentReply> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<CommentReply> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<CommentReply> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Update setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Update setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }
    }

    public Revisions revisions() {
        return new Revisions();
    }

    /* loaded from: classes.dex */
    public class Revisions {
        public Revisions() {
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        /* loaded from: classes.dex */
        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";

            @Key
            private String fileId;

            @Key
            private String revisionId;

            protected Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) Preconditions.a(str2, "Required parameter revisionId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Void> setAlt2(String str) {
                return (Delete) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Void> setKey2(String str) {
                return (Delete) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Void> setOauthToken2(String str) {
                return (Delete) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Void> setQuotaUser2(String str) {
                return (Delete) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Void> setUserIp2(String str) {
                return (Delete) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Delete setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        /* loaded from: classes.dex */
        public class Get extends DriveRequest<Revision> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";

            @Key
            private String fileId;

            @Key
            private String revisionId;

            protected Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Revision.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) Preconditions.a(str2, "Required parameter revisionId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Revision> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Revision> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Revision> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Revision> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Revision> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Revision> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Revision> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Get setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        /* loaded from: classes.dex */
        public class List extends DriveRequest<RevisionList> {
            private static final String REST_PATH = "files/{fileId}/revisions";

            @Key
            private String fileId;

            protected List(String str) {
                super(Drive.this, "GET", REST_PATH, null, RevisionList.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<RevisionList> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<RevisionList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<RevisionList> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<RevisionList> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<RevisionList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<RevisionList> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<RevisionList> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public Patch patch(String str, String str2, Revision revision) throws IOException {
            Patch patch = new Patch(str, str2, revision);
            Drive.this.initialize(patch);
            return patch;
        }

        /* loaded from: classes.dex */
        public class Patch extends DriveRequest<Revision> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";

            @Key
            private String fileId;

            @Key
            private String revisionId;

            protected Patch(String str, String str2, Revision revision) {
                super(Drive.this, "PATCH", REST_PATH, revision, Revision.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) Preconditions.a(str2, "Required parameter revisionId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Revision> setAlt2(String str) {
                return (Patch) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Revision> setFields2(String str) {
                return (Patch) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Revision> setKey2(String str) {
                return (Patch) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Revision> setOauthToken2(String str) {
                return (Patch) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Revision> setPrettyPrint2(Boolean bool) {
                return (Patch) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Revision> setQuotaUser2(String str) {
                return (Patch) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Revision> setUserIp2(String str) {
                return (Patch) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Patch setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Patch setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Patch set(String str, Object obj) {
                return (Patch) super.set(str, obj);
            }
        }

        public Update update(String str, String str2, Revision revision) throws IOException {
            Update update = new Update(str, str2, revision);
            Drive.this.initialize(update);
            return update;
        }

        /* loaded from: classes.dex */
        public class Update extends DriveRequest<Revision> {
            private static final String REST_PATH = "files/{fileId}/revisions/{revisionId}";

            @Key
            private String fileId;

            @Key
            private String revisionId;

            protected Update(String str, String str2, Revision revision) {
                super(Drive.this, "PUT", REST_PATH, revision, Revision.class);
                this.fileId = (String) Preconditions.a(str, "Required parameter fileId must be specified.");
                this.revisionId = (String) Preconditions.a(str2, "Required parameter revisionId must be specified.");
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setAlt */
            public DriveRequest<Revision> setAlt2(String str) {
                return (Update) super.setAlt2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Revision> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setKey */
            public DriveRequest<Revision> setKey2(String str) {
                return (Update) super.setKey2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setOauthToken */
            public DriveRequest<Revision> setOauthToken2(String str) {
                return (Update) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Revision> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setQuotaUser */
            public DriveRequest<Revision> setQuotaUser2(String str) {
                return (Update) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.drive.DriveRequest
            /* renamed from: setUserIp */
            public DriveRequest<Revision> setUserIp2(String str) {
                return (Update) super.setUserIp2(str);
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public String getRevisionId() {
                return this.revisionId;
            }

            public Update setRevisionId(String str) {
                this.revisionId = str;
                return this;
            }

            @Override // com.google.api.services.drive.DriveRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends AbstractGoogleJsonClient.Builder {
        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
            super(httpTransport, jsonFactory, Drive.DEFAULT_ROOT_URL, Drive.DEFAULT_SERVICE_PATH, httpRequestInitializer, false);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Drive build() {
            return new Drive(this);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressPatternChecks(boolean z) {
            return (Builder) super.setSuppressPatternChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressRequiredParameterChecks(boolean z) {
            return (Builder) super.setSuppressRequiredParameterChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressAllChecks(boolean z) {
            return (Builder) super.setSuppressAllChecks(z);
        }

        public Builder setDriveRequestInitializer(DriveRequestInitializer driveRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer((GoogleClientRequestInitializer) driveRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }
    }
}
