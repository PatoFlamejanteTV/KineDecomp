package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.measurement.oa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1382oa implements Fb {

    /* renamed from: a, reason: collision with root package name */
    private final zztv f13502a;

    private C1382oa(zztv zztvVar) {
        zzuq.zza(zztvVar, "output");
        this.f13502a = zztvVar;
        this.f13502a.zzbun = this;
    }

    public static C1382oa a(zztv zztvVar) {
        C1382oa c1382oa = zztvVar.zzbun;
        return c1382oa != null ? c1382oa : new C1382oa(zztvVar);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void b(int i, long j) throws IOException {
        this.f13502a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void c(int i, int i2) throws IOException {
        this.f13502a.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void d(int i, long j) throws IOException {
        this.f13502a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void e(int i, int i2) throws IOException {
        this.f13502a.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void f(int i, int i2) throws IOException {
        this.f13502a.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void g(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbj(list.get(i4).intValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zzaz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void h(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzba(list.get(i4).longValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zzav(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void i(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbf(list.get(i4).intValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zzba(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbi(list.get(i4).intValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zzbc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void k(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzaz(list.get(i4).longValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zzav(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzax(list.get(i4).longValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zzat(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void m(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzc(list.get(i4).doubleValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void n(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzb(list.get(i4).floatValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzte) {
            this.f13502a.zzb(i, (zzte) obj);
        } else {
            this.f13502a.zzb(i, (zzvv) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void zzbn(int i) throws IOException {
        this.f13502a.zzc(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void c(int i, long j) throws IOException {
        this.f13502a.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void d(int i, int i2) throws IOException {
        this.f13502a.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final int a() {
        return zzuo.zze.zzbyv;
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void b(int i, int i2) throws IOException {
        this.f13502a.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void c(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbh(list.get(i4).intValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zzbc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzay(list.get(i4).longValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zzau(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void e(int i, long j) throws IOException {
        this.f13502a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void f(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzt(list.get(i4).booleanValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zzs(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void a(int i, float f2) throws IOException {
        this.f13502a.zza(i, f2);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void b(int i, Object obj, InterfaceC1353cb interfaceC1353cb) throws IOException {
        zztv zztvVar = this.f13502a;
        zztvVar.zzc(i, 3);
        interfaceC1353cb.a((InterfaceC1353cb) obj, (Fb) zztvVar.zzbun);
        zztvVar.zzc(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void a(int i, double d2) throws IOException {
        this.f13502a.zza(i, d2);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void e(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbg(list.get(i4).intValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zzbb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void a(int i, long j) throws IOException {
        this.f13502a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void a(int i, boolean z) throws IOException {
        this.f13502a.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void a(int i, String str) throws IOException {
        this.f13502a.zzb(i, str);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void b(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzaw(list.get(i4).longValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zzat(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void a(int i, zzte zzteVar) throws IOException {
        this.f13502a.zza(i, zzteVar);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void a(int i, int i2) throws IOException {
        this.f13502a.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void a(int i, Object obj, InterfaceC1353cb interfaceC1353cb) throws IOException {
        this.f13502a.zza(i, (zzvv) obj, interfaceC1353cb);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void a(int i) throws IOException {
        this.f13502a.zzc(i, 3);
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13502a.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbe(list.get(i4).intValue());
            }
            this.f13502a.zzba(i3);
            while (i2 < list.size()) {
                this.f13502a.zzaz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void b(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzve) {
            zzve zzveVar = (zzve) list;
            while (i2 < list.size()) {
                Object zzbp = zzveVar.zzbp(i2);
                if (zzbp instanceof String) {
                    this.f13502a.zzb(i, (String) zzbp);
                } else {
                    this.f13502a.zza(i, (zzte) zzbp);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13502a.zzb(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void a(int i, List<zzte> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f13502a.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void a(int i, List<?> list, InterfaceC1353cb interfaceC1353cb) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, list.get(i2), interfaceC1353cb);
        }
    }

    @Override // com.google.android.gms.internal.measurement.Fb
    public final void b(int i, List<?> list, InterfaceC1353cb interfaceC1353cb) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, list.get(i2), interfaceC1353cb);
        }
    }
}
