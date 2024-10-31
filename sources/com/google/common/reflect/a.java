package com.google.common.reflect;

import com.google.common.base.Predicate;
import com.google.common.reflect.ClassPath;

/* compiled from: ClassPath.java */
/* loaded from: classes2.dex */
class a implements Predicate<ClassPath.ClassInfo> {
    @Override // com.google.common.base.Predicate
    /* renamed from: a */
    public boolean apply(ClassPath.ClassInfo classInfo) {
        String str;
        str = classInfo.f16049c;
        return str.indexOf(36) == -1;
    }
}
