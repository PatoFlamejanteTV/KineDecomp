package com.bumptech.glide.load.engine.a;

/* compiled from: IntegerArrayAdapter.java */
/* loaded from: classes.dex */
public final class i implements a<int[]> {
    @Override // com.bumptech.glide.load.engine.a.a
    public int a() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public String getTag() {
        return "IntegerArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public int a(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.engine.a.a
    public int[] newArray(int i) {
        return new int[i];
    }
}
