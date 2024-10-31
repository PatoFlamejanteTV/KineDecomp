package retrofit2.adapter.rxjava2;

import io.reactivex.i;
import io.reactivex.m;
import io.reactivex.r;
import io.reactivex.s;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.D;
import retrofit2.F;
import retrofit2.InterfaceC2579c;

/* compiled from: RxJava2CallAdapterFactory.java */
/* loaded from: classes3.dex */
public final class g extends InterfaceC2579c.a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final r f29485a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f29486b;

    private g(@Nullable r rVar, boolean z) {
        this.f29485a = rVar;
        this.f29486b = z;
    }

    public static g a() {
        return new g(null, false);
    }

    @Override // retrofit2.InterfaceC2579c.a
    @Nullable
    public InterfaceC2579c<?, ?> a(Type type, Annotation[] annotationArr, F f2) {
        Type type2;
        boolean z;
        boolean z2;
        Class<?> a2 = InterfaceC2579c.a.a(type);
        if (a2 == io.reactivex.a.class) {
            return new f(Void.class, this.f29485a, this.f29486b, false, true, false, false, false, true);
        }
        boolean z3 = a2 == io.reactivex.e.class;
        boolean z4 = a2 == s.class;
        boolean z5 = a2 == i.class;
        if (a2 != m.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type a3 = InterfaceC2579c.a.a(0, (ParameterizedType) type);
        Class<?> a4 = InterfaceC2579c.a.a(a3);
        if (a4 == D.class) {
            if (a3 instanceof ParameterizedType) {
                type2 = InterfaceC2579c.a.a(0, (ParameterizedType) a3);
                z = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (a4 == d.class) {
            if (a3 instanceof ParameterizedType) {
                type2 = InterfaceC2579c.a.a(0, (ParameterizedType) a3);
                z = true;
            } else {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
        } else {
            type2 = a3;
            z = false;
            z2 = true;
            return new f(type2, this.f29485a, this.f29486b, z, z2, z3, z4, z5, false);
        }
        z2 = false;
        return new f(type2, this.f29485a, this.f29486b, z, z2, z3, z4, z5, false);
    }
}
