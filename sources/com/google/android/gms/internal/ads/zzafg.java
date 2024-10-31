package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzafg extends zzaeo {
    private final OnPublisherAdViewLoadedListener zzdel;

    public zzafg(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzdel = onPublisherAdViewLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final void zza(zzxl zzxlVar, IObjectWrapper iObjectWrapper) {
        if (zzxlVar == null || iObjectWrapper == null) {
            return;
        }
        PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.a(iObjectWrapper));
        try {
            if (zzxlVar.zzis() instanceof zzvx) {
                zzvx zzvxVar = (zzvx) zzxlVar.zzis();
                publisherAdView.setAdListener(zzvxVar != null ? zzvxVar.getAdListener() : null);
            }
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
        try {
            if (zzxlVar.zzir() instanceof zzwh) {
                zzwh zzwhVar = (zzwh) zzxlVar.zzir();
                publisherAdView.setAppEventListener(zzwhVar != null ? zzwhVar.getAppEventListener() : null);
            }
        } catch (RemoteException e3) {
            zzbbd.zzb("", e3);
        }
        zzbat.zztu.post(new B(this, publisherAdView, zzxlVar));
    }
}
