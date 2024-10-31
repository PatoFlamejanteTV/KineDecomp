package com.google.firebase.database.core;

import com.google.firebase.database.core.SyncTree;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.Node;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* renamed from: com.google.firebase.database.core.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC1603t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ QuerySpec f17047a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SyncTree.CompletionListener f17048b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ u f17049c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1603t(u uVar, QuerySpec querySpec, SyncTree.CompletionListener completionListener) {
        this.f17049c = uVar;
        this.f17047a = querySpec;
        this.f17048b = completionListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        SnapshotHolder snapshotHolder;
        SyncTree syncTree;
        snapshotHolder = this.f17049c.f17050a.f16906d;
        Node a2 = snapshotHolder.a(this.f17047a.c());
        if (a2.isEmpty()) {
            return;
        }
        syncTree = this.f17049c.f17050a.o;
        this.f17049c.f17050a.a((List<? extends Event>) syncTree.a(this.f17047a.c(), a2));
        this.f17048b.a(null);
    }
}
