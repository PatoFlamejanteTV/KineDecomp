package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExtensionRegistryFactory.java */
/* renamed from: com.google.protobuf.u */
/* loaded from: classes2.dex */
public final class C1666u {

    /* renamed from: a */
    static final Class<?> f18798a = b();

    public static ExtensionRegistryLite a() {
        if (f18798a != null) {
            try {
                return a("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return ExtensionRegistryLite.f18563b;
    }

    static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static final ExtensionRegistryLite a(String str) throws Exception {
        return (ExtensionRegistryLite) f18798a.getMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
