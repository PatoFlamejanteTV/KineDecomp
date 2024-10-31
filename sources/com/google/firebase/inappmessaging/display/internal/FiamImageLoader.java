package com.google.firebase.inappmessaging.display.internal;

import android.widget.ImageView;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.squareup.picasso.D;
import com.squareup.picasso.InterfaceC2399l;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
@FirebaseAppScope
/* loaded from: classes2.dex */
public class FiamImageLoader {

    /* renamed from: a, reason: collision with root package name */
    private final Picasso f17541a;

    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class FiamImageRequestCreator {

        /* renamed from: a, reason: collision with root package name */
        private final D f17542a;

        public FiamImageRequestCreator(D d2) {
            this.f17542a = d2;
        }

        public FiamImageRequestCreator a(int i) {
            this.f17542a.a(i);
            return this;
        }

        public FiamImageRequestCreator a(Class cls) {
            this.f17542a.a(cls);
            return this;
        }

        public void a(ImageView imageView, InterfaceC2399l interfaceC2399l) {
            this.f17542a.a(imageView, interfaceC2399l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public FiamImageLoader(Picasso picasso) {
        this.f17541a = picasso;
    }

    public FiamImageRequestCreator a(String str) {
        return new FiamImageRequestCreator(this.f17541a.a(str));
    }

    public void a(Class cls) {
        this.f17541a.a(cls);
    }
}
