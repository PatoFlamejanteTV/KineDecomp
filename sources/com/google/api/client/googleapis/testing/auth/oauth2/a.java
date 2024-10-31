package com.google.api.client.googleapis.testing.auth.oauth2;

import com.facebook.AccessToken;
import com.google.api.client.googleapis.testing.TestUtils;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import java.io.IOException;
import java.util.Map;

/* compiled from: MockTokenServerTransport.java */
/* loaded from: classes.dex */
class a extends MockLowLevelHttpRequest {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MockTokenServerTransport f2445a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MockTokenServerTransport mockTokenServerTransport, String str) {
        super(str);
        this.f2445a = mockTokenServerTransport;
    }

    @Override // com.google.api.client.testing.http.MockLowLevelHttpRequest, com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse a() throws IOException {
        String str;
        Map<String, String> a2 = TestUtils.a(f());
        String str2 = a2.get("client_id");
        if (str2 != null) {
            if (!this.f2445a.c.containsKey(str2)) {
                throw new IOException("Client ID not found.");
            }
            String str3 = a2.get("client_secret");
            String str4 = this.f2445a.c.get(str2);
            if (str3 == null || !str3.equals(str4)) {
                throw new IOException("Client secret not found.");
            }
            String str5 = a2.get("refresh_token");
            if (!this.f2445a.d.containsKey(str5)) {
                throw new IOException("Refresh Token not found.");
            }
            str = this.f2445a.d.get(str5);
        } else if (a2.containsKey("grant_type")) {
            if (!"urn:ietf:params:oauth:grant-type:jwt-bearer".equals(a2.get("grant_type"))) {
                throw new IOException("Unexpected Grant Type.");
            }
            JsonWebSignature c = JsonWebSignature.c(MockTokenServerTransport.f2444a, a2.get("assertion"));
            String issuer = c.b().getIssuer();
            if (!this.f2445a.b.containsKey(issuer)) {
                throw new IOException("Service Account Email not found as issuer.");
            }
            str = this.f2445a.b.get(issuer);
            String str6 = (String) c.b().get("scope");
            if (str6 == null || str6.length() == 0) {
                throw new IOException("Scopes not found.");
            }
        } else {
            throw new IOException("Uknown token type.");
        }
        GenericJson genericJson = new GenericJson();
        genericJson.setFactory(MockTokenServerTransport.f2444a);
        genericJson.put("access_token", (Object) str);
        genericJson.put(AccessToken.EXPIRES_IN_KEY, (Object) 3600000);
        genericJson.put("token_type", (Object) "Bearer");
        return new MockLowLevelHttpResponse().b("application/json; charset=UTF-8").a(genericJson.toPrettyString());
    }
}
