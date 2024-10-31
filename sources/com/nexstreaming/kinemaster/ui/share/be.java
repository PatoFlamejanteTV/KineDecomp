package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
public class be implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f4316a;
    final /* synthetic */ bd b;

    public be(bd bdVar, String str) {
        this.b = bdVar;
        this.f4316a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        AndroidMediaStoreProvider c;
        MSID a2 = AndroidMediaStoreProvider.a(new File(this.f4316a));
        c = this.b.b.b.c();
        MediaStoreItem a3 = c.a(a2);
        if (a3 != null) {
            this.b.b.f4314a.a(this.b.f4315a, a3);
        } else {
            KineMasterApplication.a().c().a(this.b.f4315a).onComplete(new bf(this));
        }
    }
}
