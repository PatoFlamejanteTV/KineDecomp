package com.google.zxing.oned.rss;

import com.google.zxing.oned.OneDReader;

/* loaded from: classes2.dex */
public abstract class AbstractRSSReader extends OneDReader {

    /* renamed from: a */
    private final int[] f19184a = new int[4];

    /* renamed from: b */
    private final int[] f19185b = new int[8];

    /* renamed from: c */
    private final float[] f19186c = new float[4];

    /* renamed from: d */
    private final float[] f19187d = new float[4];

    /* renamed from: e */
    private final int[] f19188e;

    /* renamed from: f */
    private final int[] f19189f;

    public AbstractRSSReader() {
        int[] iArr = this.f19185b;
        this.f19188e = new int[iArr.length / 2];
        this.f19189f = new int[iArr.length / 2];
    }
}
