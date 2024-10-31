package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.kinemaster.ui.share.ShareIntentActivity;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
public class bc implements ShareIntentActivity.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareIntentActivity.c f4314a;
    final /* synthetic */ ShareIntentActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ShareIntentActivity shareIntentActivity, ShareIntentActivity.c cVar) {
        this.b = shareIntentActivity;
        this.f4314a = cVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ShareIntentActivity.b
    public void a(File file) {
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ShareIntentActivity.b
    public void a(int i) {
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ShareIntentActivity.b
    public void b(File file) {
        if (file != null) {
            new ShareIntentActivity.d(file, new bd(this, file));
        } else {
            this.f4314a.a(file, null);
        }
    }
}
