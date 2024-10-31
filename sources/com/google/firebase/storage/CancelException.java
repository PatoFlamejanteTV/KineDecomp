package com.google.firebase.storage;

import com.google.firebase.annotations.PublicApi;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
class CancelException extends IOException {
    @PublicApi
    public CancelException() {
        super("The operation was canceled.");
    }
}
