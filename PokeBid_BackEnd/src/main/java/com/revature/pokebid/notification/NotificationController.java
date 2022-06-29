package com.revature.pokebid.notification;

import com.revature.pokebid.cardlisting.dtos.cardlisting.NewCardListingRequest;
import com.revature.pokebid.notification.dtos.NewNotificationRequest;
import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Inject
    private final NotificationService notificationService;

    @Inject
    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @CrossOrigin
    @GetMapping(value = "/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Notification> getAllNotificationsByUser(@PathVariable String user_id) {
        return notificationService.getAllNotificationsByUser(user_id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addNotification(@RequestBody NewNotificationRequest request){
        return notificationService.newNotification(request).getId();
    }

}
