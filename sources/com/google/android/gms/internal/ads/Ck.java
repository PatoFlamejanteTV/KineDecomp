package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
final class Ck {

    /* renamed from: a */
    private final zzpx f11448a = new zzpx(8);

    /* renamed from: b */
    private int f11449b;

    private final long b(zzia zziaVar) throws IOException, InterruptedException {
        int i = 0;
        zziaVar.zza(this.f11448a.data, 0, 1);
        int i2 = this.f11448a.data[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (i3 ^ (-1));
        zziaVar.zza(this.f11448a.data, 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.f11448a.data[i] & 255) + (i5 << 8);
        }
        this.f11449b += i4 + 1;
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x009c, code lost:            return false;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.google.android.gms.internal.ads.zzia r18) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            long r2 = r18.getLength()
            r4 = 1024(0x400, double:5.06E-321)
            r6 = -1
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 == 0) goto L16
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 <= 0) goto L15
            goto L16
        L15:
            r4 = r2
        L16:
            int r5 = (int) r4
            com.google.android.gms.internal.ads.zzpx r4 = r0.f11448a
            byte[] r4 = r4.data
            r8 = 4
            r9 = 0
            r1.zza(r4, r9, r8)
            com.google.android.gms.internal.ads.zzpx r4 = r0.f11448a
            long r10 = r4.zzhd()
            r0.f11449b = r8
        L28:
            r12 = 440786851(0x1a45dfa3, double:2.1777764E-315)
            r4 = 1
            int r8 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r8 == 0) goto L50
            int r8 = r0.f11449b
            int r8 = r8 + r4
            r0.f11449b = r8
            if (r8 != r5) goto L38
            return r9
        L38:
            com.google.android.gms.internal.ads.zzpx r8 = r0.f11448a
            byte[] r8 = r8.data
            r1.zza(r8, r9, r4)
            r4 = 8
            long r10 = r10 << r4
            r12 = -256(0xffffffffffffff00, double:NaN)
            long r10 = r10 & r12
            com.google.android.gms.internal.ads.zzpx r4 = r0.f11448a
            byte[] r4 = r4.data
            r4 = r4[r9]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r12 = (long) r4
            long r10 = r10 | r12
            goto L28
        L50:
            long r10 = r17.b(r18)
            int r5 = r0.f11449b
            long r12 = (long) r5
            r14 = -9223372036854775808
            int r5 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r5 == 0) goto La3
            int r5 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r5 == 0) goto L68
            long r5 = r12 + r10
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 < 0) goto L68
            goto La3
        L68:
            int r2 = r0.f11449b
            long r5 = (long) r2
            long r7 = r12 + r10
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 >= 0) goto L9d
            long r2 = r17.b(r18)
            int r5 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r5 != 0) goto L7a
            return r9
        L7a:
            long r2 = r17.b(r18)
            r5 = 0
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 < 0) goto L9c
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r16 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r16 <= 0) goto L8c
            goto L9c
        L8c:
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 == 0) goto L68
            int r5 = (int) r2
            r1.zzx(r5)
            int r5 = r0.f11449b
            long r5 = (long) r5
            long r5 = r5 + r2
            int r2 = (int) r5
            r0.f11449b = r2
            goto L68
        L9c:
            return r9
        L9d:
            long r1 = (long) r2
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 != 0) goto La3
            return r4
        La3:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.Ck.a(com.google.android.gms.internal.ads.zzia):boolean");
    }
}
