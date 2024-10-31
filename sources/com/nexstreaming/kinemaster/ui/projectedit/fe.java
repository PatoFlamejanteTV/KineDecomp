package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.os.Handler;
import c.e.a.a.f;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionSplitFragment.java */
/* loaded from: classes2.dex */
public class Fe implements f.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f21846a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ge f21847b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fe(Ge ge, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f21847b = ge;
        this.f21846a = cVar;
    }

    @Override // c.e.a.a.f.e
    public void a(Bitmap bitmap) {
        VideoEditor da = this.f21847b.f21877b.da();
        NexTimelineItem Y = this.f21847b.f21877b.Y();
        Ge ge = this.f21847b;
        da.a(Y, ge.f21876a, ge.f21877b.O()).onComplete(new De(this, bitmap)).onFailure(new Be(this));
    }

    @Override // c.e.a.a.f.e
    public void a() {
        this.f21847b.f21877b.a(this.f21846a.getId(), null, ProjectEditActivity.InsertPosition.BeforeSelected, true, true);
        this.f21847b.f21877b.ga();
        new Handler().postDelayed(new Ee(this), 300L);
    }
}
