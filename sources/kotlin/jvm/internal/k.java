package kotlin.jvm.internal;

/* compiled from: ReflectionFactory.java */
/* loaded from: classes.dex */
public class k {
    public kotlin.reflect.e a(Class cls, String str) {
        return new i(cls, str);
    }

    public kotlin.reflect.f a(FunctionReference functionReference) {
        return functionReference;
    }

    public kotlin.reflect.h a(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public kotlin.reflect.i a(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public kotlin.reflect.c a(Class cls) {
        return new d(cls);
    }

    public String a(Lambda lambda) {
        return a((g) lambda);
    }

    public String a(g gVar) {
        String obj = gVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
