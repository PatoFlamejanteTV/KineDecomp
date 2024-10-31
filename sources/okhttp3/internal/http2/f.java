package okhttp3.internal.http2;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Http2Connection.java */
/* loaded from: classes3.dex */
public class f extends okhttp3.a.b {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f29066b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f29067c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ k f29068d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(k kVar, String str, Object[] objArr, int i, long j) {
        super(str, objArr);
        this.f29068d = kVar;
        this.f29066b = i;
        this.f29067c = j;
    }

    @Override // okhttp3.a.b
    public void c() {
        try {
            this.f29068d.s.a(this.f29066b, this.f29067c);
        } catch (IOException unused) {
            this.f29068d.s();
        }
    }
}
