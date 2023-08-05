package com.jpa.test.entities;

import java.util.List;
import java.util.Set;

public class FilterResponse {
	private Set<String> sites;
    private Set<String> olts;
    private List<String> onts;

    public FilterResponse(Set<String> sites, Set<String> olts, List<String> onts) {
        this.sites = sites;
        this.olts = olts;
        this.onts = onts;
    }

    public Set<String> getSites() {
        return sites;
    }

    public Set<String> getOlts() {
        return olts;
    }

    public List<String> getOnts() {
        return onts;
    }
}
