package com.nexstreaming.kinemaster.kmpackage;

/* loaded from: classes.dex */
public interface OnFontChangeListener {

    /* loaded from: classes.dex */
    public enum FontEvent {
        SERVER_UPDATE,
        LOCAL_UPDATE,
        INSTALL,
        UNINSTALL
    }

    void a(FontEvent fontEvent);
}
