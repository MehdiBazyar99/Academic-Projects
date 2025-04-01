
SELECT room_room_id,count(room_number) as frequent
FROM bookings INNER JOIN room  INNER JOIN guests ON room_room_id = room_id and guest_id = guests_guest_id
group by room_number
ORDER BY frequent desc
limit 5
;