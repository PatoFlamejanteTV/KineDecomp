package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class ft implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3910a;
    final /* synthetic */ Intent b;
    final /* synthetic */ VideoEditor c;
    final /* synthetic */ ez d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ft(ez ezVar, int i, Intent intent, VideoEditor videoEditor) {
        this.d = ezVar;
        this.f3910a = i;
        this.b = intent;
        this.c = videoEditor;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        String str;
        String str2 = null;
        if (this.f3910a == 20) {
            str = this.b.getStringExtra("VIDEO_PATH");
            z = this.b.getBooleanExtra("USE_AS_LAYER", false);
        } else {
            z = false;
            str = null;
        }
        MediaInfo a2 = MediaInfo.a(str);
        if (!a2.l()) {
            str2 = this.d.getResources().getString(R.string.rec_video_fail_formaterr);
        } else if (a2.y() < 1000) {
            str2 = this.d.getResources().getString(R.string.rec_video_fail_tooshort, Float.valueOf(1.0f));
        } else if (a2.v() * a2.u() > 2088960) {
            str2 = this.d.getResources().getString(R.string.rec_video_fail_toolarge, 1920, 1088);
        }
        if (str2 == null) {
            if (((str != null && str.length() > 0 && new File(str).exists()) || str.startsWith("@solid:")) && EditorGlobal.b(str)) {
                File file = new File(str);
                KineMasterApplication.a().c().a(file).onComplete(new fu(this, file, z));
            }
        }
    }
}
