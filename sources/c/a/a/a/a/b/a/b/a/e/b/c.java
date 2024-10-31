package c.a.a.a.a.b.a.b.a.e.b;

import android.graphics.Color;
import java.lang.ref.WeakReference;

/* compiled from: ACAdobeColorRGB.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private double f3440a;

    /* renamed from: b */
    private double f3441b;

    /* renamed from: c */
    private double f3442c;

    /* renamed from: d */
    private WeakReference<a> f3443d;

    public c(a aVar) {
        this.f3443d = new WeakReference<>(aVar);
    }

    public int a() {
        return Color.rgb((int) this.f3440a, (int) this.f3441b, (int) this.f3442c);
    }

    public void a(double d2, double d3, double d4) {
        this.f3440a = d2;
        this.f3441b = d3;
        this.f3442c = d4;
    }
}
