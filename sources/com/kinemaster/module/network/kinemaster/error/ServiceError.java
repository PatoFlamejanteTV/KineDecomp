package com.kinemaster.module.network.kinemaster.error;

import android.support.v4.app.FrameMetricsAggregator;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes2.dex */
public enum ServiceError {
    UNKNOWN_ERROR(-1, "모듈에서 정의되지 않은 에러 발생"),
    EMPTY_TOKEN_ERROR(-100, "로컬에 저장된 토큰값이 존재하지 않습니다"),
    NETWORK_UNKNOWN_ERROR(-200, "알 수 없는 네트워크 통신 에러 발생"),
    NETWORK_NO_CONNECTION_ERROR(-201, "Retrofit 에서 기본적으로 발생하는 에러 ex: java.net.UnknownHostException"),
    NETWORK_HTTP_ERROR(-202, "Retrofit HttpException 발생"),
    AUTH_SERVICE_FAILED(-300, "허가되지않은 사용자 - ASMS 에서 등록된 앱정보가 올바른지 확인"),
    COMMON_SERVICE_REQUEST_ERROR(-400, "요청 에러 발생"),
    KINEMASTER_SERVER_INTERNAL_ERROR(500, "The request failed due to an internal error."),
    KINEMASTER_SERVER_GATEWAY_TIMEOUT(504, "Service unavailable. Typically the server is down."),
    KINEMASTER_SERVER_UNAVAILABLE(FrameMetricsAggregator.EVERY_DURATION, "Service unavailable. Typically the server is down."),
    KINEMASTER_SERVER_BAD_REQUEST(400, "The API server could not understand the request."),
    KINEMASTER_SERVER_UNAUTHORIZED(ErrorCode.NetWorkError.QUEUE_FULL_ERROR, "Incorrect authentication credentials. This may also returned in other undefined circumstances. or Expired"),
    KINEMASTER_SERVER_PRECONDITION_FAILED(FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED, "The condition set in the request parameter's was not met."),
    KINEMASTER_SERVER_FORBIDDEN(ErrorCode.NetWorkError.HTTP_STATUS_ERROR, "Client does not have sufficient permission"),
    KINEMASTER_SERVER_NOT_FOUND(404, "Resource associated with the request could not be found.");

    private final int errorCode;
    private final String errorMessage;

    ServiceError(int i, String str) {
        this.errorCode = i;
        this.errorMessage = str;
    }

    public static ServiceError fromInt(int i) {
        for (ServiceError serviceError : values()) {
            if (serviceError.getErrorCode() == i) {
                return serviceError;
            }
        }
        return UNKNOWN_ERROR;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ServiceError{  name='" + name() + "', errorCode='" + getErrorCode() + "', errorMessage='" + this.errorMessage + "'}";
    }
}
