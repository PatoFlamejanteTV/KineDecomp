package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
@Deprecated
/* loaded from: classes2.dex */
public final class CredentialStoreRefreshListener implements CredentialRefreshListener {

    /* renamed from: a, reason: collision with root package name */
    private final CredentialStore f14611a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14612b;

    @Override // com.google.api.client.auth.oauth2.CredentialRefreshListener
    public void a(Credential credential, TokenResponse tokenResponse) throws IOException {
        a(credential);
    }

    @Override // com.google.api.client.auth.oauth2.CredentialRefreshListener
    public void a(Credential credential, TokenErrorResponse tokenErrorResponse) throws IOException {
        a(credential);
    }

    public void a(Credential credential) throws IOException {
        this.f14611a.a(this.f14612b, credential);
    }
}
