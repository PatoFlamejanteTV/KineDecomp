package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class InflaterModule {

    /* renamed from: a */
    private final InAppMessage f17667a;

    /* renamed from: b */
    private final InAppMessageLayoutConfig f17668b;

    /* renamed from: c */
    private final Application f17669c;

    public InflaterModule(InAppMessage inAppMessage, InAppMessageLayoutConfig inAppMessageLayoutConfig, Application application) {
        this.f17667a = inAppMessage;
        this.f17668b = inAppMessageLayoutConfig;
        this.f17669c = application;
    }

    @InAppMessageScope
    public InAppMessageLayoutConfig a() {
        return this.f17668b;
    }

    public InAppMessage b() {
        return this.f17667a;
    }

    @InAppMessageScope
    public LayoutInflater c() {
        return (LayoutInflater) this.f17669c.getSystemService("layout_inflater");
    }
}
