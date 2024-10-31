package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
public final class a implements DynamiteModule.VersionPolicy.zza {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza
    public final int a(Context context, String str, boolean z) throws DynamiteModule.LoadingException {
        return DynamiteModule.a(context, str, z);
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.zza
    public final int a(Context context, String str) {
        return DynamiteModule.a(context, str);
    }
}
