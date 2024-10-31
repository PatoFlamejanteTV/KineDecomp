package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* compiled from: Invocation.java */
/* loaded from: classes3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final Method f29516a;

    /* renamed from: b, reason: collision with root package name */
    private final List<?> f29517b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(Method method, List<?> list) {
        this.f29516a = method;
        this.f29517b = Collections.unmodifiableList(list);
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f29516a.getDeclaringClass().getName(), this.f29516a.getName(), this.f29517b);
    }
}
