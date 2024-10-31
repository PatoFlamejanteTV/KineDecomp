package com.google.api.client.auth.oauth;

import com.google.api.client.util.Beta;
import java.security.GeneralSecurityException;

@Beta
/* loaded from: classes2.dex */
public interface OAuthSigner {
    String a();

    String a(String str) throws GeneralSecurityException;
}
