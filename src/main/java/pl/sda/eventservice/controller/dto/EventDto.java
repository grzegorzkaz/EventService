package pl.sda.eventservice.controller.dto;

import lombok.Data;
import pl.sda.eventservice.model.enums.EventCategoryEnum;
import pl.sda.eventservice.model.enums.EventLocationEnum;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Data
public class EventDto {

    private String eventName;
    private EventLocationEnum location;
    private EventCategoryEnum category;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date eventDateStart;
    @Temporal(TemporalType.DATE)
    private Date eventDateEnd;
}
