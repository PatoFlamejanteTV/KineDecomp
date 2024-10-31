package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.WebDialog;

/* compiled from: FacebookDialogFragment.java */
/* loaded from: classes.dex */
class k implements WebDialog.OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookDialogFragment f291a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FacebookDialogFragment facebookDialogFragment) {
        this.f291a = facebookDialogFragment;
    }

    @Override // com.facebook.internal.WebDialog.OnCompleteListener
    public void onComplete(Bundle bundle, FacebookException facebookException) {
        this.f291a.onCompleteWebDialog(bundle, facebookException);
    }
}
