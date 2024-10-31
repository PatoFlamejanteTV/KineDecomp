package kotlinx.coroutines.internal;

import kotlin.TypeCastException;

/* compiled from: ArrayQueue.kt */
/* loaded from: classes3.dex */
public class b<T> {

    /* renamed from: a */
    private Object[] f28626a = new Object[16];

    /* renamed from: b */
    private int f28627b;

    /* renamed from: c */
    private int f28628c;

    private final void c() {
        Object[] objArr = this.f28626a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        int length2 = objArr.length;
        int i = this.f28627b;
        int i2 = length2 - i;
        a.a(objArr, i, objArr2, 0, i2);
        a.a(this.f28626a, 0, objArr2, i2, this.f28627b);
        this.f28626a = objArr2;
        this.f28627b = 0;
        this.f28628c = length;
    }

    public final boolean a() {
        return this.f28627b == this.f28628c;
    }

    public final T b() {
        int i = this.f28627b;
        if (i == this.f28628c) {
            return null;
        }
        Object[] objArr = this.f28626a;
        T t = (T) objArr[i];
        objArr[i] = null;
        this.f28627b = (i + 1) & (objArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public final void a(T t) {
        kotlin.jvm.internal.h.b(t, "element");
        Object[] objArr = this.f28626a;
        int i = this.f28628c;
        objArr[i] = t;
        this.f28628c = (objArr.length - 1) & (i + 1);
        if (this.f28628c == this.f28627b) {
            c();
        }
    }
}
