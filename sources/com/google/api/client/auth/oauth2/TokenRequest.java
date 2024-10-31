package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

/* loaded from: classes2.dex */
public class TokenRequest extends GenericData {

    /* renamed from: a, reason: collision with root package name */
    HttpRequestInitializer f14615a;

    /* renamed from: b, reason: collision with root package name */
    HttpExecuteInterceptor f14616b;

    /* renamed from: c, reason: collision with root package name */
    private final HttpTransport f14617c;

    /* renamed from: d, reason: collision with root package name */
    private final JsonFactory f14618d;

    /* renamed from: e, reason: collision with root package name */
    private GenericUrl f14619e;

    /* renamed from: f, reason: collision with root package name */
    protected Class<? extends TokenResponse> f14620f;

    @Key("grant_type")
    private String grantType;

    @Key("scope")
    private String scopes;

    public TokenRequest(HttpTransport httpTransport, JsonFactory jsonFactory, GenericUrl genericUrl, String str) {
        this(httpTransport, jsonFactory, genericUrl, str, TokenResponse.class);
    }

    public TokenRequest a(HttpRequestInitializer httpRequestInitializer) {
        this.f14615a = httpRequestInitializer;
        return this;
    }

    public TokenResponse execute() throws IOException {
        return (TokenResponse) executeUnparsed().a(this.f14620f);
    }

    public final HttpResponse executeUnparsed() throws IOException {
        HttpRequest a2 = this.f14617c.createRequestFactory(new b(this)).a(this.f14619e, new UrlEncodedContent(this));
        a2.a(new JsonObjectParser(this.f14618d));
        a2.a(false);
        HttpResponse a3 = a2.a();
        if (a3.j()) {
            return a3;
        }
        throw TokenResponseException.from(this.f14618d, a3);
    }

    public TokenRequest(HttpTransport httpTransport, JsonFactory jsonFactory, GenericUrl genericUrl, String str, Class<? extends TokenResponse> cls) {
        Preconditions.a(httpTransport);
        this.f14617c = httpTransport;
        Preconditions.a(jsonFactory);
        this.f14618d = jsonFactory;
        a(genericUrl);
        a(str);
        a(cls);
    }

    public TokenRequest a(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.f14616b = httpExecuteInterceptor;
        return this;
    }

    @Override // com.google.api.client.util.GenericData
    public TokenRequest set(String str, Object obj) {
        super.set(str, obj);
        return this;
    }

    public TokenRequest a(GenericUrl genericUrl) {
        this.f14619e = genericUrl;
        Preconditions.a(genericUrl.c() == null);
        return this;
    }

    public TokenRequest a(String str) {
        Preconditions.a(str);
        this.grantType = str;
        return this;
    }

    public TokenRequest a(Class<? extends TokenResponse> cls) {
        this.f14620f = cls;
        return this;
    }
}
