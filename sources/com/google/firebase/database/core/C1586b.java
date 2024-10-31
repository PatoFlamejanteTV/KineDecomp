package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.snapshot.Node;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1586b implements ImmutableTree.TreeVisitor<Node, CompoundWrite> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Path f16966a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ CompoundWrite f16967b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1586b(CompoundWrite compoundWrite, Path path) {
        this.f16967b = compoundWrite;
        this.f16966a = path;
    }

    @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
    public CompoundWrite a(Path path, Node node, CompoundWrite compoundWrite) {
        return compoundWrite.b(this.f16966a.e(path), node);
    }
}
