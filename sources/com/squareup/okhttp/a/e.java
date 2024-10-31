package com.squareup.okhttp.a;

import com.squareup.okhttp.a.f;
import java.io.IOException;
import okio.y;

/* compiled from: DiskLruCache.java */
/* loaded from: classes3.dex */
public class e extends g {

    /* renamed from: c */
    final /* synthetic */ f.a f25163c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f.a aVar, y yVar) {
        super(yVar);
        this.f25163c = aVar;
    }

    @Override // com.squareup.okhttp.a.g
    protected void a(IOException iOException) {
        synchronized (f.this) {
            this.f25163c.f25174c = true;
        }
    }
}
