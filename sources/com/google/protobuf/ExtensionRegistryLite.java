package com.google.protobuf;

import android.support.v4.internal.view.SupportMenu;
import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ExtensionRegistryLite {

    /* renamed from: a */
    private static final Class<?> f18562a = b();

    /* renamed from: b */
    static final ExtensionRegistryLite f18563b = new ExtensionRegistryLite(true);

    /* renamed from: c */
    private final Map<a, GeneratedMessageLite.GeneratedExtension<?, ?>> f18564c;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        private final Object f18565a;

        /* renamed from: b */
        private final int f18566b;

        a(Object obj, int i) {
            this.f18565a = obj;
            this.f18566b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f18565a == aVar.f18565a && this.f18566b == aVar.f18566b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f18565a) * SupportMenu.USER_MASK) + this.f18566b;
        }
    }

    ExtensionRegistryLite() {
        this.f18564c = new HashMap();
    }

    public static ExtensionRegistryLite a() {
        return C1666u.a();
    }

    static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> a(ContainingType containingtype, int i) {
        return (GeneratedMessageLite.GeneratedExtension) this.f18564c.get(new a(containingtype, i));
    }

    ExtensionRegistryLite(boolean z) {
        this.f18564c = Collections.emptyMap();
    }
}
