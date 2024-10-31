package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile zzm f10672a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f10673b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static Context f10674c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (f10674c != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f10674c = context.getApplicationContext();
            }
        }
    }

    private static i b(final String str, final c cVar, final boolean z, boolean z2) {
        try {
            if (f10672a == null) {
                Preconditions.a(f10674c);
                synchronized (f10673b) {
                    if (f10672a == null) {
                        f10672a = zzn.a(DynamiteModule.a(f10674c, DynamiteModule.k, "com.google.android.gms.googlecertificates").a("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            Preconditions.a(f10674c);
            try {
                if (f10672a.a(new zzk(str, cVar, z, z2), ObjectWrapper.a(f10674c.getPackageManager()))) {
                    return i.b();
                }
                return i.a((Callable<String>) new Callable(z, str, cVar) { // from class: com.google.android.gms.common.b

                    /* renamed from: a, reason: collision with root package name */
                    private final boolean f10978a;

                    /* renamed from: b, reason: collision with root package name */
                    private final String f10979b;

                    /* renamed from: c, reason: collision with root package name */
                    private final c f10980c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f10978a = z;
                        this.f10979b = str;
                        this.f10980c = cVar;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        String a2;
                        a2 = i.a(this.f10979b, this.f10980c, this.f10978a, !r3 && a.b(r4, r5, true, false).f11025b);
                        return a2;
                    }
                });
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return i.a("module call", e2);
            }
        } catch (DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            String valueOf = String.valueOf(e3.getMessage());
            return i.a(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i a(String str, c cVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return b(str, cVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
