package com.squareup.picasso;

/* compiled from: BitmapHunter.java */
/* renamed from: com.squareup.picasso.c */
/* loaded from: classes3.dex */
class C2390c extends ThreadLocal<StringBuilder> {
    @Override // java.lang.ThreadLocal
    public StringBuilder initialValue() {
        return new StringBuilder("Picasso-");
    }
}
