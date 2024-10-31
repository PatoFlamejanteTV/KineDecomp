package kotlinx.coroutines;

import com.facebook.share.internal.ShareConstants;
import java.util.concurrent.CancellationException;

/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public final class JobCancellationException extends CancellationException {
    public final P job;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobCancellationException(String str, Throwable th, P p) {
        super(str);
        kotlin.jvm.internal.h.b(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        kotlin.jvm.internal.h.b(p, "job");
        this.job = p;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!kotlin.jvm.internal.h.a((Object) jobCancellationException.getMessage(), (Object) getMessage()) || !kotlin.jvm.internal.h.a(jobCancellationException.job, this.job) || !kotlin.jvm.internal.h.a(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (!C2553w.f28726a) {
            return this;
        }
        Throwable fillInStackTrace = super.fillInStackTrace();
        kotlin.jvm.internal.h.a((Object) fillInStackTrace, "super.fillInStackTrace()");
        return fillInStackTrace;
    }

    public int hashCode() {
        String message = getMessage();
        if (message == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        int hashCode = ((message.hashCode() * 31) + this.job.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }
}
