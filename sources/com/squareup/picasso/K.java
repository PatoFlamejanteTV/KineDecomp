package com.squareup.picasso;

/* compiled from: UrlConnectionDownloader.java */
/* loaded from: classes3.dex */
class K extends ThreadLocal<StringBuilder> {
    @Override // java.lang.ThreadLocal
    public StringBuilder initialValue() {
        return new StringBuilder();
    }
}
