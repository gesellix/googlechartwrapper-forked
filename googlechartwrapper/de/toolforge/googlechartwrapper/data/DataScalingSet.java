/*
 * Copyright (c) 2008-2010, Steffan Voß, Martin Vanauer
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
 * DISCLAIMED. IN NO EVENT SHALL Steffan Voß, Martin Vanauer BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package de.toolforge.googlechartwrapper.data;

import de.toolforge.googlechartwrapper.ChartTypeFeature;
import de.toolforge.googlechartwrapper.util.AppendableFeature;
import de.toolforge.googlechartwrapper.util.IFeatureAppender;

import java.util.ArrayList;
import java.util.List;


/**
 * A DataScalingSet enables the transformation of chart values on one axis.
 * If you supply fewer data scaling parameters than there are data sets the
 * last scaling parameter is applied to the remaining data sets.
 *
 * @author steffan
 * @author martin
 * @see ISingleDataScaleable
 * @see IMultiDataScaleable
 */
public class DataScalingSet implements IFeatureAppender {

    private double minimumValue;
    private double maximumValue;

    /**
     * Constructs a DataScalingSet the lowest and highest number you want to
     * apply to the dataset. You can specify a missing value with a number
     * that is out of range.
     *
     * @param maximumValue lowest number you want to apply to the data set
     * @param minimumValue highest number you want to apply to the data set
     */
    public DataScalingSet(double minimumValue, double maximumValue) {

        this.maximumValue = maximumValue;
        this.minimumValue = minimumValue;
    }

    public List<AppendableFeature> getAppendableFeatures(
            List<? extends IFeatureAppender> otherAppenders) {

        StringBuilder builder = new StringBuilder();

        builder.append(this.minimumValue);
        builder.append(',');
        builder.append(this.maximumValue);

        List<AppendableFeature> feature = new ArrayList<AppendableFeature>();

        feature.add(new AppendableFeature(builder.toString(),
                ChartTypeFeature.DataScaling));

        return feature;
    }

    /**
     * Returns the maximum value for the dataset.
     *
     * @return maximum value
     */
    public double getMaximumValue() {
        return maximumValue;
    }

    /**
     * Sets the maximum value for the dataset.
     *
     * @param maximumValue highest number you want to apply to the first data set
     */
    public void setMaximumValue(double maximumValue) {
        this.maximumValue = maximumValue;
    }

    /**
     * Returns the minimum value for the dataset.
     *
     * @return minimum value
     */
    public double getMinimumValue() {
        return minimumValue;
    }

    /**
     * Sets the minimum value for the dataset.
     *
     * @param minimumValue lowest number you want to apply to the first data set
     */
    public void setMinimumValue(double minimumValue) {
        this.minimumValue = minimumValue;
    }

}
