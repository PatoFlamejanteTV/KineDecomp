package com.nexstreaming.kinemaster.integration.kmxml.adapter.items;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class SourceItem {

    /* renamed from: a */
    ItemType f20569a;

    /* renamed from: b */
    float f20570b;

    /* renamed from: c */
    ArrayList<Effect> f20571c = new ArrayList<>();

    /* loaded from: classes.dex */
    public enum ItemType {
        IMAGE(MessengerShareContentUtility.MEDIA_IMAGE),
        SOLID("solid"),
        VIDEO("video"),
        AUDIO("audio"),
        TRANSITION("transition"),
        LAYER("layer");

        private String type;

        ItemType(String str) {
            this.type = str;
        }

        public String getName() {
            return this.type;
        }
    }

    public SourceItem(ItemType itemType, float f2) {
        this.f20569a = itemType;
        this.f20570b = f2;
    }

    public float a() {
        return this.f20570b;
    }

    public ArrayList<Effect> b() {
        return this.f20571c;
    }

    public void a(Effect effect) {
        this.f20571c.add(effect);
    }
}
