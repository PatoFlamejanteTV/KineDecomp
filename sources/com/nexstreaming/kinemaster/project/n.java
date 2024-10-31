package com.nexstreaming.kinemaster.project;

import java.lang.Enum;
import java.util.Arrays;

/* compiled from: TrackUsage.java */
/* loaded from: classes.dex */
public class n<TrackType extends Enum<?>> {

    /* renamed from: a */
    private int f21209a = -1;

    /* renamed from: b */
    private a<TrackType>[] f21210b = new a[0];

    /* compiled from: TrackUsage.java */
    /* loaded from: classes.dex */
    public static class a<TrackType extends Enum<?>> {

        /* renamed from: a */
        int f21211a;

        /* renamed from: b */
        TrackType f21212b;

        private a() {
            this.f21211a = 0;
            this.f21212b = null;
        }

        public void a() {
            this.f21211a = 0;
            this.f21212b = null;
        }

        /* synthetic */ a(m mVar) {
            this();
        }
    }

    public void a(int i) {
        a<TrackType>[] aVarArr = this.f21210b;
        int length = aVarArr.length;
        if (i > length) {
            this.f21210b = (a[]) Arrays.copyOf(aVarArr, i);
            while (length < i) {
                this.f21210b[length] = new a<>();
                length++;
            }
        }
    }

    public int b(int i) {
        if (i < 0 || i + 1 > this.f21209a) {
            return 0;
        }
        return this.f21210b[i].f21211a;
    }

    public void a() {
        this.f21209a = 0;
        for (a<TrackType> aVar : this.f21210b) {
            aVar.a();
        }
    }

    public void a(int i, int i2) {
        int i3 = i + 1;
        if (i3 > this.f21210b.length) {
            a(i3);
        }
        this.f21210b[i].f21211a = i2;
        if (i3 > this.f21209a) {
            this.f21209a = i3;
        }
    }
}
