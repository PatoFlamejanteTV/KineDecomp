package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;

/* loaded from: classes.dex */
public final class AdSize {

    /* renamed from: a, reason: collision with root package name */
    public static final AdSize f516a = new AdSize(320, 50, "320x50_mb");
    public static final AdSize b = new AdSize(468, 60, "468x60_as");
    public static final AdSize c = new AdSize(320, 100, "320x100_as");
    public static final AdSize d = new AdSize(728, 90, "728x90_as");
    public static final AdSize e = new AdSize(300, 250, "300x250_as");
    public static final AdSize f = new AdSize(160, 600, "160x600_as");
    public static final AdSize g = new AdSize(-1, -2, "smart_banner");
    public static final AdSize h = new AdSize(-3, -4, "fluid");
    private final int i;
    private final int j;
    private final String k;

    public AdSize(int i, int i2) {
        this(i, i2, (i == -1 ? "FULL" : String.valueOf(i)) + "x" + (i2 == -2 ? "AUTO" : String.valueOf(i2)) + "_as");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        }
        if (i2 < 0 && i2 != -2 && i2 != -4) {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
        this.i = i;
        this.j = i2;
        this.k = str;
    }

    public int a() {
        return this.j;
    }

    public int a(Context context) {
        switch (this.j) {
            case -4:
            case -3:
                return -1;
            case -2:
                return AdSizeParcel.b(context.getResources().getDisplayMetrics());
            default:
                return zzl.a().a(context, this.j);
        }
    }

    public int b() {
        return this.i;
    }

    public int b(Context context) {
        switch (this.i) {
            case -4:
            case -3:
                return -1;
            case -2:
            default:
                return zzl.a().a(context, this.i);
            case -1:
                return AdSizeParcel.a(context.getResources().getDisplayMetrics());
        }
    }

    public boolean c() {
        return this.i == -3 && this.j == -4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.i == adSize.i && this.j == adSize.j && this.k.equals(adSize.k);
    }

    public int hashCode() {
        return this.k.hashCode();
    }

    public String toString() {
        return this.k;
    }
}
