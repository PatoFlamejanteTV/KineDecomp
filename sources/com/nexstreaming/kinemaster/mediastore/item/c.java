package com.nexstreaming.kinemaster.mediastore.item;

import android.os.Bundle;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import java.util.Date;

/* compiled from: MediaStoreItem.kt */
/* loaded from: classes.dex */
public interface c {
    long a();

    Bundle a(Class<?> cls);

    int b();

    String c();

    Date d();

    ResultTask<MediaSupportType> e();

    boolean f();

    MediaSupportType g();

    int getDuration();

    int getHeight();

    MediaStoreItemId getId();

    String getNamespace();

    int getOrientation();

    String getPath();

    MediaItemType getType();

    int getWidth();

    boolean h();
}
