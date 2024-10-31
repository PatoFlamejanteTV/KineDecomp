package com.google.api.services.plus;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.plus.model.Activity;
import com.google.api.services.plus.model.ActivityFeed;
import com.google.api.services.plus.model.Comment;
import com.google.api.services.plus.model.CommentFeed;
import com.google.api.services.plus.model.Moment;
import com.google.api.services.plus.model.MomentsFeed;
import com.google.api.services.plus.model.PeopleFeed;
import com.google.api.services.plus.model.Person;
import java.io.IOException;

/* loaded from: classes.dex */
public class Plus extends AbstractGoogleJsonClient {
    static {
        Preconditions.b(GoogleUtils.f2424a.intValue() == 1 && GoogleUtils.b.intValue() >= 15, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.20.0 of the Google+ API library.", GoogleUtils.d);
    }

    Plus(Builder builder) {
        super(builder);
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClient
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        super.initialize(abstractGoogleClientRequest);
    }

    /* loaded from: classes.dex */
    public class Activities {

        /* renamed from: a */
        final /* synthetic */ Plus f2567a;

        /* loaded from: classes.dex */
        public class Get extends PlusRequest<Activity> {
            private static final String REST_PATH = "activities/{activityId}";

            @Key
            private String activityId;

            protected Get(String str) {
                super(Activities.this.f2567a, "GET", REST_PATH, null, Activity.class);
                this.activityId = (String) Preconditions.a(str, "Required parameter activityId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setAlt */
            public PlusRequest<Activity> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setFields */
            public PlusRequest<Activity> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setKey */
            public PlusRequest<Activity> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setOauthToken */
            public PlusRequest<Activity> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setPrettyPrint */
            public PlusRequest<Activity> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setQuotaUser */
            public PlusRequest<Activity> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setUserIp */
            public PlusRequest<Activity> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getActivityId() {
                return this.activityId;
            }

            public Get setActivityId(String str) {
                this.activityId = str;
                return this;
            }

            @Override // com.google.api.services.plus.PlusRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* loaded from: classes.dex */
        public class List extends PlusRequest<ActivityFeed> {
            private static final String REST_PATH = "people/{userId}/activities/{collection}";

            @Key
            private String collection;

            @Key
            private Long maxResults;

            @Key
            private String pageToken;

            @Key
            private String userId;

            protected List(String str, String str2) {
                super(Activities.this.f2567a, "GET", REST_PATH, null, ActivityFeed.class);
                this.userId = (String) Preconditions.a(str, "Required parameter userId must be specified.");
                this.collection = (String) Preconditions.a(str2, "Required parameter collection must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setAlt */
            public PlusRequest<ActivityFeed> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setFields */
            public PlusRequest<ActivityFeed> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setKey */
            public PlusRequest<ActivityFeed> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setOauthToken */
            public PlusRequest<ActivityFeed> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setPrettyPrint */
            public PlusRequest<ActivityFeed> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setQuotaUser */
            public PlusRequest<ActivityFeed> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setUserIp */
            public PlusRequest<ActivityFeed> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public String getUserId() {
                return this.userId;
            }

            public List setUserId(String str) {
                this.userId = str;
                return this;
            }

            public String getCollection() {
                return this.collection;
            }

            public List setCollection(String str) {
                this.collection = str;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public Long getMaxResults() {
                return this.maxResults;
            }

            public List setMaxResults(Long l) {
                this.maxResults = l;
                return this;
            }

            @Override // com.google.api.services.plus.PlusRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* loaded from: classes.dex */
        public class Search extends PlusRequest<ActivityFeed> {
            private static final String REST_PATH = "activities";

            @Key
            private String language;

            @Key
            private Long maxResults;

            @Key
            private String orderBy;

            @Key
            private String pageToken;

            @Key
            private String query;

            protected Search(String str) {
                super(Activities.this.f2567a, "GET", REST_PATH, null, ActivityFeed.class);
                this.query = (String) Preconditions.a(str, "Required parameter query must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setAlt */
            public PlusRequest<ActivityFeed> setAlt2(String str) {
                return (Search) super.setAlt2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setFields */
            public PlusRequest<ActivityFeed> setFields2(String str) {
                return (Search) super.setFields2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setKey */
            public PlusRequest<ActivityFeed> setKey2(String str) {
                return (Search) super.setKey2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setOauthToken */
            public PlusRequest<ActivityFeed> setOauthToken2(String str) {
                return (Search) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setPrettyPrint */
            public PlusRequest<ActivityFeed> setPrettyPrint2(Boolean bool) {
                return (Search) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setQuotaUser */
            public PlusRequest<ActivityFeed> setQuotaUser2(String str) {
                return (Search) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setUserIp */
            public PlusRequest<ActivityFeed> setUserIp2(String str) {
                return (Search) super.setUserIp2(str);
            }

            public String getQuery() {
                return this.query;
            }

            public Search setQuery(String str) {
                this.query = str;
                return this;
            }

            public String getOrderBy() {
                return this.orderBy;
            }

            public Search setOrderBy(String str) {
                this.orderBy = str;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public Search setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public Long getMaxResults() {
                return this.maxResults;
            }

            public Search setMaxResults(Long l) {
                this.maxResults = l;
                return this;
            }

            public String getLanguage() {
                return this.language;
            }

            public Search setLanguage(String str) {
                this.language = str;
                return this;
            }

            @Override // com.google.api.services.plus.PlusRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Search set(String str, Object obj) {
                return (Search) super.set(str, obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public class Comments {

        /* renamed from: a */
        final /* synthetic */ Plus f2568a;

        /* loaded from: classes.dex */
        public class Get extends PlusRequest<Comment> {
            private static final String REST_PATH = "comments/{commentId}";

            @Key
            private String commentId;

            protected Get(String str) {
                super(Comments.this.f2568a, "GET", REST_PATH, null, Comment.class);
                this.commentId = (String) Preconditions.a(str, "Required parameter commentId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setAlt */
            public PlusRequest<Comment> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setFields */
            public PlusRequest<Comment> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setKey */
            public PlusRequest<Comment> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setOauthToken */
            public PlusRequest<Comment> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setPrettyPrint */
            public PlusRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setQuotaUser */
            public PlusRequest<Comment> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setUserIp */
            public PlusRequest<Comment> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getCommentId() {
                return this.commentId;
            }

            public Get setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            @Override // com.google.api.services.plus.PlusRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* loaded from: classes.dex */
        public class List extends PlusRequest<CommentFeed> {
            private static final String REST_PATH = "activities/{activityId}/comments";

            @Key
            private String activityId;

            @Key
            private Long maxResults;

            @Key
            private String pageToken;

            @Key
            private String sortOrder;

            protected List(String str) {
                super(Comments.this.f2568a, "GET", REST_PATH, null, CommentFeed.class);
                this.activityId = (String) Preconditions.a(str, "Required parameter activityId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setAlt */
            public PlusRequest<CommentFeed> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setFields */
            public PlusRequest<CommentFeed> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setKey */
            public PlusRequest<CommentFeed> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setOauthToken */
            public PlusRequest<CommentFeed> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setPrettyPrint */
            public PlusRequest<CommentFeed> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setQuotaUser */
            public PlusRequest<CommentFeed> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setUserIp */
            public PlusRequest<CommentFeed> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public String getActivityId() {
                return this.activityId;
            }

            public List setActivityId(String str) {
                this.activityId = str;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public String getSortOrder() {
                return this.sortOrder;
            }

            public List setSortOrder(String str) {
                this.sortOrder = str;
                return this;
            }

            public Long getMaxResults() {
                return this.maxResults;
            }

            public List setMaxResults(Long l) {
                this.maxResults = l;
                return this;
            }

            @Override // com.google.api.services.plus.PlusRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public class Moments {

        /* renamed from: a */
        final /* synthetic */ Plus f2569a;

        /* loaded from: classes.dex */
        public class Insert extends PlusRequest<Moment> {
            private static final String REST_PATH = "people/{userId}/moments/{collection}";

            @Key
            private String collection;

            @Key
            private Boolean debug;

            @Key
            private String userId;

            protected Insert(String str, String str2, Moment moment) {
                super(Moments.this.f2569a, "POST", REST_PATH, moment, Moment.class);
                this.userId = (String) Preconditions.a(str, "Required parameter userId must be specified.");
                this.collection = (String) Preconditions.a(str2, "Required parameter collection must be specified.");
                checkRequiredParameter(moment, "content");
                checkRequiredParameter(moment.getType(), "Moment.getType()");
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setAlt */
            public PlusRequest<Moment> setAlt2(String str) {
                return (Insert) super.setAlt2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setFields */
            public PlusRequest<Moment> setFields2(String str) {
                return (Insert) super.setFields2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setKey */
            public PlusRequest<Moment> setKey2(String str) {
                return (Insert) super.setKey2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setOauthToken */
            public PlusRequest<Moment> setOauthToken2(String str) {
                return (Insert) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setPrettyPrint */
            public PlusRequest<Moment> setPrettyPrint2(Boolean bool) {
                return (Insert) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setQuotaUser */
            public PlusRequest<Moment> setQuotaUser2(String str) {
                return (Insert) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setUserIp */
            public PlusRequest<Moment> setUserIp2(String str) {
                return (Insert) super.setUserIp2(str);
            }

            public String getUserId() {
                return this.userId;
            }

            public Insert setUserId(String str) {
                this.userId = str;
                return this;
            }

            public String getCollection() {
                return this.collection;
            }

            public Insert setCollection(String str) {
                this.collection = str;
                return this;
            }

            public Boolean getDebug() {
                return this.debug;
            }

            public Insert setDebug(Boolean bool) {
                this.debug = bool;
                return this;
            }

            @Override // com.google.api.services.plus.PlusRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Insert set(String str, Object obj) {
                return (Insert) super.set(str, obj);
            }
        }

        /* loaded from: classes.dex */
        public class List extends PlusRequest<MomentsFeed> {
            private static final String REST_PATH = "people/{userId}/moments/{collection}";

            @Key
            private String collection;

            @Key
            private Long maxResults;

            @Key
            private String pageToken;

            @Key
            private String targetUrl;

            @Key
            private String type;

            @Key
            private String userId;

            protected List(String str, String str2) {
                super(Moments.this.f2569a, "GET", REST_PATH, null, MomentsFeed.class);
                this.userId = (String) Preconditions.a(str, "Required parameter userId must be specified.");
                this.collection = (String) Preconditions.a(str2, "Required parameter collection must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setAlt */
            public PlusRequest<MomentsFeed> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setFields */
            public PlusRequest<MomentsFeed> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setKey */
            public PlusRequest<MomentsFeed> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setOauthToken */
            public PlusRequest<MomentsFeed> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setPrettyPrint */
            public PlusRequest<MomentsFeed> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setQuotaUser */
            public PlusRequest<MomentsFeed> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setUserIp */
            public PlusRequest<MomentsFeed> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public String getUserId() {
                return this.userId;
            }

            public List setUserId(String str) {
                this.userId = str;
                return this;
            }

            public String getCollection() {
                return this.collection;
            }

            public List setCollection(String str) {
                this.collection = str;
                return this;
            }

            public Long getMaxResults() {
                return this.maxResults;
            }

            public List setMaxResults(Long l) {
                this.maxResults = l;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public List setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public String getTargetUrl() {
                return this.targetUrl;
            }

            public List setTargetUrl(String str) {
                this.targetUrl = str;
                return this;
            }

            public String getType() {
                return this.type;
            }

            public List setType(String str) {
                this.type = str;
                return this;
            }

            @Override // com.google.api.services.plus.PlusRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public class People {

        /* renamed from: a */
        final /* synthetic */ Plus f2570a;

        /* loaded from: classes.dex */
        public class Get extends PlusRequest<Person> {
            private static final String REST_PATH = "people/{userId}";

            @Key
            private String userId;

            protected Get(String str) {
                super(People.this.f2570a, "GET", REST_PATH, null, Person.class);
                this.userId = (String) Preconditions.a(str, "Required parameter userId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setAlt */
            public PlusRequest<Person> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setFields */
            public PlusRequest<Person> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setKey */
            public PlusRequest<Person> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setOauthToken */
            public PlusRequest<Person> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setPrettyPrint */
            public PlusRequest<Person> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setQuotaUser */
            public PlusRequest<Person> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setUserIp */
            public PlusRequest<Person> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            public String getUserId() {
                return this.userId;
            }

            public Get setUserId(String str) {
                this.userId = str;
                return this;
            }

            @Override // com.google.api.services.plus.PlusRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* loaded from: classes.dex */
        public class List extends PlusRequest<PeopleFeed> {
            private static final String REST_PATH = "people/{userId}/people/{collection}";

            @Key
            private String collection;

            @Key
            private Long maxResults;

            @Key
            private String orderBy;

            @Key
            private String pageToken;

            @Key
            private String userId;

            protected List(String str, String str2) {
                super(People.this.f2570a, "GET", REST_PATH, null, PeopleFeed.class);
                this.userId = (String) Preconditions.a(str, "Required parameter userId must be specified.");
                this.collection = (String) Preconditions.a(str2, "Required parameter collection must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setAlt */
            public PlusRequest<PeopleFeed> setAlt2(String str) {
                return (List) super.setAlt2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setFields */
            public PlusRequest<PeopleFeed> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setKey */
            public PlusRequest<PeopleFeed> setKey2(String str) {
                return (List) super.setKey2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setOauthToken */
            public PlusRequest<PeopleFeed> setOauthToken2(String str) {
                return (List) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setPrettyPrint */
            public PlusRequest<PeopleFeed> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setQuotaUser */
            public PlusRequest<PeopleFeed> setQuotaUser2(String str) {
                return (List) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setUserIp */
            public PlusRequest<PeopleFeed> setUserIp2(String str) {
                return (List) super.setUserIp2(str);
            }

            public String getUserId() {
                return this.userId;
            }

            public List setUserId(String str) {
                this.userId = str;
                return this;
            }

            public String getCollection() {
                return this.collection;
            }

            public List setCollection(String str) {
                this.collection = str;
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

            public Long getMaxResults() {
                return this.maxResults;
            }

            public List setMaxResults(Long l) {
                this.maxResults = l;
                return this;
            }

            @Override // com.google.api.services.plus.PlusRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        /* loaded from: classes.dex */
        public class ListByActivity extends PlusRequest<PeopleFeed> {
            private static final String REST_PATH = "activities/{activityId}/people/{collection}";

            @Key
            private String activityId;

            @Key
            private String collection;

            @Key
            private Long maxResults;

            @Key
            private String pageToken;

            protected ListByActivity(String str, String str2) {
                super(People.this.f2570a, "GET", REST_PATH, null, PeopleFeed.class);
                this.activityId = (String) Preconditions.a(str, "Required parameter activityId must be specified.");
                this.collection = (String) Preconditions.a(str2, "Required parameter collection must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setAlt */
            public PlusRequest<PeopleFeed> setAlt2(String str) {
                return (ListByActivity) super.setAlt2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setFields */
            public PlusRequest<PeopleFeed> setFields2(String str) {
                return (ListByActivity) super.setFields2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setKey */
            public PlusRequest<PeopleFeed> setKey2(String str) {
                return (ListByActivity) super.setKey2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setOauthToken */
            public PlusRequest<PeopleFeed> setOauthToken2(String str) {
                return (ListByActivity) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setPrettyPrint */
            public PlusRequest<PeopleFeed> setPrettyPrint2(Boolean bool) {
                return (ListByActivity) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setQuotaUser */
            public PlusRequest<PeopleFeed> setQuotaUser2(String str) {
                return (ListByActivity) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setUserIp */
            public PlusRequest<PeopleFeed> setUserIp2(String str) {
                return (ListByActivity) super.setUserIp2(str);
            }

            public String getActivityId() {
                return this.activityId;
            }

            public ListByActivity setActivityId(String str) {
                this.activityId = str;
                return this;
            }

            public String getCollection() {
                return this.collection;
            }

            public ListByActivity setCollection(String str) {
                this.collection = str;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public ListByActivity setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public Long getMaxResults() {
                return this.maxResults;
            }

            public ListByActivity setMaxResults(Long l) {
                this.maxResults = l;
                return this;
            }

            @Override // com.google.api.services.plus.PlusRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public ListByActivity set(String str, Object obj) {
                return (ListByActivity) super.set(str, obj);
            }
        }

        /* loaded from: classes.dex */
        public class Search extends PlusRequest<PeopleFeed> {
            private static final String REST_PATH = "people";

            @Key
            private String language;

            @Key
            private Long maxResults;

            @Key
            private String pageToken;

            @Key
            private String query;

            protected Search(String str) {
                super(People.this.f2570a, "GET", REST_PATH, null, PeopleFeed.class);
                this.query = (String) Preconditions.a(str, "Required parameter query must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setAlt */
            public PlusRequest<PeopleFeed> setAlt2(String str) {
                return (Search) super.setAlt2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setFields */
            public PlusRequest<PeopleFeed> setFields2(String str) {
                return (Search) super.setFields2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setKey */
            public PlusRequest<PeopleFeed> setKey2(String str) {
                return (Search) super.setKey2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setOauthToken */
            public PlusRequest<PeopleFeed> setOauthToken2(String str) {
                return (Search) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setPrettyPrint */
            public PlusRequest<PeopleFeed> setPrettyPrint2(Boolean bool) {
                return (Search) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setQuotaUser */
            public PlusRequest<PeopleFeed> setQuotaUser2(String str) {
                return (Search) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.plus.PlusRequest
            /* renamed from: setUserIp */
            public PlusRequest<PeopleFeed> setUserIp2(String str) {
                return (Search) super.setUserIp2(str);
            }

            public String getQuery() {
                return this.query;
            }

            public Search setQuery(String str) {
                this.query = str;
                return this;
            }

            public String getPageToken() {
                return this.pageToken;
            }

            public Search setPageToken(String str) {
                this.pageToken = str;
                return this;
            }

            public Long getMaxResults() {
                return this.maxResults;
            }

            public Search setMaxResults(Long l) {
                this.maxResults = l;
                return this;
            }

            public String getLanguage() {
                return this.language;
            }

            public Search setLanguage(String str) {
                this.language = str;
                return this;
            }

            @Override // com.google.api.services.plus.PlusRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Search set(String str, Object obj) {
                return (Search) super.set(str, obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends AbstractGoogleJsonClient.Builder {
        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: a */
        public Plus build() {
            return new Plus(this);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: a */
        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: b */
        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: a */
        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: c */
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: a */
        public Builder setSuppressPatternChecks(boolean z) {
            return (Builder) super.setSuppressPatternChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: b */
        public Builder setSuppressRequiredParameterChecks(boolean z) {
            return (Builder) super.setSuppressRequiredParameterChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: c */
        public Builder setSuppressAllChecks(boolean z) {
            return (Builder) super.setSuppressAllChecks(z);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: a */
        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }
    }
}
