package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.h;

/* compiled from: DebugMetadata.kt */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: b */
    public static a f28519b;

    /* renamed from: c */
    public static final f f28520c = new f();

    /* renamed from: a */
    private static final a f28518a = new a(null, null, null);

    /* compiled from: DebugMetadata.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        public final Method f28521a;

        /* renamed from: b */
        public final Method f28522b;

        /* renamed from: c */
        public final Method f28523c;

        public a(Method method, Method method2, Method method3) {
            this.f28521a = method;
            this.f28522b = method2;
            this.f28523c = method3;
        }
    }

    private f() {
    }

    private final a b(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f28519b = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f28518a;
            f28519b = aVar2;
            return aVar2;
        }
    }

    public final String a(BaseContinuationImpl baseContinuationImpl) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        h.b(baseContinuationImpl, "continuation");
        a aVar = f28519b;
        if (aVar == null) {
            aVar = b(baseContinuationImpl);
        }
        if (aVar == f28518a || (method = aVar.f28521a) == null || (invoke = method.invoke(baseContinuationImpl.getClass(), new Object[0])) == null || (method2 = aVar.f28522b) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.f28523c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (!(invoke3 instanceof String)) {
            invoke3 = null;
        }
        return (String) invoke3;
    }
}
