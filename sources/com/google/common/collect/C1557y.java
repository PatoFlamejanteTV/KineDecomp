package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collections2.java */
/* renamed from: com.google.common.collect.y */
/* loaded from: classes2.dex */
public class C1557y implements Function<Object, Object> {

    /* renamed from: a */
    final /* synthetic */ Collection f15868a;

    public C1557y(Collection collection) {
        this.f15868a = collection;
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return obj == this.f15868a ? "(this Collection)" : obj;
    }
}
