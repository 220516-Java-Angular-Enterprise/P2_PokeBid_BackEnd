package com.revature.pokebid.notification;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.cardlisting.CardListingRepository;
import com.revature.pokebid.cardlisting.CardListingService;
import com.revature.pokebid.notification.dtos.NewNotificationRequest;
import com.revature.pokebid.user.UserService;
import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class NotificationService {

    @Inject
    private final NotificationRepository notificationRepository;
    private final UserService userService;
    //private final CardListingService cardListingService;
    private final CardListingRepository cardListingRepository;

    @Inject
    @Autowired
    public NotificationService(NotificationRepository notificationRepository, UserService userService, CardListingRepository cardListingRepository) {
        this.notificationRepository = notificationRepository;
        this.userService = userService;
        this.cardListingRepository = cardListingRepository;
    }

    public Notification newNotification(NewNotificationRequest request) {
        Notification notification = new Notification();
        notification.setId(UUID.randomUUID().toString());
        notification.setUser(userService.getUserById(request.getUser_id()));
        notification.setCardListing(cardListingRepository.getCardListingByID(request.getAuction_id()));
        notification.setMessage(request.getMessage());
        notificationRepository.newNotification(notification.getId(), notification.getUser(), notification.getCardListing(), notification.getMessage());
        return notification;
    }

    public List<Notification> getAllNotificationsByUser(String id) { return notificationRepository.getAllNotificationsByUser(id); }

    public void deleteNotification(String id) { notificationRepository.deleteNotification(id); }

}
