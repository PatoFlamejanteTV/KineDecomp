package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

@zzark
/* loaded from: classes2.dex */
public final class zzary {
    public static boolean zze(Context context, boolean z) {
        if (!z) {
            return true;
        }
        int b2 = DynamiteModule.b(context, ModuleDescriptor.MODULE_ID);
        return b2 != 0 && b2 <= DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
    }
}
