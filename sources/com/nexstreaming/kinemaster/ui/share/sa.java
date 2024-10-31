package com.nexstreaming.kinemaster.ui.share;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

/* compiled from: ShareIntentActivity.java */
/* loaded from: classes2.dex */
class sa implements OnSuccessListener<PendingDynamicLinkData> {

    /* renamed from: a */
    final /* synthetic */ ShareIntentActivity f23383a;

    public sa(ShareIntentActivity shareIntentActivity) {
        this.f23383a = shareIntentActivity;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    /* renamed from: a */
    public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
        Uri a2 = pendingDynamicLinkData != null ? pendingDynamicLinkData.a() : null;
        if (a2 != null) {
            Intent intent = this.f23383a.getIntent();
            intent.setData(Uri.withAppendedPath(Uri.parse("dynamiclink://kinemaster"), a2.getPath()));
            this.f23383a.d(intent);
        } else {
            ShareIntentActivity shareIntentActivity = this.f23383a;
            shareIntentActivity.d(shareIntentActivity.getIntent());
        }
    }
}
