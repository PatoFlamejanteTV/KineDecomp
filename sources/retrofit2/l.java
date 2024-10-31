package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.InterfaceC2579c;

/* compiled from: DefaultCallAdapterFactory.java */
/* loaded from: classes3.dex */
public final class l extends InterfaceC2579c.a {

    /* renamed from: a */
    static final InterfaceC2579c.a f29500a = new l();

    l() {
    }

    @Override // retrofit2.InterfaceC2579c.a
    @Nullable
    public InterfaceC2579c<?, ?> a(Type type, Annotation[] annotationArr, F f2) {
        if (InterfaceC2579c.a.a(type) != InterfaceC2578b.class) {
            return null;
        }
        return new k(this, H.b(type));
    }
}
