package io.fabric.sdk.android.services.common;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InstallerPackageNameProvider.java */
/* loaded from: classes3.dex */
public class t implements io.fabric.sdk.android.a.a.d<String> {

    /* renamed from: a */
    final /* synthetic */ u f26906a;

    public t(u uVar) {
        this.f26906a = uVar;
    }

    @Override // io.fabric.sdk.android.a.a.d
    public String load(Context context) throws Exception {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }
}
