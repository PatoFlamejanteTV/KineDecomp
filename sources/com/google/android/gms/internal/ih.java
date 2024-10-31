package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.PanoramaApi;

/* loaded from: classes2.dex */
class ih implements PanoramaApi.PanoramaResult {

    /* renamed from: a, reason: collision with root package name */
    private final Status f1624a;
    private final Intent b;

    public ih(Status status, Intent intent) {
        this.f1624a = (Status) com.google.android.gms.common.internal.zzx.a(status);
        this.b = intent;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f1624a;
    }
}
