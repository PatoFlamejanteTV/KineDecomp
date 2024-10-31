package com.google.ads;

import android.support.v7.widget.helper.ItemTouchHelper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

@Deprecated
/* loaded from: classes.dex */
public final class AdSize {

    /* renamed from: a */
    public static final AdSize f9893a = new AdSize(-1, -2, "mb");

    /* renamed from: b */
    public static final AdSize f9894b = new AdSize(ModuleDescriptor.MODULE_VERSION, 50, "mb");

    /* renamed from: c */
    public static final AdSize f9895c = new AdSize(300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "as");

    /* renamed from: d */
    public static final AdSize f9896d = new AdSize(468, 60, "as");

    /* renamed from: e */
    public static final AdSize f9897e = new AdSize(728, 90, "as");

    /* renamed from: f */
    public static final AdSize f9898f = new AdSize(160, 600, "as");

    /* renamed from: g */
    private final com.google.android.gms.ads.AdSize f9899g;

    public AdSize(com.google.android.gms.ads.AdSize adSize) {
        this.f9899g = adSize;
    }

    public final int a() {
        return this.f9899g.a();
    }

    public final int b() {
        return this.f9899g.b();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AdSize) {
            return this.f9899g.equals(((AdSize) obj).f9899g);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9899g.hashCode();
    }

    public final String toString() {
        return this.f9899g.toString();
    }

    private AdSize(int i, int i2, String str) {
        this(new com.google.android.gms.ads.AdSize(i, i2));
    }
}
