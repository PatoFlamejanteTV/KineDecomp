package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collection;

/* compiled from: Collections2.java */
/* loaded from: classes2.dex */
final class v implements Function<Object, Object> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Collection f2892a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Collection collection) {
        this.f2892a = collection;
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return obj == this.f2892a ? "(this Collection)" : obj;
    }
}
