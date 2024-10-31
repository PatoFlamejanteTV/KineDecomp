package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@KeepForSdk
/* loaded from: classes.dex */
public class AndroidUtilsLight {
    public static MessageDigest a(String str) {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }
}
