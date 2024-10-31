package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;

/* loaded from: classes2.dex */
final class B implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ PublisherAdView f11393a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzxl f11394b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzafg f11395c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(zzafg zzafgVar, PublisherAdView publisherAdView, zzxl zzxlVar) {
        this.f11395c = zzafgVar;
        this.f11393a = publisherAdView;
        this.f11394b = zzxlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener;
        if (!this.f11393a.a(this.f11394b)) {
            zzbbd.zzeo("Could not bind.");
        } else {
            onPublisherAdViewLoadedListener = this.f11395c.zzdel;
            onPublisherAdViewLoadedListener.a(this.f11393a);
        }
    }
}
