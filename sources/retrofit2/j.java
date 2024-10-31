package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.L;
import okhttp3.O;

/* compiled from: Converter.java */
/* loaded from: classes3.dex */
public interface j<F, T> {

    /* compiled from: Converter.java */
    /* loaded from: classes3.dex */
    public static abstract class a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static Type a(int i, ParameterizedType parameterizedType) {
            return H.a(i, parameterizedType);
        }

        @Nullable
        public j<O, ?> a(Type type, Annotation[] annotationArr, F f2) {
            return null;
        }

        @Nullable
        public j<?, L> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, F f2) {
            return null;
        }

        @Nullable
        public j<?, String> b(Type type, Annotation[] annotationArr, F f2) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static Class<?> a(Type type) {
            return H.c(type);
        }
    }

    @Nullable
    T a(F f2) throws IOException;
}
