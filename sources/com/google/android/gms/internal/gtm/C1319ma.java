package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.ma, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1319ma implements Cb {

    /* renamed from: a, reason: collision with root package name */
    private final zzqj f13269a;

    private C1319ma(zzqj zzqjVar) {
        zzre.zza(zzqjVar, "output");
        this.f13269a = zzqjVar;
        this.f13269a.zzawu = this;
    }

    public static C1319ma a(zzqj zzqjVar) {
        C1319ma c1319ma = zzqjVar.zzawu;
        return c1319ma != null ? c1319ma : new C1319ma(zzqjVar);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void b(int i, long j) throws IOException {
        this.f13269a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void c(int i, int i2) throws IOException {
        this.f13269a.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void d(int i, long j) throws IOException {
        this.f13269a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void e(int i, long j) throws IOException {
        this.f13269a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void f(int i, int i2) throws IOException {
        this.f13269a.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void g(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbh(list.get(i4).intValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zzax(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void h(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzw(list.get(i4).longValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zzr(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void i(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbd(list.get(i4).intValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zzay(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbg(list.get(i4).intValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zzba(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void k(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzv(list.get(i4).longValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zzr(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzt(list.get(i4).longValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zzp(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void m(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzc(list.get(i4).doubleValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void n(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzb(list.get(i4).floatValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzps) {
            this.f13269a.zzb(i, (zzps) obj);
        } else {
            this.f13269a.zzb(i, (zzsk) obj);
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void zzp(int i, int i2) throws IOException {
        this.f13269a.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void c(int i, long j) throws IOException {
        this.f13269a.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void d(int i, int i2) throws IOException {
        this.f13269a.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final int a() {
        return zzrc.zze.zzbbc;
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void b(int i, int i2) throws IOException {
        this.f13269a.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void c(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbf(list.get(i4).intValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zzba(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzu(list.get(i4).longValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zzq(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void e(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbe(list.get(i4).intValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zzaz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void f(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzj(list.get(i4).booleanValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zzi(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void a(int i, float f2) throws IOException {
        this.f13269a.zza(i, f2);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void b(int i, Object obj, _a _aVar) throws IOException {
        this.f13269a.zza(i, (zzsk) obj, _aVar);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void a(int i, double d2) throws IOException {
        this.f13269a.zza(i, d2);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void b(int i) throws IOException {
        this.f13269a.zzd(i, 4);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void a(int i, long j) throws IOException {
        this.f13269a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void b(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzs(list.get(i4).longValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zzp(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void a(int i, boolean z) throws IOException {
        this.f13269a.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void a(int i, String str) throws IOException {
        this.f13269a.zza(i, str);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void a(int i, zzps zzpsVar) throws IOException {
        this.f13269a.zza(i, zzpsVar);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void a(int i, int i2) throws IOException {
        this.f13269a.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void a(int i, Object obj, _a _aVar) throws IOException {
        zzqj zzqjVar = this.f13269a;
        zzqjVar.zzd(i, 3);
        _aVar.a((_a) obj, (Cb) zzqjVar.zzawu);
        zzqjVar.zzd(i, 4);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void a(int i) throws IOException {
        this.f13269a.zzd(i, 3);
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13269a.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzqj.zzbc(list.get(i4).intValue());
            }
            this.f13269a.zzay(i3);
            while (i2 < list.size()) {
                this.f13269a.zzax(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void b(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzrt) {
            zzrt zzrtVar = (zzrt) list;
            while (i2 < list.size()) {
                Object zzbn = zzrtVar.zzbn(i2);
                if (zzbn instanceof String) {
                    this.f13269a.zza(i, (String) zzbn);
                } else {
                    this.f13269a.zza(i, (zzps) zzbn);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13269a.zza(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void a(int i, List<zzps> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f13269a.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void b(int i, List<?> list, _a _aVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, list.get(i2), _aVar);
        }
    }

    @Override // com.google.android.gms.internal.gtm.Cb
    public final void a(int i, List<?> list, _a _aVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, list.get(i2), _aVar);
        }
    }
}
