package com.google.android.gms.analytics.internal;

import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmy;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class zzr {

    /* renamed from: a */
    private final zzf f749a;
    private volatile Boolean b;
    private String c;
    private Set<Integer> d;

    public zzr(zzf zzfVar) {
        com.google.android.gms.common.internal.zzx.a(zzfVar);
        this.f749a = zzfVar;
    }

    public String A() {
        return "google_analytics_v4.db";
    }

    public String B() {
        return "google_analytics2_v4.db";
    }

    public long C() {
        return 86400000L;
    }

    public int D() {
        return zzy.E.a().intValue();
    }

    public int E() {
        return zzy.F.a().intValue();
    }

    public long F() {
        return zzy.G.a().longValue();
    }

    public long G() {
        return zzy.P.a().longValue();
    }

    public boolean a() {
        return com.google.android.gms.common.internal.zzd.f1003a;
    }

    public boolean b() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    ApplicationInfo applicationInfo = this.f749a.b().getApplicationInfo();
                    String zzj = zzmy.zzj(this.f749a.b(), Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.b = Boolean.valueOf(str != null && str.equals(zzj));
                    }
                    if ((this.b == null || !this.b.booleanValue()) && "com.google.android.gms.analytics".equals(zzj)) {
                        this.b = Boolean.TRUE;
                    }
                    if (this.b == null) {
                        this.b = Boolean.TRUE;
                        this.f749a.f().f("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.b.booleanValue();
    }

    public boolean c() {
        return zzy.b.a().booleanValue();
    }

    public int d() {
        return zzy.u.a().intValue();
    }

    public int e() {
        return zzy.y.a().intValue();
    }

    public int f() {
        return zzy.z.a().intValue();
    }

    public int g() {
        return zzy.A.a().intValue();
    }

    public long h() {
        return zzy.j.a().longValue();
    }

    public long i() {
        return zzy.i.a().longValue();
    }

    public long j() {
        return zzy.m.a().longValue();
    }

    public long k() {
        return zzy.n.a().longValue();
    }

    public int l() {
        return zzy.o.a().intValue();
    }

    public int m() {
        return zzy.p.a().intValue();
    }

    public long n() {
        return zzy.C.a().intValue();
    }

    public String o() {
        return zzy.r.a();
    }

    public String p() {
        return zzy.q.a();
    }

    public String q() {
        return zzy.s.a();
    }

    public String r() {
        return zzy.t.a();
    }

    public zzm s() {
        return zzm.zzbj(zzy.v.a());
    }

    public zzo t() {
        return zzo.zzbk(zzy.w.a());
    }

    public Set<Integer> u() {
        String a2 = zzy.B.a();
        if (this.d == null || this.c == null || !this.c.equals(a2)) {
            String[] split = TextUtils.split(a2, ",");
            HashSet hashSet = new HashSet();
            for (String str : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e) {
                }
            }
            this.c = a2;
            this.d = hashSet;
        }
        return this.d;
    }

    public long v() {
        return zzy.K.a().longValue();
    }

    public long w() {
        return zzy.L.a().longValue();
    }

    public long x() {
        return zzy.O.a().longValue();
    }

    public int y() {
        return zzy.f.a().intValue();
    }

    public int z() {
        return zzy.h.a().intValue();
    }
}
