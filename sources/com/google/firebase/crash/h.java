package com.google.firebase.crash;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* loaded from: classes2.dex */
final class h implements BackgroundDetector.BackgroundStateChangeListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void a(boolean z) {
        FirebaseCrash.a().a(!z);
    }
}
