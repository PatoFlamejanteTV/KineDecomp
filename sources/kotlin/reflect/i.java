package kotlin.reflect;

import kotlin.reflect.g;

/* compiled from: KProperty.kt */
/* loaded from: classes.dex */
public interface i<T, R> extends g<R>, kotlin.jvm.a.b<T, R> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes.dex */
    public interface a<T, R> extends g.b<R>, kotlin.jvm.a.b<T, R> {
    }

    R get(T t);

    Object getDelegate(T t);

    a<T, R> getGetter();
}
