package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
public enum BoundType {
    OPEN { // from class: com.google.common.collect.BoundType.1
        @Override // com.google.common.collect.BoundType
        BoundType flip() {
            return BoundType.CLOSED;
        }
    },
    CLOSED { // from class: com.google.common.collect.BoundType.2
        @Override // com.google.common.collect.BoundType
        BoundType flip() {
            return BoundType.OPEN;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.collect.BoundType$1 */
    /* loaded from: classes2.dex */
    public enum AnonymousClass1 extends BoundType {
        @Override // com.google.common.collect.BoundType
        BoundType flip() {
            return BoundType.CLOSED;
        }
    }

    /* renamed from: com.google.common.collect.BoundType$2 */
    /* loaded from: classes2.dex */
    enum AnonymousClass2 extends BoundType {
        @Override // com.google.common.collect.BoundType
        BoundType flip() {
            return BoundType.OPEN;
        }
    }

    public static BoundType forBoolean(boolean z) {
        return z ? CLOSED : OPEN;
    }

    abstract BoundType flip();

    /* synthetic */ BoundType(AnonymousClass1 anonymousClass1) {
        this();
    }
}
