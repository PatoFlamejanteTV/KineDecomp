package com.adobe.creativesdk.foundation.auth;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum AdobeAuthErrorCode implements Parcelable {
    ADOBE_AUTH_ERROR_AUTH_MODULE_NOT_INITIALIZED(1),
    ADOBE_AUTH_ERROR_CODE_OFFLINE(2),
    ADOBE_AUTH_ERROR_CODE_NO_ERROR(3),
    ADOBE_AUTH_ERROR_CODE_USER_CANCELLED(4),
    ADOBE_AUTH_ERROR_CODE_USER_INTERACTION_REQUIRED(5),
    ADOBE_AUTH_ERROR_CODE_USERNAME_AND_PASSWORD_REQUIRED(6),
    ADOBE_AUTH_ERROR_CODE_DEVICE_ID_REQUIRED(7),
    ADOBE_AUTH_ERROR_CODE_CLIENT_ID_REQUIRED(8),
    ADOBE_AUTH_ERROR_CODE_CLIENT_SECRET_REQUIRED(9),
    ADOBE_AUTH_ERROR_CODE_INVALID_ARGUMENT(10),
    ADOBE_AUTH_ERROR_CODE_UNKNOWN_ERROR(11),
    ADOBE_AUTH_ERROR_CODE_NETWORK_ERROR(12),
    ADOBE_AUTH_ERROR_CODE_USER_NOT_ENTITLED(13),
    ADOBE_AUTH_ERROR_CODE_USER_CREDENTIALS_REQUIRED(14),
    ADOBE_AUTH_ERROR_CODE_UPDATED_TOU(15),
    ADOBE_AUTH_ERROR_CODE_EMAIL_VERIFICATION(16),
    ADOBE_AUTH_ERROR_CODE_AGE_VERIFICATION(17),
    ADOBE_AUTH_ERROR_CODE_SOCIAL_LOGIN_RECOVERABLE_USER(18),
    ADOBE_AUTH_ERROR_CODE_SOCIAL_LOGIN_RECOVERABLE_SDK(19),
    ADOBE_AUTH_ERROR_CODE_INCORRECT_REDIRECT_URL(20);

    private final int value;
    private static Map<Integer, AdobeAuthErrorCode> map = new HashMap();
    public static final Parcelable.Creator<AdobeAuthErrorCode> CREATOR = new Parcelable.Creator<AdobeAuthErrorCode>() { // from class: com.adobe.creativesdk.foundation.auth.a
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdobeAuthErrorCode createFromParcel(Parcel parcel) {
            return AdobeAuthErrorCode.values()[parcel.readInt()];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdobeAuthErrorCode[] newArray(int i) {
            return new AdobeAuthErrorCode[i];
        }
    };

    static {
        for (AdobeAuthErrorCode adobeAuthErrorCode : values()) {
            map.put(Integer.valueOf(adobeAuthErrorCode.value), adobeAuthErrorCode);
        }
    }

    AdobeAuthErrorCode(int i) {
        this.value = i;
    }

    public static AdobeAuthErrorCode fromInt(int i) {
        return map.get(Integer.valueOf(i));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getValue() {
        return this.value;
    }

    public void readFromParcel(Parcel parcel) {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.value);
    }
}
