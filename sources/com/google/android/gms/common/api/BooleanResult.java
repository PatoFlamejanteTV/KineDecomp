package com.google.android.gms.common.api;

/* loaded from: classes.dex */
public class BooleanResult implements Result {

    /* renamed from: a, reason: collision with root package name */
    private final Status f974a;
    private final boolean b;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.f974a.equals(booleanResult.f974a) && this.b == booleanResult.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f974a;
    }

    public final int hashCode() {
        return (this.b ? 1 : 0) + ((this.f974a.hashCode() + 527) * 31);
    }
}
