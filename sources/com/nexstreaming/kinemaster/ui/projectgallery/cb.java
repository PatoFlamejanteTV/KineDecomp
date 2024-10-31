package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class Cb extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22819b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cb(ProjectGalleryActivity projectGalleryActivity) {
        this.f22819b = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        KMEvents.MAIN_HELP.logEvent("click");
        this.f22819b.aa();
    }
}
