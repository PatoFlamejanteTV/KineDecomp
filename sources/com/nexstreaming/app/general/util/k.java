package com.nexstreaming.app.general.util;

import android.os.AsyncTask;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: TextLoader.java */
/* loaded from: classes2.dex */
class K extends AsyncTask<Void, Void, String> {

    /* renamed from: a */
    final /* synthetic */ InputStream f19834a;

    /* renamed from: b */
    final /* synthetic */ WeakReference f19835b;

    public K(InputStream inputStream, WeakReference weakReference) {
        this.f19834a = inputStream;
        this.f19835b = weakReference;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Void... voidArr) {
        StringBuilder sb = new StringBuilder();
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                int read = this.f19834a.read(bArr);
                if (read <= 0) {
                    break;
                }
                sb.append(new String(bArr, 0, read));
            } catch (IOException unused) {
            }
        }
        return sb.toString();
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        TextView textView = (TextView) this.f19835b.get();
        if (textView == null || textView.getParent() == null) {
            return;
        }
        textView.setText(str);
    }
}
