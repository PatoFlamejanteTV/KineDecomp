package com.nexstreaming.app.general.iab;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.DiagnosticLogger;

/* loaded from: classes2.dex */
public enum BillingResponse implements Task.TaskError, DiagnosticLogger.a {
    OK(0, true),
    USER_CANCELED(1, true),
    BILLING_UNAVAILABLE(3, true),
    ITEM_UNAVAILABLE(4, true),
    DEVELOPER_ERROR(5, true),
    ERROR(6, true),
    ITEM_ALREADY_OWNED(7, true),
    ITEM_NOT_OWNED(8, true),
    SERVICE_DISCONNECTED(40, false),
    CONTEXT_DISCONNECTED(41, false),
    GENERAL_FAILURE(42, false),
    USER_CANCELED_ACTIVITY(43, false),
    BAD_ACTIVITY_RESULT(44, false),
    NULL_INTENT_DATA(45, false),
    UNKNOWN(46, false),
    PENDING_PURCHASE(47, false);

    private final int code;
    private final boolean hasCode;

    BillingResponse(int i, boolean z) {
        this.code = i;
        this.hasCode = z;
    }

    public static BillingResponse fromCode(int i) {
        int i2;
        for (BillingResponse billingResponse : values()) {
            if (billingResponse.hasCode && (i2 = billingResponse.code) >= 0 && i2 == i) {
                return billingResponse;
            }
        }
        return UNKNOWN;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public Exception getException() {
        return null;
    }

    @Override // com.nexstreaming.app.general.util.DiagnosticLogger.a
    public int getIntErrorCode() {
        return this.code;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getLocalizedMessage(Context context) {
        return getMessage();
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getMessage() {
        return name();
    }
}
