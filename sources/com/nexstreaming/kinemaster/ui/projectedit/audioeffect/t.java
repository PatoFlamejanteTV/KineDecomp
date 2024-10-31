package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import android.content.Context;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.z;
import kotlin.jvm.internal.PropertyReference1Impl;

/* compiled from: AudioEffectRepository.kt */
/* loaded from: classes2.dex */
public final class t implements h {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.g[] f22264a;

    /* renamed from: b, reason: collision with root package name */
    private final String f22265b = "audio_effect/";

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.d f22266c;

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(kotlin.jvm.internal.j.a(t.class), "effectMap", "getEffectMap()Ljava/util/Map;");
        kotlin.jvm.internal.j.a(propertyReference1Impl);
        f22264a = new kotlin.reflect.g[]{propertyReference1Impl};
    }

    public t() {
        kotlin.d a2;
        a2 = kotlin.f.a(new kotlin.jvm.a.a<Map<String, ? extends b>>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioEffectRepository$effectMap$2
            @Override // kotlin.jvm.a.a
            public final Map<String, ? extends b> invoke() {
                Map<String, ? extends b> a3;
                a3 = z.a(new Pair("Robot", new b(R.string.audio_voice_changer_robot, "Robot", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Deep", new b(R.string.audio_voice_changer_deep, "Deep", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Modulation", new b(R.string.audio_voice_changer_modulation, "Modulation", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("2_pitched_1", new b(R.string.audio_voice_changer_2pitched_1, "2_pitched_1", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Alien1", new b(R.string.audio_voice_changer_alien_1, "Alien1", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Chipmunk", new b(R.string.audio_voice_changer_chipmunk, "Chipmunk", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Chorus", new b(R.string.audio_voice_changer_chorus, "Chorus", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Confusion", new b(R.string.audio_voice_changer_confusion, "Confusion", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Death_Metal_1", new b(R.string.audio_voice_changer_deathmetal_1, "Death_Metal_1", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Echo_Extreme_1", new b(R.string.audio_voice_changer_echoextreme_1, "Echo_Extreme_1", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("DistFlanger_1", new b(R.string.audio_voice_changer_distflanger_1, "DistFlanger_1", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("FeedChoTrm_1", new b(R.string.audio_voice_changer_feedchotrm_1, "FeedChoTrm_1", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Funny_Pitch_1", new b(R.string.audio_voice_changer_funnypitch_1, "Funny_Pitch_1", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Kid", new b(R.string.audio_voice_changer_kid, "Kid", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Man", new b(R.string.audio_voice_changer_man, "Man", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Radio", new b(R.string.audio_voice_changer_radio, "Radio", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Robot_1", new b(R.string.audio_voice_changer_robot_1, "Robot_1", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Space_1_1", new b(R.string.audio_voice_changer_space1_1, "Space_1_1", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Two_Vox_1", new b(R.string.audio_voice_changer_twovox_1, "Two_Vox_1", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("Woman", new b(R.string.audio_voice_changer_woman, "Woman", AudioEffectType.VOICE_CHANGER, IABManager.BillingType.FREE)), new Pair("AM_Radio", new b(R.string.audio_eq_amradio, "AM_Radio", AudioEffectType.EQ, IABManager.BillingType.FREE)), new Pair("Bass_booster", new b(R.string.audio_eq_bassbooster, "Bass_booster", AudioEffectType.EQ, IABManager.BillingType.FREE)), new Pair("Bass_reducer", new b(R.string.audio_eq_bassreducer, "Bass_reducer", AudioEffectType.EQ, IABManager.BillingType.FREE)), new Pair("Treble_booster", new b(R.string.audio_eq_treblebooster, "Treble_booster", AudioEffectType.EQ, IABManager.BillingType.FREE)), new Pair("Treble_reducer", new b(R.string.audio_eq_treblereducer, "Treble_reducer", AudioEffectType.EQ, IABManager.BillingType.FREE)), new Pair("Hip-Hop", new b(R.string.audio_eq_hiphop, "Hip-Hop", AudioEffectType.EQ, IABManager.BillingType.FREE)), new Pair("Jazz", new b(R.string.audio_eq_jazz, "Jazz", AudioEffectType.EQ, IABManager.BillingType.FREE)), new Pair("Natural", new b(R.string.audio_eq_natural, "Natural", AudioEffectType.EQ, IABManager.BillingType.FREE)), new Pair("Pop", new b(R.string.audio_eq_pop, "Pop", AudioEffectType.EQ, IABManager.BillingType.FREE)), new Pair("RnB", new b(R.string.audio_eq_rb, "RnB", AudioEffectType.EQ, IABManager.BillingType.FREE)), new Pair("Rock", new b(R.string.audio_eq_rock, "Rock", AudioEffectType.EQ, IABManager.BillingType.FREE)), new Pair("Voice", new b(R.string.audio_eq_voice, "Voice", AudioEffectType.EQ, IABManager.BillingType.FREE)));
                return a3;
            }
        });
        this.f22266c = a2;
    }

    private final Map<String, b> a() {
        kotlin.d dVar = this.f22266c;
        kotlin.reflect.g gVar = f22264a[0];
        return (Map) dVar.getValue();
    }

    public final String a(int i) {
        b a2;
        if (i < 0 || i > 4) {
            return b.f22223b.a().f();
        }
        if (i == 0) {
            a2 = b.f22223b.a();
        } else if (i == 1) {
            a2 = a().get("Chipmunk");
        } else if (i == 2) {
            a2 = a().get("Robot");
        } else if (i == 3) {
            a2 = a().get("Deep");
        } else if (i != 4) {
            a2 = b.f22223b.a();
        } else {
            a2 = a().get("Modulation");
        }
        if (a2 != null) {
            return a2.f();
        }
        return null;
    }

    public String b(String str) {
        Context applicationContext = KineMasterApplication.f24058f.c().getApplicationContext();
        b a2 = a(str);
        AudioEffectType e2 = a2.e();
        int i = s.f22262a[e2.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        String f2 = a2.f();
        if (f2 == null) {
            return null;
        }
        kotlin.jvm.internal.h.a((Object) applicationContext, com.umeng.analytics.pro.b.Q);
        InputStream open = applicationContext.getAssets().open(this.f22265b + e2.getPath() + '/' + f2 + ".json");
        byte[] bArr = new byte[open.available()];
        open.read(bArr);
        open.close();
        Charset defaultCharset = Charset.defaultCharset();
        kotlin.jvm.internal.h.a((Object) defaultCharset, "Charset.defaultCharset()");
        return new String(bArr, defaultCharset);
    }

    public b a(String str) {
        b bVar = a().get(str);
        return bVar != null ? bVar : b.f22223b.a();
    }

    public ArrayList<b> a(AudioViewType audioViewType) {
        ArrayList<b> arrayList;
        kotlin.jvm.internal.h.b(audioViewType, "type");
        int i = s.f22263b[audioViewType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            Collection<b> values = a().values();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : values) {
                if (((b) obj).e() == AudioEffectType.EQ) {
                    arrayList2.add(obj);
                }
            }
            arrayList = new ArrayList<>(arrayList2);
        } else {
            Collection<b> values2 = a().values();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : values2) {
                if (((b) obj2).e() == AudioEffectType.VOICE_CHANGER) {
                    arrayList3.add(obj2);
                }
            }
            arrayList = new ArrayList<>(arrayList3);
        }
        arrayList.add(0, b.f22223b.a());
        return arrayList;
    }
}
