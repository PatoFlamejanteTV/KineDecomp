package com.google.firebase.database.core.utilities;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.ImmutableTree;
import java.util.AbstractMap;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class d<T> implements ImmutableTree.TreeVisitor<T, Void> {

    /* renamed from: a */
    final /* synthetic */ List f17079a;

    /* renamed from: b */
    final /* synthetic */ ImmutableTree f17080b;

    public d(ImmutableTree immutableTree, List list) {
        this.f17080b = immutableTree;
        this.f17079a = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
    public /* bridge */ /* synthetic */ Void a(Path path, Object obj, Void r3) {
        return a2(path, (Path) obj, r3);
    }

    /* renamed from: a */
    public Void a2(Path path, T t, Void r4) {
        this.f17079a.add(new AbstractMap.SimpleImmutableEntry(path, t));
        return null;
    }
}
