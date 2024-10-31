package com.google.android.gms.flags;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

/* loaded from: classes.dex */
public final class zzb {

    /* renamed from: a */
    private boolean f11358a = false;

    /* renamed from: b */
    private zzc f11359b = null;

    public final void a(Context context) {
        synchronized (this) {
            if (this.f11358a) {
                return;
            }
            try {
                this.f11359b = zzd.asInterface(DynamiteModule.a(context, DynamiteModule.k, ModuleDescriptor.MODULE_ID).a("com.google.android.gms.flags.impl.FlagProviderImpl"));
                this.f11359b.init(ObjectWrapper.a(context));
                this.f11358a = true;
            } catch (RemoteException | DynamiteModule.LoadingException e2) {
                Log.w("FlagValueProvider", "Failed to initialize flags module.", e2);
            }
        }
    }

    public final <T> T a(Flag<T> flag) {
        synchronized (this) {
            if (!this.f11358a) {
                return flag.d();
            }
            return flag.a(this.f11359b);
        }
    }
}
