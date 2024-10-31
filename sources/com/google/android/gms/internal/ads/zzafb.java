package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.HashMap;

@zzark
/* loaded from: classes2.dex */
public final class zzafb extends RemoteCreator<zzadn> {
    @VisibleForTesting
    public zzafb() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzadn getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        if (queryLocalInterface instanceof zzadn) {
            return (zzadn) queryLocalInterface;
        }
        return new zzado(iBinder);
    }

    public final zzadk zzb(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        try {
            IBinder zza = getRemoteCreatorInstance(view.getContext()).zza(ObjectWrapper.a(view), ObjectWrapper.a(hashMap), ObjectWrapper.a(hashMap2));
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            if (queryLocalInterface instanceof zzadk) {
                return (zzadk) queryLocalInterface;
            }
            return new zzadm(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbbd.zzc("Could not create remote NativeAdViewHolderDelegate.", e2);
            return null;
        }
    }
}
