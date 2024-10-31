package com.google.api.client.googleapis.testing.compute;

import com.facebook.AccessToken;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import java.io.IOException;

/* compiled from: MockMetadataServerTransport.java */
/* loaded from: classes2.dex */
class a extends MockLowLevelHttpRequest {

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ MockMetadataServerTransport f14720h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MockMetadataServerTransport mockMetadataServerTransport, String str) {
        super(str);
        this.f14720h = mockMetadataServerTransport;
    }

    @Override // com.google.api.client.testing.http.MockLowLevelHttpRequest, com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse a() throws IOException {
        if (this.f14720h.f14719h != null) {
            return new MockLowLevelHttpResponse().c(this.f14720h.f14719h.intValue()).a("Token Fetch Error");
        }
        if ("Google".equals(c("Metadata-Flavor"))) {
            GenericJson genericJson = new GenericJson();
            genericJson.setFactory(MockMetadataServerTransport.f14717f);
            genericJson.put("access_token", (Object) this.f14720h.f14718g);
            genericJson.put(AccessToken.EXPIRES_IN_KEY, (Object) 3600000);
            genericJson.put("token_type", (Object) "Bearer");
            return new MockLowLevelHttpResponse().b("application/json; charset=UTF-8").a(genericJson.toPrettyString());
        }
        throw new IOException("Metadata request header not found.");
    }
}
