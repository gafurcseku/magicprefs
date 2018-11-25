package io.github.gafurcseku.magicprefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class MagicPrefs {
    protected Context context;

    // TODO: make these members private.
    protected SharedPreferences preferences;
    protected Editor editor;

    public MagicPrefs(Context context) {
        context = context;

        preferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    /***
     * Set a value for the key
     ****/
    public void setValue(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    /***
     * Set a value for the key
     ****/
    public void setValue(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    /***
     * Set a value for the key
     ****/
    public void setValue(String key, double value) {
        setValue(key, Double.toString(value));
    }

    /***
     * Set a value for the key
     ****/
    public void setValue(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    /****
     * Gets the value from the settings stored natively on the device.
     *
     * @param defaultValue Default value for the key, if one is not found.
     **/
    public String getValue(String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

    public int getIntValue(String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    public long getLongValue(String key, long defaultValue) {
        return preferences.getLong(key, defaultValue);
    }

    /****
     * Gets the value from the preferences stored natively on the device.
     *
     * @param defValue Default value for the key, if one is not found.
     **/
    public boolean getValue(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }

    public void setValue(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * Clear all the preferences store in this {@link android.content.SharedPreferences.Editor}
     */
    public boolean clear() {
        try {
            editor.clear().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Removes preference entry for the given key.
     *
     * @param key
     */
    public void removeValue(String key) {
        if (editor != null) {
            editor.remove(key).commit();
        }
    }
}
