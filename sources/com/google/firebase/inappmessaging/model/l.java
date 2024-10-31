package com.google.firebase.inappmessaging.model;

import com.google.firebase.inappmessaging.MessagesProto;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public /* synthetic */ class l {

    /* renamed from: a */
    static final /* synthetic */ int[] f18048a = new int[MessagesProto.Content.MessageDetailsCase.values().length];

    static {
        try {
            f18048a[MessagesProto.Content.MessageDetailsCase.BANNER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f18048a[MessagesProto.Content.MessageDetailsCase.IMAGE_ONLY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f18048a[MessagesProto.Content.MessageDetailsCase.MODAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
