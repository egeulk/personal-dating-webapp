package com.example.simpledatingservice.DTO;

import com.example.simpledatingservice.entities.Tag;

import java.util.List;

public class TagsDTO {
    private List<Tag> selectedTags;
    private List<Tag> nonSelectedTags;

    public List<Tag> getSelectedTags() {
        return selectedTags;
    }

    public void setSelectedTags(List<Tag> selectedTags) {
        this.selectedTags = selectedTags;
    }

    public List<Tag> getNonSelectedTags() {
        return nonSelectedTags;
    }

    public void setNonSelectedTags(List<Tag> nonSelectedTags) {
        this.nonSelectedTags = nonSelectedTags;
    }
}
