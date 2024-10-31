package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import okhttp3.O;
import retrofit2.j;

/* compiled from: OptionalConverterFactory.java */
/* loaded from: classes3.dex */
final class w extends j.a {

    /* renamed from: a, reason: collision with root package name */
    static final j.a f29533a = new w();

    /* compiled from: OptionalConverterFactory.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements j<O, Optional<T>> {

        /* renamed from: a, reason: collision with root package name */
        final j<O, T> f29534a;

        a(j<O, T> jVar) {
            this.f29534a = jVar;
        }

        @Override // retrofit2.j
        public Optional<T> a(O o) throws IOException {
            return Optional.ofNullable(this.f29534a.a(o));
        }
    }

    w() {
    }

    @Override // retrofit2.j.a
    @Nullable
    public j<O, ?> a(Type type, Annotation[] annotationArr, F f2) {
        if (j.a.a(type) != Optional.class) {
            return null;
        }
        return new a(f2.b(j.a.a(0, (ParameterizedType) type), annotationArr));
    }
}
