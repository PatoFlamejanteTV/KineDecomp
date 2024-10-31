package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import com.nextreaming.nexeditorui.NexTimeline;

/* compiled from: TrackDisplacements.java */
/* loaded from: classes2.dex */
public class O {

    /* renamed from: a, reason: collision with root package name */
    private a[] f22614a = new a[16];

    /* renamed from: b, reason: collision with root package name */
    private int f22615b = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TrackDisplacements.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f22616a;

        /* renamed from: b, reason: collision with root package name */
        int f22617b;

        /* renamed from: c, reason: collision with root package name */
        int f22618c;

        /* renamed from: d, reason: collision with root package name */
        int f22619d;

        /* renamed from: e, reason: collision with root package name */
        int f22620e;

        private a() {
        }
    }

    public void a(int i, int i2, int i3) {
        a aVar;
        int i4 = this.f22615b;
        a[] aVarArr = this.f22614a;
        if (i4 >= aVarArr.length) {
            a[] aVarArr2 = new a[aVarArr.length + Math.min(aVarArr.length, 1024)];
            a[] aVarArr3 = this.f22614a;
            System.arraycopy(aVarArr3, 0, aVarArr2, 0, aVarArr3.length);
            this.f22614a = aVarArr2;
        }
        a[] aVarArr4 = this.f22614a;
        int i5 = this.f22615b;
        if (aVarArr4[i5] == null) {
            aVar = new a();
            this.f22614a[this.f22615b] = aVar;
        } else {
            aVar = aVarArr4[i5];
        }
        this.f22615b++;
        aVar.f22616a = i;
        aVar.f22617b = i2;
        aVar.f22620e = i3;
        aVar.f22618c = -1;
        aVar.f22619d = -1;
    }

    public void a(NexTimeline nexTimeline) {
        for (int i = 0; i < this.f22615b; i++) {
            a[] aVarArr = this.f22614a;
            aVarArr[i].f22618c = nexTimeline.getTrackIndexById(aVarArr[i].f22616a);
            a[] aVarArr2 = this.f22614a;
            aVarArr2[i].f22619d = nexTimeline.getTrackIndexById(aVarArr2[i].f22617b);
        }
    }

    public void a() {
        this.f22615b = 0;
    }

    public int a(int i) {
        for (int i2 = 0; i2 < this.f22615b; i2++) {
            a[] aVarArr = this.f22614a;
            if (i >= aVarArr[i2].f22618c && i <= aVarArr[i2].f22619d) {
                return aVarArr[i2].f22620e;
            }
        }
        return 0;
    }
}
