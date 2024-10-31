package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.codeccaps.ui.CapabilityTestIntroActivity;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import java.util.HashMap;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class Ua implements e.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Va f22887a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ua(Va va) {
        this.f22887a = va;
    }

    @Override // com.nexstreaming.kinemaster.ui.a.e.c
    public boolean a(DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, "analysis");
        KMEvents.DCI_ANALYSIS_POPUP.logEvent(hashMap);
        dialogInterface.dismiss();
        ProjectGalleryActivity projectGalleryActivity = this.f22887a.f22891c;
        projectGalleryActivity.startActivityForResult(FullScreenInputActivity.a(projectGalleryActivity).a(), 8194);
        return true;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, "analysis");
        KMEvents.DCI_ANALYSIS_POPUP.logEvent(hashMap);
        dialogInterface.dismiss();
        ProjectGalleryActivity projectGalleryActivity = this.f22887a.f22891c;
        projectGalleryActivity.startActivity(new Intent(projectGalleryActivity, (Class<?>) CapabilityTestIntroActivity.class));
    }
}
