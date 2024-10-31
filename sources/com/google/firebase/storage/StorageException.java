package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseException;
import com.google.firebase.annotations.PublicApi;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class StorageException extends FirebaseException {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @PublicApi
    public static final int ERROR_BUCKET_NOT_FOUND = -13011;

    @PublicApi
    public static final int ERROR_CANCELED = -13040;

    @PublicApi
    public static final int ERROR_INVALID_CHECKSUM = -13031;

    @PublicApi
    public static final int ERROR_NOT_AUTHENTICATED = -13020;

    @PublicApi
    public static final int ERROR_NOT_AUTHORIZED = -13021;

    @PublicApi
    public static final int ERROR_OBJECT_NOT_FOUND = -13010;

    @PublicApi
    public static final int ERROR_PROJECT_NOT_FOUND = -13012;

    @PublicApi
    public static final int ERROR_QUOTA_EXCEEDED = -13013;

    @PublicApi
    public static final int ERROR_RETRY_LIMIT_EXCEEDED = -13030;

    @PublicApi
    public static final int ERROR_UNKNOWN = -13000;
    static IOException sCancelException = new IOException("The operation was canceled.");
    private Throwable mCause;
    private String mDetailMessage;
    private final int mErrorCode;
    private final int mHttpResultCode;

    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    @Retention(RetentionPolicy.SOURCE)
    @PublicApi
    /* loaded from: classes.dex */
    public @interface ErrorCode {
    }

    StorageException(int i, Throwable th, int i2) {
        this.mDetailMessage = getErrorMessageForCode(i);
        this.mCause = th;
        this.mErrorCode = i;
        this.mHttpResultCode = i2;
        Log.e("StorageException", "StorageException has occurred.\n" + this.mDetailMessage + "\n Code: " + Integer.toString(this.mErrorCode) + " HttpResult: " + Integer.toString(this.mHttpResultCode));
        Throwable th2 = this.mCause;
        if (th2 != null) {
            Log.e("StorageException", th2.getMessage(), this.mCause);
        }
    }

    private static int a(Status status) {
        return status.S() ? ERROR_CANCELED : status.equals(Status.f10707d) ? ERROR_RETRY_LIMIT_EXCEEDED : ERROR_UNKNOWN;
    }

    private static boolean a(int i) {
        return i == 0 || (i >= 200 && i < 300);
    }

    @PublicApi
    public static StorageException fromErrorStatus(Status status) {
        Preconditions.a(status);
        Preconditions.a(!status.Q());
        return new StorageException(a(status), null, 0);
    }

    @PublicApi
    public static StorageException fromException(Throwable th) {
        return fromExceptionAndHttpCode(th, 0);
    }

    @PublicApi
    public static StorageException fromExceptionAndHttpCode(Throwable th, int i) {
        if (th instanceof StorageException) {
            return (StorageException) th;
        }
        if (a(i) && th == null) {
            return null;
        }
        return new StorageException(a(th, i), th, i);
    }

    static String getErrorMessageForCode(int i) {
        if (i == -13040) {
            return "The operation was cancelled.";
        }
        if (i == -13000) {
            return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
        }
        if (i == -13031) {
            return "Object has a checksum which does not match. Please retry the operation.";
        }
        if (i == -13030) {
            return "The operation retry limit has been exceeded.";
        }
        if (i == -13021) {
            return "User does not have permission to access this object.";
        }
        if (i == -13020) {
            return "User is not authenticated, please authenticate using Firebase Authentication and try again.";
        }
        switch (i) {
            case ERROR_QUOTA_EXCEEDED /* -13013 */:
                return "Quota for bucket exceeded, please view quota on www.firebase.google.com/storage.";
            case ERROR_PROJECT_NOT_FOUND /* -13012 */:
                return "Project does not exist.";
            case ERROR_BUCKET_NOT_FOUND /* -13011 */:
                return "Bucket does not exist.";
            case ERROR_OBJECT_NOT_FOUND /* -13010 */:
                return "Object does not exist at location.";
            default:
                return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
        }
    }

    @Override // java.lang.Throwable
    @PublicApi
    public synchronized Throwable getCause() {
        if (this.mCause == this) {
            return null;
        }
        return this.mCause;
    }

    @PublicApi
    public int getErrorCode() {
        return this.mErrorCode;
    }

    @PublicApi
    public int getHttpResultCode() {
        return this.mHttpResultCode;
    }

    @PublicApi
    public boolean getIsRecoverableException() {
        return getErrorCode() == -13030;
    }

    @Override // java.lang.Throwable
    @PublicApi
    public String getMessage() {
        return this.mDetailMessage;
    }

    private static int a(Throwable th, int i) {
        return th instanceof CancelException ? ERROR_CANCELED : i != -2 ? i != 401 ? i != 409 ? i != 403 ? i != 404 ? ERROR_UNKNOWN : ERROR_OBJECT_NOT_FOUND : ERROR_NOT_AUTHORIZED : ERROR_INVALID_CHECKSUM : ERROR_NOT_AUTHENTICATED : ERROR_RETRY_LIMIT_EXCEEDED;
    }
}
