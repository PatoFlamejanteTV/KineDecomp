package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class Q extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22878b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(ProjectGalleryActivity projectGalleryActivity) {
        this.f22878b = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        if (!c.d.b.m.e.f3850a.a()) {
            this.f22878b.Z();
            return;
        }
        KMEvents.MAIN_TIKTOK.logTiktokEvent();
        Uri parse = Uri.parse("http://v.douyin.com/aAD7aY/");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        try {
            this.f22878b.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }
}
