package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.storage.StreamDownloadTask;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class d implements StreamDownloadTask.StreamProcessor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f18139a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f18140b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ StorageReference f18141c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StorageReference storageReference, long j, TaskCompletionSource taskCompletionSource) {
        this.f18141c = storageReference;
        this.f18139a = j;
        this.f18140b = taskCompletionSource;
    }

    @Override // com.google.firebase.storage.StreamDownloadTask.StreamProcessor
    @PublicApi
    public void a(StreamDownloadTask.TaskSnapshot taskSnapshot, InputStream inputStream) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[16384];
            int i = 0;
            while (true) {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    this.f18140b.a((TaskCompletionSource) byteArrayOutputStream.toByteArray());
                    return;
                } else {
                    i += read;
                    if (i <= this.f18139a) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        Log.e("StorageReference", "the maximum allowed buffer size was exceeded.");
                        throw new IndexOutOfBoundsException("the maximum allowed buffer size was exceeded.");
                    }
                }
            }
        } finally {
            inputStream.close();
        }
    }
}
