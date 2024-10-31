package com.bumptech.glide.e;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImageHeaderParserRegistry.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    private final List<ImageHeaderParser> f8471a = new ArrayList();

    public synchronized List<ImageHeaderParser> a() {
        return this.f8471a;
    }

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.f8471a.add(imageHeaderParser);
    }
}
