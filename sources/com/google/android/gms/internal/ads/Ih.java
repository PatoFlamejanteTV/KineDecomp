package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class Ih {

    /* renamed from: a */
    private static final Class<?> f11605a = c();

    public static zzbqq a() {
        if (f11605a != null) {
            try {
                return a("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzbqq.zzfmt;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzbqq b() {
        /*
            java.lang.Class<?> r0 = com.google.android.gms.internal.ads.Ih.f11605a
            if (r0 == 0) goto Lb
            java.lang.String r0 = "loadGeneratedRegistry"
            com.google.android.gms.internal.ads.zzbqq r0 = a(r0)     // Catch: java.lang.Exception -> Lb
            goto Lc
        Lb:
            r0 = 0
        Lc:
            if (r0 != 0) goto L12
            com.google.android.gms.internal.ads.zzbqq r0 = com.google.android.gms.internal.ads.zzbqq.zzamb()
        L12:
            if (r0 != 0) goto L18
            com.google.android.gms.internal.ads.zzbqq r0 = a()
        L18:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.Ih.b():com.google.android.gms.internal.ads.zzbqq");
    }

    private static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static final zzbqq a(String str) throws Exception {
        return (zzbqq) f11605a.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
