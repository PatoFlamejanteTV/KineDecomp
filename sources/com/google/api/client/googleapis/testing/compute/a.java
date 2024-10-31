package com.google.api.client.googleapis.testing.compute;

import com.facebook.AccessToken;
import com.facebook.internal.ServerProtocol;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import java.io.IOException;

/* compiled from: MockMetadataServerTransport.java */
/* loaded from: classes.dex */
class a extends MockLowLevelHttpRequest {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MockMetadataServerTransport f2447a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MockMetadataServerTransport mockMetadataServerTransport, String str) {
        super(str);
        this.f2447a = mockMetadataServerTransport;
    }

    @Override // com.google.api.client.testing.http.MockLowLevelHttpRequest, com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse a() throws IOException {
        if (this.f2447a.c != null) {
            return new MockLowLevelHttpResponse().c(this.f2447a.c.intValue()).a("Token Fetch Error");
        }
        if (!ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(c("X-Google-Metadata-Request"))) {
            throw new IOException("Metadata request header not found.");
        }
        GenericJson genericJson = new GenericJson();
        genericJson.setFactory(MockMetadataServerTransport.f2446a);
        genericJson.put("access_token", (Object) this.f2447a.b);
        genericJson.put(AccessToken.EXPIRES_IN_KEY, (Object) 3600000);
        genericJson.put("token_type", (Object) "Bearer");
        return new MockLowLevelHttpResponse().b("application/json; charset=UTF-8").a(genericJson.toPrettyString());
    }
}
