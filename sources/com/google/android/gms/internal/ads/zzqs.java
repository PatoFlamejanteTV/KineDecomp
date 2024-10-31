package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.WindowManager;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzqs {
    private final Wl zzbjy;
    private final boolean zzbjz;
    private final long zzbka;
    private final long zzbkb;
    private long zzbkc;
    private long zzbkd;
    private long zzbke;
    private boolean zzbkf;
    private long zzbkg;
    private long zzbkh;
    private long zzbki;

    public zzqs() {
        this(-1.0d);
    }

    private final boolean zzi(long j, long j2) {
        return Math.abs((j2 - this.zzbkg) - (j - this.zzbkh)) > 20000000;
    }

    public final void disable() {
        if (this.zzbjz) {
            this.zzbjy.c();
        }
    }

    public final void enable() {
        this.zzbkf = false;
        if (this.zzbjz) {
            this.zzbjy.b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzh(long r12, long r14) {
        /*
            r11 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r12
            boolean r2 = r11.zzbkf
            if (r2 == 0) goto L42
            long r2 = r11.zzbkc
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L19
            long r2 = r11.zzbki
            r4 = 1
            long r2 = r2 + r4
            r11.zzbki = r2
            long r2 = r11.zzbke
            r11.zzbkd = r2
        L19:
            long r2 = r11.zzbki
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L3a
            long r4 = r11.zzbkh
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r11.zzbkd
            long r2 = r2 + r4
            boolean r4 = r11.zzi(r2, r14)
            if (r4 == 0) goto L33
            r11.zzbkf = r6
            goto L42
        L33:
            long r4 = r11.zzbkg
            long r4 = r4 + r2
            long r6 = r11.zzbkh
            long r4 = r4 - r6
            goto L44
        L3a:
            boolean r2 = r11.zzi(r0, r14)
            if (r2 == 0) goto L42
            r11.zzbkf = r6
        L42:
            r4 = r14
            r2 = r0
        L44:
            boolean r6 = r11.zzbkf
            r7 = 0
            if (r6 != 0) goto L53
            r11.zzbkh = r0
            r11.zzbkg = r14
            r11.zzbki = r7
            r14 = 1
            r11.zzbkf = r14
        L53:
            r11.zzbkc = r12
            r11.zzbke = r2
            com.google.android.gms.internal.ads.Wl r12 = r11.zzbjy
            if (r12 == 0) goto L86
            long r12 = r12.f11947b
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 != 0) goto L62
            goto L86
        L62:
            com.google.android.gms.internal.ads.Wl r12 = r11.zzbjy
            long r12 = r12.f11947b
            long r14 = r11.zzbka
            long r0 = r4 - r12
            long r0 = r0 / r14
            long r0 = r0 * r14
            long r12 = r12 + r0
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 > 0) goto L75
            long r14 = r12 - r14
            goto L79
        L75:
            long r14 = r14 + r12
            r9 = r12
            r12 = r14
            r14 = r9
        L79:
            long r0 = r12 - r4
            long r4 = r4 - r14
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 >= 0) goto L81
            goto L82
        L81:
            r12 = r14
        L82:
            long r14 = r11.zzbkb
            long r12 = r12 - r14
            return r12
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqs.zzh(long, long):long");
    }

    public zzqs(Context context) {
        this(((WindowManager) context.getSystemService("window")).getDefaultDisplay() != null ? r3.getDefaultDisplay().getRefreshRate() : -1.0d);
    }

    private zzqs(double d2) {
        this.zzbjz = d2 != -1.0d;
        if (this.zzbjz) {
            this.zzbjy = Wl.a();
            this.zzbka = (long) (1.0E9d / d2);
            this.zzbkb = (this.zzbka * 80) / 100;
        } else {
            this.zzbjy = null;
            this.zzbka = -1L;
            this.zzbkb = -1L;
        }
    }
}
