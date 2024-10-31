package com.google.android.gms.internal.firebase_messaging;

/* loaded from: classes2.dex */
final class d extends a {

    /* renamed from: b */
    private final b f13121b = new b();

    @Override // com.google.android.gms.internal.firebase_messaging.a
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 != null) {
            this.f13121b.a(th, true).add(th2);
            return;
        }
        throw new NullPointerException("The suppressed exception cannot be null.");
    }
}
