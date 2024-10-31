package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.kinemaster.ui.share.ShareActivity;
import com.nexstreaming.kinemaster.ui.widget.ImageCyclerView;
import java.io.ByteArrayOutputStream;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class ag implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4133a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ProjectGalleryActivity projectGalleryActivity) {
        this.f4133a = projectGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean t;
        com.nexstreaming.kinemaster.project.f fVar;
        ImageCyclerView imageCyclerView;
        ImageView imageView;
        Bitmap bitmap;
        int b;
        t = this.f4133a.t();
        if (t) {
            Intent intent = new Intent(this.f4133a, (Class<?>) ShareActivity.class);
            intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, "project_gallery");
            fVar = this.f4133a.q;
            intent.setData(Uri.fromFile(fVar.a()));
            imageCyclerView = this.f4133a.k;
            imageCyclerView.a(intent);
            imageView = this.f4133a.n;
            Drawable drawable = imageView.getDrawable();
            if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 50, new ByteArrayOutputStream());
                b = ProjectGalleryActivity.b(bitmap);
                intent.putExtra("projectThumb", b);
            }
            this.f4133a.startActivity(intent);
            this.f4133a.overridePendingTransition(0, 0);
        }
    }
}
