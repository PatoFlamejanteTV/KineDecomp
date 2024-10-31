package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import java.util.HashMap;

/* compiled from: AdobeAssetViewEditFragmentExtraConfiguration.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.h */
/* loaded from: classes.dex */
public class C0390h {

    /* renamed from: a */
    private HashMap<String, Object> f6042a = new HashMap<>();

    public void a(boolean z) {
        this.f6042a.put("CREATE_MOVE_BUTTON", Boolean.valueOf(z));
    }

    public void b(boolean z) {
        this.f6042a.put("SHOULD_SHOW_ONLY_FOLDERS", Boolean.valueOf(z));
    }

    public boolean c() {
        return this.f6042a.containsKey("SHOULD_SHOW_CREATE_NEW_FOLDER") && ((Boolean) this.f6042a.get("SHOULD_SHOW_CREATE_NEW_FOLDER")).booleanValue();
    }

    public boolean d() {
        return this.f6042a.containsKey("SHOULD_SHOW_ONLY_FOLDERS") && ((Boolean) this.f6042a.get("SHOULD_SHOW_ONLY_FOLDERS")).booleanValue();
    }

    public boolean a() {
        return this.f6042a.containsKey("CREATE_MOVE_BUTTON") && ((Boolean) this.f6042a.get("CREATE_MOVE_BUTTON")).booleanValue();
    }

    public String b() {
        return (String) this.f6042a.get("TITLE_FOR_MAIN_VIEW");
    }

    public void a(String str) {
        this.f6042a.put("TITLE_FOR_MAIN_VIEW", str);
    }
}
