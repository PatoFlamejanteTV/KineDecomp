package com.google.firebase.inappmessaging.display;

import android.app.Activity;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f17523a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ BindingWrapper f17524b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ FirebaseInAppMessagingDisplay f17525c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity, BindingWrapper bindingWrapper) {
        this.f17525c = firebaseInAppMessagingDisplay;
        this.f17523a = activity;
        this.f17524b = bindingWrapper;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17525c.inflateBinding(this.f17523a, this.f17524b);
    }
}
