package com.google.common.collect;

/* compiled from: MutableClassToInstanceMap.java */
/* loaded from: classes2.dex */
final class cn implements MapConstraint<Class<?>, Object> {
    @Override // com.google.common.collect.MapConstraint
    public void a(Class<?> cls, Object obj) {
        MutableClassToInstanceMap.b(cls, obj);
    }
}
