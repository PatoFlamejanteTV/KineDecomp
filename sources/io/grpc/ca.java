package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* compiled from: ServiceProviders.java */
/* loaded from: classes3.dex */
final class ca {

    /* compiled from: ServiceProviders.java */
    /* loaded from: classes3.dex */
    public interface a<T> {
        boolean a(T t);

        int b(T t);
    }

    public static <T> T a(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, a<T> aVar) {
        List b2 = b(cls, iterable, classLoader, aVar);
        if (b2.isEmpty()) {
            return null;
        }
        return (T) b2.get(0);
    }

    public static <T> List<T> b(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, a<T> aVar) {
        Iterable a2;
        if (a(classLoader)) {
            a2 = a(cls, iterable);
        } else {
            a2 = a(cls, classLoader);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : a2) {
            if (aVar.a(t)) {
                arrayList.add(t);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new ba(aVar)));
        return Collections.unmodifiableList(arrayList);
    }

    public static boolean a(ClassLoader classLoader) {
        try {
            Class.forName("android.app.Application", false, classLoader);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @VisibleForTesting
    public static <T> Iterable<T> a(Class<T> cls, ClassLoader classLoader) {
        ServiceLoader load = ServiceLoader.load(cls, classLoader);
        return !load.iterator().hasNext() ? ServiceLoader.load(cls) : load;
    }

    @VisibleForTesting
    static <T> Iterable<T> a(Class<T> cls, Iterable<Class<?>> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<Class<?>> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(a(cls, it.next()));
        }
        return arrayList;
    }

    @VisibleForTesting
    static <T> T a(Class<T> cls, Class<?> cls2) {
        try {
            return (T) cls2.asSubclass(cls).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", cls2.getName(), th), th);
        }
    }
}
