package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.model.MessageType;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
/* synthetic */ class a {

    /* renamed from: a */
    static final /* synthetic */ int[] f17676a = new int[MessageType.values().length];

    static {
        try {
            f17676a[MessageType.MODAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f17676a[MessageType.IMAGE_ONLY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f17676a[MessageType.BANNER.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
