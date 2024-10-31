package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzab f2030a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(zzab zzabVar) {
        this.f2030a = zzabVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
