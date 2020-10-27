package ru.sunlab.sber.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SberMessage implements Serializable {

    public SberMessage() {
    }

    public SberMessage(long id, String text, Date date) {
        this.id = id;
        this.text = text;
        this.date = date;
    }

    @XmlElement
    private long id;
    @XmlElement
    private String text;
    @XmlElement
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
