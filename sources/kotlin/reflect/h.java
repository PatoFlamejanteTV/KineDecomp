package kotlin.reflect;

import kotlin.reflect.g;

/* compiled from: KProperty.kt */
/* loaded from: classes.dex */
public interface h<R> extends g<R>, kotlin.jvm.a.a<R> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes3.dex */
    public interface a<R> extends g.b<R>, kotlin.jvm.a.a<R> {
    }

    R get();

    Object getDelegate();

    a<R> getGetter();
}
