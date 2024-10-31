package okhttp3.a.b;

import java.io.IOException;
import java.util.List;
import okhttp3.B;
import okhttp3.I;
import okhttp3.InterfaceC2562f;
import okhttp3.InterfaceC2567k;
import okhttp3.M;
import okhttp3.w;

/* compiled from: RealInterceptorChain.java */
/* loaded from: classes3.dex */
public final class h implements B.a {

    /* renamed from: a, reason: collision with root package name */
    private final List<B> f28880a;

    /* renamed from: b, reason: collision with root package name */
    private final okhttp3.internal.connection.f f28881b;

    /* renamed from: c, reason: collision with root package name */
    private final c f28882c;

    /* renamed from: d, reason: collision with root package name */
    private final okhttp3.internal.connection.c f28883d;

    /* renamed from: e, reason: collision with root package name */
    private final int f28884e;

    /* renamed from: f, reason: collision with root package name */
    private final I f28885f;

    /* renamed from: g, reason: collision with root package name */
    private final InterfaceC2562f f28886g;

    /* renamed from: h, reason: collision with root package name */
    private final w f28887h;
    private final int i;
    private final int j;
    private final int k;
    private int l;

    public h(List<B> list, okhttp3.internal.connection.f fVar, c cVar, okhttp3.internal.connection.c cVar2, int i, I i2, InterfaceC2562f interfaceC2562f, w wVar, int i3, int i4, int i5) {
        this.f28880a = list;
        this.f28883d = cVar2;
        this.f28881b = fVar;
        this.f28882c = cVar;
        this.f28884e = i;
        this.f28885f = i2;
        this.f28886g = interfaceC2562f;
        this.f28887h = wVar;
        this.i = i3;
        this.j = i4;
        this.k = i5;
    }

    @Override // okhttp3.B.a
    public I a() {
        return this.f28885f;
    }

    @Override // okhttp3.B.a
    public int b() {
        return this.j;
    }

    @Override // okhttp3.B.a
    public int c() {
        return this.k;
    }

    @Override // okhttp3.B.a
    public int d() {
        return this.i;
    }

    public InterfaceC2562f e() {
        return this.f28886g;
    }

    public InterfaceC2567k f() {
        return this.f28883d;
    }

    public w g() {
        return this.f28887h;
    }

    public c h() {
        return this.f28882c;
    }

    public okhttp3.internal.connection.f i() {
        return this.f28881b;
    }

    @Override // okhttp3.B.a
    public M a(I i) throws IOException {
        return a(i, this.f28881b, this.f28882c, this.f28883d);
    }

    public M a(I i, okhttp3.internal.connection.f fVar, c cVar, okhttp3.internal.connection.c cVar2) throws IOException {
        if (this.f28884e < this.f28880a.size()) {
            this.l++;
            if (this.f28882c != null && !this.f28883d.a(i.g())) {
                throw new IllegalStateException("network interceptor " + this.f28880a.get(this.f28884e - 1) + " must retain the same host and port");
            }
            if (this.f28882c != null && this.l > 1) {
                throw new IllegalStateException("network interceptor " + this.f28880a.get(this.f28884e - 1) + " must call proceed() exactly once");
            }
            h hVar = new h(this.f28880a, fVar, cVar, cVar2, this.f28884e + 1, i, this.f28886g, this.f28887h, this.i, this.j, this.k);
            B b2 = this.f28880a.get(this.f28884e);
            M a2 = b2.a(hVar);
            if (cVar != null && this.f28884e + 1 < this.f28880a.size() && hVar.l != 1) {
                throw new IllegalStateException("network interceptor " + b2 + " must call proceed() exactly once");
            }
            if (a2 != null) {
                if (a2.a() != null) {
                    return a2;
                }
                throw new IllegalStateException("interceptor " + b2 + " returned a response with no body");
            }
            throw new NullPointerException("interceptor " + b2 + " returned null");
        }
        throw new AssertionError();
    }
}
