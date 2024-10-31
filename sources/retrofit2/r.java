package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import okhttp3.InterfaceC2562f;
import okhttp3.M;
import okhttp3.O;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpServiceMethod.java */
/* loaded from: classes3.dex */
public final class r<ResponseT, ReturnT> extends G<ReturnT> {

    /* renamed from: a, reason: collision with root package name */
    private final C f29512a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC2562f.a f29513b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC2579c<ResponseT, ReturnT> f29514c;

    /* renamed from: d, reason: collision with root package name */
    private final j<O, ResponseT> f29515d;

    private r(C c2, InterfaceC2562f.a aVar, InterfaceC2579c<ResponseT, ReturnT> interfaceC2579c, j<O, ResponseT> jVar) {
        this.f29512a = c2;
        this.f29513b = aVar;
        this.f29514c = interfaceC2579c;
        this.f29515d = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <ResponseT, ReturnT> r<ResponseT, ReturnT> a(F f2, Method method, C c2) {
        InterfaceC2579c b2 = b(f2, method);
        Type a2 = b2.a();
        if (a2 != D.class && a2 != M.class) {
            if (c2.f29405c.equals("HEAD") && !Void.class.equals(a2)) {
                throw H.a(method, "HEAD method must use Void as response type.", new Object[0]);
            }
            return new r<>(c2, f2.f29427b, b2, a(f2, method, a2));
        }
        throw H.a(method, "'" + H.c(a2).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    }

    private static <ResponseT, ReturnT> InterfaceC2579c<ResponseT, ReturnT> b(F f2, Method method) {
        Type genericReturnType = method.getGenericReturnType();
        try {
            return (InterfaceC2579c<ResponseT, ReturnT>) f2.a(genericReturnType, method.getAnnotations());
        } catch (RuntimeException e2) {
            throw H.a(method, e2, "Unable to create call adapter for %s", genericReturnType);
        }
    }

    private static <ResponseT> j<O, ResponseT> a(F f2, Method method, Type type) {
        try {
            return f2.b(type, method.getAnnotations());
        } catch (RuntimeException e2) {
            throw H.a(method, e2, "Unable to create converter for %s", type);
        }
    }

    @Override // retrofit2.G
    ReturnT a(Object[] objArr) {
        return this.f29514c.a(new v(this.f29512a, objArr, this.f29513b, this.f29515d));
    }
}
