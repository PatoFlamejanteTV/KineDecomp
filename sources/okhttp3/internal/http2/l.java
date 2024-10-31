package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.http2.k;

/* compiled from: Http2Connection.java */
/* loaded from: classes3.dex */
class l extends k.b {
    @Override // okhttp3.internal.http2.k.b
    public void a(q qVar) throws IOException {
        qVar.a(ErrorCode.REFUSED_STREAM);
    }
}
