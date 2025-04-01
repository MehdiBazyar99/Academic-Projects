
SELECT bookings.hotel_hotel_id,count(hotel_hotel_id) as frequency
FROM bookings INNER JOIN hotel  ON hotel_id = hotel_hotel_id 
group by hotel_hotel_id
ORDER BY frequency desc
limit 5
;