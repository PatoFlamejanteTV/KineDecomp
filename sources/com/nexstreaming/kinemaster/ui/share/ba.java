package com.nexstreaming.kinemaster.ui.share;

import android.content.Intent;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.ui.share.Da;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentCheckFragment.java */
/* loaded from: classes2.dex */
public class Ba implements Da.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f23248a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Da f23249b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ba(Da da, Intent intent) {
        this.f23249b = da;
        this.f23248a = intent;
    }

    @Override // com.nexstreaming.kinemaster.ui.share.Da.d
    public void a(File file, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        int i;
        Da.b bVar;
        Da.b bVar2;
        if (file != null) {
            MediaInfo a2 = MediaInfo.a(file);
            if (!a2.Z() && this.f23249b.getActivity() != null) {
                bVar = this.f23249b.f23258e;
                if (bVar != null) {
                    bVar2 = this.f23249b.f23258e;
                    bVar2.a(file, a2, cVar.g().getNotSupportedReason(this.f23249b.getActivity()));
                    return;
                }
                return;
            }
        }
        Da.b(this.f23249b);
        i = this.f23249b.f23255b;
        if (i <= 0) {
            this.f23248a.putExtra(KMIntentData.KEY_FROM_SDK, true);
            this.f23249b.d(this.f23248a);
        }
    }
}
