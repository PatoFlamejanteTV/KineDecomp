package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;

/* compiled from: PushObserver.java */
/* loaded from: classes3.dex */
class t implements u {
    @Override // okhttp3.internal.http2.u
    public void a(int i, ErrorCode errorCode) {
    }

    @Override // okhttp3.internal.http2.u
    public boolean a(int i, List<a> list) {
        return true;
    }

    @Override // okhttp3.internal.http2.u
    public boolean a(int i, List<a> list, boolean z) {
        return true;
    }

    @Override // okhttp3.internal.http2.u
    public boolean a(int i, okio.i iVar, int i2, boolean z) throws IOException {
        iVar.skip(i2);
        return true;
    }
}
