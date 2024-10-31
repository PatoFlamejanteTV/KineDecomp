package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class AbstractChainedDescriptor<E> extends Descriptor<E> implements ChainedDescriptor<E> {
    private Descriptor<? super E> mSuper;

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getAttributes(E e2, AttributeAccumulator attributeAccumulator) {
        this.mSuper.getAttributes(e2, attributeAccumulator);
        onGetAttributes(e2, attributeAccumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getChildren(E e2, Accumulator<Object> accumulator) {
        this.mSuper.getChildren(e2, accumulator);
        onGetChildren(e2, accumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getComputedStyles(E e2, ComputedStyleAccumulator computedStyleAccumulator) {
        this.mSuper.getComputedStyles(e2, computedStyleAccumulator);
        onGetComputedStyles(e2, computedStyleAccumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final String getLocalName(E e2) {
        return onGetLocalName(e2);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final String getNodeName(E e2) {
        return onGetNodeName(e2);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final NodeType getNodeType(E e2) {
        return onGetNodeType(e2);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final String getNodeValue(E e2) {
        return onGetNodeValue(e2);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getStyleRuleNames(E e2, StyleRuleNameAccumulator styleRuleNameAccumulator) {
        this.mSuper.getStyleRuleNames(e2, styleRuleNameAccumulator);
        onGetStyleRuleNames(e2, styleRuleNameAccumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getStyles(E e2, String str, StyleAccumulator styleAccumulator) {
        this.mSuper.getStyles(e2, str, styleAccumulator);
        onGetStyles(e2, str, styleAccumulator);
    }

    final Descriptor<? super E> getSuper() {
        return this.mSuper;
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void hook(E e2) {
        verifyThreadAccess();
        this.mSuper.hook(e2);
        onHook(e2);
    }

    protected void onGetAttributes(E e2, AttributeAccumulator attributeAccumulator) {
    }

    protected void onGetChildren(E e2, Accumulator<Object> accumulator) {
    }

    protected void onGetComputedStyles(E e2, ComputedStyleAccumulator computedStyleAccumulator) {
    }

    protected String onGetLocalName(E e2) {
        return this.mSuper.getLocalName(e2);
    }

    protected String onGetNodeName(E e2) {
        return this.mSuper.getNodeName(e2);
    }

    protected NodeType onGetNodeType(E e2) {
        return this.mSuper.getNodeType(e2);
    }

    @Nullable
    public String onGetNodeValue(E e2) {
        return this.mSuper.getNodeValue(e2);
    }

    protected void onGetStyleRuleNames(E e2, StyleRuleNameAccumulator styleRuleNameAccumulator) {
    }

    protected void onGetStyles(E e2, String str, StyleAccumulator styleAccumulator) {
    }

    protected void onHook(E e2) {
    }

    protected void onSetAttributesAsText(E e2, String str) {
        this.mSuper.setAttributesAsText(e2, str);
    }

    protected void onSetStyle(E e2, String str, String str2, String str3) {
    }

    protected void onUnhook(E e2) {
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void setAttributesAsText(E e2, String str) {
        onSetAttributesAsText(e2, str);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void setStyle(E e2, String str, String str2, String str3) {
        this.mSuper.setStyle(e2, str, str2, str3);
        onSetStyle(e2, str, str2, str3);
    }

    @Override // com.facebook.stetho.inspector.elements.ChainedDescriptor
    public void setSuper(Descriptor<? super E> descriptor) {
        Util.throwIfNull(descriptor);
        Descriptor<? super E> descriptor2 = this.mSuper;
        if (descriptor != descriptor2) {
            if (descriptor2 == null) {
                this.mSuper = descriptor;
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void unhook(E e2) {
        verifyThreadAccess();
        onUnhook(e2);
        this.mSuper.unhook(e2);
    }
}
