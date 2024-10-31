package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.utilities.Predicate;
import com.google.firebase.database.core.view.QueryParams;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class e implements Predicate<Map<QueryParams, TrackedQuery>> {
    @Override // com.google.firebase.database.core.utilities.Predicate
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean evaluate(Map<QueryParams, TrackedQuery> map) {
        TrackedQuery trackedQuery = map.get(QueryParams.f17117a);
        return trackedQuery != null && trackedQuery.f17027d;
    }
}
