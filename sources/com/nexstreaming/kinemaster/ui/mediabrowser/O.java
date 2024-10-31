package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.app.Activity;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnSuccessListener;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import java.util.Stack;

/* compiled from: MediaBrowserPresenter.kt */
/* loaded from: classes.dex */
final class O<TResult> implements OnSuccessListener<GoogleSignInAccount> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f21662a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f21663b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(S s, Activity activity) {
        this.f21662a = s;
        this.f21663b = activity;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onSuccess(GoogleSignInAccount googleSignInAccount) {
        GoogleSignInClient googleSignInClient;
        MediaStore mediaStore;
        Boolean bool;
        Stack stack;
        googleSignInClient = this.f21662a.f21672g;
        if (googleSignInClient != null) {
            googleSignInClient.b();
        }
        mediaStore = this.f21662a.f21666a;
        if (mediaStore != null) {
            Activity activity = this.f21663b;
            kotlin.jvm.internal.h.a((Object) googleSignInAccount, "googleSignInAccount");
            bool = Boolean.valueOf(mediaStore.a(activity, googleSignInAccount.getEmail()));
        } else {
            bool = null;
        }
        if (bool == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (bool.booleanValue()) {
            S s = this.f21662a;
            MediaViewerMode mediaViewerMode = MediaViewerMode.ALL;
            stack = s.f21670e;
            s.a(mediaViewerMode, ((com.nexstreaming.kinemaster.mediastore.item.c) stack.peek()).getId());
        }
    }
}
