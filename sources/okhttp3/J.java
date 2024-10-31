package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;
import okio.ByteString;

/* compiled from: RequestBody.java */
/* loaded from: classes3.dex */
public class J extends L {

    /* renamed from: a */
    final /* synthetic */ C f28813a;

    /* renamed from: b */
    final /* synthetic */ ByteString f28814b;

    public J(C c2, ByteString byteString) {
        this.f28813a = c2;
        this.f28814b = byteString;
    }

    @Override // okhttp3.L
    public long a() throws IOException {
        return this.f28814b.size();
    }

    @Override // okhttp3.L
    @Nullable
    public C b() {
        return this.f28813a;
    }

    @Override // okhttp3.L
    public void a(okio.h hVar) throws IOException {
        hVar.a(this.f28814b);
    }
}
