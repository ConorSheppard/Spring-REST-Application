package com.sheppard.controller;

import com.sheppard.entity.Notification;
import com.sheppard.entity.request.AddNotificationRequest;
import com.sheppard.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {

    private NotificationRepository notificationRepository;

    @Autowired
    public NotificationController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MimeTypeUtils.TEXT_HTML_VALUE)
    public ResponseEntity<String> home() {
        return new ResponseEntity<String>("Please use 8080/notifications/ to view user notifications", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,
                    value = "/notifications/{id}")
    public List<Notification> findAllNotifications(@PathVariable("id") int id) {
        List<Notification> notificationList =  notificationRepository.findAll();

        // Needs to happen after the return
        // for(Notification n : notificationList) if(!n.getRead()) n.setRead(true);

        return notificationList;
    }

    @RequestMapping(method = RequestMethod.POST,
                    value = "/notifications")
    public void addNotification(@RequestBody AddNotificationRequest addNotificationRequest) {
        Notification notification = new Notification();
        notification.setMessage(addNotificationRequest.getMessage());
        notification.setId(addNotificationRequest.getId());
        notification.setTimestamp(addNotificationRequest.getTimestamp());
        notificationRepository.save(notification);
    }
}