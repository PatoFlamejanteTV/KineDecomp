package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;

/* compiled from: ShareIntentCheckFragment.java */
/* loaded from: classes2.dex */
class ya implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f23400a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ za f23401b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ya(za zaVar, String str) {
        this.f23401b = zaVar;
        this.f23400a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        AndroidMediaStoreProvider z;
        MediaStoreItemId a2 = AndroidMediaStoreProvider.a(new File(this.f23400a));
        z = this.f23401b.f23403b.f23245b.z();
        com.nexstreaming.kinemaster.mediastore.item.c a3 = z.a(a2);
        if (a3 != null) {
            za zaVar = this.f23401b;
            zaVar.f23403b.f23244a.a(zaVar.f23402a, a3);
        } else {
            KineMasterApplication.f24056d.h().a(this.f23401b.f23402a).onComplete(new xa(this));
        }
    }
}
