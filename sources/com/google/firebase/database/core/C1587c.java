package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.snapshot.Node;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1587c implements ImmutableTree.TreeVisitor<Node, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f16968a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f16969b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ CompoundWrite f16970c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1587c(CompoundWrite compoundWrite, Map map, boolean z) {
        this.f16970c = compoundWrite;
        this.f16968a = map;
        this.f16969b = z;
    }

    @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
    public Void a(Path path, Node node, Void r4) {
        this.f16968a.put(path.h(), node.a(this.f16969b));
        return null;
    }
}
