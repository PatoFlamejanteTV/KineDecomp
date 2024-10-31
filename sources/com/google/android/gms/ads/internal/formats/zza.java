package com.google.android.gms.ads.internal.formats;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import java.util.List;

/* loaded from: classes.dex */
public class zza {
    private final String e;
    private final List<Drawable> f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private static final int c = Color.rgb(12, 174, 206);
    private static final int d = Color.rgb(204, 204, 204);

    /* renamed from: a, reason: collision with root package name */
    static final int f572a = d;
    static final int b = c;

    public zza(String str, List<Drawable> list, Integer num, Integer num2, Integer num3, int i) {
        this.e = str;
        this.f = list;
        this.g = num != null ? num.intValue() : f572a;
        this.h = num2 != null ? num2.intValue() : b;
        this.i = num3 != null ? num3.intValue() : 12;
        this.j = i;
    }

    public String a() {
        return this.e;
    }

    public List<Drawable> b() {
        return this.f;
    }

    public int c() {
        return this.g;
    }

    public int d() {
        return this.h;
    }

    public int e() {
        return this.i;
    }

    public int f() {
        return this.j;
    }
}
