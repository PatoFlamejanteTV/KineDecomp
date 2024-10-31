package com.google.android.gms.signin.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.signin.internal.zzi;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f2196a;
    final /* synthetic */ String b;
    final /* synthetic */ zzf c;
    final /* synthetic */ zzi.a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zzi.a aVar, List list, String str, zzf zzfVar) {
        this.d = aVar;
        this.f2196a = list;
        this.b = str;
        this.c = zzfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GoogleApiClient.ServerAuthCodeCallbacks a2;
        try {
            a2 = this.d.a();
            GoogleApiClient.ServerAuthCodeCallbacks.CheckResult a3 = a2.a(this.b, Collections.unmodifiableSet(new HashSet(this.f2196a)));
            this.c.a(new CheckServerAuthResult(a3.a(), a3.b()));
        } catch (RemoteException e) {
            Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", e);
        }
    }
}
