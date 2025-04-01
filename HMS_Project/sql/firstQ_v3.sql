
SELECT guests_guest_id AS Guest_ID,first_name,last_name, sum(total_payment) AS Total
FROM bookings right JOIN guests ON bookings.guests_guest_id = guests.guest_id

GROUP BY guests_guest_id
ORDER BY Total desc
Limit 5
;

