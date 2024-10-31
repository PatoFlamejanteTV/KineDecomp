package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

@zzark
/* renamed from: com.google.android.gms.internal.ads.ra, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1062ra {

    /* renamed from: a, reason: collision with root package name */
    private static final zzahq f12475a = zzahq.zzto();

    /* renamed from: b, reason: collision with root package name */
    private static final float f12476b = ((Float) zzwu.zzpz().zzd(zzaan.zzcsl)).floatValue();

    /* renamed from: c, reason: collision with root package name */
    private static final long f12477c = ((Long) zzwu.zzpz().zzd(zzaan.zzcsj)).longValue();

    /* renamed from: d, reason: collision with root package name */
    private static final float f12478d = ((Float) zzwu.zzpz().zzd(zzaan.zzcsm)).floatValue();

    /* renamed from: e, reason: collision with root package name */
    private static final long f12479e = ((Long) zzwu.zzpz().zzd(zzaan.zzcsk)).longValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a() {
        /*
            com.google.android.gms.internal.ads.zzahq r0 = com.google.android.gms.internal.ads.C1062ra.f12475a
            int r0 = r0.zztv()
            com.google.android.gms.internal.ads.zzahq r1 = com.google.android.gms.internal.ads.C1062ra.f12475a
            int r1 = r1.zztw()
            com.google.android.gms.internal.ads.zzahq r2 = com.google.android.gms.internal.ads.C1062ra.f12475a
            int r2 = r2.zztu()
            com.google.android.gms.internal.ads.zzahq r3 = com.google.android.gms.internal.ads.C1062ra.f12475a
            int r3 = r3.zztt()
            int r2 = r2 + r3
            r3 = 1
            r4 = 2147483647(0x7fffffff, float:NaN)
            r5 = 0
            r7 = 0
            r8 = 16
            if (r0 >= r8) goto L2f
            long r9 = com.google.android.gms.internal.ads.C1062ra.f12479e
            int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r11 == 0) goto L2f
            int r9 = a(r9, r0)
            goto L3e
        L2f:
            float r9 = com.google.android.gms.internal.ads.C1062ra.f12478d
            int r10 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r10 == 0) goto L3b
            float r10 = (float) r0
            float r9 = r9 * r10
            int r9 = (int) r9
            int r9 = r9 + r3
            goto L3e
        L3b:
            r9 = 2147483647(0x7fffffff, float:NaN)
        L3e:
            if (r1 > r9) goto L5a
            if (r0 >= r8) goto L4d
            long r8 = com.google.android.gms.internal.ads.C1062ra.f12477c
            int r1 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r1 == 0) goto L4d
            int r4 = a(r8, r0)
            goto L57
        L4d:
            float r1 = com.google.android.gms.internal.ads.C1062ra.f12476b
            int r5 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r5 == 0) goto L57
            float r0 = (float) r0
            float r1 = r1 * r0
            int r4 = (int) r1
        L57:
            if (r2 > r4) goto L5a
            return r3
        L5a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C1062ra.a():boolean");
    }

    @VisibleForTesting
    private static int a(long j, int i) {
        return (int) ((j >>> ((i % 16) * 4)) & 15);
    }
}
