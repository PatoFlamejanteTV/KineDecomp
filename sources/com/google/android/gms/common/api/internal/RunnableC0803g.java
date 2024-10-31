package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.common.api.internal.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0803g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zaak f10834a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0803g(zaak zaakVar) {
        this.f10834a = zaakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Context context;
        googleApiAvailabilityLight = this.f10834a.f10875d;
        context = this.f10834a.f10874c;
        googleApiAvailabilityLight.a(context);
    }
}
