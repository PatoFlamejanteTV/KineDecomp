package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class un<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzxw f12597a = c();

    private static zzxw c() {
        try {
            Object newInstance = zzwj.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (!(newInstance instanceof IBinder)) {
                zzbbd.zzeo("ClientApi class is not an instance of IBinder.");
                return null;
            }
            return zzxx.asInterface((IBinder) newInstance);
        } catch (Exception unused) {
            zzbbd.zzeo("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    private final T d() {
        zzxw zzxwVar = f12597a;
        if (zzxwVar == null) {
            zzbbd.zzeo("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return a(zzxwVar);
        } catch (RemoteException e2) {
            zzbbd.zzc("Cannot invoke local loader using ClientApi class.", e2);
            return null;
        }
    }

    private final T e() {
        try {
            return b();
        } catch (RemoteException e2) {
            zzbbd.zzc("Cannot invoke remote loader.", e2);
            return null;
        }
    }

    @Nonnull
    protected abstract T a();

    public final T a(Context context, boolean z) {
        T d2;
        if (!z) {
            zzwu.zzpv();
            if (!zzbat.zzc(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzbbd.zzdn("Google Play Services is not available.");
                z = true;
            }
        }
        if (DynamiteModule.a(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.b(context, ModuleDescriptor.MODULE_ID)) {
            z = true;
        }
        zzaan.initialize(context);
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwv)).booleanValue()) {
            z = false;
        }
        if (z) {
            d2 = d();
            if (d2 == null) {
                d2 = e();
            }
        } else {
            T e2 = e();
            int i = e2 == null ? 1 : 0;
            if (i != 0) {
                if (zzwu.zzqc().nextInt(((Integer) zzwu.zzpz().zzd(zzaan.zzcyq)).intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "dynamite_load");
                    bundle.putInt("is_missing", i);
                    zzwu.zzpv().zza(context, zzwu.zzqb().zzdp, "gmob-apps", bundle, true);
                }
            }
            d2 = e2 == null ? d() : e2;
        }
        return d2 == null ? a() : d2;
    }

    protected abstract T a(zzxw zzxwVar) throws RemoteException;

    protected abstract T b() throws RemoteException;
}
