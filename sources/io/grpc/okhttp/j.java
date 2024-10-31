package io.grpc.okhttp;

import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.l;
import java.io.IOException;

/* compiled from: AsyncFrameWriter.java */
/* loaded from: classes3.dex */
public class j extends l.a {

    /* renamed from: b */
    final /* synthetic */ int f27962b;

    /* renamed from: c */
    final /* synthetic */ ErrorCode f27963c;

    /* renamed from: d */
    final /* synthetic */ l f27964d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(l lVar, int i, ErrorCode errorCode) {
        super(lVar, null);
        this.f27964d = lVar;
        this.f27962b = i;
        this.f27963c = errorCode;
    }

    @Override // io.grpc.okhttp.l.a
    public void b() throws IOException {
        this.f27964d.f27971b.a(this.f27962b, this.f27963c);
    }
}
