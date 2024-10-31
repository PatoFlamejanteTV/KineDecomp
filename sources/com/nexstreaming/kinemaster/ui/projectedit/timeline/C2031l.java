package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.util.Log;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.C2034o;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrimaryItemDragDragDecoration.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.l, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2031l implements C2034o.a {

    /* renamed from: a, reason: collision with root package name */
    int f22683a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ float f22684b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ float f22685c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f22686d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f22687e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ C2034o.d f22688f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ C2034o f22689g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2031l(C2034o c2034o, float f2, float f3, int i, int i2, C2034o.d dVar) {
        this.f22689g = c2034o;
        this.f22684b = f2;
        this.f22685c = f3;
        this.f22686d = i;
        this.f22687e = i2;
        this.f22688f = dVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.C2034o.a
    public void a(float f2) {
        int i;
        int i2;
        this.f22689g.E = f2;
        float abs = Math.abs(f2 - this.f22684b) / Math.abs(this.f22684b - this.f22685c);
        int i3 = this.f22683a;
        int i4 = ((int) ((this.f22686d - this.f22687e) * abs)) - i3;
        this.f22683a = i3 + i4;
        C2034o.d dVar = this.f22688f;
        i = dVar.f22696e;
        dVar.f22696e = i + i4;
        Log.d(C2034o.z, "[swapPrimaryItem][onUpdate] id: " + this.f22688f.f22692a.getUniqueId() + ", fraction: " + abs + ", targetStartX: " + this.f22687e + ", targetEndX: " + this.f22686d + ", value: " + f2 + ", delta: " + i4 + ", pixelOffset: " + this.f22683a);
        C2034o c2034o = this.f22689g;
        NexPrimaryTimelineItem nexPrimaryTimelineItem = this.f22688f.f22692a;
        i2 = this.f22688f.f22696e;
        c2034o.a(nexPrimaryTimelineItem, i2);
    }
}
