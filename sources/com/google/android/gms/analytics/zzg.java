package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzg {

    /* renamed from: a */
    private final zzj f10363a;

    /* renamed from: b */
    private final Clock f10364b;

    /* renamed from: c */
    private boolean f10365c;

    /* renamed from: d */
    private long f10366d;

    /* renamed from: e */
    private long f10367e;

    /* renamed from: f */
    private long f10368f;

    /* renamed from: g */
    private long f10369g;

    /* renamed from: h */
    private long f10370h;
    private boolean i;
    private final Map<Class<? extends zzi>, zzi> j;
    private final List<zzo> k;

    @VisibleForTesting
    public zzg(zzj zzjVar, Clock clock) {
        Preconditions.a(zzjVar);
        Preconditions.a(clock);
        this.f10363a = zzjVar;
        this.f10364b = clock;
        this.f10369g = 1800000L;
        this.f10370h = 3024000000L;
        this.j = new HashMap();
        this.k = new ArrayList();
    }

    @VisibleForTesting
    public final zzg a() {
        return new zzg(this);
    }

    @VisibleForTesting
    public final <T extends zzi> T b(Class<T> cls) {
        T t = (T) this.j.get(cls);
        if (t != null) {
            return t;
        }
        T t2 = (T) c(cls);
        this.j.put(cls, t2);
        return t2;
    }

    public final List<zzo> c() {
        return this.k;
    }

    @VisibleForTesting
    public final long d() {
        return this.f10366d;
    }

    @VisibleForTesting
    public final void e() {
        this.f10363a.a().a(this);
    }

    @VisibleForTesting
    public final boolean f() {
        return this.f10365c;
    }

    @VisibleForTesting
    public final void g() {
        this.f10368f = this.f10364b.c();
        long j = this.f10367e;
        if (j != 0) {
            this.f10366d = j;
        } else {
            this.f10366d = this.f10364b.a();
        }
        this.f10365c = true;
    }

    public final zzj h() {
        return this.f10363a;
    }

    @VisibleForTesting
    public final boolean i() {
        return this.i;
    }

    @VisibleForTesting
    public final void j() {
        this.i = true;
    }

    @TargetApi(19)
    private static <T extends zzi> T c(Class<T> cls) {
        try {
            return cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            if (!(e2 instanceof InstantiationException)) {
                if (!(e2 instanceof IllegalAccessException)) {
                    if (Build.VERSION.SDK_INT >= 19 && (e2 instanceof ReflectiveOperationException)) {
                        throw new IllegalArgumentException("Linkage exception", e2);
                    }
                    throw new RuntimeException(e2);
                }
                throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
            }
            throw new IllegalArgumentException("dataType doesn't have default constructor", e2);
        }
    }

    @VisibleForTesting
    public final void a(zzi zziVar) {
        Preconditions.a(zziVar);
        Class<?> cls = zziVar.getClass();
        if (cls.getSuperclass() == zzi.class) {
            zziVar.zzb(b(cls));
            return;
        }
        throw new IllegalArgumentException();
    }

    @VisibleForTesting
    public final Collection<zzi> b() {
        return this.j.values();
    }

    @VisibleForTesting
    public final <T extends zzi> T a(Class<T> cls) {
        return (T) this.j.get(cls);
    }

    @VisibleForTesting
    public final void a(long j) {
        this.f10367e = j;
    }

    private zzg(zzg zzgVar) {
        this.f10363a = zzgVar.f10363a;
        this.f10364b = zzgVar.f10364b;
        this.f10366d = zzgVar.f10366d;
        this.f10367e = zzgVar.f10367e;
        this.f10368f = zzgVar.f10368f;
        this.f10369g = zzgVar.f10369g;
        this.f10370h = zzgVar.f10370h;
        this.k = new ArrayList(zzgVar.k);
        this.j = new HashMap(zzgVar.j.size());
        for (Map.Entry<Class<? extends zzi>, zzi> entry : zzgVar.j.entrySet()) {
            zzi c2 = c(entry.getKey());
            entry.getValue().zzb(c2);
            this.j.put(entry.getKey(), c2);
        }
    }
}
