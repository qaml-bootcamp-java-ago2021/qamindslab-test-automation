package com.qamindslab.modulethree.pom.example.googlesearch.srcmain.common;

import org.openqa.selenium.WebElement;

public class GoogleResultItem extends BaseElement {
    public GoogleResultItem(WebElement root) {
        super(root);
    }

    private WebElement title() {
        return this.root;
    }

    public String getTitle(){
        return this.title().getText();
    }

    public String getDescription() {
        return this.root.getText();
    }

    public void click(){
        this.root.click();
    }

    @Override
    public String toString(){
        return this.getDescription();
    }
}
