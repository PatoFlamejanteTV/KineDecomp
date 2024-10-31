package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
@Deprecated
/* loaded from: classes.dex */
public final class CredentialStoreRefreshListener implements CredentialRefreshListener {

    /* renamed from: a, reason: collision with root package name */
    private final CredentialStore f2412a;
    private final String b;

    @Override // com.google.api.client.auth.oauth2.CredentialRefreshListener
    public void a(Credential credential, TokenResponse tokenResponse) throws IOException {
        a(credential);
    }

    @Override // com.google.api.client.auth.oauth2.CredentialRefreshListener
    public void a(Credential credential, TokenErrorResponse tokenErrorResponse) throws IOException {
        a(credential);
    }

    public void a(Credential credential) throws IOException {
        this.f2412a.a(this.b, credential);
    }
}
