package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
final /* synthetic */ class b implements ImmutableSortedMap.Builder.KeyTranslator {

    /* renamed from: a */
    private static final b f16720a = new b();

    private b() {
    }

    public static ImmutableSortedMap.Builder.KeyTranslator a() {
        return f16720a;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap.Builder.KeyTranslator
    public Object a(Object obj) {
        ImmutableSortedMap.Builder.a(obj);
        return obj;
    }
}
