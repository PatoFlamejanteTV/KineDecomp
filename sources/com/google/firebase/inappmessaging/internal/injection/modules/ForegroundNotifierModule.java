package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class ForegroundNotifierModule {
    @Singleton
    public ForegroundNotifier a() {
        return new ForegroundNotifier();
    }
}
