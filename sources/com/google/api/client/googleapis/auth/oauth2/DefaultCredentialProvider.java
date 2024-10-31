package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes2.dex */
class DefaultCredentialProvider extends a {

    /* renamed from: b */
    private GoogleCredential f14649b = null;

    /* renamed from: c */
    private Environment f14650c = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum Environment {
        UNKNOWN,
        ENVIRONMENT_VARIABLE,
        WELL_KNOWN_FILE,
        CLOUD_SHELL,
        APP_ENGINE,
        COMPUTE_ENGINE
    }
}
