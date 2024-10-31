package com.nexstreaming.app.general.util;

import android.os.AsyncTask;
import android.widget.TextView;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: TextLoader.java */
/* loaded from: classes.dex */
final class x extends AsyncTask<Void, Void, String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InputStream f3243a;
    final /* synthetic */ WeakReference b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(InputStream inputStream, WeakReference weakReference) {
        this.f3243a = inputStream;
        this.b = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Void... voidArr) {
        StringBuilder sb = new StringBuilder();
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        while (true) {
            try {
                int read = this.f3243a.read(bArr);
                if (read <= 0) {
                    break;
                }
                sb.append(new String(bArr, 0, read));
            } catch (IOException e) {
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        TextView textView = (TextView) this.b.get();
        if (textView != null && textView.getParent() != null) {
            textView.setText(str);
        }
    }
}
