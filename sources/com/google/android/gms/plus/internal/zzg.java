package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.plus.PlusOneDummyView;
import com.google.android.gms.plus.internal.zzc;

/* loaded from: classes.dex */
public final class zzg extends com.google.android.gms.dynamic.zzg<zzc> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzg f2184a = new zzg();

    private zzg() {
        super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
    }

    public static View a(Context context, int i, int i2, String str, int i3) {
        try {
            if (str == null) {
                throw new NullPointerException();
            }
            return (View) com.google.android.gms.dynamic.zze.a(f2184a.zzas(context).a(com.google.android.gms.dynamic.zze.a(context), i, i2, str, i3));
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzc zzd(IBinder iBinder) {
        return zzc.zza.a(iBinder);
    }
}
