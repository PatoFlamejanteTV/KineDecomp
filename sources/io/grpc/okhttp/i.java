package io.grpc.okhttp;

import io.grpc.okhttp.l;
import java.io.IOException;
import java.util.List;

/* compiled from: AsyncFrameWriter.java */
/* loaded from: classes3.dex */
public class i extends l.a {

    /* renamed from: b */
    final /* synthetic */ boolean f27861b;

    /* renamed from: c */
    final /* synthetic */ boolean f27862c;

    /* renamed from: d */
    final /* synthetic */ int f27863d;

    /* renamed from: e */
    final /* synthetic */ int f27864e;

    /* renamed from: f */
    final /* synthetic */ List f27865f;

    /* renamed from: g */
    final /* synthetic */ l f27866g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(l lVar, boolean z, boolean z2, int i, int i2, List list) {
        super(lVar, null);
        this.f27866g = lVar;
        this.f27861b = z;
        this.f27862c = z2;
        this.f27863d = i;
        this.f27864e = i2;
        this.f27865f = list;
    }

    @Override // io.grpc.okhttp.l.a
    public void b() throws IOException {
        this.f27866g.f27971b.a(this.f27861b, this.f27862c, this.f27863d, this.f27864e, this.f27865f);
    }
}
