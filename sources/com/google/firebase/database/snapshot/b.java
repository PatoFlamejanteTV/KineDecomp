package com.google.firebase.database.snapshot;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class b implements Comparator<ChildKey> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ChildKey childKey, ChildKey childKey2) {
        return childKey.compareTo(childKey2);
    }
}
