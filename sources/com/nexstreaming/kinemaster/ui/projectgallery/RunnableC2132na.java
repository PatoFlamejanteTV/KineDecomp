package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.AlertDialog;
import android.util.Log;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.integration.cloud.KMCloud;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.na */
/* loaded from: classes2.dex */
public class RunnableC2132na implements Runnable {

    /* renamed from: a */
    final /* synthetic */ KMCloud.KMCloudReturnValue f22958a;

    /* renamed from: b */
    final /* synthetic */ String f22959b;

    /* renamed from: c */
    final /* synthetic */ C2134oa f22960c;

    public RunnableC2132na(C2134oa c2134oa, KMCloud.KMCloudReturnValue kMCloudReturnValue, String str) {
        this.f22960c = c2134oa;
        this.f22958a = kMCloudReturnValue;
        this.f22959b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor.b bVar;
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f22960c.f22963a);
        NexEditor.b bVar2 = NexEditor.b.f24591b;
        int i = zb.f23011b[this.f22958a.ordinal()];
        if (i == 1) {
            Log.d("ProjectGalleryActivity", this.f22959b + " " + this.f22958a.name());
            bVar = NexEditor.b.Bb;
        } else if (i == 2) {
            Log.d("ProjectGalleryActivity", this.f22959b + " " + this.f22958a.name());
            bVar = NexEditor.b.Cb;
        } else if (i == 3) {
            Log.d("ProjectGalleryActivity", this.f22959b + " " + this.f22958a.name());
            bVar = NexEditor.b.Db;
        } else if (i != 4) {
            bVar = NexEditor.b.f24593d;
        } else {
            Log.d("ProjectGalleryActivity", this.f22959b + " " + this.f22958a.name());
            bVar = NexEditor.b.Eb;
        }
        builder.setTitle("Cloud Error");
        builder.setMessage(this.f22960c.f22963a.getString(R.string.upload_project_upload_fail, new Object[]{this.f22959b, Integer.valueOf(bVar.b())}));
        builder.setNegativeButton(R.string.button_ok, new DialogInterfaceOnClickListenerC2130ma(this));
        builder.show();
    }
}
