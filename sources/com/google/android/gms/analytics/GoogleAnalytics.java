package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzap;
import com.google.android.gms.internal.gtm.zzda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@VisibleForTesting
/* loaded from: classes.dex */
public final class GoogleAnalytics extends zza {

    /* renamed from: f, reason: collision with root package name */
    private static List<Runnable> f10327f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private boolean f10328g;

    /* renamed from: h, reason: collision with root package name */
    private Set<a> f10329h;
    private boolean i;
    private volatile boolean j;

    /* loaded from: classes.dex */
    interface a {
    }

    @VisibleForTesting
    public GoogleAnalytics(zzap zzapVar) {
        super(zzapVar);
        this.f10329h = new HashSet();
    }

    public static GoogleAnalytics a(Context context) {
        return zzap.zzc(context).zzde();
    }

    public static void i() {
        synchronized (GoogleAnalytics.class) {
            if (f10327f != null) {
                Iterator<Runnable> it = f10327f.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                f10327f = null;
            }
        }
    }

    public final void b(boolean z) {
        this.i = z;
    }

    public final void d() {
        b().zzcs().zzci();
    }

    public final boolean e() {
        return this.j;
    }

    public final boolean f() {
        return this.i;
    }

    public final boolean g() {
        return this.f10328g;
    }

    public final void h() {
        zzda zzcu = b().zzcu();
        zzcu.zzgh();
        if (zzcu.zzgi()) {
            b(zzcu.zzgj());
        }
        zzcu.zzgh();
        this.f10328g = true;
    }
}
