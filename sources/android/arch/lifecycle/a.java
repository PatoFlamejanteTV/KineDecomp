package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClassesInfoCache.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    static a f31a = new a();

    /* renamed from: b */
    private final Map<Class, C0000a> f32b = new HashMap();

    /* renamed from: c */
    private final Map<Class, Boolean> f33c = new HashMap();

    /* compiled from: ClassesInfoCache.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        final int f36a;

        /* renamed from: b */
        final Method f37b;

        b(int i, Method method) {
            this.f36a = i;
            this.f37b = method;
            this.f37b.setAccessible(true);
        }

        void a(e eVar, Lifecycle.Event event, Object obj) {
            try {
                int i = this.f36a;
                if (i == 0) {
                    this.f37b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f37b.invoke(obj, eVar);
                } else {
                    if (i != 2) {
                        return;
                    }
                    this.f37b.invoke(obj, eVar, event);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to call observer method", e3.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f36a == bVar.f36a && this.f37b.getName().equals(bVar.f37b.getName());
        }

        public int hashCode() {
            return (this.f36a * 31) + this.f37b.getName().hashCode();
        }
    }

    a() {
    }

    private Method[] c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    public C0000a a(Class cls) {
        C0000a c0000a = this.f32b.get(cls);
        return c0000a != null ? c0000a : a(cls, null);
    }

    public boolean b(Class cls) {
        if (this.f33c.containsKey(cls)) {
            return this.f33c.get(cls).booleanValue();
        }
        Method[] c2 = c(cls);
        for (Method method : c2) {
            if (((n) method.getAnnotation(n.class)) != null) {
                a(cls, c2);
                return true;
            }
        }
        this.f33c.put(cls, false);
        return false;
    }

    /* compiled from: ClassesInfoCache.java */
    /* renamed from: android.arch.lifecycle.a$a */
    /* loaded from: classes.dex */
    public static class C0000a {

        /* renamed from: a */
        final Map<Lifecycle.Event, List<b>> f34a = new HashMap();

        /* renamed from: b */
        final Map<b, Lifecycle.Event> f35b;

        C0000a(Map<b, Lifecycle.Event> map) {
            this.f35b = map;
            for (Map.Entry<b, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<b> list = this.f34a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f34a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        public void a(e eVar, Lifecycle.Event event, Object obj) {
            a(this.f34a.get(event), eVar, event, obj);
            a(this.f34a.get(Lifecycle.Event.ON_ANY), eVar, event, obj);
        }

        private static void a(List<b> list, e eVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(eVar, event, obj);
                }
            }
        }
    }

    private void a(Map<b, Lifecycle.Event> map, b bVar, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = map.get(bVar);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(bVar, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f37b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }

    private C0000a a(Class cls, Method[] methodArr) {
        int i;
        C0000a a2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (a2 = a(superclass)) != null) {
            hashMap.putAll(a2.f35b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, Lifecycle.Event> entry : a(cls2).f35b.entrySet()) {
                a(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            n nVar = (n) method.getAnnotation(n.class);
            if (nVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(e.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                Lifecycle.Event value = nVar.value();
                if (parameterTypes.length > 1) {
                    if (parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        if (value != Lifecycle.Event.ON_ANY) {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0000a c0000a = new C0000a(hashMap);
        this.f32b.put(cls, c0000a);
        this.f33c.put(cls, Boolean.valueOf(z));
        return c0000a;
    }
}
