package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.widget.ImageCyclerView;
import com.nexstreaming.kinemaster.ui.widget.g;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class ao implements g.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ am f4141a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.f4141a = amVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.g.b
    public void a(com.nexstreaming.kinemaster.ui.widget.g gVar, int i) {
        com.nexstreaming.kinemaster.project.f fVar;
        com.nexstreaming.kinemaster.project.f fVar2;
        Activity D;
        Activity D2;
        com.nexstreaming.kinemaster.project.f fVar3;
        ImageCyclerView imageCyclerView;
        ImageView imageView;
        Bitmap bitmap;
        int b;
        com.nexstreaming.kinemaster.project.f fVar4;
        fVar = this.f4141a.f4139a.q;
        if (fVar != null) {
            switch (i) {
                case R.id.duplicate_project /* 2131820591 */:
                    a.C0074a c0074a = new a.C0074a(this.f4141a.f4139a);
                    c0074a.f(R.string.project_gallery_duplicate_project);
                    c0074a.a(R.string.project_gallery_duplicate_project_popup);
                    fVar4 = this.f4141a.f4139a.q;
                    c0074a.b(fVar4.f());
                    c0074a.a(R.string.button_ok, new ap(this));
                    c0074a.b(R.string.button_cancel, new aq(this));
                    c0074a.a().show();
                    return;
                case R.id.export_file_list /* 2131820599 */:
                    Intent intent = new Intent(this.f4141a.f4139a, (Class<?>) ExportFileListActivity.class);
                    intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, "project_gallery");
                    fVar3 = this.f4141a.f4139a.q;
                    intent.setData(Uri.fromFile(fVar3.a()));
                    imageCyclerView = this.f4141a.f4139a.k;
                    imageCyclerView.a(intent);
                    imageView = this.f4141a.f4139a.n;
                    Drawable drawable = imageView.getDrawable();
                    if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 50, new ByteArrayOutputStream());
                        b = ProjectGalleryActivity.b(bitmap);
                        intent.putExtra("projectThumb", b);
                    }
                    this.f4141a.f4139a.startActivity(intent);
                    this.f4141a.f4139a.overridePendingTransition(0, 0);
                    return;
                case R.id.report_project_issue /* 2131820697 */:
                    fVar2 = this.f4141a.f4139a.q;
                    File a2 = fVar2.a();
                    File file = new File(a2.getParentFile(), com.nexstreaming.kinemaster.project.f.e(com.nexstreaming.kinemaster.project.f.f(a2.getName())) + ".export.log");
                    if (file.exists()) {
                        D2 = this.f4141a.f4139a.D();
                        com.nexstreaming.kinemaster.support.i.a(D2, "rpi", a2, file);
                        return;
                    } else {
                        D = this.f4141a.f4139a.D();
                        com.nexstreaming.kinemaster.support.i.a(D, "rpi", a2);
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
