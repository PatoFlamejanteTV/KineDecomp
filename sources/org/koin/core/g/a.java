package org.koin.core.g;

import kotlin.Pair;
import kotlin.jvm.internal.h;
import kotlin.k;

/* compiled from: Measure.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final <T> Pair<T, Double> a(kotlin.jvm.a.a<? extends T> aVar) {
        h.b(aVar, "code");
        long nanoTime = System.nanoTime();
        T invoke = aVar.invoke();
        double nanoTime2 = System.nanoTime() - nanoTime;
        Double.isNaN(nanoTime2);
        return new Pair<>(invoke, Double.valueOf(nanoTime2 / 1000000.0d));
    }

    public static final double b(kotlin.jvm.a.a<k> aVar) {
        h.b(aVar, "code");
        long nanoTime = System.nanoTime();
        aVar.invoke();
        double nanoTime2 = System.nanoTime() - nanoTime;
        Double.isNaN(nanoTime2);
        return nanoTime2 / 1000000.0d;
    }
}
