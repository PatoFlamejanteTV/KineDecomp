package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServiceMethod.java */
/* loaded from: classes3.dex */
public abstract class G<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> G<T> a(F f2, Method method) {
        C a2 = C.a(f2, method);
        Type genericReturnType = method.getGenericReturnType();
        if (H.d(genericReturnType)) {
            throw H.a(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType != Void.TYPE) {
            return r.a(f2, method, a2);
        }
        throw H.a(method, "Service methods cannot return void.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T a(Object[] objArr);
}
