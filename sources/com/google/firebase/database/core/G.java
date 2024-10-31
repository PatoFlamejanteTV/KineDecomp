package com.google.firebase.database.core;

import com.google.firebase.database.core.SyncTree;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.view.View;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class G implements ImmutableTree.TreeVisitor<SyncPoint, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SyncTree f16861a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(SyncTree syncTree) {
        this.f16861a = syncTree;
    }

    @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
    public Void a(Path path, SyncPoint syncPoint, Void r5) {
        SyncTree.ListenProvider listenProvider;
        QuerySpec a2;
        SyncTree.ListenProvider listenProvider2;
        QuerySpec a3;
        if (!path.isEmpty() && syncPoint.c()) {
            QuerySpec b2 = syncPoint.a().b();
            listenProvider2 = this.f16861a.f16939f;
            a3 = this.f16861a.a(b2);
            listenProvider2.a(a3, this.f16861a.b(b2));
            return null;
        }
        Iterator<View> it = syncPoint.b().iterator();
        while (it.hasNext()) {
            QuerySpec b3 = it.next().b();
            listenProvider = this.f16861a.f16939f;
            a2 = this.f16861a.a(b3);
            listenProvider.a(a2, this.f16861a.b(b3));
        }
        return null;
    }
}
