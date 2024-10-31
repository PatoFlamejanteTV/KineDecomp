package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* compiled from: CallAdapter.java */
/* renamed from: retrofit2.c */
/* loaded from: classes3.dex */
public interface InterfaceC2579c<R, T> {

    /* compiled from: CallAdapter.java */
    /* renamed from: retrofit2.c$a */
    /* loaded from: classes3.dex */
    public static abstract class a {
        public static Type a(int i, ParameterizedType parameterizedType) {
            return H.a(i, parameterizedType);
        }

        @Nullable
        public abstract InterfaceC2579c<?, ?> a(Type type, Annotation[] annotationArr, F f2);

        public static Class<?> a(Type type) {
            return H.c(type);
        }
    }

    T a(InterfaceC2578b<R> interfaceC2578b);

    Type a();
}
