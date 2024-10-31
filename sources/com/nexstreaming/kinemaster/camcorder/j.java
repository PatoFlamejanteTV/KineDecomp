package com.nexstreaming.kinemaster.camcorder;

import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.File;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class j implements MediaScannerConnection.OnScanCompletedListener {

    /* renamed from: a */
    final /* synthetic */ Intent f19998a;

    /* renamed from: b */
    final /* synthetic */ CamcorderActivity f19999b;

    public j(CamcorderActivity camcorderActivity, Intent intent) {
        this.f19999b = camcorderActivity;
        this.f19998a = intent;
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        File file;
        this.f19999b.y();
        Intent intent = this.f19998a;
        file = this.f19999b.u;
        intent.putExtra("VIDEO_PATH", file.getAbsolutePath());
        this.f19999b.setResult(-1, this.f19998a);
        this.f19999b.finish();
    }
}
