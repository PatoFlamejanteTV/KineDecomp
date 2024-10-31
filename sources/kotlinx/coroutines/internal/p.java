package kotlinx.coroutines.internal;

import com.facebook.share.internal.ShareConstants;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.text.w;
import kotlinx.coroutines.C2553w;

/* compiled from: StackTraceRecovery.kt */
/* loaded from: classes3.dex */
public final class p {
    public static final <E extends Throwable> E a(E e2, kotlin.coroutines.b<?> bVar) {
        kotlin.jvm.internal.h.b(e2, "exception");
        kotlin.jvm.internal.h.b(bVar, "continuation");
        return (c(e2) || !(bVar instanceof kotlin.coroutines.jvm.internal.b)) ? e2 : (E) a(e2, (kotlin.coroutines.jvm.internal.b) bVar);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> b(E e2) {
        boolean z;
        Throwable cause = e2.getCause();
        if (cause != null && kotlin.jvm.internal.h.a(cause.getClass(), e2.getClass())) {
            StackTraceElement[] stackTrace = e2.getStackTrace();
            kotlin.jvm.internal.h.a((Object) stackTrace, "currentTrace");
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                kotlin.jvm.internal.h.a((Object) stackTraceElement, "it");
                if (a(stackTraceElement)) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                return kotlin.i.a(cause, stackTrace);
            }
            return kotlin.i.a(e2, new StackTraceElement[0]);
        }
        return kotlin.i.a(e2, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> boolean c(E e2) {
        return (C2553w.f28727b && C2553w.f28726a && !(e2 instanceof CancellationException)) ? false : true;
    }

    private static final <E extends Throwable> E a(E e2, kotlin.coroutines.jvm.internal.b bVar) {
        Pair b2 = b(e2);
        Throwable th = (Throwable) b2.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) b2.component2();
        E e3 = (E) h.a(th);
        if (e3 == null) {
            return e2;
        }
        ArrayDeque<StackTraceElement> a2 = a(bVar);
        if (a2.isEmpty()) {
            return e2;
        }
        if (th != e2) {
            a(stackTraceElementArr, a2);
        }
        a(th, e3, a2);
        return e3;
    }

    private static final <E extends Throwable> E a(E e2, E e3, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(a("Coroutine boundary"));
        StackTraceElement[] stackTrace = e2.getStackTrace();
        kotlin.jvm.internal.h.a((Object) stackTrace, "causeTrace");
        int a2 = a(stackTrace, "kotlin.coroutines.jvm.internal.BaseContinuationImpl");
        int i = 0;
        if (a2 == -1) {
            if (arrayDeque != null) {
                Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                e3.setStackTrace((StackTraceElement[]) array);
                return e3;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + a2];
        for (int i2 = 0; i2 < a2; i2++) {
            stackTraceElementArr[i2] = stackTrace[i2];
        }
        Iterator<T> it = arrayDeque.iterator();
        while (it.hasNext()) {
            stackTraceElementArr[a2 + i] = (StackTraceElement) it.next();
            i++;
        }
        e3.setStackTrace(stackTraceElementArr);
        return e3;
    }

    public static final StackTraceElement b(StackTraceElement stackTraceElement) {
        boolean a2;
        String a3;
        kotlin.jvm.internal.h.b(stackTraceElement, "element");
        String className = stackTraceElement.getClassName();
        kotlin.jvm.internal.h.a((Object) className, "element.className");
        a2 = w.a((CharSequence) className, '/', false, 2, (Object) null);
        if (!a2) {
            return stackTraceElement;
        }
        String className2 = stackTraceElement.getClassName();
        kotlin.jvm.internal.h.a((Object) className2, "element.className");
        a3 = kotlin.text.v.a(className2, '/', '.', false, 4, (Object) null);
        return new StackTraceElement(a3, stackTraceElement.getMethodName(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }

    public static final <E extends Throwable> E a(E e2) {
        Throwable cause;
        kotlin.jvm.internal.h.b(e2, "exception");
        if (c(e2) || (cause = e2.getCause()) == null) {
            return e2;
        }
        boolean z = true;
        if (!kotlin.jvm.internal.h.a(cause.getClass(), e2.getClass())) {
            return e2;
        }
        StackTraceElement[] stackTrace = e2.getStackTrace();
        kotlin.jvm.internal.h.a((Object) stackTrace, "exception.stackTrace");
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            kotlin.jvm.internal.h.a((Object) stackTraceElement, "it");
            if (a(stackTraceElement)) {
                break;
            }
            i++;
        }
        if (!z) {
            return e2;
        }
        Throwable cause2 = e2.getCause();
        if (!(cause2 instanceof Throwable)) {
            cause2 = null;
        }
        return cause2 != null ? (E) cause2 : e2;
    }

    private static final ArrayDeque<StackTraceElement> a(kotlin.coroutines.jvm.internal.b bVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = bVar.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(b(stackTraceElement));
        }
        while (true) {
            if (!(bVar instanceof kotlin.coroutines.jvm.internal.b)) {
                bVar = null;
            }
            if (bVar == null || (bVar = bVar.getCallerFrame()) == null) {
                break;
            }
            StackTraceElement stackTraceElement2 = bVar.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(b(stackTraceElement2));
            }
        }
        return arrayDeque;
    }

    public static final StackTraceElement a(String str) {
        kotlin.jvm.internal.h.b(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    public static final boolean a(StackTraceElement stackTraceElement) {
        boolean b2;
        kotlin.jvm.internal.h.b(stackTraceElement, "receiver$0");
        String className = stackTraceElement.getClassName();
        kotlin.jvm.internal.h.a((Object) className, "className");
        b2 = kotlin.text.v.b(className, "\b\b\b", false, 2, null);
        return b2;
    }

    private static final boolean a(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && kotlin.jvm.internal.h.a((Object) stackTraceElement.getMethodName(), (Object) stackTraceElement2.getMethodName()) && kotlin.jvm.internal.h.a((Object) stackTraceElement.getFileName(), (Object) stackTraceElement2.getFileName()) && kotlin.jvm.internal.h.a((Object) stackTraceElement.getClassName(), (Object) stackTraceElement2.getClassName());
    }

    private static final void a(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (a(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i2) {
            return;
        }
        while (true) {
            StackTraceElement stackTraceElement = stackTraceElementArr[length2];
            StackTraceElement last = arrayDeque.getLast();
            kotlin.jvm.internal.h.a((Object) last, "result.last");
            if (a(stackTraceElement, last)) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i2) {
                return;
            } else {
                length2--;
            }
        }
    }

    private static final int a(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (kotlin.jvm.internal.h.a((Object) str, (Object) stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }
}
