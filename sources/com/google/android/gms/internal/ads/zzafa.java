package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzark
/* loaded from: classes2.dex */
public final class zzafa extends RemoteCreator<zzadi> {
    @VisibleForTesting
    public zzafa() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzadi getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (queryLocalInterface instanceof zzadi) {
            return (zzadi) queryLocalInterface;
        }
        return new zzadj(iBinder);
    }

    public final zzadf zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            IBinder zza = getRemoteCreatorInstance(context).zza(ObjectWrapper.a(context), ObjectWrapper.a(frameLayout), ObjectWrapper.a(frameLayout2), 14300000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            if (queryLocalInterface instanceof zzadf) {
                return (zzadf) queryLocalInterface;
            }
            return new zzadh(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbbd.zzc("Could not create remote NativeAdViewDelegate.", e2);
            return null;
        }
    }
}
