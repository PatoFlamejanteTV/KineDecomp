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
/* loaded from: classes2.dex */
class a extends MockLowLevelHttpRequest {

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ MockTokenServerTransport f14714h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MockTokenServerTransport mockTokenServerTransport, String str) {
        super(str);
        this.f14714h = mockTokenServerTransport;
    }

    @Override // com.google.api.client.testing.http.MockLowLevelHttpRequest, com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse a() throws IOException {
        String str;
        Map<String, String> a2 = TestUtils.a(f());
        String str2 = a2.get("client_id");
        if (str2 != null) {
            if (this.f14714h.f14712g.containsKey(str2)) {
                String str3 = a2.get("client_secret");
                String str4 = this.f14714h.f14712g.get(str2);
                if (str3 != null && str3.equals(str4)) {
                    String str5 = a2.get("refresh_token");
                    if (this.f14714h.f14713h.containsKey(str5)) {
                        str = this.f14714h.f14713h.get(str5);
                    } else {
                        throw new IOException("Refresh Token not found.");
                    }
                } else {
                    throw new IOException("Client secret not found.");
                }
            } else {
                throw new IOException("Client ID not found.");
            }
        } else if (a2.containsKey("grant_type")) {
            if ("urn:ietf:params:oauth:grant-type:jwt-bearer".equals(a2.get("grant_type"))) {
                JsonWebSignature a3 = JsonWebSignature.a(MockTokenServerTransport.f14709d, a2.get("assertion"));
                String issuer = a3.b().getIssuer();
                if (this.f14714h.f14711f.containsKey(issuer)) {
                    String str6 = this.f14714h.f14711f.get(issuer);
                    String str7 = (String) a3.b().get("scope");
                    if (str7 == null || str7.length() == 0) {
                        throw new IOException("Scopes not found.");
                    }
                    str = str6;
                } else {
                    throw new IOException("Service Account Email not found as issuer.");
                }
            } else {
                throw new IOException("Unexpected Grant Type.");
            }
        } else {
            throw new IOException("Unknown token type.");
        }
        GenericJson genericJson = new GenericJson();
        genericJson.setFactory(MockTokenServerTransport.f14709d);
        genericJson.put("access_token", (Object) str);
        genericJson.put(AccessToken.EXPIRES_IN_KEY, (Object) 3600000);
        genericJson.put("token_type", (Object) "Bearer");
        return new MockLowLevelHttpResponse().b("application/json; charset=UTF-8").a(genericJson.toPrettyString());
    }
}
