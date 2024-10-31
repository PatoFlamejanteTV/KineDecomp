package com.squareup.wire;

import java.lang.reflect.Field;
import java.util.Comparator;

/* compiled from: BuilderAdapter.java */
/* loaded from: classes3.dex */
class a implements Comparator<Field> {
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Field field, Field field2) {
        return field.getName().compareTo(field2.getName());
    }
}
