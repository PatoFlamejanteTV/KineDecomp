package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import java.util.HashMap;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class Ta implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Va f22885a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ta(Va va) {
        this.f22885a = va;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, "skip");
        KMEvents.DCI_ANALYSIS_POPUP.logEvent(hashMap);
        dialogInterface.dismiss();
        this.f22885a.f22891c.U();
    }
}
