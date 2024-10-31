package com.google.api.client.googleapis.testing.compute;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
/* loaded from: classes.dex */
public class MockMetadataServerTransport extends MockHttpTransport {

    /* renamed from: a, reason: collision with root package name */
    static final JsonFactory f2446a = new JacksonFactory();
    String b;
    Integer c;

    @Override // com.google.api.client.testing.http.MockHttpTransport, com.google.api.client.http.HttpTransport
    public LowLevelHttpRequest buildRequest(String str, String str2) throws IOException {
        if (str2.equals("http://metadata/computeMetadata/v1/instance/service-accounts/default/token")) {
            return new a(this, str2);
        }
        if (str2.equals("http://metadata.google.internal")) {
            return new b(this, str2);
        }
        return super.buildRequest(str, str2);
    }
}
