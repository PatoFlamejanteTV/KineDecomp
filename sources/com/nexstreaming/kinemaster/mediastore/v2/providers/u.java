package com.nexstreaming.kinemaster.mediastore.v2.providers;

import android.os.Bundle;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.RemoteMediaInfo;
import com.nexstreaming.kinemaster.mediastore.v2.a;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
public final class u implements a.b {
    @Override // com.nexstreaming.kinemaster.mediastore.v2.a.b
    public ResultTask<MediaStoreItem.MediaSupportType> a(com.nexstreaming.kinemaster.mediastore.v2.a aVar) {
        ResultTask<MediaStoreItem.MediaSupportType> resultTask = new ResultTask<>();
        if (!aVar.n()) {
            resultTask.sendResult(aVar.p());
        } else {
            Bundle a2 = aVar.a(l.class);
            RemoteMediaInfo.a(a2.getString("downloadUrl"), (Map<String, String>) Collections.singletonMap("Authorization", "Bearer " + a2.getString("oAuthToken"))).onResultAvailable(new w(this, aVar, resultTask)).onFailure((Task.OnFailListener) new v(this, aVar, resultTask));
        }
        return resultTask;
    }
}
