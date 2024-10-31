package com.nexstreaming.sdk2.nexsns;

import android.graphics.Bitmap;
import com.google.api.services.drive.model.File;
import com.nexstreaming.app.general.task.ResultTask;
import java.util.List;

/* compiled from: CloudService.java */
/* loaded from: classes.dex */
public interface a {
    ResultTask<List<File>> a(String str);

    ResultTask<Bitmap> a(String str, String str2);

    ResultTask<java.io.File> a(String str, String str2, String str3);

    ResultTask<File> b(String str);
}
