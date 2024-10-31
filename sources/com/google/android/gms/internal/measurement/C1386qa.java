package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.qa */
/* loaded from: classes2.dex */
public final class C1386qa {

    /* renamed from: a */
    private static final Class<?> f13514a = c();

    public static zzub a() {
        if (f13514a != null) {
            try {
                return a("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzub.zzbvd;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.measurement.zzub b() {
        /*
            java.lang.Class<?> r0 = com.google.android.gms.internal.measurement.C1386qa.f13514a
            if (r0 == 0) goto Lb
            java.lang.String r0 = "loadGeneratedRegistry"
            com.google.android.gms.internal.measurement.zzub r0 = a(r0)     // Catch: java.lang.Exception -> Lb
            goto Lc
        Lb:
            r0 = 0
        Lc:
            if (r0 != 0) goto L12
            com.google.android.gms.internal.measurement.zzub r0 = com.google.android.gms.internal.measurement.zzub.zzvp()
        L12:
            if (r0 != 0) goto L18
            com.google.android.gms.internal.measurement.zzub r0 = a()
        L18:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1386qa.b():com.google.android.gms.internal.measurement.zzub");
    }

    private static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static final zzub a(String str) throws Exception {
        return (zzub) f13514a.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
