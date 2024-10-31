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

/* loaded from: classes.dex */
public class TokenRequest extends GenericData {

    /* renamed from: a, reason: collision with root package name */
    HttpRequestInitializer f2414a;
    HttpExecuteInterceptor b;
    private final HttpTransport c;
    private final JsonFactory d;
    private GenericUrl e;

    @Key(a = "grant_type")
    private String f;

    public TokenRequest(HttpTransport httpTransport, JsonFactory jsonFactory, GenericUrl genericUrl, String str) {
        this.c = (HttpTransport) Preconditions.a(httpTransport);
        this.d = (JsonFactory) Preconditions.a(jsonFactory);
        b(genericUrl);
        b(str);
    }

    public TokenRequest b(HttpRequestInitializer httpRequestInitializer) {
        this.f2414a = httpRequestInitializer;
        return this;
    }

    public TokenRequest b(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.b = httpExecuteInterceptor;
        return this;
    }

    public TokenRequest b(GenericUrl genericUrl) {
        this.e = genericUrl;
        Preconditions.a(genericUrl.i() == null);
        return this;
    }

    public TokenRequest b(String str) {
        this.f = (String) Preconditions.a(str);
        return this;
    }

    public final HttpResponse a() throws IOException {
        HttpRequest a2 = this.c.createRequestFactory(new a(this)).a(this.e, new UrlEncodedContent(this));
        a2.a(new JsonObjectParser(this.d));
        a2.a(false);
        HttpResponse p = a2.p();
        if (p.c()) {
            return p;
        }
        throw TokenResponseException.from(this.d, p);
    }

    public TokenResponse b() throws IOException {
        return (TokenResponse) a().a(TokenResponse.class);
    }

    @Override // com.google.api.client.util.GenericData
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public TokenRequest set(String str, Object obj) {
        return (TokenRequest) super.set(str, obj);
    }
}
