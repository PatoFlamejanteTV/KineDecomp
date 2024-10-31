package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Gh implements Xi {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqk f11550a;

    private Gh(zzbqk zzbqkVar) {
        zzbrf.zza(zzbqkVar, "output");
        this.f11550a = zzbqkVar;
        this.f11550a.zzfmf = this;
    }

    public static Gh a(zzbqk zzbqkVar) {
        Gh gh = zzbqkVar.zzfmf;
        return gh != null ? gh : new Gh(zzbqkVar);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void b(int i, long j) throws IOException {
        this.f11550a.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void c(int i, int i2) throws IOException {
        this.f11550a.zzy(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void d(int i, long j) throws IOException {
        this.f11550a.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void e(int i, int i2) throws IOException {
        this.f11550a.zzy(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void f(int i, int i2) throws IOException {
        this.f11550a.zzv(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void g(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzfj(list.get(i4).intValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzez(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzv(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void h(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzbf(list.get(i4).longValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzba(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzl(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void i(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzff(list.get(i4).intValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzfa(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzw(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzfi(list.get(i4).intValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzfc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzy(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void k(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzbe(list.get(i4).longValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzba(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzl(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzbc(list.get(i4).longValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzay(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void m(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzc(list.get(i4).doubleValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzb(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void n(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzg(list.get(i4).floatValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzf(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void b(int i, int i2) throws IOException {
        this.f11550a.zzx(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void e(int i, long j) throws IOException {
        this.f11550a.zzk(i, j);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final int a() {
        return zzbrd.zze.zzfqm;
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void b(int i, Object obj, InterfaceC1112ui interfaceC1112ui) throws IOException {
        this.f11550a.zza(i, (zzbsl) obj, interfaceC1112ui);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void c(int i, long j) throws IOException {
        this.f11550a.zzl(i, j);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void d(int i, int i2) throws IOException {
        this.f11550a.zzv(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void e(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzfg(list.get(i4).intValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzfb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzx(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void f(int i, long j) throws IOException {
        this.f11550a.zzl(i, j);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void a(int i, float f2) throws IOException {
        this.f11550a.zza(i, f2);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void b(int i) throws IOException {
        this.f11550a.zzu(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzbd(list.get(i4).longValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzaz(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzk(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void f(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzbe(list.get(i4).booleanValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzbd(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzj(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void a(int i, double d2) throws IOException {
        this.f11550a.zzb(i, d2);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void b(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzbb(list.get(i4).longValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzay(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void c(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzfh(list.get(i4).intValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzfc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzy(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void a(int i, boolean z) throws IOException {
        this.f11550a.zzj(i, z);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void a(int i, String str) throws IOException {
        this.f11550a.zzf(i, str);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void a(int i, zzbpu zzbpuVar) throws IOException {
        this.f11550a.zza(i, zzbpuVar);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void a(int i, int i2) throws IOException {
        this.f11550a.zzw(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void a(int i, Object obj, InterfaceC1112ui interfaceC1112ui) throws IOException {
        zzbqk zzbqkVar = this.f11550a;
        zzbqkVar.zzu(i, 3);
        interfaceC1112ui.a((InterfaceC1112ui) obj, (Xi) zzbqkVar.zzfmf);
        zzbqkVar.zzu(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void a(int i) throws IOException {
        this.f11550a.zzu(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void a(int i, Object obj) throws IOException {
        if (obj instanceof zzbpu) {
            this.f11550a.zzb(i, (zzbpu) obj);
        } else {
            this.f11550a.zzb(i, (zzbsl) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void b(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzbru) {
            zzbru zzbruVar = (zzbru) list;
            while (i2 < list.size()) {
                Object zzfp = zzbruVar.zzfp(i2);
                if (zzfp instanceof String) {
                    this.f11550a.zzf(i, (String) zzfp);
                } else {
                    this.f11550a.zza(i, (zzbpu) zzfp);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzf(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.f11550a.zzu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.zzfe(list.get(i4).intValue());
            }
            this.f11550a.zzfa(i3);
            while (i2 < list.size()) {
                this.f11550a.zzez(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f11550a.zzv(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void b(int i, List<?> list, InterfaceC1112ui interfaceC1112ui) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, list.get(i2), interfaceC1112ui);
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void a(int i, List<zzbpu> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f11550a.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.Xi
    public final void a(int i, List<?> list, InterfaceC1112ui interfaceC1112ui) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, list.get(i2), interfaceC1112ui);
        }
    }
}
