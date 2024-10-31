package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.view.QueryParams;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class i implements ImmutableTree.TreeVisitor<Map<QueryParams, TrackedQuery>, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TrackedQueryManager f17039a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TrackedQueryManager trackedQueryManager) {
        this.f17039a = trackedQueryManager;
    }

    @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
    public Void a(Path path, Map<QueryParams, TrackedQuery> map, Void r3) {
        Iterator<Map.Entry<QueryParams, TrackedQuery>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            TrackedQuery value = it.next().getValue();
            if (!value.f17027d) {
                this.f17039a.b(value.a());
            }
        }
        return null;
    }
}
