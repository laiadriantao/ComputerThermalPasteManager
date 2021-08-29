# ComputerThermalPasteManager
This is my final project for school. 
The project aims to remind the user to replace the thermalpaste for each computer every two years.
The idea for this app came to me after I had periodic GPU failures and ended up changing it's thermalpaste.

# What did I use to make it?

Java 8, MySQL, Maven, Hibernate, JavaFX, Lombok

Make sure you have Lombok installed.
https://projectlombok.org/

# How to use:

1. Use a program such as XAMPP to create a database named "myproject".
2. Go to hibernate.cfg.xml and HibernateUtil then change hbm2dll from update to create-drop.
3. After the table is created, switch the properties back to update.

# What does it do:

#### 1. Create
1.  Creates computers based on the current date (instantly).
  1.2 Creates computers based on the date of choice (choosing date from the calendar).
  
#### 2. Read
2.1.  All computers are listed on a list no matter their state (at opening and after refresh).
2.2.  The program is able to list all the computers in need of a revision (after check function is done).
  2.2.1.  The program will notify the user if any computer revisions must be performed before listing all the "faulty" computers (at check function).

#### 3. Update
3.1 Updates the state (revision performed) of the chosen computer based on current date (instantly). 
3.2 Refresh function (just in case)

#### 4. Delete
4.1 Deletes the chosen computer

# What's next?
After going through my application again I realise there is place for improvement but due to it being a school project I can't perform any changes to this specific repository.






