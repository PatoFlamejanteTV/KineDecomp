package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: classes2.dex */
public final class zzdw {
    public static Object a(Object obj) {
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;
        try {
            if (obj == null) {
                return null;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                } catch (Throwable th) {
                    th = th;
                    objectInputStream = null;
                }
                try {
                    Object readObject = objectInputStream.readObject();
                    objectOutputStream.close();
                    objectInputStream.close();
                    return readObject;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                objectOutputStream = null;
            }
        } catch (IOException | ClassNotFoundException unused) {
            return null;
        }
    }

    public static String a(String str, String[] strArr, String[] strArr2) {
        boolean equals;
        Preconditions.a(strArr);
        Preconditions.a(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            String str2 = strArr[i];
            if (str == null && str2 == null) {
                equals = true;
            } else {
                equals = str == null ? false : str.equals(str2);
            }
            if (equals) {
                return strArr2[i];
            }
        }
        return null;
    }
}
