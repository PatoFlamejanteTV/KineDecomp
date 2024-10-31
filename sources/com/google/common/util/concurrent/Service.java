package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public interface Service {

    @Beta
    /* loaded from: classes2.dex */
    public static abstract class Listener {
        public void a() {
        }

        public void a(State state) {
        }

        public void a(State state, Throwable th) {
        }

        public void b() {
        }

        public void b(State state) {
        }
    }

    @Beta
    /* loaded from: classes2.dex */
    public enum State {
        NEW { // from class: com.google.common.util.concurrent.Service.State.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        STARTING { // from class: com.google.common.util.concurrent.Service.State.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        RUNNING { // from class: com.google.common.util.concurrent.Service.State.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        STOPPING { // from class: com.google.common.util.concurrent.Service.State.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        },
        TERMINATED { // from class: com.google.common.util.concurrent.Service.State.5
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return true;
            }
        },
        FAILED { // from class: com.google.common.util.concurrent.Service.State.6
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return true;
            }
        };

        /* renamed from: com.google.common.util.concurrent.Service$State$1 */
        /* loaded from: classes2.dex */
        enum AnonymousClass1 extends State {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        }

        /* renamed from: com.google.common.util.concurrent.Service$State$2 */
        /* loaded from: classes2.dex */
        enum AnonymousClass2 extends State {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        }

        /* renamed from: com.google.common.util.concurrent.Service$State$3 */
        /* loaded from: classes2.dex */
        enum AnonymousClass3 extends State {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        }

        /* renamed from: com.google.common.util.concurrent.Service$State$4 */
        /* loaded from: classes2.dex */
        enum AnonymousClass4 extends State {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return false;
            }
        }

        /* renamed from: com.google.common.util.concurrent.Service$State$5 */
        /* loaded from: classes2.dex */
        enum AnonymousClass5 extends State {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return true;
            }
        }

        /* renamed from: com.google.common.util.concurrent.Service$State$6 */
        /* loaded from: classes2.dex */
        enum AnonymousClass6 extends State {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.util.concurrent.Service.State
            public boolean isTerminal() {
                return true;
            }
        }

        public abstract boolean isTerminal();

        /* synthetic */ State(u uVar) {
            this();
        }
    }

    State a();
}
