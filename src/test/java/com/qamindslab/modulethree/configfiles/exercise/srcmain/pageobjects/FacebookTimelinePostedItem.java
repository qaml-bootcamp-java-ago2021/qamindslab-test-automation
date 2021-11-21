package com.qamindslab.modulethree.configfiles.exercise.srcmain.pageobjects;

import com.qamindslab.modulethree.configfiles.exercise.srcmain.common.BaseElement;
import org.openqa.selenium.WebElement;

public class FacebookTimelinePostedItem extends BaseElement {
    public FacebookTimelinePostedItem(WebElement root) {
        super(root);
    }

    public String getDescription(){
        return this.root.getText();
    }
}
