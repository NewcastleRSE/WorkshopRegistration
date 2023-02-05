package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
- link: https://nclrse-training.github.io/2023-02-14-NCL-ONLINE/
        date: 2023-02-14
        title: Unix Shell - Online
        type: n8-bash
        form: https://www.eventbrite.co.uk/e/unix-shell-workshop-tickets-519600347627
 **/

public class Workshop {
    private static final long serialVersionUID = 6529685098267757690L;

    @JsonProperty
    String id = "";

    @JsonProperty
    String link = "";

    @JsonProperty
    String date = "";

    @JsonProperty
    String title = "";

    @JsonProperty
    String type = "";

    @JsonProperty
    String form = "";

    public Workshop() {}

    public Workshop(String id, String link, String date, String title, String type, String form) {
        this.id = id;
        this.link = link;
        this.date = date;
        this.title = title;
        this.type = type;
        this.form = form;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return "\nid: ".concat(id).concat("\nlink: ").concat(link).concat("\ndate: ").concat(date).
                concat("\ntitle: ").concat(title).concat("\ntype: ").concat(type).
                concat("\nform: ").concat(form);
    }
}
