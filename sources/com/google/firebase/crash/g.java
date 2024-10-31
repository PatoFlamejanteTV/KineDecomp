package com.google.firebase.crash;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.crash.zzk;
import com.google.android.gms.internal.crash.zzm;
import com.google.android.gms.internal.crash.zzo;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Future f16622a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ long f16623b = 10000;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ i f16624c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzf f16625d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zzf zzfVar, Future future, long j, i iVar) {
        this.f16625d = zzfVar;
        this.f16622a = future;
        this.f16624c = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzm zzmVar;
        Context context;
        FirebaseApp firebaseApp;
        Context context2;
        Context context3;
        boolean z = true;
        try {
            zzmVar = (zzm) this.f16622a.get(this.f16623b, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            Log.e("FirebaseCrash", "Failed to load crash reporting in time", e2);
            this.f16622a.cancel(true);
            zzmVar = null;
        }
        if (zzmVar == null) {
            this.f16624c.zzi();
            return;
        }
        try {
            firebaseApp = this.f16625d.f16626a;
            FirebaseOptions e3 = firebaseApp.e();
            zzk zzkVar = new zzk(e3.b(), e3.a());
            context2 = this.f16625d.f16627b;
            zzmVar.zza(ObjectWrapper.a(context2), zzkVar);
            zzmVar.zza(new ArrayList());
            context3 = this.f16625d.f16627b;
            BackgroundDetector.a((Application) context3.getApplicationContext());
            if (BackgroundDetector.a().b()) {
                z = false;
            }
            zzmVar.zza(z);
            BackgroundDetector.a().a(new h(this));
            String valueOf = String.valueOf(zzo.zzl());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
            sb.append("FirebaseCrash reporting initialized ");
            sb.append(valueOf);
            Log.i("FirebaseCrash", sb.toString());
            this.f16624c.a(zzmVar);
        } catch (Exception e4) {
            Log.e("FirebaseCrash", "Failed to initialize crash reporting", e4);
            context = this.f16625d.f16627b;
            CrashUtils.a(context, e4);
            this.f16624c.zzi();
        }
    }
}
