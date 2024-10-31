package com.nexstreaming.kinemaster.ui.projectgallery;

import android.os.Build;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class by implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4178a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(ProjectGalleryActivity projectGalleryActivity) {
        this.f4178a = projectGalleryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        j = this.f4178a.F;
        if (j < 0) {
            this.f4178a.F = System.nanoTime();
            if (Build.VERSION.SDK_INT >= 23) {
                this.f4178a.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, R.id.reqperms);
            }
        }
    }
}
