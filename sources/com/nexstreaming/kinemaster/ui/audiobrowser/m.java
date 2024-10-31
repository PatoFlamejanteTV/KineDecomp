package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.content.Context;
import com.nexstreaming.app.general.task.ResultTask;
import java.util.List;

/* compiled from: AudioLister.java */
/* loaded from: classes.dex */
public interface m {
    ResultTask<List<l>> a(Context context);

    ResultTask<List<n>> a(Context context, long j);

    boolean a();
}
