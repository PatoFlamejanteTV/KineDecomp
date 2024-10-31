package com.google.zxing.aztec.encoder;

import java.util.Comparator;

/* compiled from: HighLevelEncoder.java */
/* loaded from: classes2.dex */
public class b implements Comparator<d> {

    /* renamed from: a */
    final /* synthetic */ HighLevelEncoder f18985a;

    public b(HighLevelEncoder highLevelEncoder) {
        this.f18985a = highLevelEncoder;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(d dVar, d dVar2) {
        return dVar.b() - dVar2.b();
    }
}
