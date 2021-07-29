# ComputerThermalPasteManager
This is my final project for school. 
The project aims to remind the user to replace the thermalpaste for each computer every two years.
The idea for this app came to me after I had periodic GPU failures and ended up changing it's thermalpaste.

# What did I use to make it?

Java, MySQL, Maven, Hibernate, JavaFX, Lombok

# How to use:

1. Use a program such as XAMPP to create a database named "myproject".
2. Go to hibernate.cfg.xml and HibernateUtil then change hbm2dll from update to create-drop.
3. After the table is created, switch the properties back to update.

# What does it do:

CRUD operations regarding computer revisions.

# FAQ

1. Why is it not possible to choose a date for the computer?

- Because it makes no sense to know when a computer was created. Computers are not "created" in the way that humans are born. Computers are pure concepts made up of many parts which themselves have different manufacturing dates. If I made a computer with a Pentium IV, 2GB DDR2 RAM and an nVidia 8800 GT in 2021 that would be a computer CREATED in 2021, am I wrong? Now, when creating a computer thermalpaste must be applied so it makes sense for it to not have a selectable creation date. 

1.1 What if I made my computer way back. What am I going to do?

- Most likely you will add it manually through XAMPP or anything you are using. Now you will have to ask yourself "When was the last time I applied/reapplied the thermalpaste?". I bet you don't even remember.

2. Why is the interval two years?

- After owning my computer for a good while, 2 years seems to be the best interval.
