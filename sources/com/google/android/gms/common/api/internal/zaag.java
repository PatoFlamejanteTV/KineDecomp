package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class zaag extends GoogleApiClient {

    /* renamed from: b, reason: collision with root package name */
    private final String f10869b;

    public zaag(String str) {
        this.f10869b = str;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult a() {
        throw new UnsupportedOperationException(this.f10869b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public PendingResult<Status> b() {
        throw new UnsupportedOperationException(this.f10869b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void c() {
        throw new UnsupportedOperationException(this.f10869b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void d() {
        throw new UnsupportedOperationException(this.f10869b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void a(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.f10869b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void b(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.f10869b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.f10869b);
    }
}
