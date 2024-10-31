package com.nexstreaming.kinemaster.usage.analytics;

import com.nexstreaming.kinemaster.ui.audiobrowser.AudioCategory;
import com.nexstreaming.kinemaster.ui.audiobrowser.u;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.util.HashMap;
import kotlin.jvm.internal.PropertyReference0Impl;

/* compiled from: GeneralEventMaker.kt */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.g[] f23913a;

    static {
        PropertyReference0Impl propertyReference0Impl = new PropertyReference0Impl(kotlin.jvm.internal.j.a(f.class, "KineMaster_googlePlayRelease"), "type", "<v#0>");
        kotlin.jvm.internal.j.a(propertyReference0Impl);
        PropertyReference0Impl propertyReference0Impl2 = new PropertyReference0Impl(kotlin.jvm.internal.j.a(f.class, "KineMaster_googlePlayRelease"), "name", "<v#1>");
        kotlin.jvm.internal.j.a(propertyReference0Impl2);
        f23913a = new kotlin.reflect.g[]{propertyReference0Impl, propertyReference0Impl2};
    }

    public static final void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("turn", EditorGlobal.w() ? "on" : "off");
        KMEvents.UNLIMITED_LAYERS_ENABLE.logEvent(hashMap);
    }

    public static final void a(final AudioCategory audioCategory, final u uVar) {
        kotlin.jvm.internal.h.b(audioCategory, "category");
        kotlin.jvm.internal.h.b(uVar, "trackInfo");
        HashMap hashMap = new HashMap();
        kotlin.d a2 = kotlin.e.a(new kotlin.jvm.a.a<String>() { // from class: com.nexstreaming.kinemaster.usage.analytics.GeneralEventMakerKt$trackAddAudioEvent$type$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            public final String invoke() {
                int i = e.f23911a[AudioCategory.this.ordinal()];
                return i != 1 ? i != 2 ? "AudioLocal" : "Sound Effect" : "Audio";
            }
        });
        kotlin.reflect.g gVar = f23913a[0];
        kotlin.d a3 = kotlin.e.a(new kotlin.jvm.a.a<String>() { // from class: com.nexstreaming.kinemaster.usage.analytics.GeneralEventMakerKt$trackAddAudioEvent$name$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            public final String invoke() {
                int i = e.f23912b[AudioCategory.this.ordinal()];
                return (i == 1 || i == 2) ? uVar.b() : "Local";
            }
        });
        kotlin.reflect.g gVar2 = f23913a[1];
        com.nexstreaming.app.general.nexasset.assetpackage.b a4 = uVar.a();
        if (a4 != null) {
            hashMap.put("asset_id", String.valueOf(a4.getAssetIdx()));
        }
        hashMap.put("type", (String) a2.getValue());
        hashMap.put("name", (String) a3.getValue());
        hashMap.put("result", "Success");
        KMEvents.EDIT_ADD_AUDIO.logEvent(hashMap);
    }

    public static final void a(String str) {
        kotlin.jvm.internal.h.b(str, "type");
        HashMap hashMap = new HashMap();
        hashMap.put("button", str);
        KMEvents.SUBSCRIPTION_CLICK_BUTTON.logEvent(hashMap);
    }
}
