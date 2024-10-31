package com.google.firebase.crash;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.internal.crash.zzm;
import com.google.android.gms.internal.crash.zzo;
import com.google.android.gms.internal.crash.zzp;
import com.google.android.gms.internal.crash.zzs;
import com.google.firebase.FirebaseApp;

/* loaded from: classes2.dex */
public final class zzf {

    /* renamed from: a */
    private final FirebaseApp f16626a;

    /* renamed from: b */
    private final Context f16627b;

    public zzf(FirebaseApp firebaseApp) {
        this.f16627b = firebaseApp.b();
        this.f16626a = firebaseApp;
    }

    public final zzm a() {
        zzs.initialize(this.f16627b);
        zzm zzmVar = null;
        if (zzs.zzap.a().booleanValue()) {
            try {
                zzo.zzl().init(this.f16627b);
                zzmVar = zzo.zzl().zzm();
                String valueOf = String.valueOf(zzo.zzl());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 33);
                sb.append("FirebaseCrash reporting loaded - ");
                sb.append(valueOf);
                Log.i("FirebaseCrash", sb.toString());
                return zzmVar;
            } catch (zzp e2) {
                Log.e("FirebaseCrash", "Failed to load crash reporting", e2);
                CrashUtils.a(this.f16627b, e2);
                return zzmVar;
            }
        }
        Log.w("FirebaseCrash", "Crash reporting is disabled");
        return null;
    }
}
