package com.squareup.picasso;

import java.io.PrintWriter;

/* compiled from: StatsSnapshot.java */
/* loaded from: classes3.dex */
public class I {

    /* renamed from: a */
    public final int f25587a;

    /* renamed from: b */
    public final int f25588b;

    /* renamed from: c */
    public final long f25589c;

    /* renamed from: d */
    public final long f25590d;

    /* renamed from: e */
    public final long f25591e;

    /* renamed from: f */
    public final long f25592f;

    /* renamed from: g */
    public final long f25593g;

    /* renamed from: h */
    public final long f25594h;
    public final long i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final long n;

    public I(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f25587a = i;
        this.f25588b = i2;
        this.f25589c = j;
        this.f25590d = j2;
        this.f25591e = j3;
        this.f25592f = j4;
        this.f25593g = j5;
        this.f25594h = j6;
        this.i = j7;
        this.j = j8;
        this.k = i3;
        this.l = i4;
        this.m = i5;
        this.n = j9;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f25587a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f25588b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((this.f25588b / this.f25587a) * 100.0f));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f25589c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f25590d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f25591e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f25594h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f25592f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f25593g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f25587a + ", size=" + this.f25588b + ", cacheHits=" + this.f25589c + ", cacheMisses=" + this.f25590d + ", downloadCount=" + this.k + ", totalDownloadSize=" + this.f25591e + ", averageDownloadSize=" + this.f25594h + ", totalOriginalBitmapSize=" + this.f25592f + ", totalTransformedBitmapSize=" + this.f25593g + ", averageOriginalBitmapSize=" + this.i + ", averageTransformedBitmapSize=" + this.j + ", originalBitmapCount=" + this.l + ", transformedBitmapCount=" + this.m + ", timeStamp=" + this.n + '}';
    }
}
