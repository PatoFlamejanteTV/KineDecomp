package com.nexstreaming.kinemaster.integration.kmxml.adapter.effect;

import android.graphics.Rect;

/* loaded from: classes.dex */
public class CropEffect extends Effect {

    /* renamed from: b */
    CropValue f20546b;

    /* renamed from: c */
    Rect f20547c;

    /* renamed from: d */
    float f20548d;

    /* renamed from: e */
    float f20549e;

    /* loaded from: classes.dex */
    public enum CropValue {
        OFF("off"),
        FIT("fit"),
        FILL("fill");

        private String value;

        CropValue(String str) {
            this.value = str;
        }

        public String getName() {
            return this.value;
        }
    }

    public Rect a() {
        return this.f20547c;
    }

    public float b() {
        return this.f20548d;
    }

    public float c() {
        return this.f20549e;
    }

    public CropValue d() {
        return this.f20546b;
    }
}
