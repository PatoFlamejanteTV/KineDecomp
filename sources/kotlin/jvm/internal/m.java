package kotlin.jvm.internal;

/* compiled from: TypeIntrinsics.java */
/* loaded from: classes3.dex */
public class m {
    private static <T extends Throwable> T a(T t) {
        h.a((Throwable) t, m.class.getName());
        return t;
    }

    public static boolean b(Object obj, int i) {
        return (obj instanceof kotlin.c) && a(obj) == i;
    }

    public static void a(Object obj, String str) {
        a((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
        throw null;
    }

    public static void a(String str) {
        a(new ClassCastException(str));
        throw null;
    }

    public static ClassCastException a(ClassCastException classCastException) {
        a(classCastException);
        throw classCastException;
    }

    public static int a(Object obj) {
        if (obj instanceof g) {
            return ((g) obj).getArity();
        }
        if (obj instanceof kotlin.jvm.a.a) {
            return 0;
        }
        if (obj instanceof kotlin.jvm.a.b) {
            return 1;
        }
        return obj instanceof kotlin.jvm.a.c ? 2 : -1;
    }

    public static Object a(Object obj, int i) {
        if (obj == null || b(obj, i)) {
            return obj;
        }
        a(obj, "kotlin.jvm.functions.Function" + i);
        throw null;
    }
}
