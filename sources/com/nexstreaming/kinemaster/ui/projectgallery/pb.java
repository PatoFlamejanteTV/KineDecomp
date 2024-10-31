package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.C2343y;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.util.HashMap;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class pb extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22968b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public pb(ProjectGalleryActivity projectGalleryActivity) {
        this.f22968b = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f22968b);
        defaultSharedPreferences.getBoolean("km.pga.tried_new_proj_assist", false);
        defaultSharedPreferences.getBoolean("km.pga.tried_new_proj_empty", false);
        defaultSharedPreferences.edit().putBoolean("km.pga.tried_new_proj_assist", true).apply();
        EditorGlobal.a(1.7777778f);
        String a2 = C2343y.a();
        HashMap hashMap = new HashMap();
        hashMap.put("aspect_ratio", a2);
        hashMap.put("type", "project_assistant");
        KMEvents.PROJECT_NEW.logEvent(hashMap);
        String b2 = com.nexstreaming.kinemaster.project.k.b(com.nexstreaming.kinemaster.project.k.b(this.f22968b));
        ProjectGalleryActivity projectGalleryActivity = this.f22968b;
        FullScreenInputActivity.a a3 = FullScreenInputActivity.a(projectGalleryActivity);
        a3.b(b2);
        a3.f(true);
        a3.d(true);
        a3.c(false);
        a3.e(false);
        projectGalleryActivity.startActivityForResult(a3.a(), FullScreenInputActivity.t());
        this.f22968b.ga();
        this.f22968b.N = true;
    }
}
