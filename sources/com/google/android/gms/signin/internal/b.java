package com.google.android.gms.signin.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.signin.internal.zzi;

/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f2197a;
    final /* synthetic */ String b;
    final /* synthetic */ zzf c;
    final /* synthetic */ zzi.a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzi.a aVar, String str, String str2, zzf zzfVar) {
        this.d = aVar;
        this.f2197a = str;
        this.b = str2;
        this.c = zzfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GoogleApiClient.ServerAuthCodeCallbacks a2;
        try {
            a2 = this.d.a();
            this.c.a(a2.a(this.f2197a, this.b));
        } catch (RemoteException e) {
            Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", e);
        }
    }
}
