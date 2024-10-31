package com.google.api.client.auth.oauth2;

import java.io.IOException;

/* loaded from: classes.dex */
public interface CredentialRefreshListener {
    void a(Credential credential, TokenErrorResponse tokenErrorResponse) throws IOException;

    void a(Credential credential, TokenResponse tokenResponse) throws IOException;
}
