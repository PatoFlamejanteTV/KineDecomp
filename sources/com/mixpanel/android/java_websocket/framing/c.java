package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import java.nio.ByteBuffer;

/* compiled from: FrameBuilder.java */
/* loaded from: classes.dex */
public interface c extends Framedata {
    void a(Framedata.Opcode opcode);

    void a(ByteBuffer byteBuffer) throws InvalidDataException;

    void a(boolean z);
}
