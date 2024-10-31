package retrofit2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Retrofit.java */
/* loaded from: classes3.dex */
public class E implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    private final A f29422a = A.d();

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f29423b = new Object[0];

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Class f29424c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f29425d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(F f2, Class cls) {
        this.f29425d = f2;
        this.f29424c = cls;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (this.f29422a.a(method)) {
            return this.f29422a.a(method, this.f29424c, obj, objArr);
        }
        G<?> a2 = this.f29425d.a(method);
        if (objArr == null) {
            objArr = this.f29423b;
        }
        return a2.a(objArr);
    }
}
