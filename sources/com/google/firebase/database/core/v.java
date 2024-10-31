package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.connection.RequestResultCallback;
import com.google.firebase.database.core.SyncTree;
import com.google.firebase.database.core.view.Event;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class v implements RequestResultCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SyncTree.CompletionListener f17096a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ w f17097b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(w wVar, SyncTree.CompletionListener completionListener) {
        this.f17097b = wVar;
        this.f17096a = completionListener;
    }

    @Override // com.google.firebase.database.connection.RequestResultCallback
    public void a(String str, String str2) {
        DatabaseError b2;
        b2 = Repo.b(str, str2);
        this.f17097b.f17158a.a((List<? extends Event>) this.f17096a.a(b2));
    }
}
