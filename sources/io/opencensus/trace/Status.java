package io.opencensus.trace;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes3.dex */
public final class Status {

    /* renamed from: a */
    private static final List<Status> f28044a = c();

    /* renamed from: b */
    public static final Status f28045b = CanonicalCode.OK.toStatus();

    /* renamed from: c */
    public static final Status f28046c = CanonicalCode.CANCELLED.toStatus();

    /* renamed from: d */
    public static final Status f28047d = CanonicalCode.UNKNOWN.toStatus();

    /* renamed from: e */
    public static final Status f28048e = CanonicalCode.INVALID_ARGUMENT.toStatus();

    /* renamed from: f */
    public static final Status f28049f = CanonicalCode.DEADLINE_EXCEEDED.toStatus();

    /* renamed from: g */
    public static final Status f28050g = CanonicalCode.NOT_FOUND.toStatus();

    /* renamed from: h */
    public static final Status f28051h = CanonicalCode.ALREADY_EXISTS.toStatus();
    public static final Status i = CanonicalCode.PERMISSION_DENIED.toStatus();
    public static final Status j = CanonicalCode.UNAUTHENTICATED.toStatus();
    public static final Status k = CanonicalCode.RESOURCE_EXHAUSTED.toStatus();
    public static final Status l = CanonicalCode.FAILED_PRECONDITION.toStatus();
    public static final Status m = CanonicalCode.ABORTED.toStatus();
    public static final Status n = CanonicalCode.OUT_OF_RANGE.toStatus();
    public static final Status o = CanonicalCode.UNIMPLEMENTED.toStatus();
    public static final Status p = CanonicalCode.INTERNAL.toStatus();
    public static final Status q = CanonicalCode.UNAVAILABLE.toStatus();
    public static final Status r = CanonicalCode.DATA_LOSS.toStatus();
    private final CanonicalCode s;

    @Nullable
    private final String t;

    /* loaded from: classes3.dex */
    public enum CanonicalCode {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);

        private final int value;

        CanonicalCode(int i) {
            this.value = i;
        }

        @VisibleForTesting
        public Status toStatus() {
            return (Status) Status.f28044a.get(this.value);
        }

        public int value() {
            return this.value;
        }
    }

    private Status(CanonicalCode canonicalCode, @Nullable String str) {
        Preconditions.a(canonicalCode, "canonicalCode");
        this.s = canonicalCode;
        this.t = str;
    }

    private static List<Status> c() {
        TreeMap treeMap = new TreeMap();
        for (CanonicalCode canonicalCode : CanonicalCode.values()) {
            Status status = (Status) treeMap.put(Integer.valueOf(canonicalCode.value()), new Status(canonicalCode, null));
            if (status != null) {
                throw new IllegalStateException("Code value duplication between " + status.b().name() + " & " + canonicalCode.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    public CanonicalCode b() {
        return this.s;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.s == status.s && Objects.a(this.t, status.t);
    }

    public int hashCode() {
        return Objects.a(this.s, this.t);
    }

    public String toString() {
        return MoreObjects.a(this).a("canonicalCode", this.s).a("description", this.t).toString();
    }

    public Status a(String str) {
        return Objects.a(this.t, str) ? this : new Status(this.s, str);
    }
}
