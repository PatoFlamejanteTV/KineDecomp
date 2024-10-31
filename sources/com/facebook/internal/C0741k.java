package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.WebDialog;

/* compiled from: FacebookDialogFragment.java */
/* renamed from: com.facebook.internal.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0741k implements WebDialog.OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookDialogFragment f9320a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0741k(FacebookDialogFragment facebookDialogFragment) {
        this.f9320a = facebookDialogFragment;
    }

    @Override // com.facebook.internal.WebDialog.OnCompleteListener
    public void onComplete(Bundle bundle, FacebookException facebookException) {
        this.f9320a.onCompleteWebDialog(bundle, facebookException);
    }
}
