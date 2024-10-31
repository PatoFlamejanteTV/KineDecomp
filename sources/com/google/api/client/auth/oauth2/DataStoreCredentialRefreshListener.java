package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import com.google.api.client.util.store.DataStore;
import java.io.IOException;

@Beta
/* loaded from: classes2.dex */
public final class DataStoreCredentialRefreshListener implements CredentialRefreshListener {

    /* renamed from: a, reason: collision with root package name */
    private final DataStore<StoredCredential> f14613a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14614b;

    @Override // com.google.api.client.auth.oauth2.CredentialRefreshListener
    public void a(Credential credential, TokenResponse tokenResponse) throws IOException {
        a(credential);
    }

    @Override // com.google.api.client.auth.oauth2.CredentialRefreshListener
    public void a(Credential credential, TokenErrorResponse tokenErrorResponse) throws IOException {
        a(credential);
    }

    public void a(Credential credential) throws IOException {
        this.f14613a.a(this.f14614b, new StoredCredential(credential));
    }
}
