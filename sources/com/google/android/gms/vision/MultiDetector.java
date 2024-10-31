package com.google.android.gms.vision;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MultiDetector extends Detector<Object> {

    /* renamed from: a, reason: collision with root package name */
    private List<Detector<? extends Object>> f2252a;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private MultiDetector f2253a = new MultiDetector();
    }

    private MultiDetector() {
        this.f2252a = new ArrayList();
    }

    @Override // com.google.android.gms.vision.Detector
    public void a() {
        Iterator<Detector<? extends Object>> it = this.f2252a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f2252a.clear();
    }
}
