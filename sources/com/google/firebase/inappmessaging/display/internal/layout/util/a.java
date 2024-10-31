package com.google.firebase.inappmessaging.display.internal.layout.util;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class a implements Comparator<ViewMeasure> {

    /* renamed from: a */
    final /* synthetic */ VerticalViewGroupMeasure f17701a;

    public a(VerticalViewGroupMeasure verticalViewGroupMeasure) {
        this.f17701a = verticalViewGroupMeasure;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ViewMeasure viewMeasure, ViewMeasure viewMeasure2) {
        if (viewMeasure.a() > viewMeasure2.a()) {
            return -1;
        }
        return viewMeasure.a() < viewMeasure2.a() ? 1 : 0;
    }
}
