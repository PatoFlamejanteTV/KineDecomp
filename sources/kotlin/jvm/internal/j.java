package kotlin.jvm.internal;

/* compiled from: Reflection.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a */
    private static final k f28542a;

    /* renamed from: b */
    private static final kotlin.reflect.c[] f28543b;

    static {
        k kVar = null;
        try {
            kVar = (k) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (kVar == null) {
            kVar = new k();
        }
        f28542a = kVar;
        f28543b = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.e a(Class cls, String str) {
        return f28542a.a(cls, str);
    }

    public static kotlin.reflect.c a(Class cls) {
        return f28542a.a(cls);
    }

    public static String a(Lambda lambda) {
        return f28542a.a(lambda);
    }

    public static String a(g gVar) {
        return f28542a.a(gVar);
    }

    public static kotlin.reflect.f a(FunctionReference functionReference) {
        f28542a.a(functionReference);
        return functionReference;
    }

    public static kotlin.reflect.h a(PropertyReference0 propertyReference0) {
        f28542a.a(propertyReference0);
        return propertyReference0;
    }

    public static kotlin.reflect.i a(PropertyReference1 propertyReference1) {
        f28542a.a(propertyReference1);
        return propertyReference1;
    }
}
