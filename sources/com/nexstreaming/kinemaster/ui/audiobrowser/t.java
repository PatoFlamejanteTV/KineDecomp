package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.content.Context;
import com.nexstreaming.app.general.task.ResultTask;
import java.util.List;

/* compiled from: AudioLister.kt */
/* loaded from: classes.dex */
public interface t {
    ResultTask<List<s>> a(Context context);

    ResultTask<List<u>> a(Context context, long j);

    boolean a();
}
