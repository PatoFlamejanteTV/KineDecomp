package com.google.firebase.inappmessaging.display.internal;

import android.net.Uri;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
@FirebaseAppScope
/* loaded from: classes2.dex */
public class PicassoErrorListener implements Picasso.c {

    /* renamed from: a */
    private InAppMessage f17555a;

    /* renamed from: b */
    private FirebaseInAppMessagingDisplayCallbacks f17556b;

    @Inject
    public PicassoErrorListener() {
    }

    @Override // com.squareup.picasso.Picasso.c
    public void a(Picasso picasso, Uri uri, Exception exc) {
        FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks;
        if (this.f17555a == null || (firebaseInAppMessagingDisplayCallbacks = this.f17556b) == null) {
            return;
        }
        if (exc instanceof Downloader.ResponseException) {
            firebaseInAppMessagingDisplayCallbacks.a(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_FETCH_ERROR);
        } else if ((exc instanceof IOException) && exc.getLocalizedMessage().contains("Failed to decode")) {
            this.f17556b.a(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT);
        } else {
            this.f17556b.a(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR);
        }
    }
}
