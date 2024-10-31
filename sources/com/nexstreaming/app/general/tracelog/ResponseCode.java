package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes2.dex */
public enum ResponseCode implements Task.TaskError, DiagnosticLogger.a {
    SUCCESS(0),
    APPAUTH_FAILED(1),
    LICENSE_EXPIRED(2),
    DLLIMIT_EXCEEDED(3),
    NO_AVAILABLE_LICENSE(4),
    INVALID_APIVERSION(5),
    ERR_NORMAL(6),
    ERR_FATAL(7),
    INVALID_CODECID(8),
    INVALID_DEVICE(9),
    UPDATE_AVAILABLE(10),
    UPDATE_NOTAVAILABLE(11),
    APP_VERSION_EXISTED(12),
    NOTICE_AVAILABLE(13),
    NOTICE_NOTAVAILABLE(14),
    INVALID_PROMOCODE(15),
    EXPIRED_PROMOCODE(16),
    ALREADYINUSE_PROMOCODE(17),
    PROMOCODE_NONE(18),
    PROMOCODE_ALREADY(19),
    ALREADY_IAP_REGISTERED(20),
    APP_BLOCKDATE(21),
    INVALID_SOUNDTRACKID(22),
    NO_MATCH(23),
    INVALID_TOKEN(24),
    PURCHASE_CANCEL(25),
    CONSUMED(26),
    PURCHASE_EXCEPTION(27),
    NOT_FOUND_LIST(28),
    AUTH_FAILED_XIAOMI_UID(29),
    NOT_FOUND_XIAOMI_PAYMENT_ORDER_ID(30),
    PAYMENT_STATUS_FAILED(31),
    SOMETHING_WRONG(ErrorCode.AdError.RETRY_NO_FILL_ERROR),
    SOCKET_ERROR(-1),
    UNKNOWN;

    private final boolean unknown;
    private final int value;

    ResponseCode(int i) {
        this.value = i;
        this.unknown = false;
    }

    public static ResponseCode fromValue(int i) {
        for (ResponseCode responseCode : values()) {
            if (responseCode.value == i) {
                return responseCode;
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
        return value();
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getLocalizedMessage(Context context) {
        return getMessage();
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getMessage() {
        if (this.unknown) {
            return "UNKNOWN";
        }
        return name() + " [" + this.value + "]";
    }

    public int value() {
        return this.value;
    }

    ResponseCode() {
        this.value = 0;
        this.unknown = true;
    }
}
