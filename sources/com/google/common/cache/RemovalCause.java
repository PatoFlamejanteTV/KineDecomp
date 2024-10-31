package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: classes2.dex */
public enum RemovalCause {
    EXPLICIT { // from class: com.google.common.cache.RemovalCause.1
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return false;
        }
    },
    REPLACED { // from class: com.google.common.cache.RemovalCause.2
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return false;
        }
    },
    COLLECTED { // from class: com.google.common.cache.RemovalCause.3
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    },
    EXPIRED { // from class: com.google.common.cache.RemovalCause.4
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    },
    SIZE { // from class: com.google.common.cache.RemovalCause.5
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.cache.RemovalCause$1 */
    /* loaded from: classes2.dex */
    public enum AnonymousClass1 extends RemovalCause {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return false;
        }
    }

    /* renamed from: com.google.common.cache.RemovalCause$2 */
    /* loaded from: classes2.dex */
    enum AnonymousClass2 extends RemovalCause {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return false;
        }
    }

    /* renamed from: com.google.common.cache.RemovalCause$3 */
    /* loaded from: classes2.dex */
    enum AnonymousClass3 extends RemovalCause {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    }

    /* renamed from: com.google.common.cache.RemovalCause$4 */
    /* loaded from: classes2.dex */
    enum AnonymousClass4 extends RemovalCause {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    }

    /* renamed from: com.google.common.cache.RemovalCause$5 */
    /* loaded from: classes2.dex */
    enum AnonymousClass5 extends RemovalCause {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.cache.RemovalCause
        public boolean wasEvicted() {
            return true;
        }
    }

    public abstract boolean wasEvicted();

    /* synthetic */ RemovalCause(AnonymousClass1 anonymousClass1) {
        this();
    }
}
