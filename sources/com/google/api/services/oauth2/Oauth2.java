package com.google.api.services.oauth2;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.oauth2.model.Jwk;
import com.google.api.services.oauth2.model.Userinfoplus;
import java.io.IOException;

/* loaded from: classes2.dex */
public class Oauth2 extends AbstractGoogleJsonClient {
    static {
        Preconditions.b(GoogleUtils.f2424a.intValue() == 1 && GoogleUtils.b.intValue() >= 15, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.20.0 of the Google OAuth2 API library.", GoogleUtils.d);
    }

    Oauth2(Builder builder) {
        super(builder);
    }

    @Override // com.google.api.client.googleapis.services.AbstractGoogleClient
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        super.initialize(abstractGoogleClientRequest);
    }

    /* loaded from: classes2.dex */
    public class Userinfo {

        /* renamed from: a */
        final /* synthetic */ Oauth2 f2564a;

        /* loaded from: classes2.dex */
        public class Get extends Oauth2Request<Userinfoplus> {
            private static final String REST_PATH = "oauth2/v2/userinfo";

            protected Get() {
                super(Userinfo.this.f2564a, "GET", REST_PATH, null, Userinfoplus.class);
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.services.oauth2.Oauth2Request
            /* renamed from: setAlt */
            public Oauth2Request<Userinfoplus> setAlt2(String str) {
                return (Get) super.setAlt2(str);
            }

            @Override // com.google.api.services.oauth2.Oauth2Request
            /* renamed from: setFields */
            public Oauth2Request<Userinfoplus> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.google.api.services.oauth2.Oauth2Request
            /* renamed from: setKey */
            public Oauth2Request<Userinfoplus> setKey2(String str) {
                return (Get) super.setKey2(str);
            }

            @Override // com.google.api.services.oauth2.Oauth2Request
            /* renamed from: setOauthToken */
            public Oauth2Request<Userinfoplus> setOauthToken2(String str) {
                return (Get) super.setOauthToken2(str);
            }

            @Override // com.google.api.services.oauth2.Oauth2Request
            /* renamed from: setPrettyPrint */
            public Oauth2Request<Userinfoplus> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.google.api.services.oauth2.Oauth2Request
            /* renamed from: setQuotaUser */
            public Oauth2Request<Userinfoplus> setQuotaUser2(String str) {
                return (Get) super.setQuotaUser2(str);
            }

            @Override // com.google.api.services.oauth2.Oauth2Request
            /* renamed from: setUserIp */
            public Oauth2Request<Userinfoplus> setUserIp2(String str) {
                return (Get) super.setUserIp2(str);
            }

            @Override // com.google.api.services.oauth2.Oauth2Request, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        /* loaded from: classes2.dex */
        public class V2 {

            /* renamed from: a */
            final /* synthetic */ Userinfo f2565a;

            /* loaded from: classes2.dex */
            public class Me {

                /* renamed from: a */
                final /* synthetic */ V2 f2566a;

                /* loaded from: classes2.dex */
                public class Get extends Oauth2Request<Userinfoplus> {
                    private static final String REST_PATH = "userinfo/v2/me";

                    protected Get() {
                        super(Me.this.f2566a.f2565a.f2564a, "GET", REST_PATH, null, Userinfoplus.class);
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpResponse executeUsingHead() throws IOException {
                        return super.executeUsingHead();
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpRequest buildHttpRequestUsingHead() throws IOException {
                        return super.buildHttpRequestUsingHead();
                    }

                    @Override // com.google.api.services.oauth2.Oauth2Request
                    /* renamed from: setAlt */
                    public Oauth2Request<Userinfoplus> setAlt2(String str) {
                        return (Get) super.setAlt2(str);
                    }

                    @Override // com.google.api.services.oauth2.Oauth2Request
                    /* renamed from: setFields */
                    public Oauth2Request<Userinfoplus> setFields2(String str) {
                        return (Get) super.setFields2(str);
                    }

                    @Override // com.google.api.services.oauth2.Oauth2Request
                    /* renamed from: setKey */
                    public Oauth2Request<Userinfoplus> setKey2(String str) {
                        return (Get) super.setKey2(str);
                    }

                    @Override // com.google.api.services.oauth2.Oauth2Request
                    /* renamed from: setOauthToken */
                    public Oauth2Request<Userinfoplus> setOauthToken2(String str) {
                        return (Get) super.setOauthToken2(str);
                    }

                    @Override // com.google.api.services.oauth2.Oauth2Request
                    /* renamed from: setPrettyPrint */
                    public Oauth2Request<Userinfoplus> setPrettyPrint2(Boolean bool) {
                        return (Get) super.setPrettyPrint2(bool);
                    }

                    @Override // com.google.api.services.oauth2.Oauth2Request
                    /* renamed from: setQuotaUser */
                    public Oauth2Request<Userinfoplus> setQuotaUser2(String str) {
                        return (Get) super.setQuotaUser2(str);
                    }

                    @Override // com.google.api.services.oauth2.Oauth2Request
                    /* renamed from: setUserIp */
                    public Oauth2Request<Userinfoplus> setUserIp2(String str) {
                        return (Get) super.setUserIp2(str);
                    }

                    @Override // com.google.api.services.oauth2.Oauth2Request, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Get set(String str, Object obj) {
                        return (Get) super.set(str, obj);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class GetCertForOpenIdConnect extends Oauth2Request<Jwk> {
        private static final String REST_PATH = "oauth2/v2/certs";

        protected GetCertForOpenIdConnect() {
            super(Oauth2.this, "GET", REST_PATH, null, Jwk.class);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
        public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
        public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setAlt */
        public Oauth2Request<Jwk> setAlt2(String str) {
            return (GetCertForOpenIdConnect) super.setAlt2(str);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setFields */
        public Oauth2Request<Jwk> setFields2(String str) {
            return (GetCertForOpenIdConnect) super.setFields2(str);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setKey */
        public Oauth2Request<Jwk> setKey2(String str) {
            return (GetCertForOpenIdConnect) super.setKey2(str);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setOauthToken */
        public Oauth2Request<Jwk> setOauthToken2(String str) {
            return (GetCertForOpenIdConnect) super.setOauthToken2(str);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setPrettyPrint */
        public Oauth2Request<Jwk> setPrettyPrint2(Boolean bool) {
            return (GetCertForOpenIdConnect) super.setPrettyPrint2(bool);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setQuotaUser */
        public Oauth2Request<Jwk> setQuotaUser2(String str) {
            return (GetCertForOpenIdConnect) super.setQuotaUser2(str);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setUserIp */
        public Oauth2Request<Jwk> setUserIp2(String str) {
            return (GetCertForOpenIdConnect) super.setUserIp2(str);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
        public GetCertForOpenIdConnect set(String str, Object obj) {
            return (GetCertForOpenIdConnect) super.set(str, obj);
        }
    }

    /* loaded from: classes.dex */
    public class Tokeninfo extends Oauth2Request<com.google.api.services.oauth2.model.Tokeninfo> {
        private static final String REST_PATH = "oauth2/v2/tokeninfo";

        @Key(a = "access_token")
        private String accessToken;

        @Key(a = "id_token")
        private String idToken;

        @Key(a = "token_handle")
        private String tokenHandle;

        protected Tokeninfo() {
            super(Oauth2.this, "POST", REST_PATH, null, com.google.api.services.oauth2.model.Tokeninfo.class);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setAlt */
        public Oauth2Request<com.google.api.services.oauth2.model.Tokeninfo> setAlt2(String str) {
            return (Tokeninfo) super.setAlt2(str);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setFields */
        public Oauth2Request<com.google.api.services.oauth2.model.Tokeninfo> setFields2(String str) {
            return (Tokeninfo) super.setFields2(str);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setKey */
        public Oauth2Request<com.google.api.services.oauth2.model.Tokeninfo> setKey2(String str) {
            return (Tokeninfo) super.setKey2(str);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setOauthToken */
        public Oauth2Request<com.google.api.services.oauth2.model.Tokeninfo> setOauthToken2(String str) {
            return (Tokeninfo) super.setOauthToken2(str);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setPrettyPrint */
        public Oauth2Request<com.google.api.services.oauth2.model.Tokeninfo> setPrettyPrint2(Boolean bool) {
            return (Tokeninfo) super.setPrettyPrint2(bool);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setQuotaUser */
        public Oauth2Request<com.google.api.services.oauth2.model.Tokeninfo> setQuotaUser2(String str) {
            return (Tokeninfo) super.setQuotaUser2(str);
        }

        @Override // com.google.api.services.oauth2.Oauth2Request
        /* renamed from: setUserIp */
        public Oauth2Request<com.google.api.services.oauth2.model.Tokeninfo> setUserIp2(String str) {
            return (Tokeninfo) super.setUserIp2(str);
        }

        public String getAccessToken() {
            return this.accessToken;
        }

        public Tokeninfo setAccessToken(String str) {
            this.accessToken = str;
            return this;
        }

        public String getIdToken() {
            return this.idToken;
        }

        public Tokeninfo setIdToken(String str) {
            this.idToken = str;
            return this;
        }

        public String getTokenHandle() {
            return this.tokenHandle;
        }

        public Tokeninfo setTokenHandle(String str) {
            this.tokenHandle = str;
            return this;
        }

        @Override // com.google.api.services.oauth2.Oauth2Request, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
        public Tokeninfo set(String str, Object obj) {
            return (Tokeninfo) super.set(str, obj);
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends AbstractGoogleJsonClient.Builder {
        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        /* renamed from: a */
        public Oauth2 build() {
            return new Oauth2(this);
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
