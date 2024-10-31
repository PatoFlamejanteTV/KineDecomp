package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;
import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase_auth.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1275t implements Ra {

    /* renamed from: a, reason: collision with root package name */
    private final zzfa f13081a;

    private C1275t(zzfa zzfaVar) {
        zzfv.zza(zzfaVar, "output");
        this.f13081a = zzfaVar;
        this.f13081a.zztq = this;
    }

    public static C1275t a(zzfa zzfaVar) {
        C1275t c1275t = zzfaVar.zztq;
        return c1275t != null ? c1275t : new C1275t(zzfaVar);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void b(int i, long j) throws IOException {
        this.f13081a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void c(int i, long j) throws IOException {
        this.f13081a.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void d(int i, long j) throws IOException {
        this.f13081a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void e(int i, int i2) throws IOException {
        this.f13081a.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void f(int i, int i2) throws IOException {
        this.f13081a.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void g(int i, int i2) throws IOException {
        this.f13081a.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void h(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzi(list.get(i4).longValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zzd(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void i(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzai(list.get(i4).intValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zzad(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzal(list.get(i4).intValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zzaf(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zzj(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void k(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzh(list.get(i4).longValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zzd(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzf(list.get(i4).longValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void m(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzb(list.get(i4).doubleValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void n(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzb(list.get(i4).floatValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzeh) {
            this.f13081a.zzb(i, (zzeh) obj);
        } else {
            this.f13081a.zza(i, (zzhc) obj);
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final int zzgl() {
        return zzft.zze.zzxq;
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void zzi(int i, int i2) throws IOException {
        this.f13081a.zzi(i, i2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void c(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzak(list.get(i4).intValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zzaf(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zzj(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void d(int i, int i2) throws IOException {
        this.f13081a.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void g(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzam(list.get(i4).intValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zzac(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void a(int i, float f2) throws IOException {
        this.f13081a.zza(i, f2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void b(int i, int i2) throws IOException {
        this.f13081a.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzg(list.get(i4).longValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void e(int i, long j) throws IOException {
        this.f13081a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void f(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzt(list.get(i4).booleanValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zzs(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void a(int i, double d2) throws IOException {
        this.f13081a.zza(i, d2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void b(int i, Object obj, InterfaceC1263ma interfaceC1263ma) throws IOException {
        this.f13081a.zza(i, (zzhc) obj, interfaceC1263ma);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void a(int i, long j) throws IOException {
        this.f13081a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void b(int i) throws IOException {
        this.f13081a.zzf(i, 3);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void e(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzaj(list.get(i4).intValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zzae(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zzi(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void a(int i, boolean z) throws IOException {
        this.f13081a.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void b(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zze(list.get(i4).longValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void a(int i, String str) throws IOException {
        this.f13081a.zza(i, str);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void a(int i, zzeh zzehVar) throws IOException {
        this.f13081a.zza(i, zzehVar);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void a(int i, Object obj, InterfaceC1263ma interfaceC1263ma) throws IOException {
        zzfa zzfaVar = this.f13081a;
        zzfaVar.zzf(i, 3);
        interfaceC1263ma.a((InterfaceC1263ma) obj, (Ra) zzfaVar.zztq);
        zzfaVar.zzf(i, 4);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void a(int i) throws IOException {
        this.f13081a.zzf(i, 4);
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f13081a.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzah(list.get(i4).intValue());
            }
            this.f13081a.zzad(i3);
            while (i2 < list.size()) {
                this.f13081a.zzac(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void b(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzgl) {
            zzgl zzglVar = (zzgl) list;
            while (i2 < list.size()) {
                Object zzat = zzglVar.zzat(i2);
                if (zzat instanceof String) {
                    this.f13081a.zza(i, (String) zzat);
                } else {
                    this.f13081a.zza(i, (zzeh) zzat);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f13081a.zza(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void a(int i, List<zzeh> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f13081a.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void a(int i, List<?> list, InterfaceC1263ma interfaceC1263ma) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, list.get(i2), interfaceC1263ma);
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.Ra
    public final void b(int i, List<?> list, InterfaceC1263ma interfaceC1263ma) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, list.get(i2), interfaceC1263ma);
        }
    }
}
