/*
 * Copyright (c) 2008-2010, Steffan Vo�, Martin Vanauer
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Steffan Vo�, Martin Vanauer BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 *
 */
package de.toolforge.googlechartwrapper.style.icon;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.Color;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;

import java.util.ArrayList;
import java.util.List;


/**
 * @author steffan
 */
public class BubbleFactory {


    private BubbleFactory() {
    }

    public static Bubble createSmallBubble(TailDirection direction, String text, Color fillColor, Color textColor, boolean withShadow) {

        return buildBubble(BubbleStringConstant.BubbleTextSmall, null, direction, fillColor, textColor, text, null, withShadow);

    }

    public static Bubble createSmallBubble(TailDirection direction, String text, Color fillColor, Color textColor) {

        return buildBubble(BubbleStringConstant.BubbleTextSmall, null, direction, fillColor, textColor, text, null, false);

    }

    public static Bubble createSmallBubble(Icon icon, TailDirection direction, String text, Color fillColor, Color textColor, boolean withShadow) {

        if (icon == null)
            throw new IllegalArgumentException("icon can not be null");

        return buildBubble(BubbleStringConstant.BubbleIconTextSmall, icon, direction, fillColor, textColor, text, null, withShadow);

    }

    public static Bubble createSmallBubble(Icon icon, TailDirection direction, String text, Color fillColor, Color textColor) {

        if (icon == null)
            throw new IllegalArgumentException("icon can not be null");

        return buildBubble(BubbleStringConstant.BubbleIconTextSmall, icon, direction, fillColor, textColor, text, null, false);

    }

    public static Bubble createBubble(Icon icon, TailDirection direction, String text, Color fillColor, Color textColor, boolean withShadow) {

        return buildBubble(BubbleStringConstant.BubbleIconTextBig, icon, direction, fillColor, textColor, text, null, withShadow);
    }

    public static Bubble createBubble(Icon icon, TailDirection direction, String text, Color fillColor, Color textColor) {

        return buildBubble(BubbleStringConstant.BubbleIconTextBig, icon, direction, fillColor, textColor, text, null, false);
    }

    public static Bubble createBubble(TailDirection direction, List<String> text, Color fillColor, Color textColor, boolean withShadow) {

        return buildBubble(BubbleStringConstant.BubbleTextBig, null, direction, fillColor, textColor, null, text, withShadow);

    }

    public static Bubble createBubble(TailDirection direction, List<String> text, Color fillColor, Color textColor) {

        return buildBubble(BubbleStringConstant.BubbleTextBig, null, direction, fillColor, textColor, null, text, false);

    }

    public static Bubble createBubble(Icon icon, TailDirection direction, List<String> text, Color fillColor, Color textColor, boolean withShadow) {

        return buildBubble(BubbleStringConstant.BubbleIconTextBig, icon, direction, fillColor, textColor, null, text, withShadow);

    }

    public static Bubble createBubble(Icon icon, TailDirection direction, List<String> text, Color fillColor, Color textColor) {

        return buildBubble(BubbleStringConstant.BubbleIconTextBig, icon, direction, fillColor, textColor, null, text, false);

    }

    private static Bubble buildBubble(BubbleStringConstant bubbleStringConstant, Icon icon, TailDirection direction, Color fillColor, Color textColor, String text, List<String> textList, boolean withShadow) {

        Bubble b = new Bubble();

        b.bubbleStringConstant = bubbleStringConstant;
        b.icon = icon;
        b.direction = direction;
        b.fillColor = fillColor;
        b.textColor = textColor;
        b.text = text;
        b.textList = textList;
        b.withShadow = withShadow;


        return b;
    }

    public static ShadowBubble createShadowBubble(TailDirection direction, String text) {

        return buildShadowBubble(BubbleStringConstant.BubbleTextSmall, direction, text, null, null);
    }

    private static ShadowBubble buildShadowBubble(BubbleStringConstant bubbleStringConstant, TailDirection direction, String text, Icon icon, List<String> textList) {

        ShadowBubble b = new ShadowBubble();

        b.bubbleStringConstant = bubbleStringConstant;
        b.icon = icon;
        b.direction = direction;
        b.text = text;
        b.textList = textList;


        return b;

    }


    private static class Bubble implements de.toolforge.googlechartwrapper.style.icon.Bubble, de.toolforge.googlechartwrapper.style.icon.ShadowBubble {


        private TailDirection direction = null;
        private String text = null;
        private Color fillColor = null;
        private Color textColor = null;
        private Icon icon = null;
        private List<String> textList = null;
        private BubbleStringConstant bubbleStringConstant = null;
        private boolean withShadow = false;

        public ShadowBubble toShadow() {

            return buildShadowBubble(bubbleStringConstant, direction, text, icon, textList);

        }

        public List<AppendableFeature> getAppendableFeatures(List<? extends IFeatureAppender> otherAppenders) {

            List<AppendableFeature> features = new ArrayList<AppendableFeature>();

            StringBuilder builder = new StringBuilder();

            if (!withShadow)
                builder.append(bubbleStringConstant.getFreestandingIconStringConstant());

            if (withShadow)
                builder.append(bubbleStringConstant.getFreestandingShadowIconStringConstant());

            features.add(new AppendableFeature(builder.toString(), ChartTypeFeature.FreeStandingDynamicIcon));

            builder = new StringBuilder();

            if (icon != null)
                builder.append(icon.toString());

            if (direction != null)
                builder.append("|" + direction.toString());

            if (text != null)
                builder.append("|" + text);

            builder.append("|" + fillColor.getSixCharacterHexValue());

            builder.append("|" + textColor.getSixCharacterHexValue());

            if (textList != null) {

                for (String current : textList) {

                    builder.append("|" + current);
                }
            }


            features.add(new AppendableFeature(builder.toString(), ChartTypeFeature.IconData));

            return features;
        }
    }


    private static class ShadowBubble implements de.toolforge.googlechartwrapper.style.icon.ShadowBubble {

        private TailDirection direction = null;
        private String text = null;
        private Icon icon = null;
        private List<String> textList = null;
        private BubbleStringConstant bubbleStringConstant = null;

        public List<AppendableFeature> getAppendableFeatures(List<? extends IFeatureAppender> otherAppenders) {

            List<AppendableFeature> features = new ArrayList<AppendableFeature>();

            StringBuilder builder = new StringBuilder();

            builder.append(bubbleStringConstant.getFreestandingShadowIconStringConstantOnly());

            features.add(new AppendableFeature(builder.toString(), ChartTypeFeature.FreeStandingDynamicIcon));

            builder = new StringBuilder();

            if (icon != null)
                builder.append(icon.toString());

            if (direction != null)
                builder.append("|" + direction.toString());

            if (text != null)
                builder.append("|" + text);

            if (textList != null) {

                for (String current : textList) {

                    builder.append("|" + current);
                }
            }


            features.add(new AppendableFeature(builder.toString(), ChartTypeFeature.IconData));

            return features;
        }
    }


}
