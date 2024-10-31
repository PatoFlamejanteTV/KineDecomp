package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import java.util.logging.Logger;

@Beta
/* loaded from: classes2.dex */
public final class ClassPath {

    /* renamed from: a */
    private static final Logger f16046a = Logger.getLogger(ClassPath.class.getName());

    /* renamed from: b */
    private static final Predicate<ClassInfo> f16047b = new a();

    /* renamed from: c */
    private static final Splitter f16048c = Splitter.a(" ").a();

    @Beta
    /* loaded from: classes2.dex */
    public static final class ClassInfo extends ResourceInfo {

        /* renamed from: c */
        private final String f16049c;

        @Override // com.google.common.reflect.ClassPath.ResourceInfo
        public String toString() {
            return this.f16049c;
        }
    }

    @Beta
    /* loaded from: classes2.dex */
    public static class ResourceInfo {

        /* renamed from: a */
        private final String f16050a;

        /* renamed from: b */
        final ClassLoader f16051b;

        public boolean equals(Object obj) {
            if (!(obj instanceof ResourceInfo)) {
                return false;
            }
            ResourceInfo resourceInfo = (ResourceInfo) obj;
            return this.f16050a.equals(resourceInfo.f16050a) && this.f16051b == resourceInfo.f16051b;
        }

        public int hashCode() {
            return this.f16050a.hashCode();
        }

        public String toString() {
            return this.f16050a;
        }
    }
}
