package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import com.google.api.client.util.store.DataStore;
import java.io.IOException;

@Beta
/* loaded from: classes.dex */
public final class DataStoreCredentialRefreshListener implements CredentialRefreshListener {

    /* renamed from: a, reason: collision with root package name */
    private final DataStore<StoredCredential> f2413a;
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
        this.f2413a.a(this.b, new StoredCredential(credential));
    }
}
