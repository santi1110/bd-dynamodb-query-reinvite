package com.amazon.ata.dynamodbquery.dao;

import com.amazon.ata.dynamodbquery.converter.ZonedDateTimeConverter;
import com.amazon.ata.dynamodbquery.dao.models.EventAnnouncement;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/**
 * Manages access to EventAnnouncement items.
 */
public class EventAnnouncementDao {
    private static final ZonedDateTimeConverter ZONED_DATE_TIME_CONVERTER = new ZonedDateTimeConverter();

    private DynamoDBMapper mapper;

    /**
     * Creates an EventDao with the given DDB mapper.
     * @param mapper DynamoDBMapper
     */
    @Inject
    public EventAnnouncementDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Gets all event announcements for a specific event.
     *
     * @param eventId The event to get announcements for.
     * @return the list of event announcements.
     */
    public List<EventAnnouncement> getEventAnnouncements(String eventId) {
        EventAnnouncement key = new EventAnnouncement();
        key.setEventId(eventId);

        DynamoDBQueryExpression<EventAnnouncement> queryExpression = new DynamoDBQueryExpression<EventAnnouncement>()
            .withHashKeyValues(key);

        return mapper.query(EventAnnouncement.class, queryExpression);
    }

    /**
     * Get all event announcements posted between the given dates for the given event.
     *
     * @param eventId The event to get announcements for.
     * @param startTime The start time to get announcements for.
     * @param endTime The end time to get announcements for.
     * @return The list of event announcements.
     */
    public List<EventAnnouncement> getEventAnnouncementsBetweenDates(String eventId,
                                                                     ZonedDateTime startTime,
                                                                     ZonedDateTime endTime) {
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":eventId", new AttributeValue().withS(eventId));
        valueMap.put(":startDate", new AttributeValue().withS(ZONED_DATE_TIME_CONVERTER.convert(startTime)));
        valueMap.put(":endDate", new AttributeValue().withS(ZONED_DATE_TIME_CONVERTER.convert(endTime)));

        DynamoDBQueryExpression<EventAnnouncement> queryExpression = new DynamoDBQueryExpression<EventAnnouncement>()
            .withKeyConditionExpression("eventId = :eventId and timePublished between :startDate and :endDate")
            .withExpressionAttributeValues(valueMap);

        return mapper.query(EventAnnouncement.class, queryExpression);
    }

    /**
     * Creates a new event announcement.
     *
     * @param eventAnnouncement The event announcement to create.
     * @return The newly created event announcement.
     */
    public EventAnnouncement createEventAnnouncement(EventAnnouncement eventAnnouncement) {
        mapper.save(eventAnnouncement);
        return eventAnnouncement;
    }
}
