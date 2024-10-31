package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ab {

    /* renamed from: a */
    long f11363a;

    /* renamed from: b */
    final String f11364b;

    /* renamed from: c */
    final String f11365c;

    /* renamed from: d */
    final long f11366d;

    /* renamed from: e */
    final long f11367e;

    /* renamed from: f */
    final long f11368f;

    /* renamed from: g */
    final long f11369g;

    /* renamed from: h */
    final List<zzl> f11370h;

    private Ab(String str, String str2, long j, long j2, long j3, long j4, List<zzl> list) {
        this.f11364b = str;
        this.f11365c = "".equals(str2) ? null : str2;
        this.f11366d = j;
        this.f11367e = j2;
        this.f11368f = j3;
        this.f11369g = j4;
        this.f11370h = list;
    }

    public static Ab a(Kb kb) throws IOException {
        if (zzam.zzb((InputStream) kb) == 538247942) {
            return new Ab(zzam.zza(kb), zzam.zza(kb), zzam.zzc(kb), zzam.zzc(kb), zzam.zzc(kb), zzam.zzc(kb), zzam.zzb(kb));
        }
        throw new IOException();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Ab(java.lang.String r16, com.google.android.gms.internal.ads.zzc r17) {
        /*
            r15 = this;
            r0 = r17
            java.lang.String r3 = r0.zza
            long r4 = r0.zzb
            long r6 = r0.zzc
            long r8 = r0.zzd
            long r10 = r0.zze
            java.util.List<com.google.android.gms.internal.ads.zzl> r1 = r0.zzg
            if (r1 == 0) goto L12
            r12 = r1
            goto L47
        L12:
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.zzf
            java.util.ArrayList r2 = new java.util.ArrayList
            int r12 = r1.size()
            r2.<init>(r12)
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L25:
            boolean r12 = r1.hasNext()
            if (r12 == 0) goto L46
            java.lang.Object r12 = r1.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            com.google.android.gms.internal.ads.zzl r13 = new com.google.android.gms.internal.ads.zzl
            java.lang.Object r14 = r12.getKey()
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r12 = r12.getValue()
            java.lang.String r12 = (java.lang.String) r12
            r13.<init>(r14, r12)
            r2.add(r13)
            goto L25
        L46:
            r12 = r2
        L47:
            r1 = r15
            r2 = r16
            r1.<init>(r2, r3, r4, r6, r8, r10, r12)
            byte[] r0 = r0.data
            int r0 = r0.length
            long r0 = (long) r0
            r2 = r15
            r2.f11363a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.Ab.<init>(java.lang.String, com.google.android.gms.internal.ads.zzc):void");
    }

    public final boolean a(OutputStream outputStream) {
        try {
            zzam.zza(outputStream, 538247942);
            zzam.zza(outputStream, this.f11364b);
            zzam.zza(outputStream, this.f11365c == null ? "" : this.f11365c);
            zzam.zza(outputStream, this.f11366d);
            zzam.zza(outputStream, this.f11367e);
            zzam.zza(outputStream, this.f11368f);
            zzam.zza(outputStream, this.f11369g);
            List<zzl> list = this.f11370h;
            if (list != null) {
                zzam.zza(outputStream, list.size());
                for (zzl zzlVar : list) {
                    zzam.zza(outputStream, zzlVar.getName());
                    zzam.zza(outputStream, zzlVar.getValue());
                }
            } else {
                zzam.zza(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e2) {
            zzaf.d("%s", e2.toString());
            return false;
        }
    }
}
