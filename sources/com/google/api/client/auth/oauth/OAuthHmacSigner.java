package com.google.api.client.auth.oauth;

import com.google.api.client.util.Base64;
import com.google.api.client.util.Beta;
import com.google.api.client.util.StringUtils;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Beta
/* loaded from: classes2.dex */
public final class OAuthHmacSigner implements OAuthSigner {

    /* renamed from: a */
    public String f14579a;

    /* renamed from: b */
    public String f14580b;

    @Override // com.google.api.client.auth.oauth.OAuthSigner
    public String a() {
        return "HMAC-SHA1";
    }

    @Override // com.google.api.client.auth.oauth.OAuthSigner
    public String a(String str) throws GeneralSecurityException {
        StringBuilder sb = new StringBuilder();
        String str2 = this.f14579a;
        if (str2 != null) {
            sb.append(OAuthParameters.a(str2));
        }
        sb.append('&');
        String str3 = this.f14580b;
        if (str3 != null) {
            sb.append(OAuthParameters.a(str3));
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(StringUtils.a(sb.toString()), "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretKeySpec);
        return Base64.b(mac.doFinal(StringUtils.a(str)));
    }
}
