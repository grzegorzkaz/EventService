package pl.sda.eventservice.controller.dto;

import lombok.Data;

import pl.sda.eventservice.model.enums.EventCategoryEnum;
import pl.sda.eventservice.model.enums.EventLocationEnum;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Data
public class EventDto {

    private String eventName;
    private EventLocationEnum location;
    private EventCategoryEnum category;
    private String description;
    private String eventDateStart;
    private String eventDateEnd;
}
