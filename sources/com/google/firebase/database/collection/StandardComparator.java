package com.google.firebase.database.collection;

import java.lang.Comparable;
import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
public class StandardComparator<A extends Comparable<A>> implements Comparator<A> {

    /* renamed from: a */
    private static StandardComparator f16715a = new StandardComparator();

    private StandardComparator() {
    }

    public static <T extends Comparable<T>> StandardComparator<T> a(Class<T> cls) {
        return f16715a;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(A a2, A a3) {
        return a2.compareTo(a3);
    }
}
