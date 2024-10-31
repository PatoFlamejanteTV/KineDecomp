package com.squareup.wire;

import java.lang.reflect.Field;
import java.util.Comparator;

/* compiled from: BuilderAdapter.java */
/* loaded from: classes.dex */
final class b implements Comparator<Field> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Field field, Field field2) {
        return field.getName().compareTo(field2.getName());
    }
}
