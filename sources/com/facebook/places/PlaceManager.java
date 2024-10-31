package com.facebook.places;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.places.internal.BluetoothScanResult;
import com.facebook.places.internal.LocationPackage;
import com.facebook.places.internal.LocationPackageManager;
import com.facebook.places.internal.LocationPackageRequestParams;
import com.facebook.places.internal.ScannerException;
import com.facebook.places.internal.WifiScanResult;
import com.facebook.places.model.CurrentPlaceFeedbackRequestParams;
import com.facebook.places.model.CurrentPlaceRequestParams;
import com.facebook.places.model.PlaceInfoRequestParams;
import com.facebook.places.model.PlaceSearchRequestParams;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PlaceManager {
    private static final String CURRENT_PLACE_FEEDBACK = "current_place/feedback";
    private static final String CURRENT_PLACE_RESULTS = "current_place/results";
    private static final String PARAM_ACCESS_POINTS = "access_points";
    private static final String PARAM_ACCURACY = "accuracy";
    private static final String PARAM_ALTITUDE = "altitude";
    private static final String PARAM_BLUETOOTH = "bluetooth";
    private static final String PARAM_CATEGORIES = "categories";
    private static final String PARAM_CENTER = "center";
    private static final String PARAM_COORDINATES = "coordinates";
    private static final String PARAM_CURRENT_CONNECTION = "current_connection";
    private static final String PARAM_DISTANCE = "distance";
    private static final String PARAM_ENABLED = "enabled";
    private static final String PARAM_FIELDS = "fields";
    private static final String PARAM_FREQUENCY = "frequency";
    private static final String PARAM_HEADING = "heading";
    private static final String PARAM_LATITUDE = "latitude";
    private static final String PARAM_LIMIT = "limit";
    private static final String PARAM_LONGITUDE = "longitude";
    private static final String PARAM_MAC_ADDRESS = "mac_address";
    private static final String PARAM_MIN_CONFIDENCE_LEVEL = "min_confidence_level";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_PLACE_ID = "place_id";
    private static final String PARAM_Q = "q";
    private static final String PARAM_RSSI = "rssi";
    private static final String PARAM_SCANS = "scans";
    private static final String PARAM_SIGNAL_STRENGTH = "signal_strength";
    private static final String PARAM_SPEED = "speed";
    private static final String PARAM_SSID = "ssid";
    private static final String PARAM_SUMMARY = "summary";
    private static final String PARAM_TRACKING = "tracking";
    private static final String PARAM_TYPE = "type";
    private static final String PARAM_WAS_HERE = "was_here";
    private static final String PARAM_WIFI = "wifi";
    private static final String SEARCH = "search";

    /* loaded from: classes.dex */
    public enum LocationError {
        LOCATION_PERMISSION_DENIED,
        LOCATION_SERVICES_DISABLED,
        LOCATION_TIMEOUT,
        UNKNOWN_ERROR
    }

    /* loaded from: classes.dex */
    public interface OnRequestReadyCallback {
        void onLocationError(LocationError locationError);

        void onRequestReady(GraphRequest graphRequest);
    }

    private PlaceManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle getCurrentPlaceParameters(CurrentPlaceRequestParams currentPlaceRequestParams, LocationPackage locationPackage) throws FacebookException {
        if (currentPlaceRequestParams != null) {
            if (locationPackage == null) {
                locationPackage = new LocationPackage();
            }
            if (locationPackage.location == null) {
                locationPackage.location = currentPlaceRequestParams.getLocation();
            }
            if (locationPackage.location != null) {
                try {
                    Bundle bundle = new Bundle(6);
                    bundle.putString(PARAM_SUMMARY, PARAM_TRACKING);
                    int limit = currentPlaceRequestParams.getLimit();
                    if (limit > 0) {
                        bundle.putInt(PARAM_LIMIT, limit);
                    }
                    Set<String> fields = currentPlaceRequestParams.getFields();
                    if (fields != null && !fields.isEmpty()) {
                        bundle.putString("fields", TextUtils.join(",", fields));
                    }
                    Location location = locationPackage.location;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(PARAM_LATITUDE, location.getLatitude());
                    jSONObject.put(PARAM_LONGITUDE, location.getLongitude());
                    if (location.hasAccuracy()) {
                        jSONObject.put(PARAM_ACCURACY, location.getAccuracy());
                    }
                    if (location.hasAltitude()) {
                        jSONObject.put(PARAM_ALTITUDE, location.getAltitude());
                    }
                    if (location.hasBearing()) {
                        jSONObject.put(PARAM_HEADING, location.getBearing());
                    }
                    if (location.hasSpeed()) {
                        jSONObject.put(PARAM_SPEED, location.getSpeed());
                    }
                    bundle.putString(PARAM_COORDINATES, jSONObject.toString());
                    CurrentPlaceRequestParams.ConfidenceLevel minConfidenceLevel = currentPlaceRequestParams.getMinConfidenceLevel();
                    if (minConfidenceLevel == CurrentPlaceRequestParams.ConfidenceLevel.LOW || minConfidenceLevel == CurrentPlaceRequestParams.ConfidenceLevel.MEDIUM || minConfidenceLevel == CurrentPlaceRequestParams.ConfidenceLevel.HIGH) {
                        bundle.putString(PARAM_MIN_CONFIDENCE_LEVEL, minConfidenceLevel.toString().toLowerCase(Locale.US));
                    }
                    if (locationPackage != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(PARAM_ENABLED, locationPackage.isWifiScanningEnabled);
                        WifiScanResult wifiScanResult = locationPackage.connectedWifi;
                        if (wifiScanResult != null) {
                            jSONObject2.put(PARAM_CURRENT_CONNECTION, getWifiScanJson(wifiScanResult));
                        }
                        List<WifiScanResult> list = locationPackage.ambientWifi;
                        if (list != null) {
                            JSONArray jSONArray = new JSONArray();
                            Iterator<WifiScanResult> it = list.iterator();
                            while (it.hasNext()) {
                                jSONArray.put(getWifiScanJson(it.next()));
                            }
                            jSONObject2.put(PARAM_ACCESS_POINTS, jSONArray);
                        }
                        bundle.putString(PARAM_WIFI, jSONObject2.toString());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(PARAM_ENABLED, locationPackage.isBluetoothScanningEnabled);
                        List<BluetoothScanResult> list2 = locationPackage.ambientBluetoothLe;
                        if (list2 != null) {
                            JSONArray jSONArray2 = new JSONArray();
                            for (BluetoothScanResult bluetoothScanResult : list2) {
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("payload", bluetoothScanResult.payload);
                                jSONObject4.put(PARAM_RSSI, bluetoothScanResult.rssi);
                                jSONArray2.put(jSONObject4);
                            }
                            jSONObject3.put(PARAM_SCANS, jSONArray2);
                        }
                        bundle.putString(PARAM_BLUETOOTH, jSONObject3.toString());
                    }
                    return bundle;
                } catch (JSONException e2) {
                    throw new FacebookException(e2);
                }
            }
            throw new FacebookException("A location must be specified");
        }
        throw new FacebookException("Request and location must be specified.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LocationError getLocationError(ScannerException.Type type) {
        if (type == ScannerException.Type.PERMISSION_DENIED) {
            return LocationError.LOCATION_PERMISSION_DENIED;
        }
        if (type == ScannerException.Type.DISABLED) {
            return LocationError.LOCATION_SERVICES_DISABLED;
        }
        if (type == ScannerException.Type.TIMEOUT) {
            return LocationError.LOCATION_TIMEOUT;
        }
        return LocationError.UNKNOWN_ERROR;
    }

    private static JSONObject getWifiScanJson(WifiScanResult wifiScanResult) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(PARAM_MAC_ADDRESS, wifiScanResult.bssid);
        jSONObject.put(PARAM_SSID, wifiScanResult.ssid);
        jSONObject.put(PARAM_SIGNAL_STRENGTH, wifiScanResult.rssi);
        jSONObject.put(PARAM_FREQUENCY, wifiScanResult.frequency);
        return jSONObject;
    }

    public static GraphRequest newCurrentPlaceFeedbackRequest(CurrentPlaceFeedbackRequestParams currentPlaceFeedbackRequestParams) {
        String placeId = currentPlaceFeedbackRequestParams.getPlaceId();
        String tracking = currentPlaceFeedbackRequestParams.getTracking();
        Boolean wasHere = currentPlaceFeedbackRequestParams.wasHere();
        if (tracking != null && placeId != null && wasHere != null) {
            Bundle bundle = new Bundle(3);
            bundle.putString(PARAM_TRACKING, tracking);
            bundle.putString(PARAM_PLACE_ID, placeId);
            bundle.putBoolean(PARAM_WAS_HERE, wasHere.booleanValue());
            return new GraphRequest(AccessToken.getCurrentAccessToken(), CURRENT_PLACE_FEEDBACK, bundle, HttpMethod.POST);
        }
        throw new FacebookException("tracking, placeId and wasHere must be specified.");
    }

    public static void newCurrentPlaceRequest(CurrentPlaceRequestParams currentPlaceRequestParams, OnRequestReadyCallback onRequestReadyCallback) {
        Location location = currentPlaceRequestParams.getLocation();
        CurrentPlaceRequestParams.ScanMode scanMode = currentPlaceRequestParams.getScanMode();
        LocationPackageRequestParams.Builder builder = new LocationPackageRequestParams.Builder();
        builder.setLocationScanEnabled(location == null);
        if (scanMode != null && scanMode == CurrentPlaceRequestParams.ScanMode.LOW_LATENCY) {
            builder.setWifiActiveScanAllowed(false);
        }
        LocationPackageManager.requestLocationPackage(builder.build(), new b(onRequestReadyCallback, currentPlaceRequestParams));
    }

    public static GraphRequest newPlaceInfoRequest(PlaceInfoRequestParams placeInfoRequestParams) {
        String placeId = placeInfoRequestParams.getPlaceId();
        if (placeId != null) {
            Bundle bundle = new Bundle(1);
            Set<String> fields = placeInfoRequestParams.getFields();
            if (fields != null && !fields.isEmpty()) {
                bundle.putString("fields", TextUtils.join(",", fields));
            }
            return new GraphRequest(AccessToken.getCurrentAccessToken(), placeId, bundle, HttpMethod.GET);
        }
        throw new FacebookException("placeId must be specified.");
    }

    public static void newPlaceSearchRequest(PlaceSearchRequestParams placeSearchRequestParams, OnRequestReadyCallback onRequestReadyCallback) {
        LocationPackageRequestParams.Builder builder = new LocationPackageRequestParams.Builder();
        builder.setWifiScanEnabled(false);
        builder.setBluetoothScanEnabled(false);
        LocationPackageManager.requestLocationPackage(builder.build(), new a(placeSearchRequestParams, onRequestReadyCallback));
    }

    public static GraphRequest newPlaceSearchRequestForLocation(PlaceSearchRequestParams placeSearchRequestParams, Location location) {
        String searchText = placeSearchRequestParams.getSearchText();
        if (location == null && searchText == null) {
            throw new FacebookException("Either location or searchText must be specified.");
        }
        int limit = placeSearchRequestParams.getLimit();
        Set<String> fields = placeSearchRequestParams.getFields();
        Set<String> categories = placeSearchRequestParams.getCategories();
        Bundle bundle = new Bundle(7);
        bundle.putString("type", "place");
        if (location != null) {
            bundle.putString(PARAM_CENTER, String.format(Locale.US, "%f,%f", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
            int distance = placeSearchRequestParams.getDistance();
            if (distance > 0) {
                bundle.putInt(PARAM_DISTANCE, distance);
            }
        }
        if (limit > 0) {
            bundle.putInt(PARAM_LIMIT, limit);
        }
        if (!Utility.isNullOrEmpty(searchText)) {
            bundle.putString(PARAM_Q, searchText);
        }
        if (categories != null && !categories.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = categories.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            bundle.putString(PARAM_CATEGORIES, jSONArray.toString());
        }
        if (fields != null && !fields.isEmpty()) {
            bundle.putString("fields", TextUtils.join(",", fields));
        }
        return new GraphRequest(AccessToken.getCurrentAccessToken(), SEARCH, bundle, HttpMethod.GET);
    }
}
