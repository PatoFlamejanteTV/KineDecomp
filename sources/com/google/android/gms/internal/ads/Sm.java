package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* loaded from: classes2.dex */
final class Sm extends PushbackInputStream {

    /* renamed from: a */
    private final /* synthetic */ Pm f11836a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Sm(Pm pm, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.f11836a = pm;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f11836a.f11781c.disconnect();
        super.close();
    }
}
