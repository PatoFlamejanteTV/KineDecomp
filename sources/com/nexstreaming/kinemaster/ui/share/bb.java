package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import com.nexstreaming.kinemaster.ui.share.ShareIntentActivity;
import java.io.File;

/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
class bb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ba f4313a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.f4313a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AndroidMediaStoreProvider c;
        MSID a2 = AndroidMediaStoreProvider.a(this.f4313a.f4312a);
        ShareIntentActivity.c cVar = this.f4313a.b;
        File file = this.f4313a.f4312a;
        c = this.f4313a.c.c();
        cVar.a(file, c.a(a2));
    }
}
