package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.WhichTimeline;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.gg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class DialogInterfaceOnClickListenerC1903gg implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f22353a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ WhichTimeline f22354b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f22355c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C1947lg f22356d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC1903gg(C1947lg c1947lg, NexTimelineItem nexTimelineItem, WhichTimeline whichTimeline, int i) {
        this.f22356d = c1947lg;
        this.f22353a = nexTimelineItem;
        this.f22354b = whichTimeline;
        this.f22355c = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f22356d.f22438a.m(this.f22353a);
        this.f22356d.b(this.f22354b, this.f22355c, this.f22353a);
    }
}
