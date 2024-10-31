package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public enum BoundType {
    OPEN { // from class: com.google.common.collect.BoundType.1
        @Override // com.google.common.collect.BoundType
        BoundType flip() {
            return CLOSED;
        }
    },
    CLOSED { // from class: com.google.common.collect.BoundType.2
        @Override // com.google.common.collect.BoundType
        BoundType flip() {
            return OPEN;
        }
    };

    abstract BoundType flip();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BoundType forBoolean(boolean z) {
        return z ? CLOSED : OPEN;
    }
}
