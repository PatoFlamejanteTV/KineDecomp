package okhttp3.internal.http2;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Http2Connection.java */
/* loaded from: classes3.dex */
public class e extends okhttp3.a.b {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f29063b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ErrorCode f29064c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ k f29065d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(k kVar, String str, Object[] objArr, int i, ErrorCode errorCode) {
        super(str, objArr);
        this.f29065d = kVar;
        this.f29063b = i;
        this.f29064c = errorCode;
    }

    @Override // okhttp3.a.b
    public void c() {
        try {
            this.f29065d.b(this.f29063b, this.f29064c);
        } catch (IOException unused) {
            this.f29065d.s();
        }
    }
}
