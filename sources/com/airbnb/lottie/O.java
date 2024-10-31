package com.airbnb.lottie;

import android.content.res.Resources;
import com.airbnb.lottie.C0657ka;
import java.io.InputStream;

/* compiled from: FileCompositionLoader.java */
/* loaded from: classes.dex */
public final class O extends I<InputStream> {

    /* renamed from: a */
    private final Resources f7667a;

    /* renamed from: b */
    private final InterfaceC0682xa f7668b;

    public O(Resources resources, InterfaceC0682xa interfaceC0682xa) {
        this.f7667a = resources;
        this.f7668b = interfaceC0682xa;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public C0657ka doInBackground(InputStream... inputStreamArr) {
        return C0657ka.a.a(this.f7667a, inputStreamArr[0]);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(C0657ka c0657ka) {
        this.f7668b.a(c0657ka);
    }
}
