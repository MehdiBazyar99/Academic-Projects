
SELECT city as City,count(city) as Frequency
FROM bookings INNER JOIN guests  ON guests_guest_id = guest_id 
group by City
ORDER BY Frequency desc
limit 5
;