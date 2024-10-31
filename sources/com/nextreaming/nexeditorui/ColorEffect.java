package com.nextreaming.nexeditorui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.wire.KMProto;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ColorEffect implements Serializable {
    private static final long serialVersionUID = 1;
    private transient ColorMatrix b;
    private Bitmap bitmap_;
    private final float brightness;
    private final float contrast;
    private final int icon_resource_id_;
    private boolean lut_enabled_;
    private int lut_resource_id_;
    private final String presetName;
    private final float saturation;
    private final int tintColor;
    public static final ColorEffect NONE = new ColorEffect("NONE", 0.0f, 0.0f, 0.0f, 0);
    public static final ColorEffect ALIEN_INVASION = new ColorEffect("ALIEN_INVASION", 0.12f, -0.06f, -0.3f, -15437804);
    public static final ColorEffect BLACK_AND_WHITE = new ColorEffect("BLACK_AND_WHITE", 0.0f, 0.0f, -1.0f, -1);
    public static final ColorEffect COOL = new ColorEffect("COOL", 0.12f, -0.12f, -0.3f, -15449488);
    public static final ColorEffect DEEP_BLUE = new ColorEffect("DEEP_BLUE", -0.2f, -0.3f, -0.6f, -16763905);
    public static final ColorEffect PINK = new ColorEffect("PINK", 0.1f, -0.3f, -0.6f, -6533297);
    public static final ColorEffect RED_ALERT = new ColorEffect("RED_ALERT", -0.3f, -0.19f, -1.0f, -65536);
    public static final ColorEffect SEPIA = new ColorEffect("SEPIA", 0.12f, -0.12f, -0.3f, -9420268);
    public static final ColorEffect SUNNY = new ColorEffect("SUNNY", 0.08f, -0.06f, -0.3f, -3364267);
    public static final ColorEffect PURPLE = new ColorEffect("PURPLE", 0.08f, -0.06f, -0.3f, -5614132);
    public static final ColorEffect ORANGE = new ColorEffect("ORANGE", 0.08f, -0.06f, -0.35f, -17664);
    public static final ColorEffect STRONG_ORANGE = new ColorEffect("STRONG_ORANGE", 0.08f, -0.06f, -0.5f, -17664);
    public static final ColorEffect SPRING = new ColorEffect("SPRING", 0.08f, -0.06f, -0.3f, -5583787);
    public static final ColorEffect SUMMER = new ColorEffect("SUMMER", 0.08f, -0.06f, -0.5f, -5570816);
    public static final ColorEffect FALL = new ColorEffect("FALL", 0.08f, -0.06f, -0.5f, -16711766);
    public static final ColorEffect ROUGE = new ColorEffect("ROUGE", 0.08f, -0.06f, -0.6f, -43691);
    public static final ColorEffect PASTEL = new ColorEffect("PASTEL", 0.08f, -0.06f, -0.5f, -11184811);
    public static final ColorEffect NOIR = new ColorEffect("NOIR", -0.25f, 0.6f, -1.0f, -8952235);
    public static final ColorEffect LUT_BLUE = new ColorEffect("LUT_BLUE", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_blue, R.drawable.lut_blue);
    public static final ColorEffect LUT_LUDWIG = new ColorEffect("LUT_LUDWIG", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_ludwig, R.drawable.lut_ludwig);
    public static final ColorEffect LUT_OLDFILM = new ColorEffect("LUT_OLDFILM", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_oldfilm, R.drawable.lut_oldfilm);
    public static final ColorEffect LUT_ROSY = new ColorEffect("LUT_ROSY", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_rosy, R.drawable.lut_rosy);
    public static final ColorEffect LUT_SUNSET = new ColorEffect("LUT_SUNSET", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_sunset, R.drawable.lut_sunset);
    public static final ColorEffect LUT_SWEET = new ColorEffect("LUT_SWEET", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_sweet, R.drawable.lut_sweet);
    public static final ColorEffect LUT_SALMON_TEAL = new ColorEffect("LUT_SALMON_TEAL", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_salmon_teal, R.drawable.lut_salmon_teal);
    public static final ColorEffect LUT_HEAT = new ColorEffect("LUT_HEAT", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_heat, R.drawable.lut_heat);
    public static final ColorEffect LUT_BLUEONLY = new ColorEffect("LUT_BLUEONLY", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_blueonly, R.drawable.lut_blueonly);
    public static final ColorEffect LUT_NEGATIVE = new ColorEffect("LUT_NEGATIVE", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_negative, R.drawable.lut_negative);
    public static final ColorEffect LUT_SUNPRINT = new ColorEffect("LUT_SUNPRINT", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_sunprint, R.drawable.lut_sunprint);
    public static final ColorEffect LUT_SHERBERT = new ColorEffect("LUT_SHERBERT", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_sherbert, R.drawable.lut_sherbert);
    public static final ColorEffect LUT_AFTERNOON = new ColorEffect("LUT_AFTERNOON", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_afternoon, R.drawable.lut_afternoon);
    public static final ColorEffect LUT_DAISY = new ColorEffect("LUT_DAISY", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_daisy, R.drawable.lut_daisy);
    public static final ColorEffect LUT_DBRIGHT = new ColorEffect("LUT_DBRIGHT", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_dbright, R.drawable.lut_dbright);
    public static final ColorEffect LUT_BORING = new ColorEffect("LUT_BORING", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_boring, R.drawable.lut_boring);
    public static final ColorEffect LUT_ALMOND_BLOSSOM = new ColorEffect("LUT_ALMOND_BLOSSOM", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_almond_blossom, R.drawable.lut_almond_blossom);
    public static final ColorEffect LUT_MOONLIGHT = new ColorEffect("LUT_MOONLIGHT", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_moonlight, R.drawable.lut_moonlight);
    public static final ColorEffect LUT_CINNAMON = new ColorEffect("LUT_CINNAMON", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_cinnamon, R.drawable.lut_cinnamon);
    public static final ColorEffect LUT_RAINY = new ColorEffect("LUT_RAINY", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_rainy, R.drawable.lut_rainy);
    public static final ColorEffect LUT_CLOUD = new ColorEffect("LUT_CLOUD", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_cloud, R.drawable.lut_cloud);

    /* renamed from: a, reason: collision with root package name */
    private static final ColorEffect[] f4463a = {NONE, BLACK_AND_WHITE, LUT_BLUE, LUT_LUDWIG, LUT_OLDFILM, LUT_ROSY, LUT_SUNSET, LUT_SWEET, LUT_SALMON_TEAL, LUT_HEAT, LUT_BLUEONLY, LUT_NEGATIVE, LUT_SUNPRINT, LUT_SHERBERT, LUT_AFTERNOON, LUT_DAISY, LUT_DBRIGHT, LUT_BORING, LUT_ALMOND_BLOSSOM, LUT_MOONLIGHT, LUT_CINNAMON, LUT_RAINY, LUT_CLOUD, ALIEN_INVASION, COOL, DEEP_BLUE, PINK, RED_ALERT, SEPIA, SUNNY, PURPLE, ORANGE, STRONG_ORANGE, SPRING, SUMMER, FALL, ROUGE, PASTEL, NOIR};
    private static Bitmap c = null;

    public static List<ColorEffect> getPresetList() {
        return Arrays.asList(f4463a);
    }

    public static ColorEffect[] values() {
        return f4463a;
    }

    public static ColorEffect fromPresetName(String str) {
        for (ColorEffect colorEffect : f4463a) {
            if (colorEffect.presetName.equals(str)) {
                return colorEffect;
            }
        }
        return null;
    }

    private ColorEffect(String str, float f, float f2, float f3, int i) {
        this.lut_enabled_ = false;
        this.lut_resource_id_ = 0;
        this.bitmap_ = null;
        this.brightness = f;
        this.contrast = f2;
        this.saturation = f3;
        this.tintColor = i;
        this.presetName = str;
        this.lut_enabled_ = false;
        this.bitmap_ = null;
        this.icon_resource_id_ = 0;
    }

    public ColorEffect(float f, float f2, float f3, int i) {
        this.lut_enabled_ = false;
        this.lut_resource_id_ = 0;
        this.bitmap_ = null;
        this.brightness = f;
        this.contrast = f2;
        this.saturation = f3;
        this.tintColor = i;
        this.presetName = null;
        this.lut_enabled_ = false;
        this.bitmap_ = null;
        this.icon_resource_id_ = 0;
    }

    public ColorEffect(String str, float f, float f2, float f3, int i, int i2, int i3) {
        this.lut_enabled_ = false;
        this.lut_resource_id_ = 0;
        this.bitmap_ = null;
        this.brightness = f;
        this.contrast = f2;
        this.saturation = f3;
        this.tintColor = i;
        this.presetName = str;
        this.lut_enabled_ = true;
        this.lut_resource_id_ = i2;
        this.icon_resource_id_ = i3;
        this.bitmap_ = null;
    }

    public ColorMatrix getColorMatrix() {
        if (this.b == null) {
            this.b = com.nexstreaming.app.general.c.a.a(this.brightness, this.contrast, this.saturation, this.tintColor);
        }
        return this.b;
    }

    public int getLutResourceID() {
        return this.lut_resource_id_;
    }

    public Bitmap getLut() {
        if (this.lut_enabled_ && this.bitmap_ == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            this.bitmap_ = BitmapFactory.decodeResource(KineMasterApplication.a().getResources(), this.lut_resource_id_, options);
        }
        return this.bitmap_;
    }

    public String getPresetName() {
        return this.presetName;
    }

    public float getContrast() {
        return this.contrast;
    }

    public float getBrightness() {
        return this.brightness;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public int getTintColor() {
        return this.tintColor;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ColorEffect)) {
            return false;
        }
        ColorEffect colorEffect = (ColorEffect) obj;
        return colorEffect.brightness == this.brightness && colorEffect.contrast == this.contrast && colorEffect.saturation == this.saturation && colorEffect.tintColor == this.tintColor && colorEffect.lut_resource_id_ == this.lut_resource_id_;
    }

    public int hashCode() {
        return ((((((((int) (this.brightness * 255.0f)) * 71) + ((int) (this.contrast * 255.0f))) * 479) + ((int) (this.saturation * 255.0f))) * 977) + this.tintColor) ^ this.lut_resource_id_;
    }

    public KMProto.KMProject.ColorEffect asProtoBuf() {
        KMProto.KMProject.ColorEffect.Builder builder = new KMProto.KMProject.ColorEffect.Builder();
        builder.brightness(Float.valueOf(this.brightness));
        builder.contrast(Float.valueOf(this.contrast));
        builder.saturation(Float.valueOf(this.saturation));
        builder.tint_color(Integer.valueOf(this.tintColor));
        builder.preset_name(this.presetName);
        return builder.build();
    }

    public static ColorEffect fromProtoBuf(KMProto.KMProject.ColorEffect colorEffect) {
        ColorEffect fromPresetName;
        if (colorEffect == null) {
            return null;
        }
        return (colorEffect.preset_name != null && (fromPresetName = fromPresetName(colorEffect.preset_name)) != null && fromPresetName.brightness == colorEffect.brightness.floatValue() && fromPresetName.saturation == colorEffect.saturation.floatValue() && fromPresetName.contrast == colorEffect.contrast.floatValue() && fromPresetName.tintColor == colorEffect.tint_color.intValue()) ? fromPresetName : new ColorEffect(colorEffect.brightness.floatValue(), colorEffect.contrast.floatValue(), colorEffect.saturation.floatValue(), colorEffect.tint_color.intValue());
    }

    public static ColorEffect findByLUTResourceID(int i) {
        for (ColorEffect colorEffect : f4463a) {
            if (colorEffect.getLutResourceID() == i) {
                return colorEffect;
            }
        }
        return null;
    }

    public static Bitmap getBitmapForVignette() {
        if (c == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            c = BitmapFactory.decodeResource(KineMasterApplication.a().getResources(), R.raw.vignette, options);
        }
        return c;
    }

    public int getIconResourceId() {
        return this.icon_resource_id_;
    }
}
