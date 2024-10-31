package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import c.e.a.a.f;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Ff implements f.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f21848a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f21849b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Gf f21850c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ff(Gf gf, MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f21850c = gf;
        this.f21848a = mediaStoreItemId;
        this.f21849b = cVar;
    }

    @Override // c.e.a.a.f.e
    public void a(Bitmap bitmap) {
        InterfaceC2025f interfaceC2025f;
        VideoEditor ja = this.f21850c.f21879b.ja();
        interfaceC2025f = this.f21850c.f21879b.T;
        NexTimelineItem selectedItem = interfaceC2025f.getSelectedItem();
        Gf gf = this.f21850c;
        ja.a(selectedItem, gf.f21878a, gf.f21879b.W()).onComplete(new Ef(this, bitmap)).onFailure(new Df(this));
    }

    @Override // c.e.a.a.f.e
    public void a() {
        this.f21850c.f21879b.a(this.f21848a, this.f21849b, (Bitmap) null, ProjectEditActivity.InsertPosition.BeforeSelected, true, true);
        this.f21850c.f21879b.Da();
    }
}
