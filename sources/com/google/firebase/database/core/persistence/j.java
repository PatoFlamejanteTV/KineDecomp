package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.utilities.Utilities;
import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class j implements Comparator<TrackedQuery> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TrackedQueryManager f17040a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TrackedQueryManager trackedQueryManager) {
        this.f17040a = trackedQueryManager;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(TrackedQuery trackedQuery, TrackedQuery trackedQuery2) {
        return Utilities.a(trackedQuery.f17026c, trackedQuery2.f17026c);
    }
}
