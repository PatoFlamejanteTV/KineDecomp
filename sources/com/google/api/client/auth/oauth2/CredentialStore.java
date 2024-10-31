package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
@Deprecated
/* loaded from: classes2.dex */
public interface CredentialStore {
    void a(String str, Credential credential) throws IOException;
}
