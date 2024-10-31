package com.google.firebase.inappmessaging.display.internal.injection.components;

import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BannerBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ImageBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
@InAppMessageScope
/* loaded from: classes2.dex */
public interface InAppMessageComponent {
    @InAppMessageScope
    ImageBindingWrapper a();

    @InAppMessageScope
    BannerBindingWrapper b();

    @InAppMessageScope
    ModalBindingWrapper c();
}
