package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MapMaker;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@GwtIncompatible
@CanIgnoreReturnValue
@ThreadSafe
/* loaded from: classes2.dex */
public class CycleDetectingLockFactory {

    /* renamed from: a */
    private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, a>> f16164a = new MapMaker().g().f();

    /* renamed from: b */
    private static final Logger f16165b = Logger.getLogger(CycleDetectingLockFactory.class.getName());

    /* renamed from: c */
    private static final ThreadLocal<ArrayList<a>> f16166c = new m();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ExampleStackTrace extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        static final Set<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), a.class.getName());

        ExampleStackTrace(a aVar, a aVar2) {
            super(aVar.a() + " -> " + aVar2.a());
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                if (WithExplicitOrdering.class.getName().equals(stackTrace[i].getClassName())) {
                    setStackTrace(EMPTY_STACK_TRACE);
                    return;
                } else {
                    if (!EXCLUDED_CLASS_NAMES.contains(stackTrace[i].getClassName())) {
                        setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i, length));
                        return;
                    }
                }
            }
        }
    }

    @Beta
    /* loaded from: classes2.dex */
    public enum Policies implements Policy {
        THROW { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.1
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        },
        WARN { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.2
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.f16165b.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        },
        DISABLED { // from class: com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.3
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        };

        /* renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$1 */
        /* loaded from: classes2.dex */
        enum AnonymousClass1 extends Policies {
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        }

        /* renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$2 */
        /* loaded from: classes2.dex */
        enum AnonymousClass2 extends Policies {
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.f16165b.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        }

        /* renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$3 */
        /* loaded from: classes2.dex */
        enum AnonymousClass3 extends Policies {
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        }

        /* synthetic */ Policies(m mVar) {
            this();
        }
    }

    @Beta
    @ThreadSafe
    /* loaded from: classes2.dex */
    public interface Policy {
    }

    @Beta
    /* loaded from: classes2.dex */
    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace conflictingStackTrace;

        /* synthetic */ PotentialDeadlockException(a aVar, a aVar2, ExampleStackTrace exampleStackTrace, m mVar) {
            this(aVar, aVar2, exampleStackTrace);
        }

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder sb = new StringBuilder(super.getMessage());
            for (Throwable th = this.conflictingStackTrace; th != null; th = th.getCause()) {
                sb.append(", ");
                sb.append(th.getMessage());
            }
            return sb.toString();
        }

        private PotentialDeadlockException(a aVar, a aVar2, ExampleStackTrace exampleStackTrace) {
            super(aVar, aVar2);
            this.conflictingStackTrace = exampleStackTrace;
            initCause(exampleStackTrace);
        }
    }

    @Beta
    /* loaded from: classes2.dex */
    public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        final String f16167a;

        String a() {
            return this.f16167a;
        }
    }
}
