package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;

/* compiled from: Channel.kt */
/* loaded from: classes3.dex */
public final class ClosedSendChannelException extends CancellationException {
    public ClosedSendChannelException(String str) {
        super(str);
    }
}
