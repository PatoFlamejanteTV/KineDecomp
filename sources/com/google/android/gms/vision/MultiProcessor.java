package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;

/* loaded from: classes.dex */
public class MultiProcessor<T> implements Detector.Processor<T> {

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<MultiProcessor<T>.a> f2254a = new SparseArray<>();
    private int b = 3;

    /* loaded from: classes.dex */
    public static class Builder<T> {
    }

    /* loaded from: classes.dex */
    public interface Factory<T> {
    }

    /* loaded from: classes.dex */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        private Tracker<T> f2255a;
    }

    private MultiProcessor() {
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2254a.size()) {
                this.f2254a.clear();
                return;
            } else {
                ((a) this.f2254a.valueAt(i2)).f2255a.a();
                i = i2 + 1;
            }
        }
    }
}
