package com.nexstreaming.kinemaster.integration.fcpxml.adapter.items;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.nextreaming.nexeditorui.NexTimeline;

/* loaded from: classes.dex */
public class SourceItem implements Cloneable {

    /* renamed from: a */
    public String f20474a;

    /* renamed from: b */
    public int f20475b;

    /* renamed from: c */
    public int f20476c;

    /* renamed from: d */
    public int f20477d;

    /* renamed from: e */
    public int f20478e;

    /* renamed from: f */
    public int f20479f;

    /* renamed from: g */
    public int f20480g;

    /* renamed from: h */
    public int f20481h;
    public ItemType i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public double n;
    public OutputChannel o;
    public int p;
    public b q;

    /* loaded from: classes.dex */
    public enum Alignment {
        NONE(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE),
        START("start"),
        CENTER("center"),
        END("end"),
        END_BLACK("end-black"),
        START_BLACK("start-black");

        private String alignment;

        Alignment(String str) {
            this.alignment = str;
        }

        public String getAlignment() {
            return this.alignment;
        }
    }

    /* loaded from: classes.dex */
    public enum AlphaType {
        none,
        straight,
        black,
        white
    }

    /* loaded from: classes.dex */
    public enum DisplayFormat {
        DF,
        NDF
    }

    /* loaded from: classes.dex */
    public enum ItemType {
        VISUAL,
        SOUNDTRACK,
        EFFECT,
        TRANSITION
    }

    /* loaded from: classes.dex */
    public enum MediaType {
        IMAGE(MessengerShareContentUtility.MEDIA_IMAGE),
        SOLID("solid"),
        BGIMAGE("bgimage"),
        VIDEO("video"),
        AUDIO("audio");

        private String type;

        MediaType(String str) {
            this.type = str;
        }

        public String getMediaType() {
            return this.type;
        }
    }

    /* loaded from: classes.dex */
    public enum OutputChannel {
        LEFT,
        RIGHT
    }

    /* loaded from: classes.dex */
    public enum PixelAspectRatio {
        square
    }

    protected Object clone() throws CloneNotSupportedException {
        SourceItem sourceItem = new SourceItem();
        sourceItem.f20474a = this.f20474a;
        sourceItem.f20475b = this.f20475b;
        sourceItem.f20476c = this.f20476c;
        sourceItem.f20477d = this.f20477d;
        sourceItem.f20478e = this.f20478e;
        sourceItem.f20479f = this.f20479f;
        sourceItem.f20480g = this.f20480g;
        sourceItem.f20481h = this.f20481h;
        sourceItem.i = this.i;
        sourceItem.j = this.j;
        sourceItem.k = this.k;
        sourceItem.l = this.l;
        sourceItem.m = this.m;
        sourceItem.n = this.n;
        sourceItem.o = this.o;
        sourceItem.p = this.p;
        sourceItem.q = this.q;
        return sourceItem;
    }
}
