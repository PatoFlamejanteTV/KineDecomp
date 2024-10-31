package com.google.firebase.inappmessaging.display;

import android.app.Activity;
import android.app.Application;
import android.view.ViewTreeObserver;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.squareup.picasso.InterfaceC2399l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class h implements InterfaceC2399l {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BindingWrapper f17533a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f17534b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f17535c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ FirebaseInAppMessagingDisplay f17536d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, BindingWrapper bindingWrapper, Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f17536d = firebaseInAppMessagingDisplay;
        this.f17533a = bindingWrapper;
        this.f17534b = activity;
        this.f17535c = onGlobalLayoutListener;
    }

    @Override // com.squareup.picasso.InterfaceC2399l
    public void a() {
        Logging.c("Image download failure ");
        if (this.f17535c != null) {
            this.f17533a.e().getViewTreeObserver().removeGlobalOnLayoutListener(this.f17535c);
        }
        this.f17536d.cancelTimers();
        this.f17536d.inAppMessage = null;
        this.f17536d.callbacks = null;
    }

    @Override // com.squareup.picasso.InterfaceC2399l
    public void onSuccess() {
        RenewableTimer renewableTimer;
        FiamWindowManager fiamWindowManager;
        FiamAnimator fiamAnimator;
        Application application;
        RenewableTimer renewableTimer2;
        if (!this.f17533a.b().c().booleanValue()) {
            this.f17533a.f().setOnTouchListener(new e(this));
        }
        renewableTimer = this.f17536d.impressionTimer;
        renewableTimer.a(new f(this), 5000L, 1000L);
        if (this.f17533a.b().b().booleanValue()) {
            renewableTimer2 = this.f17536d.autoDismissTimer;
            renewableTimer2.a(new g(this), 20000L, 1000L);
        }
        fiamWindowManager = this.f17536d.windowManager;
        fiamWindowManager.a(this.f17533a, this.f17534b);
        if (this.f17533a.b().a().booleanValue()) {
            fiamAnimator = this.f17536d.animator;
            application = this.f17536d.application;
            fiamAnimator.a(application, this.f17533a.f(), FiamAnimator.Position.TOP);
        }
    }
}
