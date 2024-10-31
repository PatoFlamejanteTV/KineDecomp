package e.a.c;

import java.util.ServiceConfigurationError;

/* compiled from: Provider.java */
/* loaded from: classes3.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(Class<?> cls, Class<T> cls2) {
        try {
            return (T) cls.asSubclass(cls2).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            throw new ServiceConfigurationError("Provider " + cls.getName() + " could not be instantiated.", e2);
        }
    }
}
