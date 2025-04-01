
CREATE OR REPLACE VIEW VISITED_HOTELS as (

select guest_id,city,hotel_hotel_id as fhotel_id 
from bookings right join (
select guest_id,city,max(tbic) as BITCity
from (
select guests_guest_id as guest_id,city,count(city) as tbic
from hotel right join
(
select guests_guest_id,hotel_hotel_id
from bookings 
having guests_guest_id = 16) as A1 on hotel_id = hotel_hotel_id
group by city order by  tbic desc) as A2
-- times the selected guest visited the citys 
) as A3
-- selects the city that the guest travelled most frequently
 on guests_guest_id = guest_id
 
);


select distinct guest_id,hotel.city,hotel_id 
from hotel right join ( select * from VISITED_HOTELS
 
) AS A4 on hotel.city = A4.city and hotel.hotel_id not in ( select fhotel_id from (VISITED_HOTELS)

 )

;