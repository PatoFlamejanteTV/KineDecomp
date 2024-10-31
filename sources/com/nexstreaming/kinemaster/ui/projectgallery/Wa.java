package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Wa implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22893a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wa(ProjectGalleryActivity projectGalleryActivity) {
        this.f22893a = projectGalleryActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, "skip");
        KMEvents.DCI_ANALYSIS_POPUP_CONFIRM.logEvent(hashMap);
        dialogInterface.dismiss();
    }
}
