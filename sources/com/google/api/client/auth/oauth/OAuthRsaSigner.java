package com.google.api.client.auth.oauth;

import com.google.api.client.util.Base64;
import com.google.api.client.util.Beta;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.StringUtils;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;

@Beta
/* loaded from: classes2.dex */
public final class OAuthRsaSigner implements OAuthSigner {

    /* renamed from: a */
    public PrivateKey f14591a;

    @Override // com.google.api.client.auth.oauth.OAuthSigner
    public String a() {
        return "RSA-SHA1";
    }

    @Override // com.google.api.client.auth.oauth.OAuthSigner
    public String a(String str) throws GeneralSecurityException {
        return Base64.b(SecurityUtils.a(SecurityUtils.b(), this.f14591a, StringUtils.a(str)));
    }
}
