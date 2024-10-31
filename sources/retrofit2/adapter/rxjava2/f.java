package retrofit2.adapter.rxjava2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.m;
import io.reactivex.r;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.InterfaceC2578b;
import retrofit2.InterfaceC2579c;

/* compiled from: RxJava2CallAdapter.java */
/* loaded from: classes3.dex */
final class f<R> implements InterfaceC2579c<R, Object> {

    /* renamed from: a, reason: collision with root package name */
    private final Type f29477a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final r f29478b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f29479c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f29480d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f29481e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f29482f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f29483g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f29484h;
    private final boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Type type, @Nullable r rVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f29477a = type;
        this.f29478b = rVar;
        this.f29479c = z;
        this.f29480d = z2;
        this.f29481e = z3;
        this.f29482f = z4;
        this.f29483g = z5;
        this.f29484h = z6;
        this.i = z7;
    }

    @Override // retrofit2.InterfaceC2579c
    public Type a() {
        return this.f29477a;
    }

    @Override // retrofit2.InterfaceC2579c
    public Object a(InterfaceC2578b<R> interfaceC2578b) {
        m cVar;
        m aVar;
        if (this.f29479c) {
            cVar = new b(interfaceC2578b);
        } else {
            cVar = new c(interfaceC2578b);
        }
        if (this.f29480d) {
            aVar = new e(cVar);
        } else {
            aVar = this.f29481e ? new a(cVar) : cVar;
        }
        r rVar = this.f29478b;
        if (rVar != null) {
            aVar = aVar.b(rVar);
        }
        if (this.f29482f) {
            return aVar.a(BackpressureStrategy.LATEST);
        }
        if (this.f29483g) {
            return aVar.e();
        }
        if (this.f29484h) {
            return aVar.d();
        }
        if (this.i) {
            return aVar.c();
        }
        return io.reactivex.f.a.a(aVar);
    }
}
