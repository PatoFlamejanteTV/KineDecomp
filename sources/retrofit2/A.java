package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.InterfaceC2579c;
import retrofit2.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Platform.java */
/* loaded from: classes3.dex */
public class A {

    /* renamed from: a, reason: collision with root package name */
    private static final A f29391a = e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Platform.java */
    /* loaded from: classes3.dex */
    public static class b extends A {
        b() {
        }

        @Override // retrofit2.A
        boolean a(Method method) {
            return method.isDefault();
        }

        @Override // retrofit2.A
        List<? extends j.a> b() {
            return Collections.singletonList(w.f29533a);
        }

        @Override // retrofit2.A
        int c() {
            return 1;
        }

        @Override // retrofit2.A
        Object a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }

        @Override // retrofit2.A
        List<? extends InterfaceC2579c.a> a(@Nullable Executor executor) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(C2583g.f29491a);
            if (executor != null) {
                arrayList.add(new q(executor));
            } else {
                arrayList.add(l.f29500a);
            }
            return Collections.unmodifiableList(arrayList);
        }
    }

    A() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static A d() {
        return f29391a;
    }

    private static A e() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new b();
        } catch (ClassNotFoundException unused2) {
            return new A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends InterfaceC2579c.a> a(@Nullable Executor executor) {
        if (executor != null) {
            return Collections.singletonList(new q(executor));
        }
        return Collections.singletonList(l.f29500a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Executor a() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Method method) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends j.a> b() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Platform.java */
    /* loaded from: classes3.dex */
    public static class a extends A {

        /* compiled from: Platform.java */
        /* renamed from: retrofit2.A$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static class ExecutorC0172a implements Executor {

            /* renamed from: a, reason: collision with root package name */
            private final Handler f29392a = new Handler(Looper.getMainLooper());

            ExecutorC0172a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f29392a.post(runnable);
            }
        }

        a() {
        }

        @Override // retrofit2.A
        boolean a(Method method) {
            if (Build.VERSION.SDK_INT < 24) {
                return false;
            }
            return method.isDefault();
        }

        @Override // retrofit2.A
        List<? extends j.a> b() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Collections.singletonList(w.f29533a);
            }
            return Collections.emptyList();
        }

        @Override // retrofit2.A
        int c() {
            return Build.VERSION.SDK_INT >= 24 ? 1 : 0;
        }

        @Override // retrofit2.A
        public Executor a() {
            return new ExecutorC0172a();
        }

        @Override // retrofit2.A
        List<? extends InterfaceC2579c.a> a(@Nullable Executor executor) {
            if (executor != null) {
                q qVar = new q(executor);
                return Build.VERSION.SDK_INT >= 24 ? Arrays.asList(C2583g.f29491a, qVar) : Collections.singletonList(qVar);
            }
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Object a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }
}
