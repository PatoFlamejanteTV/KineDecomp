package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.display.internal.PicassoErrorListener;
import com.squareup.picasso.Picasso;
import d.a.c;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class PicassoModule_ProvidesFiamControllerFactory implements c<Picasso> {

    /* renamed from: a, reason: collision with root package name */
    private final PicassoModule f17673a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<Application> f17674b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<PicassoErrorListener> f17675c;

    public PicassoModule_ProvidesFiamControllerFactory(PicassoModule picassoModule, Provider<Application> provider, Provider<PicassoErrorListener> provider2) {
        this.f17673a = picassoModule;
        this.f17674b = provider;
        this.f17675c = provider2;
    }

    public static c<Picasso> a(PicassoModule picassoModule, Provider<Application> provider, Provider<PicassoErrorListener> provider2) {
        return new PicassoModule_ProvidesFiamControllerFactory(picassoModule, provider, provider2);
    }

    @Override // javax.inject.Provider
    public Picasso get() {
        Picasso a2 = this.f17673a.a(this.f17674b.get(), this.f17675c.get());
        f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }
}
