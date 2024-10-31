package kotlin;

import java.io.Serializable;

/* compiled from: Result.kt */
/* loaded from: classes3.dex */
public final class Result<T> implements Serializable {
    public static final a Companion = new a(null);
    private final Object value;

    /* compiled from: Result.kt */
    /* loaded from: classes3.dex */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable th) {
            kotlin.jvm.internal.h.b(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && kotlin.jvm.internal.h.a(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    /* compiled from: Result.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl */
    public static final /* synthetic */ Result m22boximpl(Object obj) {
        return new Result(obj);
    }

    /* renamed from: constructor-impl */
    public static Object m23constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl */
    public static boolean m24equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && kotlin.jvm.internal.h.a(obj, ((Result) obj2).m31unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m25equalsimpl0(Object obj, Object obj2) {
        throw null;
    }

    /* renamed from: exceptionOrNull-impl */
    public static final Throwable m26exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* renamed from: hashCode-impl */
    public static int m27hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: isFailure-impl */
    public static final boolean m28isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl */
    public static final boolean m29isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: toString-impl */
    public static String m30toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public static /* synthetic */ void value$annotations() {
    }

    public boolean equals(Object obj) {
        return m24equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m27hashCodeimpl(this.value);
    }

    public String toString() {
        return m30toStringimpl(this.value);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ Object m31unboximpl() {
        return this.value;
    }
}
