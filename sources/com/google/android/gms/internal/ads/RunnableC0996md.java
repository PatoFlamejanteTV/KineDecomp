package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.md, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC0996md implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f12324a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbcl f12325b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0996md(zzaxc zzaxcVar, Context context, zzbcl zzbclVar) {
        this.f12324a = context;
        this.f12325b = zzbclVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f12325b.set(AdvertisingIdClient.getAdvertisingIdInfo(this.f12324a));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            this.f12325b.setException(e2);
            zzbbd.zzb("Exception while getting advertising Id info", e2);
        }
    }
}
