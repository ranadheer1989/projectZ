package com.companyname.insurance.pages;

import com.github.invictum.pages.AbstractPage;

public class ArticlePage extends AbstractPage {
    public String getArticleTitle() {
        return locate("title").getText();
    }
}
