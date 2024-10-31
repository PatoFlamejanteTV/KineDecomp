package com.google.firebase.inappmessaging.display;

import android.app.Activity;
import android.view.View;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f17526a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ FirebaseInAppMessagingDisplay f17527b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity) {
        this.f17527b = firebaseInAppMessagingDisplay;
        this.f17526a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks;
        FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks2;
        firebaseInAppMessagingDisplayCallbacks = this.f17527b.callbacks;
        if (firebaseInAppMessagingDisplayCallbacks != null) {
            firebaseInAppMessagingDisplayCallbacks2 = this.f17527b.callbacks;
            firebaseInAppMessagingDisplayCallbacks2.a(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK);
        }
        this.f17527b.dismissFiam(this.f17526a);
    }
}
