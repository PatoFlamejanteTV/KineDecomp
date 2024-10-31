package com.google.ads;

@Deprecated
/* loaded from: classes.dex */
public final class AdSize {

    /* renamed from: a, reason: collision with root package name */
    public static final AdSize f501a = new AdSize(-1, -2, "mb");
    public static final AdSize b = new AdSize(320, 50, "mb");
    public static final AdSize c = new AdSize(300, 250, "as");
    public static final AdSize d = new AdSize(468, 60, "as");
    public static final AdSize e = new AdSize(728, 90, "as");
    public static final AdSize f = new AdSize(160, 600, "as");
    private final com.google.android.gms.ads.AdSize g;

    private AdSize(int i, int i2, String str) {
        this(new com.google.android.gms.ads.AdSize(i, i2));
    }

    public AdSize(com.google.android.gms.ads.AdSize adSize) {
        this.g = adSize;
    }

    public int a() {
        return this.g.b();
    }

    public int b() {
        return this.g.a();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AdSize) {
            return this.g.equals(((AdSize) obj).g);
        }
        return false;
    }

    public int hashCode() {
        return this.g.hashCode();
    }

    public String toString() {
        return this.g.toString();
    }
}
