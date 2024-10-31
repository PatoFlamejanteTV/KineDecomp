package io.grpc;

import com.google.common.base.Preconditions;

/* compiled from: ConnectivityStateInfo.java */
/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a */
    private final ConnectivityState f28023a;

    /* renamed from: b */
    private final Status f28024b;

    private r(ConnectivityState connectivityState, Status status) {
        Preconditions.a(connectivityState, "state is null");
        this.f28023a = connectivityState;
        Preconditions.a(status, "status is null");
        this.f28024b = status;
    }

    public static r a(ConnectivityState connectivityState) {
        Preconditions.a(connectivityState != ConnectivityState.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new r(connectivityState, Status.f27129b);
    }

    public Status b() {
        return this.f28024b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f28023a.equals(rVar.f28023a) && this.f28024b.equals(rVar.f28024b);
    }

    public int hashCode() {
        return this.f28023a.hashCode() ^ this.f28024b.hashCode();
    }

    public String toString() {
        if (this.f28024b.g()) {
            return this.f28023a.toString();
        }
        return this.f28023a + "(" + this.f28024b + ")";
    }

    public static r a(Status status) {
        Preconditions.a(!status.g(), "The error status must not be OK");
        return new r(ConnectivityState.TRANSIENT_FAILURE, status);
    }

    public ConnectivityState a() {
        return this.f28023a;
    }
}
