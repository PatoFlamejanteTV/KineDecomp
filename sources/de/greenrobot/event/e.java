package de.greenrobot.event;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* compiled from: EventBus.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a */
    public static String f26675a = "Event";

    /* renamed from: b */
    static volatile e f26676b;

    /* renamed from: c */
    private static final f f26677c = new f();

    /* renamed from: d */
    private static final Map<Class<?>, List<Class<?>>> f26678d = new HashMap();

    /* renamed from: e */
    private final Map<Class<?>, CopyOnWriteArrayList<n>> f26679e;

    /* renamed from: f */
    private final Map<Object, List<Class<?>>> f26680f;

    /* renamed from: g */
    private final Map<Class<?>, Object> f26681g;

    /* renamed from: h */
    private final ThreadLocal<a> f26682h;
    private final g i;
    private final b j;
    private final de.greenrobot.event.a k;
    private final m l;
    private final ExecutorService m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;

    /* compiled from: EventBus.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        final List<Object> f26683a = new ArrayList();

        /* renamed from: b */
        boolean f26684b;

        /* renamed from: c */
        boolean f26685c;

        /* renamed from: d */
        n f26686d;

        /* renamed from: e */
        Object f26687e;

        /* renamed from: f */
        boolean f26688f;
    }

    public e() {
        this(f26677c);
    }

    public static e a() {
        if (f26676b == null) {
            synchronized (e.class) {
                if (f26676b == null) {
                    f26676b = new e();
                }
            }
        }
        return f26676b;
    }

    public void b(Object obj) {
        a(obj, false, 0);
    }

    public synchronized void c(Object obj) {
        List<Class<?>> list = this.f26680f.get(obj);
        if (list != null) {
            Iterator<Class<?>> it = list.iterator();
            while (it.hasNext()) {
                a(obj, it.next());
            }
            this.f26680f.remove(obj);
        } else {
            Log.w(f26675a, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    e(f fVar) {
        this.f26682h = new c(this);
        this.f26679e = new HashMap();
        this.f26680f = new HashMap();
        this.f26681g = new ConcurrentHashMap();
        this.i = new g(this, Looper.getMainLooper(), 10);
        this.j = new b(this);
        this.k = new de.greenrobot.event.a(this);
        this.l = new m(fVar.i);
        this.o = fVar.f26690b;
        this.p = fVar.f26691c;
        this.q = fVar.f26692d;
        this.r = fVar.f26693e;
        this.n = fVar.f26694f;
        this.s = fVar.f26695g;
        this.m = fVar.f26696h;
    }

    public ExecutorService b() {
        return this.m;
    }

    private synchronized void a(Object obj, boolean z, int i) {
        Iterator<l> it = this.l.a(obj.getClass()).iterator();
        while (it.hasNext()) {
            a(obj, it.next(), z, i);
        }
    }

    private void a(Object obj, l lVar, boolean z, int i) {
        Object obj2;
        Class<?> cls = lVar.f26715c;
        CopyOnWriteArrayList<n> copyOnWriteArrayList = this.f26679e.get(cls);
        n nVar = new n(obj, lVar, i);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f26679e.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(nVar)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i2 = 0; i2 <= size; i2++) {
            if (i2 == size || nVar.f26721c > copyOnWriteArrayList.get(i2).f26721c) {
                copyOnWriteArrayList.add(i2, nVar);
                break;
            }
        }
        List<Class<?>> list = this.f26680f.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.f26680f.put(obj, list);
        }
        list.add(cls);
        if (z) {
            synchronized (this.f26681g) {
                obj2 = this.f26681g.get(cls);
            }
            if (obj2 != null) {
                a(nVar, obj2, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    private void a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<n> copyOnWriteArrayList = this.f26679e.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                n nVar = copyOnWriteArrayList.get(i);
                if (nVar.f26719a == obj) {
                    nVar.f26722d = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    public void a(Object obj) {
        a aVar = this.f26682h.get();
        List<Object> list = aVar.f26683a;
        list.add(obj);
        if (aVar.f26684b) {
            return;
        }
        aVar.f26685c = Looper.getMainLooper() == Looper.myLooper();
        aVar.f26684b = true;
        if (!aVar.f26688f) {
            while (!list.isEmpty()) {
                try {
                    a(list.remove(0), aVar);
                } finally {
                    aVar.f26684b = false;
                    aVar.f26685c = false;
                }
            }
            return;
        }
        throw new EventBusException("Internal error. Abort state was not reset");
    }

    private void a(Object obj, a aVar) throws Error {
        boolean a2;
        Class<?> cls = obj.getClass();
        if (this.s) {
            List<Class<?>> a3 = a(cls);
            int size = a3.size();
            a2 = false;
            for (int i = 0; i < size; i++) {
                a2 |= a(obj, aVar, a3.get(i));
            }
        } else {
            a2 = a(obj, aVar, cls);
        }
        if (a2) {
            return;
        }
        if (this.p) {
            Log.d(f26675a, "No subscribers registered for event " + cls);
        }
        if (!this.r || cls == h.class || cls == k.class) {
            return;
        }
        a(new h(this, obj));
    }

    private boolean a(Object obj, a aVar, Class<?> cls) {
        CopyOnWriteArrayList<n> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f26679e.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<n> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            aVar.f26687e = obj;
            aVar.f26686d = next;
            try {
                a(next, obj, aVar.f26685c);
                if (aVar.f26688f) {
                    return true;
                }
            } finally {
                aVar.f26687e = null;
                aVar.f26686d = null;
                aVar.f26688f = false;
            }
        }
        return true;
    }

    private void a(n nVar, Object obj, boolean z) {
        int i = d.f26674a[nVar.f26720b.f26714b.ordinal()];
        if (i == 1) {
            a(nVar, obj);
            return;
        }
        if (i == 2) {
            if (z) {
                a(nVar, obj);
                return;
            } else {
                this.i.a(nVar, obj);
                return;
            }
        }
        if (i == 3) {
            if (z) {
                this.j.a(nVar, obj);
                return;
            } else {
                a(nVar, obj);
                return;
            }
        }
        if (i == 4) {
            this.k.a(nVar, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + nVar.f26720b.f26714b);
    }

    private List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (f26678d) {
            list = f26678d.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                f26678d.put(cls, list);
            }
        }
        return list;
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public void a(i iVar) {
        Object obj = iVar.f26704b;
        n nVar = iVar.f26705c;
        i.a(iVar);
        if (nVar.f26722d) {
            a(nVar, obj);
        }
    }

    void a(n nVar, Object obj) {
        try {
            nVar.f26720b.f26713a.invoke(nVar.f26719a, obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            a(nVar, obj, e3.getCause());
        }
    }

    private void a(n nVar, Object obj, Throwable th) {
        if (obj instanceof k) {
            if (this.o) {
                Log.e(f26675a, "SubscriberExceptionEvent subscriber " + nVar.f26719a.getClass() + " threw an exception", th);
                k kVar = (k) obj;
                Log.e(f26675a, "Initial event " + kVar.f26711c + " caused exception in " + kVar.f26712d, kVar.f26710b);
                return;
            }
            return;
        }
        if (!this.n) {
            if (this.o) {
                Log.e(f26675a, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + nVar.f26719a.getClass(), th);
            }
            if (this.q) {
                a(new k(this, th, obj, nVar.f26719a));
                return;
            }
            return;
        }
        throw new EventBusException("Invoking subscriber failed", th);
    }
}
