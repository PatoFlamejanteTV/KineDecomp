package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public final class Fl implements zzpm<Long> {
    private Fl() {
    }

    private static Long a(Uri uri, InputStream inputStream) throws IOException {
        String readLine = new BufferedReader(new InputStreamReader(inputStream)).readLine();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return Long.valueOf(simpleDateFormat.parse(readLine).getTime());
        } catch (ParseException e2) {
            throw new zzfx(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpm
    public final /* synthetic */ Long zzb(Uri uri, InputStream inputStream) throws IOException {
        return a(uri, inputStream);
    }

    public /* synthetic */ Fl(Cl cl) {
        this();
    }
}
