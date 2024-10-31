package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.io.File;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class bj implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4163a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(ProjectGalleryActivity projectGalleryActivity) {
        this.f4163a = projectGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        File file;
        z = this.f4163a.H;
        if (!z) {
            String string = this.f4163a.getResources().getString(R.string.default_project_name);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f4163a);
            boolean z2 = defaultSharedPreferences.getBoolean("km.pga.tried_new_proj_assist", false);
            boolean z3 = defaultSharedPreferences.getBoolean("km.pga.tried_new_proj_empty", false);
            defaultSharedPreferences.edit().putBoolean("km.pga.tried_new_proj_empty", true).apply();
            int i = 0;
            while (true) {
                if (i >= 10000) {
                    file = null;
                    break;
                }
                file = new File(EditorGlobal.j().getAbsolutePath(), string + (i > 0 ? " " + i : "") + VideoEditor.a());
                File file2 = new File(EditorGlobal.j().getAbsolutePath(), string + (i > 0 ? " " + i : "") + ".nexvideoproject");
                if (!file.exists() && !file2.exists()) {
                    break;
                } else {
                    i++;
                }
            }
            if (file != null) {
                KMUsage kMUsage = KMUsage.ProjectList_NewProject;
                String[] strArr = new String[8];
                strArr[0] = NativeProtocol.WEB_DIALOG_ACTION;
                strArr[1] = "empty";
                strArr[2] = "triedAssist";
                strArr[3] = z2 ? "yes" : "no";
                strArr[4] = "triedEmpty";
                strArr[5] = z3 ? "yes" : "no";
                strArr[6] = "lang";
                strArr[7] = this.f4163a.getResources().getConfiguration().locale.getLanguage();
                kMUsage.logEvent(strArr);
                this.f4163a.startActivity(ProjectEditActivity.a(this.f4163a, file));
                this.f4163a.overridePendingTransition(0, 0);
                this.f4163a.o();
                this.f4163a.C = true;
            }
        }
    }
}
