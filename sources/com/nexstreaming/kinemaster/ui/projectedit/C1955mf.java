package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import c.e.a.a.f;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.mf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1955mf implements f.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f22448a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f22449b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22450c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1955mf(ProjectEditActivity projectEditActivity, com.nexstreaming.kinemaster.mediastore.item.c cVar, NexTimelineItem nexTimelineItem) {
        this.f22450c = projectEditActivity;
        this.f22448a = cVar;
        this.f22449b = nexTimelineItem;
    }

    @Override // c.e.a.a.f.e
    public void a(Bitmap bitmap) {
        this.f22450c.a(this.f22448a.getId(), this.f22448a, bitmap, this.f22449b, true, false, true);
    }

    @Override // c.e.a.a.f.e
    public void a() {
        this.f22450c.a(this.f22448a.getId(), this.f22448a, (Bitmap) null, this.f22449b, true, false, true);
    }
}
