package android.support.constraint.solver;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
interface g<T> {
    void a(T[] tArr, int i);

    T acquire();

    boolean release(T t);
}
