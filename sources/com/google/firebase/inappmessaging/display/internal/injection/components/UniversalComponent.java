package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.app.Application;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import java.util.Map;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
@Singleton
/* loaded from: classes2.dex */
public interface UniversalComponent {
    FiamWindowManager a();

    Application b();

    Map<String, Provider<InAppMessageLayoutConfig>> c();

    BindingWrapperFactory d();
}
