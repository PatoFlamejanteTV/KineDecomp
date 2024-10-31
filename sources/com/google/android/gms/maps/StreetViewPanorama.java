package com.google.android.gms.maps;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;

/* loaded from: classes.dex */
public class StreetViewPanorama {

    /* renamed from: a, reason: collision with root package name */
    private final IStreetViewPanoramaDelegate f1918a;

    /* loaded from: classes.dex */
    public interface OnStreetViewPanoramaCameraChangeListener {
    }

    /* loaded from: classes.dex */
    public interface OnStreetViewPanoramaChangeListener {
    }

    /* loaded from: classes.dex */
    public interface OnStreetViewPanoramaClickListener {
    }

    /* loaded from: classes.dex */
    public interface OnStreetViewPanoramaLongClickListener {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StreetViewPanorama(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.f1918a = (IStreetViewPanoramaDelegate) zzx.a(iStreetViewPanoramaDelegate);
    }
}
