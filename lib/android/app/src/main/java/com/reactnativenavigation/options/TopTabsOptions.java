package com.reactnativenavigation.options;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.reactnativenavigation.options.params.BoolProp;
import com.reactnativenavigation.options.params.Colour;
import com.reactnativenavigation.options.params.NoValBool;
import com.reactnativenavigation.options.params.NullColor;
import com.reactnativenavigation.options.params.NoValInt;
import com.reactnativenavigation.options.params.IntProp;
import com.reactnativenavigation.options.parsers.BoolParser;
import com.reactnativenavigation.options.parsers.ColorParser;
import com.reactnativenavigation.options.parsers.NumberParser;

import org.json.JSONObject;

public class TopTabsOptions {

    @NonNull public Colour selectedTabColor = NullColor.INSTANCE;
    @NonNull public Colour unselectedTabColor = NullColor.INSTANCE;
    @NonNull public IntProp fontSize = NoValInt.INSTANCE;
    @NonNull public BoolProp visible = NoValBool.INSTANCE;
    @NonNull public IntProp height = NoValInt.INSTANCE;

    public static TopTabsOptions parse(Context context, @Nullable JSONObject json) {
        TopTabsOptions result = new TopTabsOptions();
        if (json == null) return result;
        result.selectedTabColor = ColorParser.parse(context, json, "selectedTabColor");
        result.unselectedTabColor = ColorParser.parse(context, json, "unselectedTabColor");
        result.fontSize = NumberParser.parse(json, "fontSize");
        result.visible = BoolParser.parse(json, "visible");
        result.height = NumberParser.parse(json, "height");
        return result;
    }

    void mergeWith(TopTabsOptions other) {
        if (other.selectedTabColor.hasValue()) selectedTabColor = other.selectedTabColor;
        if (other.unselectedTabColor.hasValue()) unselectedTabColor = other.unselectedTabColor;
        if (other.fontSize.hasValue()) fontSize = other.fontSize;
        if (other.visible.hasValue()) visible = other.visible;
        if (other.height.hasValue()) height = other.height;
    }

    void mergeWithDefault(TopTabsOptions defaultOptions) {
        if (!selectedTabColor.hasValue()) selectedTabColor = defaultOptions.selectedTabColor;
        if (!unselectedTabColor.hasValue()) unselectedTabColor = defaultOptions.unselectedTabColor;
        if (!fontSize.hasValue()) fontSize = defaultOptions.fontSize;
        if (!visible.hasValue()) visible = defaultOptions.visible;
        if (!height.hasValue()) height = defaultOptions.height;
    }
}
