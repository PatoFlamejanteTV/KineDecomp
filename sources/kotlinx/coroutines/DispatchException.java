package kotlinx.coroutines;

import com.facebook.share.internal.ShareConstants;

/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public final class DispatchException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DispatchException(String str, Throwable th) {
        super(str, th);
        kotlin.jvm.internal.h.b(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        kotlin.jvm.internal.h.b(th, "cause");
    }
}
