package com.google.android.gms.location.places;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> List<E> a(Collection<E> collection) {
        return (collection == null || collection.isEmpty()) ? Collections.emptyList() : new ArrayList(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Set<E> a(List<E> list) {
        return (list == null || list.isEmpty()) ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(list));
    }
}
