package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class av implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ProjectGalleryActivity projectGalleryActivity) {
        this.f4148a = projectGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity D;
        Activity D2;
        z = this.f4148a.H;
        if (!z) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f4148a);
            boolean z2 = defaultSharedPreferences.getBoolean("km.pga.tried_new_proj_assist", false);
            boolean z3 = defaultSharedPreferences.getBoolean("km.pga.tried_new_proj_empty", false);
            defaultSharedPreferences.edit().putBoolean("km.pga.tried_new_proj_assist", true).apply();
            KMUsage kMUsage = KMUsage.ProjectList_NewProject;
            String[] strArr = new String[8];
            strArr[0] = NativeProtocol.WEB_DIALOG_ACTION;
            strArr[1] = "assist";
            strArr[2] = "triedAssist";
            strArr[3] = z2 ? "yes" : "no";
            strArr[4] = "triedEmpty";
            strArr[5] = z3 ? "yes" : "no";
            strArr[6] = "lang";
            strArr[7] = this.f4148a.getResources().getConfiguration().locale.getLanguage();
            kMUsage.logEvent(strArr);
            D = this.f4148a.D();
            String c = com.nexstreaming.kinemaster.project.f.c(com.nexstreaming.kinemaster.project.f.a(D));
            ProjectGalleryActivity projectGalleryActivity = this.f4148a;
            D2 = this.f4148a.D();
            projectGalleryActivity.startActivityForResult(FullScreenInputActivity.a(D2).a(c).e(true).d(true).c(false).b(false).a(), FullScreenInputActivity.b());
            this.f4148a.p();
            this.f4148a.B = true;
        }
    }
}
