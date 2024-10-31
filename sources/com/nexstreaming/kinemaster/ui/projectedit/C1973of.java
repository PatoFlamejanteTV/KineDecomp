package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import c.e.a.a.f;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.of, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1973of implements f.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f22471a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AsyncTaskC2075xf f22472b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1973of(AsyncTaskC2075xf asyncTaskC2075xf, NexVideoClipItem nexVideoClipItem) {
        this.f22472b = asyncTaskC2075xf;
        this.f22471a = nexVideoClipItem;
    }

    @Override // c.e.a.a.f.e
    public void a() {
    }

    @Override // c.e.a.a.f.e
    public void a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || this.f22471a == null) {
            return;
        }
        this.f22472b.f22781h.ja().s().a().getThumbnailCache().put(this.f22471a.getUniqueId(), bitmap);
    }
}
