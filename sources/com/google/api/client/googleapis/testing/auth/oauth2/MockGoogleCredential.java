package com.google.api.client.googleapis.testing.auth.oauth2;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes.dex */
public class MockGoogleCredential extends GoogleCredential {
    private static final String b = String.format("{\"access_token\": \"%s\", \"expires_in\":  %s, \"refresh_token\": \"%s\", \"token_type\": \"%s\"}", "access_xyz", "3600", "refresh123", "Bearer");

    @Beta
    /* loaded from: classes.dex */
    public static class Builder extends GoogleCredential.Builder {
    }
}
