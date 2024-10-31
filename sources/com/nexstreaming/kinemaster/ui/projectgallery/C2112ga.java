package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ga, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2112ga extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22922b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2112ga(ProjectGalleryActivity projectGalleryActivity) {
        this.f22922b = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        KMEvents.MAIN_YOUTUBE.logYoutubeEvent();
        Uri parse = Uri.parse("https://www.youtube.com/user/KineMasterApp/videos");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        try {
            this.f22922b.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }
}
