package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.Predicate;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class T implements Predicate<UserWriteRecord> {
    @Override // com.google.firebase.database.core.utilities.Predicate
    /* renamed from: a */
    public boolean evaluate(UserWriteRecord userWriteRecord) {
        return userWriteRecord.f();
    }
}
