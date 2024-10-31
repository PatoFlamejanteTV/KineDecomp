package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.storage.internal.SlashUtil;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class StorageReference {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f18100a;

    /* renamed from: b, reason: collision with root package name */
    private final FirebaseStorage f18101b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StorageReference(Uri uri, FirebaseStorage firebaseStorage) {
        Preconditions.a(uri != null, "storageUri cannot be null");
        Preconditions.a(firebaseStorage != null, "FirebaseApp cannot be null");
        this.f18100a = uri;
        this.f18101b = firebaseStorage;
    }

    @PublicApi
    public StorageReference a(String str) {
        Preconditions.a(!TextUtils.isEmpty(str), "childName cannot be null or empty");
        String a2 = SlashUtil.a(str);
        try {
            return new StorageReference(this.f18100a.buildUpon().appendEncodedPath(SlashUtil.b(a2)).build(), this.f18101b);
        } catch (UnsupportedEncodingException e2) {
            Log.e("StorageReference", "Unable to create a valid default Uri. " + a2, e2);
            throw new IllegalArgumentException("childName");
        }
    }

    @PublicApi
    public StorageReference b() {
        String path = this.f18100a.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        if (path.equals("/")) {
            return null;
        }
        int lastIndexOf = path.lastIndexOf(47);
        return new StorageReference(this.f18100a.buildUpon().path(lastIndexOf != -1 ? path.substring(0, lastIndexOf) : "/").build(), this.f18101b);
    }

    @PublicApi
    public FirebaseStorage c() {
        return this.f18101b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Uri d() {
        return this.f18100a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof StorageReference) {
            return ((StorageReference) obj).toString().equals(toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return "gs://" + this.f18100a.getAuthority() + this.f18100a.getEncodedPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseApp a() {
        return c().a();
    }

    @PublicApi
    public UploadTask a(byte[] bArr) {
        Preconditions.a(bArr != null, "bytes cannot be null");
        UploadTask uploadTask = new UploadTask(this, null, bArr);
        uploadTask.q();
        return uploadTask;
    }

    @PublicApi
    public Task<byte[]> a(long j) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.a(new d(this, j, taskCompletionSource)).a((OnSuccessListener) new c(this, taskCompletionSource)).a((OnFailureListener) new b(this, taskCompletionSource));
        streamDownloadTask.q();
        return taskCompletionSource.a();
    }
}
