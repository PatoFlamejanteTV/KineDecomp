package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* renamed from: com.google.android.gms.internal.ads.oa */
/* loaded from: classes2.dex */
public final class C1021oa {

    /* renamed from: a */
    private final LinkedList<C1035pa> f12375a;

    /* renamed from: b */
    private zzwb f12376b;

    /* renamed from: c */
    private final String f12377c;

    /* renamed from: d */
    private final int f12378d;

    /* renamed from: e */
    private boolean f12379e;

    public C1021oa(zzwb zzwbVar, String str, int i) {
        Preconditions.a(zzwbVar);
        Preconditions.a(str);
        this.f12375a = new LinkedList<>();
        this.f12376b = zzwbVar;
        this.f12377c = str;
        this.f12378d = i;
    }

    public final String a() {
        return this.f12377c;
    }

    public final int b() {
        return this.f12378d;
    }

    public final int c() {
        return this.f12375a.size();
    }

    public final zzwb d() {
        return this.f12376b;
    }

    public final int e() {
        Iterator<C1035pa> it = this.f12375a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().f12417e) {
                i++;
            }
        }
        return i;
    }

    public final int f() {
        Iterator<C1035pa> it = this.f12375a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().a()) {
                i++;
            }
        }
        return i;
    }

    public final void g() {
        this.f12379e = true;
    }

    public final boolean h() {
        return this.f12379e;
    }

    public final C1035pa a(zzwb zzwbVar) {
        if (zzwbVar != null) {
            this.f12376b = zzwbVar;
        }
        return this.f12375a.remove();
    }

    public final boolean a(zzagi zzagiVar) {
        C1035pa c1035pa = new C1035pa(this, zzagiVar);
        this.f12375a.add(c1035pa);
        return c1035pa.a();
    }

    public final void a(zzagi zzagiVar, zzwb zzwbVar) {
        this.f12375a.add(new C1035pa(this, zzagiVar, zzwbVar));
    }
}
