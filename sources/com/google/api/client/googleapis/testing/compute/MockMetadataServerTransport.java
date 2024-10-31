package com.google.api.client.googleapis.testing.compute;

import com.google.api.client.googleapis.auth.oauth2.OAuth2Utils;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
/* loaded from: classes2.dex */
public class MockMetadataServerTransport extends MockHttpTransport {

    /* renamed from: d, reason: collision with root package name */
    private static final String f14715d = OAuth2Utils.a();

    /* renamed from: e, reason: collision with root package name */
    private static final String f14716e = f14715d + "/computeMetadata/v1/instance/service-accounts/default/token";

    /* renamed from: f, reason: collision with root package name */
    static final JsonFactory f14717f = new JacksonFactory();

    /* renamed from: g, reason: collision with root package name */
    String f14718g;

    /* renamed from: h, reason: collision with root package name */
    Integer f14719h;

    @Override // com.google.api.client.testing.http.MockHttpTransport, com.google.api.client.http.HttpTransport
    public LowLevelHttpRequest buildRequest(String str, String str2) throws IOException {
        if (str2.equals(f14716e)) {
            return new a(this, str2);
        }
        if (str2.equals(f14715d)) {
            return new b(this, str2);
        }
        return super.buildRequest(str, str2);
    }
}
