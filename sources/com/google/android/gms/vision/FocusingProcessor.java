package com.google.android.gms.vision;

import com.google.android.gms.vision.Detector;

/* loaded from: classes.dex */
public abstract class FocusingProcessor<T> implements Detector.Processor<T> {

    /* renamed from: a, reason: collision with root package name */
    private Tracker<T> f2249a;

    @Override // com.google.android.gms.vision.Detector.Processor
    public void a() {
        this.f2249a.a();
    }
}
