package com.companyname.insurance.panels;

import com.github.invictum.panels.AbstractPanel;

public class SearchPanel extends AbstractPanel {

    public void fillSearchCriteria(String searchCriteria) {
        locate("search.input").type(searchCriteria);
    }

    public void clickSearchButton() {
        locate("search.button").click();
    }
}
