package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BannerBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BannerBindingWrapper_Factory;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ImageBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ImageBindingWrapper_Factory;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper_Factory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule_InAppMessageLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule_ProvidesBannerMessageFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule_ProvidesInflaterserviceFactory;
import com.google.firebase.inappmessaging.model.InAppMessage;
import d.a.f;
import javax.inject.Provider;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class DaggerInAppMessageComponent implements InAppMessageComponent {

    /* renamed from: a, reason: collision with root package name */
    private Provider<InAppMessageLayoutConfig> f17630a;

    /* renamed from: b, reason: collision with root package name */
    private Provider<LayoutInflater> f17631b;

    /* renamed from: c, reason: collision with root package name */
    private Provider<InAppMessage> f17632c;

    /* renamed from: d, reason: collision with root package name */
    private Provider<ImageBindingWrapper> f17633d;

    /* renamed from: e, reason: collision with root package name */
    private Provider<ModalBindingWrapper> f17634e;

    /* renamed from: f, reason: collision with root package name */
    private Provider<BannerBindingWrapper> f17635f;

    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private InflaterModule f17636a;

        private Builder() {
        }

        public InAppMessageComponent a() {
            if (this.f17636a != null) {
                return new DaggerInAppMessageComponent(this);
            }
            throw new IllegalStateException(InflaterModule.class.getCanonicalName() + " must be set");
        }

        public Builder a(InflaterModule inflaterModule) {
            f.a(inflaterModule);
            this.f17636a = inflaterModule;
            return this;
        }
    }

    private void a(Builder builder) {
        this.f17630a = d.a.b.a(InflaterModule_InAppMessageLayoutConfigFactory.a(builder.f17636a));
        this.f17631b = d.a.b.a(InflaterModule_ProvidesInflaterserviceFactory.a(builder.f17636a));
        this.f17632c = InflaterModule_ProvidesBannerMessageFactory.a(builder.f17636a);
        this.f17633d = d.a.b.a(ImageBindingWrapper_Factory.a(this.f17630a, this.f17631b, this.f17632c));
        this.f17634e = d.a.b.a(ModalBindingWrapper_Factory.a(this.f17630a, this.f17631b, this.f17632c));
        this.f17635f = d.a.b.a(BannerBindingWrapper_Factory.a(this.f17632c, this.f17631b, this.f17630a));
    }

    public static Builder d() {
        return new Builder();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.InAppMessageComponent
    public BannerBindingWrapper b() {
        return this.f17635f.get();
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.InAppMessageComponent
    public ModalBindingWrapper c() {
        return this.f17634e.get();
    }

    private DaggerInAppMessageComponent(Builder builder) {
        a(builder);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.injection.components.InAppMessageComponent
    public ImageBindingWrapper a() {
        return this.f17633d.get();
    }
}
