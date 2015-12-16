package com.WVA.selenium.WeaveHTML5Utils;

import net.coobird.thumbnailator.Thumbnails;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * *** BEGIN LICENSE BLOCK *****
 * <p/>
 * This file is part of WeaveHTML5SeleniumTests.
 * <p/>
 * The Initial Developer of WeaveHTML5SeleniumTests is Weave Visual Analytics.
 * Portions created by the Initial Developer are Copyright (C) 2015-present
 * the Initial Developer. All Rights Reserved.
 * <p/>
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 * <p/>
 * **** END LICENSE BLOCK *****
 * <p/>
 * Created by ZMaybury on 12/15/15.
 */
public class BufferedImageResize {
    public static BufferedImage resize(BufferedImage img, int newW, int newH) throws IOException {
        return Thumbnails.of(img).forceSize(newW, newH).asBufferedImage();
    }
}
