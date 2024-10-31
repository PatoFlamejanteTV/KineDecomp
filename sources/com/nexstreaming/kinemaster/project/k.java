package com.nexstreaming.kinemaster.project;

import java.lang.Enum;
import java.util.Arrays;

/* compiled from: TrackUsage.java */
/* loaded from: classes.dex */
public class k<TrackType extends Enum<?>> {

    /* renamed from: a, reason: collision with root package name */
    private int f3627a = -1;
    private a<TrackType>[] b = new a[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TrackUsage.java */
    /* loaded from: classes.dex */
    public static class a<TrackType extends Enum<?>> {

        /* renamed from: a, reason: collision with root package name */
        int f3628a;
        TrackType b;

        private a() {
            this.f3628a = 0;
            this.b = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f3628a = 0;
            this.b = null;
        }
    }

    public void a(int i) {
        int length = this.b.length;
        if (i > length) {
            this.b = (a[]) Arrays.copyOf(this.b, i);
            for (int i2 = length; i2 < i; i2++) {
                this.b[i2] = new a<>();
            }
        }
    }

    public void a() {
        this.f3627a = 0;
        for (a<TrackType> aVar : this.b) {
            aVar.a();
        }
    }

    public int b(int i) {
        if (i < 0 || i + 1 > this.f3627a) {
            return 0;
        }
        return this.b[i].f3628a;
    }

    public void a(int i, int i2) {
        if (i + 1 > this.b.length) {
            a(i + 1);
        }
        this.b[i].f3628a = i2;
        if (i + 1 > this.f3627a) {
            this.f3627a = i + 1;
        }
    }
}
