package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Ordering.java */
/* loaded from: classes2.dex */
public class co implements Function<Object, Integer> {

    /* renamed from: a, reason: collision with root package name */
    final AtomicInteger f2846a = new AtomicInteger(0);
    final /* synthetic */ Ordering.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(Ordering.a aVar) {
        this.b = aVar;
    }

    @Override // com.google.common.base.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer apply(Object obj) {
        return Integer.valueOf(this.f2846a.getAndIncrement());
    }
}
