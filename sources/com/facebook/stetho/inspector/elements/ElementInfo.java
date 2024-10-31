package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.Util;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes.dex */
public final class ElementInfo {
    public final List<Object> children;
    public final Object element;

    @Nullable
    public final Object parentElement;

    public ElementInfo(Object obj, @Nullable Object obj2, List<Object> list) {
        Util.throwIfNull(obj);
        this.element = obj;
        this.parentElement = obj2;
        this.children = ListUtil.copyToImmutableList(list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ElementInfo)) {
            return false;
        }
        ElementInfo elementInfo = (ElementInfo) obj;
        return this.element == elementInfo.element && this.parentElement == elementInfo.parentElement && ListUtil.identityEquals(this.children, elementInfo.children);
    }
}
