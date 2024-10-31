package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.common.base.Preconditions;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.model.InAppMessage;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
@Singleton
/* loaded from: classes2.dex */
public class ProtoMarshallerClient {
    @Inject
    public ProtoMarshallerClient() {
    }

    @Nonnull
    private static InAppMessage.Builder a() {
        return InAppMessage.builder().a(MessageType.UNSUPPORTED);
    }

    @Nonnull
    private static InAppMessage.Builder a(MessagesProto.ModalMessage modalMessage) {
        InAppMessage.Builder a2 = InAppMessage.builder().a(MessageType.MODAL);
        if (!TextUtils.isEmpty(modalMessage.p())) {
            a2.a(modalMessage.p());
        }
        if (!TextUtils.isEmpty(modalMessage.s())) {
            a2.d(modalMessage.s());
        }
        if (modalMessage.u()) {
            a2.a(a(modalMessage.n()));
        }
        if (modalMessage.w()) {
            a2.a(a(modalMessage.q()));
        }
        if (modalMessage.x()) {
            a2.b(a(modalMessage.t()));
        }
        if (modalMessage.v()) {
            a2.a(a(modalMessage.o()));
        }
        return a2;
    }

    @Nonnull
    private static InAppMessage.Builder a(MessagesProto.ImageOnlyMessage imageOnlyMessage) {
        InAppMessage.Builder a2 = InAppMessage.builder().a(MessageType.IMAGE_ONLY);
        if (!TextUtils.isEmpty(imageOnlyMessage.p())) {
            a2.d(imageOnlyMessage.p());
        }
        if (imageOnlyMessage.q()) {
            a2.a(a(imageOnlyMessage.n()));
        }
        return a2;
    }

    private static InAppMessage.Button a(MessagesProto.Button button) {
        InAppMessage.Button.Builder builder = InAppMessage.Button.builder();
        if (!TextUtils.isEmpty(button.n())) {
            builder.a(button.n());
        }
        if (button.q()) {
            builder.a(a(button.p()));
        }
        return builder.a();
    }

    private static InAppMessage.Action a(MessagesProto.Action action) {
        InAppMessage.Action.Builder builder = InAppMessage.Action.builder();
        if (!TextUtils.isEmpty(action.n())) {
            builder.a(action.n());
        }
        return builder.a();
    }

    private static InAppMessage.Text a(MessagesProto.Text text) {
        InAppMessage.Text.Builder builder = InAppMessage.Text.builder();
        if (!TextUtils.isEmpty(text.o())) {
            builder.a(text.o());
        }
        if (!TextUtils.isEmpty(text.p())) {
            builder.b(text.p());
        }
        return builder.a();
    }

    public static InAppMessage a(@Nonnull MessagesProto.Content content, String str, String str2, boolean z) {
        InAppMessage.Builder a2;
        Preconditions.a(content, "FirebaseInAppMessaging content cannot be null.");
        int i = l.f18048a[content.q().ordinal()];
        if (i == 1) {
            a2 = a(content.n());
        } else if (i == 2) {
            a2 = a(content.p());
        } else if (i != 3) {
            a2 = a();
        } else {
            a2 = a(content.r());
        }
        return a2.b(str).c(str2).a(Boolean.valueOf(z)).a();
    }

    @Nonnull
    private static InAppMessage.Builder a(MessagesProto.BannerMessage bannerMessage) {
        InAppMessage.Builder a2 = InAppMessage.builder().a(MessageType.BANNER);
        if (!TextUtils.isEmpty(bannerMessage.o())) {
            a2.a(bannerMessage.o());
        }
        if (!TextUtils.isEmpty(bannerMessage.r())) {
            a2.d(bannerMessage.r());
        }
        if (bannerMessage.t()) {
            a2.a(a(bannerMessage.n()));
        }
        if (bannerMessage.u()) {
            a2.a(a(bannerMessage.p()));
        }
        if (bannerMessage.v()) {
            a2.b(a(bannerMessage.s()));
        }
        return a2;
    }
}
