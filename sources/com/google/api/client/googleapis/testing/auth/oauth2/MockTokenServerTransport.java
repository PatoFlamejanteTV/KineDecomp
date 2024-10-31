package com.google.api.client.googleapis.testing.auth.oauth2;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Beta
/* loaded from: classes2.dex */
public class MockTokenServerTransport extends MockHttpTransport {

    /* renamed from: d, reason: collision with root package name */
    static final JsonFactory f14709d = new JacksonFactory();

    /* renamed from: e, reason: collision with root package name */
    final String f14710e;

    /* renamed from: f, reason: collision with root package name */
    Map<String, String> f14711f;

    /* renamed from: g, reason: collision with root package name */
    Map<String, String> f14712g;

    /* renamed from: h, reason: collision with root package name */
    Map<String, String> f14713h;

    public MockTokenServerTransport() {
        this("https://oauth2.googleapis.com/token");
    }

    @Override // com.google.api.client.testing.http.MockHttpTransport, com.google.api.client.http.HttpTransport
    public LowLevelHttpRequest buildRequest(String str, String str2) throws IOException {
        if (str2.equals(this.f14710e)) {
            return new a(this, str2);
        }
        return super.buildRequest(str, str2);
    }

    public MockTokenServerTransport(String str) {
        this.f14711f = new HashMap();
        this.f14712g = new HashMap();
        this.f14713h = new HashMap();
        this.f14710e = str;
    }
}
