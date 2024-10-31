package com.nexstreaming.app.general.iab.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.a.a.a.a;
import com.nexstreaming.app.general.iab.IABHelper;

/* compiled from: GoogleIABHelper.java */
/* loaded from: classes.dex */
class b implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABHelper.e f3144a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IABHelper.e eVar) {
        this.b = aVar;
        this.f3144a = eVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        obj = this.b.i;
        synchronized (obj) {
            this.b.g = a.AbstractBinderC0023a.a(iBinder);
        }
        this.f3144a.a(true, 0);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Object obj;
        obj = this.b.i;
        synchronized (obj) {
            this.b.g = null;
        }
    }
}
