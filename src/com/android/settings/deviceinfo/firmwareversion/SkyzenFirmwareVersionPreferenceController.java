/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;

import com.android.settings.core.BasePreferenceController;

public class SkyzenFirmwareVersionPreferenceController extends BasePreferenceController {

    private static final String TAG = "SkyzenFirmwareVersion";
    private static final String SKYZEN_VERSION = "ro.skyzen.display.version";
    private static final String SKYZEN_DEVICE = "ro.skyzen.device";
    private static final String SKYZEN_BUILDTYPE = "ro.skyzen.releasetype";

    public SkyzenFirmwareVersionPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        String getVer = SystemProperties.get(SKYZEN_VERSION);
        String getDevice = SystemProperties.get(SKYZEN_DEVICE);
        String getType = SystemProperties.get(SKYZEN_BUILDTYPE);
        return getVer + " | " + getDevice + " | " + getType;
    }
}
