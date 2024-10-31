package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import java.util.HashMap;

/* compiled from: AdobeLibraryItemMoveExtraConfiguration.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a */
    private HashMap<String, Object> f6252a = new HashMap<>();

    public void a(boolean z) {
        this.f6252a.put("CREATE_MOVE_BUTTON", Boolean.valueOf(z));
    }

    public void b(boolean z) {
        this.f6252a.put("SHOULD_SHOW_ONLY_COLLECTIONS", Boolean.valueOf(z));
    }

    public boolean a() {
        return this.f6252a.containsKey("CREATE_MOVE_BUTTON") && ((Boolean) this.f6252a.get("CREATE_MOVE_BUTTON")).booleanValue();
    }
}
