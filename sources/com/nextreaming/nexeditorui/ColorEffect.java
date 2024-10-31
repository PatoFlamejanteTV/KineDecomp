package com.nextreaming.nexeditorui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.support.v4.internal.view.SupportMenu;
import com.facebook.internal.AnalyticsEvents;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.wire.KMProto;
import java.io.Serializable;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ColorEffect implements Serializable {
    private static final long serialVersionUID = 1;
    private Bitmap bitmap_;
    private final float brightness;
    private final float contrast;

    /* renamed from: f */
    private transient ColorMatrix f23990f;
    private final FilterType filterType;
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
    public static final ColorEffect RED_ALERT = new ColorEffect("RED_ALERT", -0.3f, -0.19f, -1.0f, SupportMenu.CATEGORY_MASK);
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
    public static final ColorEffect LUT_BLUE = new ColorEffect("LUT_BLUE", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_blue, R.drawable.thumb_lut_b14);
    public static final ColorEffect LUT_LUDWIG = new ColorEffect("LUT_LUDWIG", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_ludwig, R.drawable.thumb_lut_b16);
    public static final ColorEffect LUT_OLDFILM = new ColorEffect("LUT_OLDFILM", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_oldfilm, R.drawable.thumb_lut_b04);
    public static final ColorEffect LUT_ROSY = new ColorEffect("LUT_ROSY", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_rosy, R.drawable.thumb_lut_b07);
    public static final ColorEffect LUT_SUNSET = new ColorEffect("LUT_SUNSET", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_sunset, R.drawable.thumb_lut_b01);
    public static final ColorEffect LUT_SWEET = new ColorEffect("LUT_SWEET", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_sweet, R.drawable.thumb_lut_b09);
    public static final ColorEffect LUT_SALMON_TEAL = new ColorEffect("LUT_SALMON_TEAL", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_salmon_teal, R.drawable.thumb_lut_b11);
    public static final ColorEffect LUT_HEAT = new ColorEffect("LUT_HEAT", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_heat, R.drawable.thumb_lut_b12);
    public static final ColorEffect LUT_BLUEONLY = new ColorEffect("LUT_BLUEONLY", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_blueonly, R.drawable.thumb_lut_b02);
    public static final ColorEffect LUT_NEGATIVE = new ColorEffect("LUT_NEGATIVE", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_negative, R.drawable.thumb_lut_b05);
    public static final ColorEffect LUT_SUNPRINT = new ColorEffect("LUT_SUNPRINT", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_sunprint, R.drawable.thumb_lut_b06);
    public static final ColorEffect LUT_SHERBERT = new ColorEffect("LUT_SHERBERT", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_sherbert, R.drawable.thumb_lut_b15);
    public static final ColorEffect LUT_AFTERNOON = new ColorEffect("LUT_AFTERNOON", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_afternoon, R.drawable.thumb_lut_b03);
    public static final ColorEffect LUT_DAISY = new ColorEffect("LUT_DAISY", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_daisy, R.drawable.thumb_lut_b17);
    public static final ColorEffect LUT_DBRIGHT = new ColorEffect("LUT_DBRIGHT", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_dbright, R.drawable.thumb_lut_b13);
    public static final ColorEffect LUT_BORING = new ColorEffect("LUT_BORING", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_boring, R.drawable.thumb_lut_b20);
    public static final ColorEffect LUT_ALMOND_BLOSSOM = new ColorEffect("LUT_ALMOND_BLOSSOM", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_almond_blossom, R.drawable.thumb_lut_b19);
    public static final ColorEffect LUT_MOONLIGHT = new ColorEffect("LUT_MOONLIGHT", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_moonlight, R.drawable.thumb_lut_b18);
    public static final ColorEffect LUT_CINNAMON = new ColorEffect("LUT_CINNAMON", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_cinnamon, R.drawable.thumb_lut_b08);
    public static final ColorEffect LUT_RAINY = new ColorEffect("LUT_RAINY", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_rainy, R.drawable.thumb_lut_b21);
    public static final ColorEffect LUT_CLOUD = new ColorEffect("LUT_CLOUD", 0.0f, 0.0f, 0.0f, 0, R.raw.lut_cloud, R.drawable.thumb_lut_b10);
    public static final ColorEffect COLOR_FILTER_NONE = new ColorEffect("NONE", FilterType.FILTER_TYPE_NONE, 0.0f, 0.0f, 0.0f, 0, 0, 0);
    public static final ColorEffect COLOR_FILTER_BASIC_B01 = new ColorEffect("B01", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_sunset, R.drawable.thumb_lut_b01);
    public static final ColorEffect COLOR_FILTER_BASIC_B02 = new ColorEffect("B02", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_blueonly, R.drawable.thumb_lut_b02);
    public static final ColorEffect COLOR_FILTER_BASIC_B03 = new ColorEffect("B03", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_afternoon, R.drawable.thumb_lut_b03);
    public static final ColorEffect COLOR_FILTER_BASIC_B04 = new ColorEffect("B04", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_oldfilm, R.drawable.thumb_lut_b04);
    public static final ColorEffect COLOR_FILTER_BASIC_B05 = new ColorEffect("B05", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_negative, R.drawable.thumb_lut_b05);
    public static final ColorEffect COLOR_FILTER_BASIC_B06 = new ColorEffect("B06", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_sunprint, R.drawable.thumb_lut_b06);
    public static final ColorEffect COLOR_FILTER_BASIC_B07 = new ColorEffect("B07", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_rosy, R.drawable.thumb_lut_b07);
    public static final ColorEffect COLOR_FILTER_BASIC_B08 = new ColorEffect("B08", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_cinnamon, R.drawable.thumb_lut_b08);
    public static final ColorEffect COLOR_FILTER_BASIC_B09 = new ColorEffect("B09", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_sweet, R.drawable.thumb_lut_b09);
    public static final ColorEffect COLOR_FILTER_BASIC_B10 = new ColorEffect("B10", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_cloud, R.drawable.thumb_lut_b10);
    public static final ColorEffect COLOR_FILTER_BASIC_B11 = new ColorEffect("B11", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_salmon_teal, R.drawable.thumb_lut_b11);
    public static final ColorEffect COLOR_FILTER_BASIC_B12 = new ColorEffect("B12", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_heat, R.drawable.thumb_lut_b12);
    public static final ColorEffect COLOR_FILTER_BASIC_B13 = new ColorEffect("B13", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_dbright, R.drawable.thumb_lut_b13);
    public static final ColorEffect COLOR_FILTER_BASIC_B14 = new ColorEffect("B14", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_blue, R.drawable.thumb_lut_b14);
    public static final ColorEffect COLOR_FILTER_BASIC_B15 = new ColorEffect("B15", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_sherbert, R.drawable.thumb_lut_b15);
    public static final ColorEffect COLOR_FILTER_BASIC_B16 = new ColorEffect("B16", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_ludwig, R.drawable.thumb_lut_b16);
    public static final ColorEffect COLOR_FILTER_BASIC_B17 = new ColorEffect("B17", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_daisy, R.drawable.thumb_lut_b17);
    public static final ColorEffect COLOR_FILTER_BASIC_B18 = new ColorEffect("B18", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_moonlight, R.drawable.thumb_lut_b18);
    public static final ColorEffect COLOR_FILTER_BASIC_B19 = new ColorEffect("B19", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_almond_blossom, R.drawable.thumb_lut_b19);
    public static final ColorEffect COLOR_FILTER_BASIC_B20 = new ColorEffect("B20", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_boring, R.drawable.thumb_lut_b20);
    public static final ColorEffect COLOR_FILTER_BASIC_B21 = new ColorEffect("B21", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_rainy, R.drawable.thumb_lut_b21);
    public static final ColorEffect COLOR_FILTER_BASIC_B22 = new ColorEffect("B22", FilterType.FILTER_TYPE_BASIC, 0.08f, -0.06f, -0.5f, -11184811, 0, R.drawable.thumb_lut_b22);
    public static final ColorEffect COLOR_FILTER_BASIC_B23 = new ColorEffect("B23", FilterType.FILTER_TYPE_BASIC, 0.08f, -0.06f, -0.3f, -3364267, 0, R.drawable.thumb_lut_b23);
    public static final ColorEffect COLOR_FILTER_BASIC_B24 = new ColorEffect("B24", FilterType.FILTER_TYPE_BASIC, 0.08f, -0.06f, -0.3f, -5583787, 0, R.drawable.thumb_lut_b24);
    public static final ColorEffect COLOR_FILTER_BASIC_B25 = new ColorEffect("B25", FilterType.FILTER_TYPE_BASIC, 0.12f, -0.12f, -0.3f, -9420268, 0, R.drawable.thumb_lut_b25);
    public static final ColorEffect COLOR_FILTER_BASIC_B26 = new ColorEffect("B26", FilterType.FILTER_TYPE_BASIC, 0.08f, -0.06f, -0.5f, -17664, 0, R.drawable.thumb_lut_b26);
    public static final ColorEffect COLOR_FILTER_BASIC_B27 = new ColorEffect("B27", FilterType.FILTER_TYPE_BASIC, 0.08f, -0.06f, -0.35f, -17664, 0, R.drawable.thumb_lut_b27);
    public static final ColorEffect COLOR_FILTER_BASIC_B28 = new ColorEffect("B28", FilterType.FILTER_TYPE_BASIC, 0.08f, -0.06f, -0.3f, -5614132, 0, R.drawable.thumb_lut_b28);
    public static final ColorEffect COLOR_FILTER_BASIC_B29 = new ColorEffect("B29", FilterType.FILTER_TYPE_BASIC, 0.12f, -0.12f, -0.3f, -15449488, 0, R.drawable.thumb_lut_b29);
    public static final ColorEffect COLOR_FILTER_BASIC_B30 = new ColorEffect("B30", FilterType.FILTER_TYPE_BASIC, 0.1f, -0.3f, -0.6f, -6533297, 0, R.drawable.thumb_lut_b30);
    public static final ColorEffect COLOR_FILTER_BASIC_B31 = new ColorEffect("B31", FilterType.FILTER_TYPE_BASIC, 0.08f, -0.06f, -0.6f, -43691, 0, R.drawable.thumb_lut_b31);
    public static final ColorEffect COLOR_FILTER_BASIC_B32 = new ColorEffect("B32", FilterType.FILTER_TYPE_BASIC, 0.0f, 0.0f, -1.0f, -1, 0, R.drawable.thumb_lut_b32);
    public static final ColorEffect COLOR_FILTER_BASIC_B33 = new ColorEffect("B33", FilterType.FILTER_TYPE_BASIC, -0.25f, 0.6f, -1.0f, -8952235, 0, R.drawable.thumb_lut_b33);
    public static final ColorEffect COLOR_FILTER_BASIC_B34 = new ColorEffect("B34", FilterType.FILTER_TYPE_BASIC, 0.08f, -0.06f, -0.5f, -5570816, 0, R.drawable.thumb_lut_b34);
    public static final ColorEffect COLOR_FILTER_BASIC_B35 = new ColorEffect("B35", FilterType.FILTER_TYPE_BASIC, 0.12f, -0.06f, -0.3f, -15437804, 0, R.drawable.thumb_lut_b35);
    public static final ColorEffect COLOR_FILTER_BASIC_B36 = new ColorEffect("B36", FilterType.FILTER_TYPE_BASIC, 0.08f, -0.06f, -0.5f, -16711766, 0, R.drawable.thumb_lut_b36);
    public static final ColorEffect COLOR_FILTER_BASIC_B37 = new ColorEffect("B37", FilterType.FILTER_TYPE_BASIC, -0.2f, -0.3f, -0.6f, -16763905, 0, R.drawable.thumb_lut_b37);
    public static final ColorEffect COLOR_FILTER_BASIC_B38 = new ColorEffect("B38", FilterType.FILTER_TYPE_BASIC, -0.3f, -0.19f, -1.0f, SupportMenu.CATEGORY_MASK, 0, R.drawable.thumb_lut_b38);
    public static final ColorEffect COLOR_FILTER_WARM_W01 = new ColorEffect("W01", FilterType.FILTER_TYPE_WARM, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_w01, R.drawable.thumb_lut_w01);
    public static final ColorEffect COLOR_FILTER_WARM_W02 = new ColorEffect("W02", FilterType.FILTER_TYPE_WARM, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_w02, R.drawable.thumb_lut_w02);
    public static final ColorEffect COLOR_FILTER_WARM_W03 = new ColorEffect("W03", FilterType.FILTER_TYPE_WARM, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_w03, R.drawable.thumb_lut_w03);
    public static final ColorEffect COLOR_FILTER_WARM_W04 = new ColorEffect("W04", FilterType.FILTER_TYPE_WARM, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_w04, R.drawable.thumb_lut_w04);
    public static final ColorEffect COLOR_FILTER_WARM_W05 = new ColorEffect("W05", FilterType.FILTER_TYPE_WARM, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_w05, R.drawable.thumb_lut_w05);
    public static final ColorEffect COLOR_FILTER_WARM_W06 = new ColorEffect("W06", FilterType.FILTER_TYPE_WARM, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_w06, R.drawable.thumb_lut_w06);
    public static final ColorEffect COLOR_FILTER_WARM_W07 = new ColorEffect("W07", FilterType.FILTER_TYPE_WARM, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_w07, R.drawable.thumb_lut_w07);
    public static final ColorEffect COLOR_FILTER_WARM_W08 = new ColorEffect("W08", FilterType.FILTER_TYPE_WARM, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_w08, R.drawable.thumb_lut_w08);
    public static final ColorEffect COLOR_FILTER_WARM_W09 = new ColorEffect("W09", FilterType.FILTER_TYPE_WARM, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_w09, R.drawable.thumb_lut_w09);
    public static final ColorEffect COLOR_FILTER_WARM_W10 = new ColorEffect("W10", FilterType.FILTER_TYPE_WARM, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_w10, R.drawable.thumb_lut_w10);
    public static final ColorEffect COLOR_FILTER_WARM_W11 = new ColorEffect("W11", FilterType.FILTER_TYPE_WARM, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_w11, R.drawable.thumb_lut_w11);
    public static final ColorEffect COLOR_FILTER_WARM_W12 = new ColorEffect("W12", FilterType.FILTER_TYPE_WARM, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_w12, R.drawable.thumb_lut_w12);
    public static final ColorEffect COLOR_FILTER_COLD_C01 = new ColorEffect("C01", FilterType.FILTER_TYPE_COLD, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_c01, R.drawable.thumb_lut_c01);
    public static final ColorEffect COLOR_FILTER_COLD_C02 = new ColorEffect("C02", FilterType.FILTER_TYPE_COLD, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_c02, R.drawable.thumb_lut_c02);
    public static final ColorEffect COLOR_FILTER_COLD_C03 = new ColorEffect("C03", FilterType.FILTER_TYPE_COLD, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_c03, R.drawable.thumb_lut_c03);
    public static final ColorEffect COLOR_FILTER_COLD_C04 = new ColorEffect("C04", FilterType.FILTER_TYPE_COLD, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_c04, R.drawable.thumb_lut_c04);
    public static final ColorEffect COLOR_FILTER_COLD_C05 = new ColorEffect("C05", FilterType.FILTER_TYPE_COLD, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_c05, R.drawable.thumb_lut_c05);
    public static final ColorEffect COLOR_FILTER_COLD_C06 = new ColorEffect("C06", FilterType.FILTER_TYPE_COLD, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_c06, R.drawable.thumb_lut_c06);
    public static final ColorEffect COLOR_FILTER_COLD_C07 = new ColorEffect("C07", FilterType.FILTER_TYPE_COLD, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_c07, R.drawable.thumb_lut_c07);
    public static final ColorEffect COLOR_FILTER_COLD_C08 = new ColorEffect("C08", FilterType.FILTER_TYPE_COLD, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_c08, R.drawable.thumb_lut_c08);
    public static final ColorEffect COLOR_FILTER_COLD_C09 = new ColorEffect("C09", FilterType.FILTER_TYPE_COLD, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_c09, R.drawable.thumb_lut_c09);
    public static final ColorEffect COLOR_FILTER_COLD_C10 = new ColorEffect("C10", FilterType.FILTER_TYPE_COLD, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_c10, R.drawable.thumb_lut_c10);
    public static final ColorEffect COLOR_FILTER_COLD_C11 = new ColorEffect("C11", FilterType.FILTER_TYPE_COLD, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_c11, R.drawable.thumb_lut_c11);
    public static final ColorEffect COLOR_FILTER_VIVID_V01 = new ColorEffect("V01", FilterType.FILTER_TYPE_VIVID, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_v01, R.drawable.thumb_lut_v01);
    public static final ColorEffect COLOR_FILTER_VIVID_V02 = new ColorEffect("V02", FilterType.FILTER_TYPE_VIVID, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_v02, R.drawable.thumb_lut_v02);
    public static final ColorEffect COLOR_FILTER_VIVID_V03 = new ColorEffect("V03", FilterType.FILTER_TYPE_VIVID, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_v03, R.drawable.thumb_lut_v03);
    public static final ColorEffect COLOR_FILTER_VIVID_V04 = new ColorEffect("V04", FilterType.FILTER_TYPE_VIVID, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_v04, R.drawable.thumb_lut_v04);
    public static final ColorEffect COLOR_FILTER_VIVID_V05 = new ColorEffect("V05", FilterType.FILTER_TYPE_VIVID, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_v05, R.drawable.thumb_lut_v05);
    public static final ColorEffect COLOR_FILTER_VIVID_V06 = new ColorEffect("V06", FilterType.FILTER_TYPE_VIVID, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_v06, R.drawable.thumb_lut_v06);
    public static final ColorEffect COLOR_FILTER_MONOCHROME_M01 = new ColorEffect("M01", FilterType.FILTER_TYPE_MONOCHROME, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_m01, R.drawable.thumb_lut_m01);
    public static final ColorEffect COLOR_FILTER_MONOCHROME_M02 = new ColorEffect("M02", FilterType.FILTER_TYPE_MONOCHROME, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_m02, R.drawable.thumb_lut_m02);
    public static final ColorEffect COLOR_FILTER_MONOCHROME_M03 = new ColorEffect("M03", FilterType.FILTER_TYPE_MONOCHROME, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_m03, R.drawable.thumb_lut_m03);
    public static final ColorEffect COLOR_FILTER_MONOCHROME_M04 = new ColorEffect("M04", FilterType.FILTER_TYPE_MONOCHROME, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_m04, R.drawable.thumb_lut_m04);
    public static final ColorEffect COLOR_FILTER_MONOCHROME_M05 = new ColorEffect("M05", FilterType.FILTER_TYPE_MONOCHROME, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_m05, R.drawable.thumb_lut_m05);
    public static final ColorEffect COLOR_FILTER_MONOCHROME_M06 = new ColorEffect("M06", FilterType.FILTER_TYPE_MONOCHROME, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_m06, R.drawable.thumb_lut_m06);
    public static final ColorEffect COLOR_FILTER_MONOCHROME_M07 = new ColorEffect("M07", FilterType.FILTER_TYPE_MONOCHROME, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_m07, R.drawable.thumb_lut_m07);
    public static final ColorEffect COLOR_FILTER_MONOCHROME_M08 = new ColorEffect("M08", FilterType.FILTER_TYPE_MONOCHROME, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_m08, R.drawable.thumb_lut_m08);
    public static final ColorEffect COLOR_FILTER_MONOCHROME_M09 = new ColorEffect("M09", FilterType.FILTER_TYPE_MONOCHROME, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_m09, R.drawable.thumb_lut_m09);
    public static final ColorEffect COLOR_FILTER_MONOCHROME_M10 = new ColorEffect("M10", FilterType.FILTER_TYPE_MONOCHROME, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_m10, R.drawable.thumb_lut_m10);
    public static final ColorEffect COLOR_FILTER_LOWSATURATION_L01 = new ColorEffect("L01", FilterType.FILTER_TYPE_LOWSATURATION, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_l01, R.drawable.thumb_lut_l01);
    public static final ColorEffect COLOR_FILTER_LOWSATURATION_L02 = new ColorEffect("L02", FilterType.FILTER_TYPE_LOWSATURATION, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_l02, R.drawable.thumb_lut_l02);
    public static final ColorEffect COLOR_FILTER_LOWSATURATION_L03 = new ColorEffect("L03", FilterType.FILTER_TYPE_LOWSATURATION, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_l03, R.drawable.thumb_lut_l03);
    public static final ColorEffect COLOR_FILTER_LOWSATURATION_L04 = new ColorEffect("L04", FilterType.FILTER_TYPE_LOWSATURATION, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_l04, R.drawable.thumb_lut_l04);
    public static final ColorEffect COLOR_FILTER_LOWSATURATION_L05 = new ColorEffect("L05", FilterType.FILTER_TYPE_LOWSATURATION, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_l05, R.drawable.thumb_lut_l05);
    public static final ColorEffect COLOR_FILTER_LOWSATURATION_L06 = new ColorEffect("L06", FilterType.FILTER_TYPE_LOWSATURATION, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_l06, R.drawable.thumb_lut_l06);
    public static final ColorEffect COLOR_FILTER_LOWSATURATION_L07 = new ColorEffect("L07", FilterType.FILTER_TYPE_LOWSATURATION, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_l07, R.drawable.thumb_lut_l07);
    public static final ColorEffect COLOR_FILTER_LOWSATURATION_L08 = new ColorEffect("L08", FilterType.FILTER_TYPE_LOWSATURATION, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_l08, R.drawable.thumb_lut_l08);
    public static final ColorEffect COLOR_FILTER_LOWSATURATION_L09 = new ColorEffect("L09", FilterType.FILTER_TYPE_LOWSATURATION, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_l09, R.drawable.thumb_lut_l09);
    public static final ColorEffect COLOR_FILTER_LOWSATURATION_L10 = new ColorEffect("L10", FilterType.FILTER_TYPE_LOWSATURATION, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_l10, R.drawable.thumb_lut_l10);
    public static final ColorEffect COLOR_FILTER_LOWSATURATION_L11 = new ColorEffect("L11", FilterType.FILTER_TYPE_LOWSATURATION, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_l11, R.drawable.thumb_lut_l11);
    public static final ColorEffect COLOR_FILTER_LOWSATURATION_L12 = new ColorEffect("L12", FilterType.FILTER_TYPE_LOWSATURATION, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_l12, R.drawable.thumb_lut_l12);
    public static final ColorEffect COLOR_FILTER_LOWSATURATION_L13 = new ColorEffect("L13", FilterType.FILTER_TYPE_LOWSATURATION, 0.0f, 0.0f, 0.0f, 0, R.raw.lut_l13, R.drawable.thumb_lut_l13);

    /* renamed from: a */
    private static final ColorEffect[] f23985a = {NONE, BLACK_AND_WHITE, LUT_BLUE, LUT_LUDWIG, LUT_OLDFILM, LUT_ROSY, LUT_SUNSET, LUT_SWEET, LUT_SALMON_TEAL, LUT_HEAT, LUT_BLUEONLY, LUT_NEGATIVE, LUT_SUNPRINT, LUT_SHERBERT, LUT_AFTERNOON, LUT_DAISY, LUT_DBRIGHT, LUT_BORING, LUT_ALMOND_BLOSSOM, LUT_MOONLIGHT, LUT_CINNAMON, LUT_RAINY, LUT_CLOUD, ALIEN_INVASION, COOL, DEEP_BLUE, PINK, RED_ALERT, SEPIA, SUNNY, PURPLE, ORANGE, STRONG_ORANGE, SPRING, SUMMER, FALL, ROUGE, PASTEL, NOIR};

    /* renamed from: b */
    private static final ColorEffect[] f23986b = {COLOR_FILTER_NONE, COLOR_FILTER_BASIC_B01, COLOR_FILTER_BASIC_B02, COLOR_FILTER_BASIC_B03, COLOR_FILTER_BASIC_B04, COLOR_FILTER_BASIC_B05, COLOR_FILTER_BASIC_B06, COLOR_FILTER_BASIC_B07, COLOR_FILTER_BASIC_B08, COLOR_FILTER_BASIC_B09, COLOR_FILTER_BASIC_B10, COLOR_FILTER_BASIC_B11, COLOR_FILTER_BASIC_B12, COLOR_FILTER_BASIC_B13, COLOR_FILTER_BASIC_B14, COLOR_FILTER_BASIC_B15, COLOR_FILTER_BASIC_B16, COLOR_FILTER_BASIC_B17, COLOR_FILTER_BASIC_B18, COLOR_FILTER_BASIC_B19, COLOR_FILTER_BASIC_B20, COLOR_FILTER_BASIC_B21, COLOR_FILTER_BASIC_B22, COLOR_FILTER_BASIC_B23, COLOR_FILTER_BASIC_B24, COLOR_FILTER_BASIC_B25, COLOR_FILTER_BASIC_B26, COLOR_FILTER_BASIC_B27, COLOR_FILTER_BASIC_B28, COLOR_FILTER_BASIC_B29, COLOR_FILTER_BASIC_B30, COLOR_FILTER_BASIC_B31, COLOR_FILTER_BASIC_B32, COLOR_FILTER_BASIC_B33, COLOR_FILTER_BASIC_B34, COLOR_FILTER_BASIC_B35, COLOR_FILTER_BASIC_B36, COLOR_FILTER_BASIC_B37, COLOR_FILTER_BASIC_B38, COLOR_FILTER_WARM_W01, COLOR_FILTER_WARM_W02, COLOR_FILTER_WARM_W03, COLOR_FILTER_WARM_W04, COLOR_FILTER_WARM_W05, COLOR_FILTER_WARM_W06, COLOR_FILTER_WARM_W07, COLOR_FILTER_WARM_W08, COLOR_FILTER_WARM_W09, COLOR_FILTER_WARM_W10, COLOR_FILTER_WARM_W11, COLOR_FILTER_WARM_W12, COLOR_FILTER_COLD_C01, COLOR_FILTER_COLD_C02, COLOR_FILTER_COLD_C03, COLOR_FILTER_COLD_C04, COLOR_FILTER_COLD_C05, COLOR_FILTER_COLD_C06, COLOR_FILTER_COLD_C07, COLOR_FILTER_COLD_C08, COLOR_FILTER_COLD_C09, COLOR_FILTER_COLD_C10, COLOR_FILTER_COLD_C11, COLOR_FILTER_VIVID_V01, COLOR_FILTER_VIVID_V02, COLOR_FILTER_VIVID_V03, COLOR_FILTER_VIVID_V04, COLOR_FILTER_VIVID_V05, COLOR_FILTER_VIVID_V06, COLOR_FILTER_MONOCHROME_M01, COLOR_FILTER_MONOCHROME_M02, COLOR_FILTER_MONOCHROME_M03, COLOR_FILTER_MONOCHROME_M04, COLOR_FILTER_MONOCHROME_M05, COLOR_FILTER_MONOCHROME_M06, COLOR_FILTER_MONOCHROME_M07, COLOR_FILTER_MONOCHROME_M08, COLOR_FILTER_MONOCHROME_M09, COLOR_FILTER_MONOCHROME_M10, COLOR_FILTER_LOWSATURATION_L01, COLOR_FILTER_LOWSATURATION_L02, COLOR_FILTER_LOWSATURATION_L03, COLOR_FILTER_LOWSATURATION_L04, COLOR_FILTER_LOWSATURATION_L05, COLOR_FILTER_LOWSATURATION_L06, COLOR_FILTER_LOWSATURATION_L07, COLOR_FILTER_LOWSATURATION_L08, COLOR_FILTER_LOWSATURATION_L09, COLOR_FILTER_LOWSATURATION_L10, COLOR_FILTER_LOWSATURATION_L11, COLOR_FILTER_LOWSATURATION_L12, COLOR_FILTER_LOWSATURATION_L13};

    /* renamed from: c */
    private static final String[][] f23987c = {new String[]{"NONE", "NONE"}, new String[]{"LUT_SUNSET", "B01"}, new String[]{"LUT_BLUEONLY", "B02"}, new String[]{"LUT_AFTERNOON", "B03"}, new String[]{"LUT_OLDFILM", "B04"}, new String[]{"LUT_NEGATIVE", "B05"}, new String[]{"LUT_SUNPRINT", "B06"}, new String[]{"LUT_ROSY", "B07"}, new String[]{"LUT_CINNAMON", "B08"}, new String[]{"LUT_SWEET", "B09"}, new String[]{"LUT_CLOUD", "B10"}, new String[]{"LUT_SALMON_TEAL", "B11"}, new String[]{"LUT_HEAT", "B12"}, new String[]{"LUT_DBRIGHT", "B13"}, new String[]{"LUT_BLUE", "B14"}, new String[]{"LUT_SHERBERT", "B15"}, new String[]{"LUT_LUDWIG", "B16"}, new String[]{"LUT_DAISY", "B17"}, new String[]{"LUT_MOONLIGHT", "B18"}, new String[]{"LUT_ALMOND_BLOSSOM", "B19"}, new String[]{"LUT_BORING", "B20"}, new String[]{"LUT_RAINY", "B21"}, new String[]{"PASTEL", "B22"}, new String[]{"SUNNY", "B23"}, new String[]{"SPRING", "B24"}, new String[]{"SEPIA", "B25"}, new String[]{"STRONG_ORANGE", "B26"}, new String[]{"ORANGE", "B27"}, new String[]{"PURPLE", "B28"}, new String[]{"COOL", "B29"}, new String[]{"PINK", "B30"}, new String[]{"ROUGE", "B31"}, new String[]{"BLACK_AND_WHITE", "B32"}, new String[]{"NOIR", "B33"}, new String[]{"SUMMER", "B34"}, new String[]{"ALIEN_INVASION", "B35"}, new String[]{"FALL", "B36"}, new String[]{"DEEP_BLUE", "B37"}, new String[]{"RED_ALERT", "B38"}};

    /* renamed from: d */
    private static Map<String, String> f23988d = new HashMap();

    /* renamed from: e */
    private static Bitmap f23989e = null;

    /* loaded from: classes.dex */
    public enum FilterType {
        FILTER_TYPE_UNKNOWN(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN),
        FILTER_TYPE_NONE("None"),
        FILTER_TYPE_BASIC("Basic"),
        FILTER_TYPE_WARM("Warm"),
        FILTER_TYPE_COLD("Cold"),
        FILTER_TYPE_VIVID("Vivid"),
        FILTER_TYPE_MONOCHROME("Monochrome"),
        FILTER_TYPE_LOWSATURATION("Low Saturation");

        String value;

        FilterType(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    private ColorEffect(String str, float f2, float f3, float f4, int i) {
        this.lut_enabled_ = false;
        this.lut_resource_id_ = 0;
        this.bitmap_ = null;
        this.brightness = f2;
        this.contrast = f3;
        this.saturation = f4;
        this.tintColor = i;
        this.presetName = str;
        this.filterType = FilterType.FILTER_TYPE_UNKNOWN;
        this.lut_enabled_ = false;
        this.bitmap_ = null;
        this.icon_resource_id_ = 0;
    }

    public static ColorEffect findByLUTResourceID(int i) {
        for (ColorEffect colorEffect : f23986b) {
            if (colorEffect.getLutResourceID() == i) {
                return colorEffect;
            }
        }
        return null;
    }

    public static ColorEffect fromPresetName(String str) {
        if (f23988d.isEmpty()) {
            for (String[] strArr : f23987c) {
                f23988d.put(strArr[0], strArr[1]);
            }
        }
        if (f23988d.containsKey(str)) {
            String str2 = f23988d.get(str);
            for (ColorEffect colorEffect : f23986b) {
                if (colorEffect.presetName.compareTo(str2) == 0) {
                    return colorEffect;
                }
            }
        }
        for (ColorEffect colorEffect2 : f23986b) {
            if (colorEffect2.presetName.compareTo(str) == 0) {
                return colorEffect2;
            }
        }
        for (ColorEffect colorEffect3 : f23985a) {
            if (colorEffect3.presetName.equals(str)) {
                return colorEffect3;
            }
        }
        return COLOR_FILTER_NONE;
    }

    public static ColorEffect fromProtoBuf(KMProto.KMProject.ColorEffect colorEffect) {
        ColorEffect fromPresetName;
        if (colorEffect == null) {
            return null;
        }
        String str = colorEffect.preset_name;
        return (str != null && (fromPresetName = fromPresetName(str)) != null && fromPresetName.brightness == colorEffect.brightness.floatValue() && fromPresetName.saturation == colorEffect.saturation.floatValue() && fromPresetName.contrast == colorEffect.contrast.floatValue() && fromPresetName.tintColor == colorEffect.tint_color.intValue()) ? fromPresetName : new ColorEffect(colorEffect.brightness.floatValue(), colorEffect.contrast.floatValue(), colorEffect.saturation.floatValue(), colorEffect.tint_color.intValue());
    }

    public static Bitmap getBitmapForVignette() {
        if (f23989e == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            f23989e = BitmapFactory.decodeResource(KineMasterApplication.f24056d.getResources(), R.raw.vignette, options);
        }
        return f23989e;
    }

    public static List<ColorEffect> getColorFilters(FilterType filterType) {
        ArrayList arrayList = new ArrayList();
        for (ColorEffect colorEffect : f23986b) {
            if (colorEffect.filterType == filterType) {
                arrayList.add(colorEffect);
            }
        }
        return arrayList;
    }

    public static List<ColorEffect> getPresetList() {
        return Arrays.asList(f23985a);
    }

    public static ColorEffect[] values() {
        return f23985a;
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

    public boolean equals(Object obj) {
        if (!(obj instanceof ColorEffect)) {
            return false;
        }
        ColorEffect colorEffect = (ColorEffect) obj;
        return colorEffect.brightness == this.brightness && colorEffect.contrast == this.contrast && colorEffect.saturation == this.saturation && colorEffect.tintColor == this.tintColor && colorEffect.lut_resource_id_ == this.lut_resource_id_;
    }

    public float getBrightness() {
        return this.brightness;
    }

    public ColorMatrix getColorMatrix() {
        if (this.f23990f == null) {
            this.f23990f = c.d.a.a.e.a.a(this.brightness, this.contrast, this.saturation, this.tintColor);
        }
        return this.f23990f;
    }

    public float getContrast() {
        return this.contrast;
    }

    public FilterType getFilterType() {
        return this.filterType;
    }

    public int getIconResourceId() {
        return this.icon_resource_id_;
    }

    public Bitmap getLut() {
        if (this.lut_enabled_ && this.bitmap_ == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            Bitmap decodeResource = BitmapFactory.decodeResource(KineMasterApplication.f24056d.getResources(), this.lut_resource_id_, options);
            if (decodeResource != null) {
                IntBuffer allocate = IntBuffer.allocate(262144);
                IntBuffer allocate2 = IntBuffer.allocate(262144);
                decodeResource.getPixels(allocate.array(), 0, decodeResource.getWidth(), 0, 0, decodeResource.getWidth(), decodeResource.getHeight());
                int[] array = allocate.array();
                int[] array2 = allocate2.array();
                for (int i = 0; i < 8; i++) {
                    for (int i2 = 0; i2 < 8; i2++) {
                        for (int i3 = 0; i3 < 64; i3++) {
                            for (int i4 = 0; i4 < 64; i4++) {
                                array2[(i * 64) + (i2 * 512 * 64) + i3 + (i4 * 512)] = array[(((262080 - ((i * 512) * 64)) - ((i2 * 64) * 64)) + i3) - (i4 * 64)];
                            }
                        }
                    }
                }
                this.bitmap_ = Bitmap.createBitmap(array2, 512, 512, decodeResource.getConfig());
            }
        }
        return this.bitmap_;
    }

    public int getLutResourceID() {
        return this.lut_resource_id_;
    }

    public String getPresetName() {
        return this.presetName;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public int getTintColor() {
        return this.tintColor;
    }

    public int hashCode() {
        return ((((((((int) (this.brightness * 255.0f)) * 71) + ((int) (this.contrast * 255.0f))) * 479) + ((int) (this.saturation * 255.0f))) * 977) + this.tintColor) ^ this.lut_resource_id_;
    }

    public ColorEffect(float f2, float f3, float f4, int i) {
        this.lut_enabled_ = false;
        this.lut_resource_id_ = 0;
        this.bitmap_ = null;
        this.brightness = f2;
        this.contrast = f3;
        this.saturation = f4;
        this.tintColor = i;
        this.presetName = null;
        this.filterType = FilterType.FILTER_TYPE_UNKNOWN;
        this.lut_enabled_ = false;
        this.bitmap_ = null;
        this.icon_resource_id_ = 0;
    }

    public ColorEffect(String str, float f2, float f3, float f4, int i, int i2, int i3) {
        this.lut_enabled_ = false;
        this.lut_resource_id_ = 0;
        this.bitmap_ = null;
        this.brightness = f2;
        this.contrast = f3;
        this.saturation = f4;
        this.tintColor = i;
        this.presetName = str;
        this.filterType = FilterType.FILTER_TYPE_UNKNOWN;
        this.lut_enabled_ = true;
        this.lut_resource_id_ = i2;
        this.icon_resource_id_ = i3;
        this.bitmap_ = null;
    }

    public ColorEffect(String str, FilterType filterType, float f2, float f3, float f4, int i, int i2, int i3) {
        this.lut_enabled_ = false;
        this.lut_resource_id_ = 0;
        this.bitmap_ = null;
        this.brightness = f2;
        this.contrast = f3;
        this.saturation = f4;
        this.tintColor = i;
        this.presetName = str;
        this.filterType = filterType;
        this.lut_enabled_ = true;
        this.lut_resource_id_ = i2;
        this.icon_resource_id_ = i3;
        this.bitmap_ = null;
    }
}
