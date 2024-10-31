package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth;

/* loaded from: classes.dex */
public final class CredentialsOptions extends Auth.AuthCredentialsOptions {

    /* renamed from: d */
    public static final CredentialsOptions f10513d = (CredentialsOptions) new Builder().a();

    /* loaded from: classes.dex */
    public static final class Builder extends Auth.AuthCredentialsOptions.Builder {
        @Override // com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder
        /* renamed from: b */
        public final CredentialsOptions a() {
            return new CredentialsOptions(this);
        }
    }

    private CredentialsOptions(Builder builder) {
        super(builder);
    }

    /* synthetic */ CredentialsOptions(Builder builder, c cVar) {
        this(builder);
    }
}
