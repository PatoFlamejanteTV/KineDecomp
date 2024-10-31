package com.google.android.gms.ads;

import android.content.Context;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;

@VisibleForTesting
/* loaded from: classes.dex */
public final class AdSize {

    /* renamed from: a */
    public static final AdSize f9932a = new AdSize(ModuleDescriptor.MODULE_VERSION, 50, "320x50_mb");

    /* renamed from: b */
    public static final AdSize f9933b = new AdSize(468, 60, "468x60_as");

    /* renamed from: c */
    public static final AdSize f9934c = new AdSize(ModuleDescriptor.MODULE_VERSION, 100, "320x100_as");

    /* renamed from: d */
    public static final AdSize f9935d = new AdSize(728, 90, "728x90_as");

    /* renamed from: e */
    public static final AdSize f9936e = new AdSize(300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "300x250_as");

    /* renamed from: f */
    public static final AdSize f9937f = new AdSize(160, 600, "160x600_as");

    /* renamed from: g */
    public static final AdSize f9938g = new AdSize(-1, -2, "smart_banner");

    /* renamed from: h */
    public static final AdSize f9939h = new AdSize(-3, -4, "fluid");
    public static final AdSize i = new AdSize(50, 50, "50x50_mb");
    public static final AdSize j = new AdSize(-3, 0, "search_v2");
    private final int k;
    private final int l;
    private final String m;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AdSize(int r5, int r6) {
        /*
            r4 = this;
            r0 = -1
            if (r5 != r0) goto L6
            java.lang.String r0 = "FULL"
            goto La
        L6:
            java.lang.String r0 = java.lang.String.valueOf(r5)
        La:
            r1 = -2
            if (r6 != r1) goto L10
            java.lang.String r1 = "AUTO"
            goto L14
        L10:
            java.lang.String r1 = java.lang.String.valueOf(r6)
        L14:
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 4
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r0)
            java.lang.String r0 = "x"
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = "_as"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r4.<init>(r5, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    public final int a() {
        return this.l;
    }

    public final int b() {
        return this.k;
    }

    public final boolean c() {
        return this.k == -3 && this.l == -4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.k == adSize.k && this.l == adSize.l && this.m.equals(adSize.m);
    }

    public final int hashCode() {
        return this.m.hashCode();
    }

    public final String toString() {
        return this.m;
    }

    public final int a(Context context) {
        int i2 = this.l;
        if (i2 == -4 || i2 == -3) {
            return -1;
        }
        if (i2 != -2) {
            zzwu.zzpv();
            return zzbat.zza(context, this.l);
        }
        return zzwf.zzc(context.getResources().getDisplayMetrics());
    }

    public final int b(Context context) {
        int i2 = this.k;
        if (i2 == -4 || i2 == -3) {
            return -1;
        }
        if (i2 != -1) {
            zzwu.zzpv();
            return zzbat.zza(context, this.k);
        }
        return zzwf.zzb(context.getResources().getDisplayMetrics());
    }

    public AdSize(int i2, int i3, String str) {
        if (i2 < 0 && i2 != -1 && i2 != -3) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Invalid width for AdSize: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i3 < 0 && i3 != -2 && i3 != -4) {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("Invalid height for AdSize: ");
            sb2.append(i3);
            throw new IllegalArgumentException(sb2.toString());
        }
        this.k = i2;
        this.l = i3;
        this.m = str;
    }
}
