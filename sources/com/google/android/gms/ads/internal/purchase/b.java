package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzp;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f610a;
    final /* synthetic */ zzi b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzi zziVar, Context context) {
        this.b = zziVar;
        this.f610a = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzb zzbVar = new zzb(this.f610a.getApplicationContext(), false);
        zzbVar.a(iBinder);
        zzp.h().zzB(zzbVar.a(3, this.f610a.getPackageName(), "inapp") == 0);
        this.f610a.unbindService(this);
        zzbVar.a();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
