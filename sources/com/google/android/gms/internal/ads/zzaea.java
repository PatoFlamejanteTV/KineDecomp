package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import java.util.WeakHashMap;

@zzark
/* loaded from: classes2.dex */
public final class zzaea implements NativeCustomTemplateAd {
    private static WeakHashMap<IBinder, zzaea> zzddy = new WeakHashMap<>();
    private final VideoController zzcml = new VideoController();
    private final zzadx zzddz;
    private final MediaView zzdea;

    @VisibleForTesting
    private zzaea(zzadx zzadxVar) {
        Context context;
        this.zzddz = zzadxVar;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.a(zzadxVar.zzsg());
        } catch (RemoteException | NullPointerException e2) {
            zzbbd.zzb("", e2);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.zzddz.zzi(ObjectWrapper.a(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e3) {
                zzbbd.zzb("", e3);
            }
        }
        this.zzdea = mediaView;
    }

    public static zzaea zza(zzadx zzadxVar) {
        synchronized (zzddy) {
            zzaea zzaeaVar = zzddy.get(zzadxVar.asBinder());
            if (zzaeaVar != null) {
                return zzaeaVar;
            }
            zzaea zzaeaVar2 = new zzaea(zzadxVar);
            zzddy.put(zzadxVar.asBinder(), zzaeaVar2);
            return zzaeaVar2;
        }
    }

    public final void destroy() {
        try {
            this.zzddz.destroy();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zzddz.getAvailableAssetNames();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final String getCustomTemplateId() {
        try {
            return this.zzddz.getCustomTemplateId();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    public final NativeAd.Image getImage(String str) {
        try {
            zzadb zzbr = this.zzddz.zzbr(str);
            if (zzbr != null) {
                return new zzade(zzbr);
            }
            return null;
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    public final CharSequence getText(String str) {
        try {
            return this.zzddz.zzbq(str);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            zzyp videoController = this.zzddz.getVideoController();
            if (videoController != null) {
                this.zzcml.a(videoController);
            }
        } catch (RemoteException e2) {
            zzbbd.zzb("Exception occurred while getting video controller", e2);
        }
        return this.zzcml;
    }

    public final MediaView getVideoMediaView() {
        return this.zzdea;
    }

    public final void performClick(String str) {
        try {
            this.zzddz.performClick(str);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }

    public final void recordImpression() {
        try {
            this.zzddz.recordImpression();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }

    public final zzadx zzsx() {
        return this.zzddz;
    }
}
