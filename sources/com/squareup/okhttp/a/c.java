package com.squareup.okhttp.a;

import java.io.IOException;
import okio.y;

/* compiled from: DiskLruCache.java */
/* loaded from: classes3.dex */
public class c extends g {

    /* renamed from: c */
    final /* synthetic */ f f25162c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(f fVar, y yVar) {
        super(yVar);
        this.f25162c = fVar;
    }

    @Override // com.squareup.okhttp.a.g
    protected void a(IOException iOException) {
        this.f25162c.o = true;
    }
}
