package io.grpc.okhttp;

import io.grpc.okhttp.l;
import java.io.IOException;

/* compiled from: AsyncFrameWriter.java */
/* loaded from: classes3.dex */
public class h extends l.a {

    /* renamed from: b */
    final /* synthetic */ l f27860b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(l lVar) {
        super(lVar, null);
        this.f27860b = lVar;
    }

    @Override // io.grpc.okhttp.l.a
    public void b() throws IOException {
        this.f27860b.f27971b.flush();
    }
}
