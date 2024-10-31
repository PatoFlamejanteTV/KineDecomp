package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzayf;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzcq;
import com.google.android.gms.internal.ads.zzct;
import com.google.android.gms.internal.ads.zzwu;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzark
/* loaded from: classes.dex */
public final class zzag implements zzcq, Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final List<Object[]> f10176a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<zzcq> f10177b;

    /* renamed from: c, reason: collision with root package name */
    private Context f10178c;

    /* renamed from: d, reason: collision with root package name */
    private zzbbi f10179d;

    /* renamed from: e, reason: collision with root package name */
    private CountDownLatch f10180e;

    public zzag(zzbw zzbwVar) {
        this(zzbwVar.f10251c, zzbwVar.f10253e);
    }

    private static Context a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private final boolean b() {
        try {
            this.f10180e.await();
            return true;
        } catch (InterruptedException e2) {
            zzbbd.zzc("Interrupted during GADSignals creation.", e2);
            return false;
        }
    }

    private final void c() {
        if (this.f10176a.isEmpty()) {
            return;
        }
        for (Object[] objArr : this.f10176a) {
            if (objArr.length == 1) {
                this.f10177b.get().zza((MotionEvent) objArr[0]);
            } else if (objArr.length == 3) {
                this.f10177b.get().zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.f10176a.clear();
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.f10179d.zzeow;
            if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcrq)).booleanValue() && z2) {
                z = true;
            }
            this.f10177b.set(zzct.zza(this.f10179d.zzdp, a(this.f10178c), z));
        } finally {
            this.f10180e.countDown();
            this.f10178c = null;
            this.f10179d = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final String zza(Context context) {
        zzcq zzcqVar;
        if (!b() || (zzcqVar = this.f10177b.get()) == null) {
            return "";
        }
        c();
        return zzcqVar.zza(a(context));
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final void zzb(View view) {
        zzcq zzcqVar = this.f10177b.get();
        if (zzcqVar != null) {
            zzcqVar.zzb(view);
        }
    }

    private zzag(Context context, zzbbi zzbbiVar) {
        this.f10176a = new Vector();
        this.f10177b = new AtomicReference<>();
        this.f10180e = new CountDownLatch(1);
        this.f10178c = context;
        this.f10179d = zzbbiVar;
        zzwu.zzpv();
        if (zzbat.zzaar()) {
            zzayf.zzc(this);
        } else {
            run();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final String zza(Context context, String str, View view, Activity activity) {
        zzcq zzcqVar;
        if (!b() || (zzcqVar = this.f10177b.get()) == null) {
            return "";
        }
        c();
        return zzcqVar.zza(a(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final void zza(MotionEvent motionEvent) {
        zzcq zzcqVar = this.f10177b.get();
        if (zzcqVar != null) {
            c();
            zzcqVar.zza(motionEvent);
        } else {
            this.f10176a.add(new Object[]{motionEvent});
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final void zza(int i, int i2, int i3) {
        zzcq zzcqVar = this.f10177b.get();
        if (zzcqVar != null) {
            c();
            zzcqVar.zza(i, i2, i3);
        } else {
            this.f10176a.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
    }
}
