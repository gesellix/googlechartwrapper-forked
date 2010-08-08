/**
 *
 */
package de.toolforge.googlechartwrapper.style.icon;

/**
 * @author steffan
 */
enum BubbleStringConstant {

    BubbleTextSmall("bubble_text_small"),
    BubbleIconTextSmall("bubble_icon_text_small"),
    BubbleIconTextBig("bubble_icon_text_big"),
    BubbleIconTextsBig("bubble_icon_texts_big"),
    BubbleTextBig("bubble_texts_big");

    private final String iconStringConstant;


    private BubbleStringConstant(String iconStringConstant) {
        this.iconStringConstant = iconStringConstant;
    }

    public String getFreestandingIconStringConstant() {

        return "d_" + iconStringConstant;

    }

    public String getFreestandingShadowIconStringConstant() {

        return "d_" + iconStringConstant + "_withshadow";
    }

    public String getFreestandingShadowIconStringConstantOnly() {

        return "d_" + iconStringConstant + "_shadow";
    }


    @Override
    public String toString() {

        return iconStringConstant;
    }

}
