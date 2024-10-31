package android.support.constraint.solver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class h<T> implements g<T> {

    /* renamed from: a */
    private final Object[] f242a;

    /* renamed from: b */
    private int f243b;

    public h(int i) {
        if (i > 0) {
            this.f242a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // android.support.constraint.solver.g
    public void a(T[] tArr, int i) {
        if (i > tArr.length) {
            i = tArr.length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            T t = tArr[i2];
            int i3 = this.f243b;
            Object[] objArr = this.f242a;
            if (i3 < objArr.length) {
                objArr[i3] = t;
                this.f243b = i3 + 1;
            }
        }
    }

    @Override // android.support.constraint.solver.g
    public T acquire() {
        int i = this.f243b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f242a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f243b = i - 1;
        return t;
    }

    @Override // android.support.constraint.solver.g
    public boolean release(T t) {
        int i = this.f243b;
        Object[] objArr = this.f242a;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = t;
        this.f243b = i + 1;
        return true;
    }
}
