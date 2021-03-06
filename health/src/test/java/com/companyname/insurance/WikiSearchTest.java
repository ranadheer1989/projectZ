package com.companyname.insurance;

import com.github.invictum.EnhancedSerenityRunner;
import com.github.invictum.data.injector.TestData;
import com.github.invictum.steps.PageNavigationSteps;
import com.github.invictum.url.Url;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTagValuesOf;
import com.companyname.insurance.core.AbstractUiTest;
import com.companyname.insurance.dto.SearchData;
import com.companyname.insurance.pages.MainPage;
import com.companyname.insurance.steps.SearchSteps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EnhancedSerenityRunner.class)
@WithTagValuesOf("area:wiki")
public class WikiSearchTest extends AbstractUiTest {

    @Steps
    PageNavigationSteps pageNavigationSteps;

    @Steps
    SearchSteps searchSteps;

    @TestData("data/search/xml.yml")
    SearchData xml;

    @TestData("data/search/json.yml")
    SearchData json;

    @Test
    @Title("Basic search on Wiki")
    @WithTagValuesOf("area:search")
    public void basicSearch() {
        pageNavigationSteps.openPage(MainPage.class);
        searchSteps.fillSearchForm(xml.getSearchText());
        searchSteps.performSearch();
        searchSteps.verifySearchResults(xml);
    }

    @Test
    @Url("italian:default")
    @Title("Basic search on Italian Wiki")
    @WithTagValuesOf({"area:search", "area:italian"})
    public void basicItalianSearch() {
        pageNavigationSteps.openPage(MainPage.class);
        searchSteps.fillSearchForm(json.getSearchText());
        searchSteps.performSearch();
        searchSteps.verifySearchResults(json);
    }
}
