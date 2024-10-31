package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.utilities.Predicate;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class h implements Predicate<TrackedQuery> {
    @Override // com.google.firebase.database.core.utilities.Predicate
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean evaluate(TrackedQuery trackedQuery) {
        Predicate predicate;
        predicate = TrackedQueryManager.f17031c;
        return !predicate.evaluate(trackedQuery);
    }
}
