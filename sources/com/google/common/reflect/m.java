package com.google.common.reflect;

import com.google.common.base.Predicate;
import com.google.common.reflect.TypeToken;

/* compiled from: TypeToken.java */
/* loaded from: classes2.dex */
class m implements Predicate<Class<?>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TypeToken.InterfaceSet f16100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TypeToken.InterfaceSet interfaceSet) {
        this.f16100a = interfaceSet;
    }

    @Override // com.google.common.base.Predicate
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean apply(Class<?> cls) {
        return cls.isInterface();
    }
}
