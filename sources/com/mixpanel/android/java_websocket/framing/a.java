package com.mixpanel.android.java_websocket.framing;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidFrameException;

/* compiled from: CloseFrame.java */
/* loaded from: classes.dex */
public interface a extends Framedata {
    int a() throws InvalidFrameException;

    String b() throws InvalidDataException;
}
