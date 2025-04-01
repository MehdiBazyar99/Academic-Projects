
 SELECT service_name,COUNT(hotel_services_service_id) AS Times_Used
 FROM service_used INNER JOIN hotel_services INNER JOIN bookings ON bookings_booking_id = booking_id AND hotel_services_service_id = service_id

WHERE booking_id IN 
 (
SELECT booking_id AS Bookings_ID
FROM room_type INNER JOIN room INNER JOIN bookings ON room_room_id = room_id and room_type_id = room_type_room_type_id
WHERE smoke_friendly = 1
)
GROUP BY hotel_services_service_id 
ORDER BY Times_Used DESC
;