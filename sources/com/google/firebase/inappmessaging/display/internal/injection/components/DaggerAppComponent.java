package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.app.Application;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay_Factory;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.PicassoErrorListener;
import com.google.firebase.inappmessaging.display.internal.PicassoErrorListener_Factory;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer_Factory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.PicassoModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.PicassoModule_ProvidesFiamControllerFactory;
import com.squareup.picasso.Picasso;
import d.a.f;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class DaggerAppComponent implements AppComponent {

    /* renamed from: a, reason: collision with root package name */
    private Provider<FirebaseInAppMessaging> f17615a;

    /* renamed from: b, reason: collision with root package name */
    private Provider<Map<String, Provider<InAppMessageLayoutConfig>>> f17616b;

    /* renamed from: c, reason: collision with root package name */
    private Provider<Application> f17617c;

    /* renamed from: d, reason: collision with root package name */
    private Provider<PicassoErrorListener> f17618d;

    /* renamed from: e, reason: collision with root package name */
    private Provider<Picasso> f17619e;

    /* renamed from: f, reason: collision with root package name */
    private Provider<FiamImageLoader> f17620f;

    /* renamed from: g, reason: collision with root package name */
    private Provider<FiamWindowManager> f17621g;

    /* renamed from: h, reason: collision with root package name */
    private Provider<BindingWrapperFactory> f17622h;
    private Provider<FiamAnimator> i;
    private Provider<FirebaseInAppMessagingDisplay> j;

    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private HeadlessInAppMessagingModule f17623a;

        /* renamed from: b, reason: collision with root package name */
        private PicassoModule f17624b;

        /* renamed from: c, reason: collision with root package name */
        private UniversalComponent f17625c;

        private Builder() {
        }

        public AppComponent a() {
            if (this.f17623a != null) {
                if (this.f17624b == null) {
                    this.f17624b = new PicassoModule();
                }
                if (this.f17625c != null) {
                    return new DaggerAppComponent(this);
                }
                throw new IllegalStateException(UniversalComponent.class.getCanonicalName() + " must be set");
            }
            throw new IllegalStateException(HeadlessInAppMessagingModule.class.getCanonicalName() + " must be set");
        }

        public Builder a(HeadlessInAppMessagingModule headlessInAppMessagingModule) {
            f.a(headlessInAppMessagingModule);
            this.f17623a = headlessInAppMessagingModule;
            return this;
        }

        public Builder a(UniversalComponent universalComponent) {
            f.a(universalComponent);
            this.f17625c = universalComponent;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class a implements Provider<FiamWindowManager> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17626a;

        a(UniversalComponent universalComponent) {
            this.f17626a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public FiamWindowManager get() {
            FiamWindowManager a2 = this.f17626a.a();
            f.a(a2, "Cannot return null from a non-@Nullable component method");
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class b implements Provider<BindingWrapperFactory> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17627a;

        b(UniversalComponent universalComponent) {
            this.f17627a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public BindingWrapperFactory get() {
            BindingWrapperFactory d2 = this.f17627a.d();
            f.a(d2, "Cannot return null from a non-@Nullable component method");
            return d2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class c implements Provider<Map<String, Provider<InAppMessageLayoutConfig>>> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17628a;

        c(UniversalComponent universalComponent) {
            this.f17628a = universalComponent;
        }

        @Override // javax.inject.Provider
        public Map<String, Provider<InAppMessageLayoutConfig>> get() {
            Map<String, Provider<InAppMessageLayoutConfig>> c2 = this.f17628a.c();
            f.a(c2, "Cannot return null from a non-@Nullable component method");
            return c2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public static class d implements Provider<Application> {

        /* renamed from: a, reason: collision with root package name */
        private final UniversalComponent f17629a;

        d(UniversalComponent universalComponent) {
            this.f17629a = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Application get() {
            Application b2 = this.f17629a.b();
            f.a(b2, "Cannot return null from a non-@Nullable component method");
            return b2;
        }
    }

    private void a(Builder builder) {
        this.f17615a = d.a.b.a(HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory.a(builder.f17623a));
        this.f17616b = new c(builder.f17625c);
        this.f17617c = new d(builder.f17625c);
        this.f17618d = d.a.b.a(PicassoErrorListener_Factory.a());
        this.f17619e = d.a.b.a(PicassoModule_ProvidesFiamControllerFactory.a(builder.f17624b, this.f17617c, this.f17618d));
        this.f17620f = d.a.b.a(FiamImageLoader_Factory.a(this.f17619e));
        this.f17621g = new a(builder.f17625c);
        this.f17622h = new b(builder.f17625c);
        this.i = d.a.b.a(FiamAnimator_Factory.a());
        this.j = d.a.b.a(FirebaseInAppMessagingDisplay_Factory.a(this.f17615a, this.f17616b, this.f17620f, RenewableTimer_Factory.a(), this.f17621g, this.f17617c, this.f17622h, this.i));
    }

    public static Builder b() {
        return new Builder();
    }

    private DaggerAppComponent(Builder builder) {
        a(builder);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.AppComponent
    public FirebaseInAppMessagingDisplay a() {
        return this.j.get();
    }
}
