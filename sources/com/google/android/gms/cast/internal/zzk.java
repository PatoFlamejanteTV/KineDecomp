package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public final class zzk {

    /* renamed from: a, reason: collision with root package name */
    public static final Api.zzc<zze> f856a = new Api.zzc<>();
    public static final Charset b;

    static {
        Charset charset = null;
        try {
            charset = Charset.forName(Keyczar.DEFAULT_ENCODING);
        } catch (IllegalCharsetNameException e) {
        } catch (UnsupportedCharsetException e2) {
        }
        b = charset;
    }
}
