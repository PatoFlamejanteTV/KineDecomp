package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public interface ChannelApi {

    /* loaded from: classes.dex */
    public interface ChannelListener {
        void a(Channel channel);

        void a(Channel channel, int i, int i2);

        void b(Channel channel, int i, int i2);

        void c(Channel channel, int i, int i2);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface CloseReason {
    }

    /* loaded from: classes.dex */
    public interface OpenChannelResult extends Result {
    }
}
