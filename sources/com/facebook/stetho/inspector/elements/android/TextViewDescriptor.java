package com.facebook.stetho.inspector.elements.android;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class TextViewDescriptor extends AbstractChainedDescriptor<TextView> {
    private static final String TEXT_ATTRIBUTE_NAME = "text";
    private final Map<TextView, ElementContext> mElementToContextMap = Collections.synchronizedMap(new IdentityHashMap());

    /* loaded from: classes.dex */
    public final class ElementContext implements TextWatcher {
        private TextView mElement;

        private ElementContext() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                TextViewDescriptor.this.getHost().onAttributeRemoved(this.mElement, TextViewDescriptor.TEXT_ATTRIBUTE_NAME);
            } else {
                TextViewDescriptor.this.getHost().onAttributeModified(this.mElement, TextViewDescriptor.TEXT_ATTRIBUTE_NAME, editable.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void hook(TextView textView) {
            Util.throwIfNull(textView);
            this.mElement = textView;
            this.mElement.addTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void unhook() {
            TextView textView = this.mElement;
            if (textView != null) {
                textView.removeTextChangedListener(this);
                this.mElement = null;
            }
        }

        /* synthetic */ ElementContext(TextViewDescriptor textViewDescriptor, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    public void onGetAttributes(TextView textView, AttributeAccumulator attributeAccumulator) {
        CharSequence text = textView.getText();
        if (text == null || text.length() == 0) {
            return;
        }
        attributeAccumulator.store(TEXT_ATTRIBUTE_NAME, text.toString());
    }

    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    public void onHook(TextView textView) {
        ElementContext elementContext = new ElementContext();
        elementContext.hook(textView);
        this.mElementToContextMap.put(textView, elementContext);
    }

    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    public void onUnhook(TextView textView) {
        this.mElementToContextMap.remove(textView).unhook();
    }
}
