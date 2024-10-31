package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzc {

    /* renamed from: a, reason: collision with root package name */
    private final zzf f2077a;
    private final zzmn b;
    private boolean c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private boolean i;
    private final Map<Class<? extends zze>, zze> j;
    private final List<zzi> k;

    zzc(zzc zzcVar) {
        this.f2077a = zzcVar.f2077a;
        this.b = zzcVar.b;
        this.d = zzcVar.d;
        this.e = zzcVar.e;
        this.f = zzcVar.f;
        this.g = zzcVar.g;
        this.h = zzcVar.h;
        this.k = new ArrayList(zzcVar.k);
        this.j = new HashMap(zzcVar.j.size());
        for (Map.Entry<Class<? extends zze>, zze> entry : zzcVar.j.entrySet()) {
            zze c = c(entry.getKey());
            entry.getValue().zza(c);
            this.j.put(entry.getKey(), c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(zzf zzfVar, zzmn zzmnVar) {
        zzx.a(zzfVar);
        zzx.a(zzmnVar);
        this.f2077a = zzfVar;
        this.b = zzmnVar;
        this.g = 1800000L;
        this.h = 3024000000L;
        this.j = new HashMap();
        this.k = new ArrayList();
    }

    private static <T extends zze> T c(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e);
        } catch (InstantiationException e2) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e2);
        }
    }

    public zzc a() {
        return new zzc(this);
    }

    public <T extends zze> T a(Class<T> cls) {
        return (T) this.j.get(cls);
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(zze zzeVar) {
        zzx.a(zzeVar);
        Class<?> cls = zzeVar.getClass();
        if (cls.getSuperclass() != zze.class) {
            throw new IllegalArgumentException();
        }
        zzeVar.zza(b(cls));
    }

    public <T extends zze> T b(Class<T> cls) {
        T t = (T) this.j.get(cls);
        if (t != null) {
            return t;
        }
        T t2 = (T) c(cls);
        this.j.put(cls, t2);
        return t2;
    }

    public Collection<zze> b() {
        return this.j.values();
    }

    public List<zzi> c() {
        return this.k;
    }

    public long d() {
        return this.d;
    }

    public void e() {
        i().a(this);
    }

    public boolean f() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f = this.b.elapsedRealtime();
        if (this.e != 0) {
            this.d = this.e;
        } else {
            this.d = this.b.currentTimeMillis();
        }
        this.c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf h() {
        return this.f2077a;
    }

    zzg i() {
        return this.f2077a.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        this.i = true;
    }
}
