package com.mixpanel.android.util;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.mixpanel.android.mpmetrics.m;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class ImageStore {

    /* renamed from: a, reason: collision with root package name */
    private final File f3073a;
    private final RemoteService b;
    private final MessageDigest c;
    private final m d;

    /* loaded from: classes.dex */
    public static class CantGetImageException extends Exception {
        public CantGetImageException(String str) {
            super(str);
        }

        public CantGetImageException(String str, Throwable th) {
            super(str, th);
        }
    }

    public ImageStore(Context context, String str) {
        this(context, "MixpanelAPI.Images." + str, new c());
    }

    public ImageStore(Context context, String str, RemoteService remoteService) {
        MessageDigest messageDigest;
        this.f3073a = context.getDir(str, 0);
        this.b = remoteService;
        this.d = m.a(context);
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            Log.w("MixpanelAPI.ImageStore", "Images won't be stored because this platform doesn't supply a SHA1 hash function");
            messageDigest = null;
        }
        this.c = messageDigest;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap a(java.lang.String r7) throws com.mixpanel.android.util.ImageStore.CantGetImageException {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.util.ImageStore.a(java.lang.String):android.graphics.Bitmap");
    }

    public void b(String str) {
        File c = c(str);
        if (c != null) {
            c.delete();
        }
    }

    private File c(String str) {
        if (this.c == null) {
            return null;
        }
        return new File(this.f3073a, "MP_IMG_" + Base64.encodeToString(this.c.digest(str.getBytes()), 10));
    }
}
