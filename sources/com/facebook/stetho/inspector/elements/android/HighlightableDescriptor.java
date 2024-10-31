package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public interface HighlightableDescriptor<E> {
    @Nullable
    Object getElementToHighlightAtPosition(E e2, int i, int i2, Rect rect);

    @Nullable
    View getViewAndBoundsForHighlighting(E e2, Rect rect);
}
