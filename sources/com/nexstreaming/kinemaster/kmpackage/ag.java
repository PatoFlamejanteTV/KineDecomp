package com.nexstreaming.kinemaster.kmpackage;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: KMTInputStreamWrapper.java */
/* loaded from: classes.dex */
class ag {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f3434a;
    public final long b;

    public ag(InputStream inputStream, long j) {
        this.f3434a = inputStream;
        this.b = j;
    }

    public ag(InputStream inputStream) throws IOException {
        this.f3434a = inputStream;
        this.b = inputStream.available();
    }
}
