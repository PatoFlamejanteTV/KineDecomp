package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzv;

/* loaded from: classes2.dex */
public final class zzbk implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final String f13964a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbj f13965b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbk(zzbj zzbjVar, String str) {
        this.f13965b = zzbjVar;
        this.f13964a = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f13965b.f13963a.b().t().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.zzu zza = zzv.zza(iBinder);
            if (zza == null) {
                this.f13965b.f13963a.b().t().a("Install Referrer Service implementation was not found");
            } else {
                this.f13965b.f13963a.b().w().a("Install Referrer Service connected");
                this.f13965b.f13963a.zzgs().a(new RunnableC1432o(this, zza, this));
            }
        } catch (Exception e2) {
            this.f13965b.f13963a.b().t().a("Exception occurred while calling Install Referrer API", e2);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f13965b.f13963a.b().w().a("Install Referrer Service disconnected");
    }
}
