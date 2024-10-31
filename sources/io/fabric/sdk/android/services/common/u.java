package io.fabric.sdk.android.services.common;

import android.content.Context;

/* compiled from: InstallerPackageNameProvider.java */
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a */
    private final io.fabric.sdk.android.a.a.d<String> f26907a = new t(this);

    /* renamed from: b */
    private final io.fabric.sdk.android.a.a.b<String> f26908b = new io.fabric.sdk.android.a.a.b<>();

    public String a(Context context) {
        try {
            String a2 = this.f26908b.a(context, this.f26907a);
            if ("".equals(a2)) {
                return null;
            }
            return a2;
        } catch (Exception e2) {
            io.fabric.sdk.android.f.f().c("Fabric", "Failed to determine installer package name", e2);
            return null;
        }
    }
}
