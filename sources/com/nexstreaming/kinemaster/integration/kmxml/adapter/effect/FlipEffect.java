package com.nexstreaming.kinemaster.integration.kmxml.adapter.effect;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;

/* loaded from: classes.dex */
public class FlipEffect extends Effect {

    /* renamed from: b */
    FlipType f20553b;

    /* loaded from: classes.dex */
    public enum FlipType {
        HORIZONTAL(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL),
        VERTICAL("vertical"),
        BOTH("both");

        private String type;

        FlipType(String str) {
            this.type = str;
        }

        public String getName() {
            return this.type;
        }
    }

    public FlipEffect(FlipType flipType) {
        super(Effect.EffectType.FLIP);
        this.f20553b = flipType;
    }

    public FlipType a() {
        return this.f20553b;
    }
}
