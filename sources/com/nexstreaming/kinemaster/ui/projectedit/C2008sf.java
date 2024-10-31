package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.media.MediaScannerConnection;
import com.nexstreaming.kinemaster.ui.projectedit.ReverseController;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.sf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2008sf implements ReverseController.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Long f22522a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f22523b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f22524c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f22525d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f22526e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22527f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2008sf(ProjectEditActivity projectEditActivity, Long l, NexTimelineItem nexTimelineItem, String str, int i, int i2) {
        this.f22527f = projectEditActivity;
        this.f22522a = l;
        this.f22523b = nexTimelineItem;
        this.f22524c = str;
        this.f22525d = i;
        this.f22526e = i2;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ReverseController.c
    public void a(ReverseController.ReverseResult reverseResult, File file) {
        AtomicBoolean atomicBoolean;
        Activity u;
        atomicBoolean = this.f22527f.db;
        atomicBoolean.set(false);
        Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f22522a.longValue());
        if (reverseResult.isSuccess() && file != null) {
            u = this.f22527f.u();
            MediaScannerConnection.scanFile(u, new String[]{file.getAbsolutePath()}, null, new C1999rf(this));
        }
        KMEvents.EDIT_REVERSE_VIDEO.trackReverse(this.f22524c, this.f22525d - this.f22526e, valueOf.intValue(), reverseResult);
    }
}
