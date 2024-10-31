package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzxz;
import com.google.android.gms.internal.measurement.zzya;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzbq extends La implements Wa {

    /* renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    private static int f13967d = 65535;

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    private static int f13968e = 2;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, Map<String, String>> f13969f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f13970g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f13971h;
    private final Map<String, zzfp> i;
    private final Map<String, Map<String, Integer>> j;
    private final Map<String, String> k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbq(zzfo zzfoVar) {
        super(zzfoVar);
        this.f13969f = new ArrayMap();
        this.f13970g = new ArrayMap();
        this.f13971h = new ArrayMap();
        this.i = new ArrayMap();
        this.k = new ArrayMap();
        this.j = new ArrayMap();
    }

    private final void h(String str) {
        o();
        c();
        Preconditions.b(str);
        if (this.i.get(str) == null) {
            byte[] d2 = m().d(str);
            if (d2 == null) {
                this.f13969f.put(str, null);
                this.f13970g.put(str, null);
                this.f13971h.put(str, null);
                this.i.put(str, null);
                this.k.put(str, null);
                this.j.put(str, null);
                return;
            }
            zzfp a2 = a(str, d2);
            this.f13969f.put(str, a(a2));
            a(str, a2);
            this.i.put(str, a2);
            this.k.put(str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzfp a(String str) {
        o();
        c();
        Preconditions.b(str);
        h(str);
        return this.i.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b(String str) {
        c();
        return this.k.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(String str) {
        c();
        this.k.put(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(String str) {
        c();
        this.i.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long e(String str) {
        String a2 = a(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(a2)) {
            return 0L;
        }
        try {
            return Long.parseLong(a2);
        } catch (NumberFormatException e2) {
            b().t().a("Unable to parse timezone offset. appId", zzas.a(str), e2);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f(String str) {
        return "1".equals(a(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g(String str) {
        return "1".equals(a(str, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ C1428m i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzq j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.Ka
    public final /* bridge */ /* synthetic */ zzfu k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.Ka
    public final /* bridge */ /* synthetic */ Ua l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.Ka
    public final /* bridge */ /* synthetic */ Xa m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.La
    protected final boolean p() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaa f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaq g() {
        return super.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b(String str, String str2) {
        Boolean bool;
        c();
        h(str);
        if (f(str) && zzfy.d(str2)) {
            return true;
        }
        if (g(str) && zzfy.a(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f13970g.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c(String str, String str2) {
        Boolean bool;
        c();
        h(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f13971h.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int d(String str, String str2) {
        Integer num;
        c();
        h(str);
        Map<String, Integer> map = this.j.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.Wa
    public final String a(String str, String str2) {
        c();
        h(str);
        Map<String, String> map = this.f13969f.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    private static Map<String, String> a(zzfp zzfpVar) {
        zzfq[] zzfqVarArr;
        ArrayMap arrayMap = new ArrayMap();
        if (zzfpVar != null && (zzfqVarArr = zzfpVar.zzawm) != null) {
            for (zzfq zzfqVar : zzfqVarArr) {
                if (zzfqVar != null) {
                    arrayMap.put(zzfqVar.zzoj, zzfqVar.value);
                }
            }
        }
        return arrayMap;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }

    private final void a(String str, zzfp zzfpVar) {
        com.google.android.gms.internal.measurement.zzfo[] zzfoVarArr;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzfpVar != null && (zzfoVarArr = zzfpVar.zzawn) != null) {
            for (com.google.android.gms.internal.measurement.zzfo zzfoVar : zzfoVarArr) {
                if (TextUtils.isEmpty(zzfoVar.name)) {
                    b().t().a("EventConfig contained null event name");
                } else {
                    String b2 = zzcu.b(zzfoVar.name);
                    if (!TextUtils.isEmpty(b2)) {
                        zzfoVar.name = b2;
                    }
                    arrayMap.put(zzfoVar.name, zzfoVar.zzawh);
                    arrayMap2.put(zzfoVar.name, zzfoVar.zzawi);
                    Integer num = zzfoVar.zzawj;
                    if (num != null) {
                        if (num.intValue() >= f13968e && zzfoVar.zzawj.intValue() <= f13967d) {
                            arrayMap3.put(zzfoVar.name, zzfoVar.zzawj);
                        } else {
                            b().t().a("Invalid sampling rate. Event name, sample rate", zzfoVar.name, zzfoVar.zzawj);
                        }
                    }
                }
            }
        }
        this.f13970g.put(str, arrayMap);
        this.f13971h.put(str, arrayMap2);
        this.j.put(str, arrayMap3);
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzfy h() {
        return super.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(String str, byte[] bArr, String str2) {
        byte[] bArr2;
        o();
        c();
        Preconditions.b(str);
        zzfp a2 = a(str, bArr);
        if (a2 == null) {
            return false;
        }
        a(str, a2);
        this.i.put(str, a2);
        this.k.put(str, str2);
        this.f13969f.put(str, a(a2));
        Ua l = l();
        zzfi[] zzfiVarArr = a2.zzawo;
        Preconditions.a(zzfiVarArr);
        for (zzfi zzfiVar : zzfiVarArr) {
            for (zzfj zzfjVar : zzfiVar.zzavg) {
                String b2 = zzcu.b(zzfjVar.zzavl);
                if (b2 != null) {
                    zzfjVar.zzavl = b2;
                }
                for (com.google.android.gms.internal.measurement.zzfk zzfkVar : zzfjVar.zzavm) {
                    String a3 = zzcv.a(zzfkVar.zzavt);
                    if (a3 != null) {
                        zzfkVar.zzavt = a3;
                    }
                }
            }
            for (zzfm zzfmVar : zzfiVar.zzavf) {
                String a4 = zzcw.a(zzfmVar.zzawa);
                if (a4 != null) {
                    zzfmVar.zzawa = a4;
                }
            }
        }
        l.m().a(str, zzfiVarArr);
        try {
            a2.zzawo = null;
            bArr2 = new byte[a2.zzvx()];
            a2.zza(zzya.zzk(bArr2, 0, bArr2.length));
        } catch (IOException e2) {
            b().t().a("Unable to serialize reduced-size config. Storing full config instead. appId", zzas.a(str), e2);
            bArr2 = bArr;
        }
        Xa m = m();
        Preconditions.b(str);
        m.c();
        m.o();
        new ContentValues().put("remote_config", bArr2);
        try {
            if (m.t().update("apps", r0, "app_id = ?", new String[]{str}) == 0) {
                m.b().q().a("Failed to update remote config (got 0). appId", zzas.a(str));
            }
        } catch (SQLiteException e3) {
            m.b().q().a("Error storing remote config. appId", zzas.a(str), e3);
        }
        return true;
    }

    private final zzfp a(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzfp();
        }
        zzxz zzj = zzxz.zzj(bArr, 0, bArr.length);
        zzfp zzfpVar = new zzfp();
        try {
            zzfpVar.zza(zzj);
            b().y().a("Parsed config. version, gmp_app_id", zzfpVar.zzawk, zzfpVar.zzafi);
            return zzfpVar;
        } catch (IOException e2) {
            b().t().a("Unable to merge remote config. appId", zzas.a(str), e2);
            return new zzfp();
        }
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Clock a() {
        return super.a();
    }
}
