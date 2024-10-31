package android.support.v4.util;

/* loaded from: classes.dex */
public final class Pools {

    /* loaded from: classes.dex */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);
    }

    /* loaded from: classes.dex */
    public static class SimplePool<T> implements Pool<T> {

        /* renamed from: a */
        private final Object[] f1745a;

        /* renamed from: b */
        private int f1746b;

        public SimplePool(int i) {
            if (i > 0) {
                this.f1745a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean a(T t) {
            for (int i = 0; i < this.f1746b; i++) {
                if (this.f1745a[i] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.support.v4.util.Pools.Pool
        public T acquire() {
            int i = this.f1746b;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.f1745a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.f1746b = i - 1;
            return t;
        }

        @Override // android.support.v4.util.Pools.Pool
        public boolean release(T t) {
            if (!a(t)) {
                int i = this.f1746b;
                Object[] objArr = this.f1745a;
                if (i >= objArr.length) {
                    return false;
                }
                objArr[i] = t;
                this.f1746b = i + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    /* loaded from: classes.dex */
    public static class SynchronizedPool<T> extends SimplePool<T> {

        /* renamed from: c */
        private final Object f1747c;

        public SynchronizedPool(int i) {
            super(i);
            this.f1747c = new Object();
        }

        @Override // android.support.v4.util.Pools.SimplePool, android.support.v4.util.Pools.Pool
        public T acquire() {
            T t;
            synchronized (this.f1747c) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // android.support.v4.util.Pools.SimplePool, android.support.v4.util.Pools.Pool
        public boolean release(T t) {
            boolean release;
            synchronized (this.f1747c) {
                release = super.release(t);
            }
            return release;
        }
    }

    private Pools() {
    }
}
