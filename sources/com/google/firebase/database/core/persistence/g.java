package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.utilities.Predicate;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class g implements Predicate<TrackedQuery> {
    @Override // com.google.firebase.database.core.utilities.Predicate
    /* renamed from: a */
    public boolean evaluate(TrackedQuery trackedQuery) {
        return !trackedQuery.f17028e;
    }
}
