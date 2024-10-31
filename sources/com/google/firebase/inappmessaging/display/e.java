package com.google.firebase.inappmessaging.display;

import android.view.MotionEvent;
import android.view.View;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
class e implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f17530a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(h hVar) {
        this.f17530a = hVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks;
        FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks2;
        if (motionEvent.getAction() != 4) {
            return false;
        }
        firebaseInAppMessagingDisplayCallbacks = this.f17530a.f17536d.callbacks;
        if (firebaseInAppMessagingDisplayCallbacks != null) {
            firebaseInAppMessagingDisplayCallbacks2 = this.f17530a.f17536d.callbacks;
            firebaseInAppMessagingDisplayCallbacks2.a(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE);
        }
        h hVar = this.f17530a;
        hVar.f17536d.dismissFiam(hVar.f17534b);
        return true;
    }
}
