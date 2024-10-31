package com.google.firebase.inappmessaging.display.internal;

import com.squareup.picasso.Picasso;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class FiamImageLoader_Factory implements d.a.c<FiamImageLoader> {

    /* renamed from: a, reason: collision with root package name */
    private final Provider<Picasso> f17543a;

    public FiamImageLoader_Factory(Provider<Picasso> provider) {
        this.f17543a = provider;
    }

    public static d.a.c<FiamImageLoader> a(Provider<Picasso> provider) {
        return new FiamImageLoader_Factory(provider);
    }

    @Override // javax.inject.Provider
    public FiamImageLoader get() {
        return new FiamImageLoader(this.f17543a.get());
    }
}
