package com.nexstreaming.kinemaster.ui.share;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: ShareIntentActivity.java */
/* loaded from: classes2.dex */
class ra implements OnFailureListener {

    /* renamed from: a */
    final /* synthetic */ ShareIntentActivity f23381a;

    public ra(ShareIntentActivity shareIntentActivity) {
        this.f23381a = shareIntentActivity;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        Log.e("DynmaicLink", "failure", exc);
        ShareIntentActivity shareIntentActivity = this.f23381a;
        shareIntentActivity.d(shareIntentActivity.getIntent());
    }
}
