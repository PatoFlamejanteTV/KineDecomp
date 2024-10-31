package kotlinx.coroutines;

import com.facebook.share.internal.ShareConstants;
import java.util.concurrent.CancellationException;

/* compiled from: Timeout.kt */
/* loaded from: classes3.dex */
public final class TimeoutCancellationException extends CancellationException {
    public final P coroutine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeoutCancellationException(String str, P p) {
        super(str);
        kotlin.jvm.internal.h.b(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.coroutine = p;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TimeoutCancellationException(String str) {
        this(str, null);
        kotlin.jvm.internal.h.b(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
    }
}
