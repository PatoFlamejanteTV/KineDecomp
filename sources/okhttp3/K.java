package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: RequestBody.java */
/* loaded from: classes3.dex */
public class K extends L {

    /* renamed from: a */
    final /* synthetic */ C f28815a;

    /* renamed from: b */
    final /* synthetic */ int f28816b;

    /* renamed from: c */
    final /* synthetic */ byte[] f28817c;

    /* renamed from: d */
    final /* synthetic */ int f28818d;

    public K(C c2, int i, byte[] bArr, int i2) {
        this.f28815a = c2;
        this.f28816b = i;
        this.f28817c = bArr;
        this.f28818d = i2;
    }

    @Override // okhttp3.L
    public long a() {
        return this.f28816b;
    }

    @Override // okhttp3.L
    @Nullable
    public C b() {
        return this.f28815a;
    }

    @Override // okhttp3.L
    public void a(okio.h hVar) throws IOException {
        hVar.write(this.f28817c, this.f28818d, this.f28816b);
    }
}
