package com.nexstreaming.kinemaster.ui.share;

import android.content.Intent;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.share.ShareIntentActivity;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
public class au implements ShareIntentActivity.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f4305a;
    final /* synthetic */ ShareIntentActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ShareIntentActivity shareIntentActivity, Intent intent) {
        this.b = shareIntentActivity;
        this.f4305a = intent;
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ShareIntentActivity.c
    public void a(File file, MediaStoreItem mediaStoreItem) {
        int i;
        if (file != null) {
            MediaInfo a2 = MediaInfo.a(file);
            if (!a2.l()) {
                this.b.a(a2.n().getNotSupportedReason(this.b));
                return;
            }
        }
        ShareIntentActivity.b(this.b);
        i = this.b.c;
        if (i <= 0) {
            this.f4305a.putExtra(KMIntentData.KEY_FROM_SDK, true);
            this.b.d(this.f4305a);
        }
    }
}
