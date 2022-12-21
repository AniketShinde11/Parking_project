Main screen => screen1.html
		screen1.java

---------------------------------------------
HOME
----
	About Project   => a.html
	About us      	=> b.html
	contact        	=> c.html

--------------------------------------------------
Search
------
	By Date 	=>search.html
			date.java
		
	By Hr		=>search1.html
			hour.java
		
	By Charges	=> search2.html
			   charges.java
--------------------------------------------------
For 2 Wheeler
			two.html
			backend(T.java)

For 4 Wheeler
			four.html
			backend(T1.java)


-----------------------------------------------------

Vehicle Details Screen
			=>
				vehicle.html
				vehicle.java

----------------------------------------------------------
Payment 
		1)credit/debit card =>credit.html
		2)Net Banking       =>bank.html
----------------------------------------------------------
Billing Information
			=>
				last.java
--------------------------------------------------------------


							DATABASE



1) vehicle information

                      Table "public.vehicle"
  Column  |         Type          | Collation | Nullable | Default 
----------+-----------------------+-----------+----------+---------
 vno      | character varying(50) |           | not null | 
 cno      | character varying(20) |           |          | 
 date     | date                  |           |          | 
 duration | integer               |           |          | 
 charges  | integer               |           |          | 
Indexes:
    "vehicle_pkey" PRIMARY KEY, btree (vno)



Projectdb=# select * from vehicle;
 vno | cno | date | duration | charges 
-----+-----+------+----------+---------
(0 rows)

---------------------------------------------------------------------

2)  TWO WHEELER
	
	Projectdb=# \d vehicle1;
                   Table "public.vehicle1"
      Column       |  Type   | Collation | Nullable | Default 
-------------------+---------+-----------+----------+---------
 number_of_parking | integer |           | not null | 
 state             | integer |           |          | 
Indexes:
    "vehicle1_pkey" PRIMARY KEY, btree (number_of_parking)


Projectdb=# select * from vehicle1;
 number_of_parking | state 
-------------------+-------
                 2 |     1
                 1 |     0
(2 rows)


----------------------------------------------------

3) FOUR WHEELER

Projectdb=# \d vehicle2;
                   Table "public.vehicle2"
      Column       |  Type   | Collation | Nullable | Default 
-------------------+---------+-----------+----------+---------
 number_of_parking | integer |           | not null | 
 state             | integer |           |          | 
Indexes:
    "vehicle2_pkey" PRIMARY KEY, btree (number_of_parking)


Projectdb=# select * from vehicle2;	
 number_of_parking | state 
-------------------+-------
                 1 |     0
                 2 |     0
(2 rows)

--------------------------------------------------------------------------

			
