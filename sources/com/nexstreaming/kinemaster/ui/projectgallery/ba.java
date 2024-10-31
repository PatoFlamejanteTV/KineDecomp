package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class Ba extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22814b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ba(ProjectGalleryActivity projectGalleryActivity) {
        this.f22814b = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        KMEvents.MAIN_WEIBO.logWeiboEvent();
        Uri parse = Uri.parse("https://data.newrank.cn/m/s.html?s=PTArPjI9LDw9");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        try {
            this.f22814b.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }
}
