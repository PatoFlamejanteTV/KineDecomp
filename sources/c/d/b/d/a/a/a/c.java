package c.d.b.d.a.a.a;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c;
import java.util.Locale;

/* compiled from: Motion.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    public String f3625a;

    /* renamed from: b */
    public b f3626b;

    /* renamed from: c */
    public a f3627c;

    /* renamed from: d */
    public b f3628d;

    /* renamed from: e */
    public a f3629e;

    /* renamed from: f */
    public double f3630f;

    /* renamed from: g */
    public b f3631g;

    /* renamed from: h */
    public a f3632h;

    /* compiled from: Motion.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public final long f3633a;

        /* renamed from: b */
        public final long f3634b;

        public a(long j, long j2) {
            this.f3633a = j;
            this.f3634b = j2;
        }
    }

    /* compiled from: Motion.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public final long f3635a;

        /* renamed from: b */
        public final long f3636b;

        public b(long j, long j2) {
            this.f3635a = j;
            this.f3636b = j2;
        }
    }

    public c(b bVar, b bVar2) {
        this.f3628d = bVar;
        this.f3626b = bVar2;
        this.f3627c = a(this.f3626b);
        this.f3629e = a(this.f3628d);
    }

    public static double a(b bVar, b bVar2) {
        double d2;
        double d3;
        double d4;
        long j = bVar.f3635a;
        long j2 = bVar.f3636b;
        if (j >= j2) {
            double d5 = j;
            double d6 = j2;
            Double.isNaN(d5);
            Double.isNaN(d6);
            d2 = d5 / d6;
        } else {
            double d7 = j2;
            double d8 = j;
            Double.isNaN(d7);
            Double.isNaN(d8);
            d2 = d7 / d8;
        }
        if (d2 <= 1.3333333333333333d) {
            long j3 = bVar.f3635a;
            long j4 = bVar.f3636b;
            if (j3 >= j4) {
                d3 = bVar2.f3636b;
                d4 = j4;
                Double.isNaN(d3);
                Double.isNaN(d4);
            } else {
                d3 = bVar2.f3635a;
                d4 = j3;
                Double.isNaN(d3);
                Double.isNaN(d4);
            }
        } else {
            long j5 = bVar.f3635a;
            long j6 = bVar.f3636b;
            if (j5 >= j6) {
                d3 = bVar2.f3635a;
                d4 = j5;
                Double.isNaN(d3);
                Double.isNaN(d4);
            } else {
                d3 = bVar2.f3636b;
                d4 = j6;
                Double.isNaN(d3);
                Double.isNaN(d4);
            }
        }
        return Double.parseDouble(String.format("%.3f", Double.valueOf(d3 / d4)));
    }

    public static double b(b bVar) {
        int i = 1;
        while (i < 8) {
            long j = i;
            if (bVar.f3635a / j <= 1920 && bVar.f3636b / j <= 1080) {
                break;
            }
            i *= 2;
        }
        double d2 = i;
        Double.isNaN(d2);
        return Double.parseDouble(String.format("%.3f", Double.valueOf(1.0d / d2)));
    }

    public static b a(b bVar, double d2) {
        double d3 = bVar.f3635a;
        Double.isNaN(d3);
        double d4 = bVar.f3636b;
        Double.isNaN(d4);
        return new b((long) (d3 * d2), (long) (d4 * d2));
    }

    public static a a(b bVar) {
        return new a(bVar.f3635a / 2, bVar.f3636b / 2);
    }

    public c.a a(NexLayerItem nexLayerItem) {
        switch (c.d.b.d.a.a.a.b.f3624a[nexLayerItem.getSplitScreenType().ordinal()]) {
            case 1:
                long j = nexLayerItem.getKeyFrames().get(0).f20232c - this.f3627c.f3633a;
                long j2 = nexLayerItem.getKeyFrames().get(0).f20233d - this.f3627c.f3634b;
                if (j == 0 && j2 == 0) {
                    return null;
                }
                double d2 = j;
                double d3 = this.f3628d.f3635a;
                Double.isNaN(d2);
                Double.isNaN(d3);
                double parseDouble = Double.parseDouble(String.format(Locale.US, "%.5f", Double.valueOf(d2 / d3)));
                double d4 = j2;
                double d5 = this.f3628d.f3636b;
                Double.isNaN(d4);
                Double.isNaN(d5);
                return new c.a(parseDouble, Double.parseDouble(String.format(Locale.US, "%.5f", Double.valueOf(d4 / d5))));
            case 2:
            default:
                return null;
            case 3:
                if (nexLayerItem.getSplitScreenSize() == 0) {
                    double d6 = -this.f3632h.f3634b;
                    double d7 = this.f3628d.f3636b;
                    Double.isNaN(d6);
                    Double.isNaN(d7);
                    return new c.a(0.0d, d6 / d7);
                }
                double splitScreenSize = nexLayerItem.getSplitScreenSize() - this.f3631g.f3636b;
                double d8 = this.f3628d.f3636b;
                Double.isNaN(splitScreenSize);
                Double.isNaN(d8);
                return new c.a(0.0d, Double.parseDouble(String.format(Locale.US, "%.5f", Double.valueOf(splitScreenSize / d8))));
            case 4:
                if (nexLayerItem.getSplitScreenSize() == 0) {
                    double d9 = -this.f3632h.f3633a;
                    double d10 = this.f3628d.f3635a;
                    Double.isNaN(d9);
                    Double.isNaN(d10);
                    return new c.a(d9 / d10, 0.0d);
                }
                double splitScreenSize2 = nexLayerItem.getSplitScreenSize() - this.f3631g.f3635a;
                double d11 = this.f3628d.f3635a;
                Double.isNaN(splitScreenSize2);
                Double.isNaN(d11);
                return new c.a(Double.parseDouble(String.format(Locale.US, "%.5f", Double.valueOf(splitScreenSize2 / d11))), 0.0d);
            case 5:
                if (nexLayerItem.getSplitScreenSize() == 0) {
                    double d12 = this.f3632h.f3633a;
                    double d13 = this.f3628d.f3635a;
                    Double.isNaN(d12);
                    Double.isNaN(d13);
                    return new c.a(d12 / d13, 0.0d);
                }
                double splitScreenSize3 = this.f3631g.f3635a - nexLayerItem.getSplitScreenSize();
                double d14 = this.f3628d.f3635a;
                Double.isNaN(splitScreenSize3);
                Double.isNaN(d14);
                return new c.a(Double.parseDouble(String.format(Locale.US, "%.5f", Double.valueOf(splitScreenSize3 / d14))), 0.0d);
            case 6:
                if (nexLayerItem.getSplitScreenSize() == 0) {
                    double d15 = this.f3632h.f3634b;
                    double d16 = this.f3628d.f3636b;
                    Double.isNaN(d15);
                    Double.isNaN(d16);
                    return new c.a(0.0d, d15 / d16);
                }
                double splitScreenSize4 = this.f3631g.f3636b - nexLayerItem.getSplitScreenSize();
                double d17 = this.f3628d.f3636b;
                Double.isNaN(splitScreenSize4);
                Double.isNaN(d17);
                return new c.a(0.0d, Double.parseDouble(String.format("%.5f", Double.valueOf(splitScreenSize4 / d17))));
        }
    }
}
