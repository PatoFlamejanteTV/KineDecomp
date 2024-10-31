package com.google.firebase.inappmessaging.display;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import b.b.c.j;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f17528a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ FirebaseInAppMessagingDisplay f17529b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity) {
        this.f17529b = firebaseInAppMessagingDisplay;
        this.f17528a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks;
        InAppMessage inAppMessage;
        FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks2;
        firebaseInAppMessagingDisplayCallbacks = this.f17529b.callbacks;
        if (firebaseInAppMessagingDisplayCallbacks != null) {
            firebaseInAppMessagingDisplayCallbacks2 = this.f17529b.callbacks;
            firebaseInAppMessagingDisplayCallbacks2.a();
        }
        j.a aVar = new j.a();
        aVar.a(true);
        j a2 = aVar.a();
        Activity activity = this.f17528a;
        inAppMessage = this.f17529b.inAppMessage;
        a2.a(activity, Uri.parse(inAppMessage.getAction().getActionUrl()));
        this.f17529b.notifyFiamClick();
        this.f17529b.removeDisplayedFiam(this.f17528a);
        this.f17529b.inAppMessage = null;
        this.f17529b.callbacks = null;
    }
}
