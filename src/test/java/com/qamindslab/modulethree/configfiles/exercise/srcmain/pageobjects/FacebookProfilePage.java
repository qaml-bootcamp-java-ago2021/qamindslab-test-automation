package com.qamindslab.modulethree.configfiles.exercise.srcmain.pageobjects;

import com.qamindslab.modulethree.configfiles.exercise.srcmain.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class FacebookProfilePage extends BasePage {

    @FindBy(how = How.CSS, using = "div[data-pagelet='ProfileTabs'] div[role='tablist'] a[href*='about']")
    private WebElement aboutTab;

    @FindBy(how = How.CSS, using = "div[data-pagelet='ProfileTabs'] div[role='tablist'] a[href*='friends']")
    private WebElement friendsTab;

    @FindBy(how = How.CSS, using = "div[data-pagelet='ProfileTabs'] div[role='tablist'] a[href*='photos']")
    private WebElement photosTab;

    // Change the href content to the Facebook user profile name.
    @FindBy(how = How.CSS, using = "div[data-pagelet='ProfileTabs'] div[role='tablist'] a[href*='<PLACE YOUR USERNAME>']")
    private WebElement postTab;

    @FindBy(how = How.CSS, using = "div[data-pagelet='ProfileTimeline'] div > div[class='rq0escxv l9j0dhe7 du4w35lb']")
    private List<WebElement> timelinePosts;

    public FacebookProfilePage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public List<FacebookTimelinePostedItem> getTimelinePosts(){

        List<FacebookTimelinePostedItem> facebookPosts = new ArrayList<>();

        for (WebElement post:timelinePosts) {
            FacebookTimelinePostedItem fbPost = new FacebookTimelinePostedItem(post);
            facebookPosts.add(fbPost);
        }

        return facebookPosts;
    }

    public void selectPosts(){
        postTab.click();
    }

    public void selectAbout(){
        driver.navigate().to(aboutTab.getAttribute("href"));
    }

    public void selectFriends(){
        friendsTab.click();
    }

    public void selectPhotos(){
        photosTab.click();
    }


}
