package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zzg;

/* loaded from: classes.dex */
public final class zzaa extends com.google.android.gms.dynamic.zzg<zzu> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzaa f1001a = new zzaa();

    private zzaa() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View a(Context context, int i, int i2) throws zzg.zza {
        return f1001a.b(context, i, i2);
    }

    private View b(Context context, int i, int i2) throws zzg.zza {
        try {
            return (View) com.google.android.gms.dynamic.zze.a(zzas(context).a(com.google.android.gms.dynamic.zze.a(context), i, i2));
        } catch (Exception e) {
            throw new zzg.zza("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    @Override // com.google.android.gms.dynamic.zzg
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzu zzd(IBinder iBinder) {
        return zzu.zza.a(iBinder);
    }
}
