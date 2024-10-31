package com.google.firebase.inappmessaging.display.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerInAppMessageComponent;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule;
import com.google.firebase.inappmessaging.model.InAppMessage;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
@Singleton
/* loaded from: classes2.dex */
public class BindingWrapperFactory {

    /* renamed from: a */
    private final Application f17538a;

    @Inject
    public BindingWrapperFactory(Application application) {
        this.f17538a = application;
    }

    public BindingWrapper a(InAppMessageLayoutConfig inAppMessageLayoutConfig, InAppMessage inAppMessage) {
        return DaggerInAppMessageComponent.d().a(new InflaterModule(inAppMessage, inAppMessageLayoutConfig, this.f17538a)).a().b();
    }

    public BindingWrapper b(InAppMessageLayoutConfig inAppMessageLayoutConfig, InAppMessage inAppMessage) {
        return DaggerInAppMessageComponent.d().a(new InflaterModule(inAppMessage, inAppMessageLayoutConfig, this.f17538a)).a().a();
    }

    public BindingWrapper c(InAppMessageLayoutConfig inAppMessageLayoutConfig, InAppMessage inAppMessage) {
        return DaggerInAppMessageComponent.d().a(new InflaterModule(inAppMessage, inAppMessageLayoutConfig, this.f17538a)).a().c();
    }
}
