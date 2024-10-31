package com.facebook.stetho.inspector.elements.android;

import android.app.Dialog;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class DialogDescriptor extends AbstractChainedDescriptor<Dialog> implements HighlightableDescriptor<Dialog> {
    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    protected /* bridge */ /* synthetic */ void onGetChildren(Dialog dialog, Accumulator accumulator) {
        onGetChildren2(dialog, (Accumulator<Object>) accumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public Object getElementToHighlightAtPosition(Dialog dialog, int i, int i2, Rect rect) {
        Window window;
        HighlightableDescriptor highlightableDescriptor;
        Descriptor.Host host = getHost();
        if (host instanceof AndroidDescriptorHost) {
            window = dialog.getWindow();
            highlightableDescriptor = ((AndroidDescriptorHost) host).getHighlightableDescriptor(window);
        } else {
            window = null;
            highlightableDescriptor = null;
        }
        if (highlightableDescriptor == null) {
            return null;
        }
        return highlightableDescriptor.getElementToHighlightAtPosition(window, i, i2, rect);
    }

    @Override // com.facebook.stetho.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public View getViewAndBoundsForHighlighting(Dialog dialog, Rect rect) {
        Window window;
        HighlightableDescriptor highlightableDescriptor;
        Descriptor.Host host = getHost();
        if (host instanceof AndroidDescriptorHost) {
            window = dialog.getWindow();
            highlightableDescriptor = ((AndroidDescriptorHost) host).getHighlightableDescriptor(window);
        } else {
            window = null;
            highlightableDescriptor = null;
        }
        if (highlightableDescriptor == null) {
            return null;
        }
        return highlightableDescriptor.getViewAndBoundsForHighlighting(window, rect);
    }

    /* renamed from: onGetChildren */
    protected void onGetChildren2(Dialog dialog, Accumulator<Object> accumulator) {
        Window window = dialog.getWindow();
        if (window != null) {
            accumulator.store(window);
        }
    }
}