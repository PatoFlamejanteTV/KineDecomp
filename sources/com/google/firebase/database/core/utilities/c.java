package com.google.firebase.database.core.utilities;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.ImmutableTree;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class c<T> implements ImmutableTree.TreeVisitor<T, Void> {

    /* renamed from: a */
    final /* synthetic */ ArrayList f17077a;

    /* renamed from: b */
    final /* synthetic */ ImmutableTree f17078b;

    public c(ImmutableTree immutableTree, ArrayList arrayList) {
        this.f17078b = immutableTree;
        this.f17077a = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
    public /* bridge */ /* synthetic */ Void a(Path path, Object obj, Void r3) {
        return a2(path, (Path) obj, r3);
    }

    /* renamed from: a */
    public Void a2(Path path, T t, Void r3) {
        this.f17077a.add(t);
        return null;
    }
}
