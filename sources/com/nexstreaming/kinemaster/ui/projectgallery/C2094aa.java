package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.share.ExportAndShareActivity;
import com.nexstreaming.kinemaster.ui.widget.ImageCyclerView;
import java.io.ByteArrayOutputStream;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.aa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2094aa implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2097ba f22903a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2094aa(C2097ba c2097ba) {
        this.f22903a = c2097ba;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        com.nexstreaming.kinemaster.project.k kVar;
        ImageCyclerView imageCyclerView;
        ImageView imageView;
        Bitmap bitmap;
        int a2;
        Intent intent = new Intent(this.f22903a.f22906b, (Class<?>) ExportAndShareActivity.class);
        intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, "project_gallery");
        kVar = this.f22903a.f22906b.va;
        intent.setData(Uri.fromFile(kVar.e()));
        imageCyclerView = this.f22903a.f22906b.ta;
        imageCyclerView.a(intent);
        imageView = this.f22903a.f22906b.ga;
        Drawable drawable = imageView.getDrawable();
        if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 50, new ByteArrayOutputStream());
            a2 = this.f22903a.f22906b.a(bitmap);
            intent.putExtra("projectThumb", a2);
        }
        this.f22903a.f22906b.startActivity(intent);
        this.f22903a.f22906b.overridePendingTransition(0, 0);
    }
}
