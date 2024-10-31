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
/* loaded from: classes.dex */
public class MockTokenServerTransport extends MockHttpTransport {

    /* renamed from: a, reason: collision with root package name */
    static final JsonFactory f2444a = new JacksonFactory();
    Map<String, String> b = new HashMap();
    Map<String, String> c = new HashMap();
    Map<String, String> d = new HashMap();

    @Override // com.google.api.client.testing.http.MockHttpTransport, com.google.api.client.http.HttpTransport
    public LowLevelHttpRequest buildRequest(String str, String str2) throws IOException {
        return str2.equals("https://accounts.google.com/o/oauth2/token") ? new a(this, str2) : super.buildRequest(str, str2);
    }
}
