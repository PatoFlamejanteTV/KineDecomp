package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.clearcut.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1234y implements Sa {

    /* renamed from: a, reason: collision with root package name */
    private final zzbn f12908a;

    private C1234y(zzbn zzbnVar) {
        zzci.zza(zzbnVar, "output");
        this.f12908a = zzbnVar;
        this.f12908a.zzfz = this;
    }

    public static C1234y a(zzbn zzbnVar) {
        C1234y c1234y = zzbnVar.zzfz;
        return c1234y != null ? c1234y : new C1234y(zzbnVar);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final int a() {
        return zzcg.zzg.zzko;
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void a(int i) throws IOException {
        this.f12908a.zzb(i, 4);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void a(int i, double d2) throws IOException {
        this.f12908a.zza(i, d2);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void a(int i, float f2) throws IOException {
        this.f12908a.zza(i, f2);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void a(int i, int i2) throws IOException {
        this.f12908a.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void a(int i, long j) throws IOException {
        this.f12908a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void a(int i, zzbb zzbbVar) throws IOException {
        this.f12908a.zza(i, zzbbVar);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void a(int i, Object obj, InterfaceC1218pa interfaceC1218pa) throws IOException {
        this.f12908a.zza(i, (zzdo) obj, interfaceC1218pa);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void a(int i, String str) throws IOException {
        this.f12908a.zza(i, str);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void a(int i, List<zzbb> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f12908a.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void a(int i, List<?> list, InterfaceC1218pa interfaceC1218pa) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, list.get(i2), interfaceC1218pa);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void a(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zzc(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zzs(list.get(i4).intValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zzn(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void a(int i, boolean z) throws IOException {
        this.f12908a.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void b(int i) throws IOException {
        this.f12908a.zzb(i, 3);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void b(int i, long j) throws IOException {
        this.f12908a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void b(int i, Object obj, InterfaceC1218pa interfaceC1218pa) throws IOException {
        zzbn zzbnVar = this.f12908a;
        zzbnVar.zzb(i, 3);
        interfaceC1218pa.a((InterfaceC1218pa) obj, (Sa) zzbnVar.zzfz);
        zzbnVar.zzb(i, 4);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void b(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzcx)) {
            while (i2 < list.size()) {
                this.f12908a.zza(i, list.get(i2));
                i2++;
            }
            return;
        }
        zzcx zzcxVar = (zzcx) list;
        while (i2 < list.size()) {
            Object raw = zzcxVar.getRaw(i2);
            if (raw instanceof String) {
                this.f12908a.zza(i, (String) raw);
            } else {
                this.f12908a.zza(i, (zzbb) raw);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void b(int i, List<?> list, InterfaceC1218pa interfaceC1218pa) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, list.get(i2), interfaceC1218pa);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void b(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zza(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zze(list.get(i4).longValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zzb(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void c(int i, int i2) throws IOException {
        this.f12908a.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void c(int i, long j) throws IOException {
        this.f12908a.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void c(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zzf(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zzv(list.get(i4).intValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zzq(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void d(int i, int i2) throws IOException {
        this.f12908a.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void d(int i, long j) throws IOException {
        this.f12908a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void d(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zzb(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zzg(list.get(i4).longValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zzc(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void e(int i, int i2) throws IOException {
        this.f12908a.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void e(int i, long j) throws IOException {
        this.f12908a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void e(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zze(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zzu(list.get(i4).intValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zzp(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void f(int i, int i2) throws IOException {
        this.f12908a.zzc(i, i2);
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void f(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zzb(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zzb(list.get(i4).booleanValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zza(list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void g(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zzc(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zzx(list.get(i4).intValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zzn(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void h(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zzc(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zzi(list.get(i4).longValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zzd(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void i(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zzd(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zzt(list.get(i4).intValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zzo(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void j(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zzf(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zzw(list.get(i4).intValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zzq(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void k(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zzc(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zzh(list.get(i4).longValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zzd(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void l(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zza(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zzf(list.get(i4).longValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zzb(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void m(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zza(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zzb(list.get(i4).doubleValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zza(list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void n(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f12908a.zza(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        this.f12908a.zzb(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzbn.zzb(list.get(i4).floatValue());
        }
        this.f12908a.zzo(i3);
        while (i2 < list.size()) {
            this.f12908a.zza(list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzbb) {
            this.f12908a.zzb(i, (zzbb) obj);
        } else {
            this.f12908a.zzb(i, (zzdo) obj);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.Sa
    public final void zzm(int i, int i2) throws IOException {
        this.f12908a.zzf(i, i2);
    }
}
