## Mobile Store

---

- A program to learn Lists, Comparators, File Reading and Writing using BufferedReader and BufferedWriter.
- This program displays a nicely formatted menu for the action one can do in the Mobile Store like - 
  - Display all the Available Mobiles in the shop
  - Add Mobile to the shop 
  - Find a specific brand of mobile 
  - Display mobiles with Price low to high
- The code automatically reads the data in the file [mobile.csv](src/main/resources/mobile.csv) as soon as the program 
is run, and automatically writes the added mobile to the file as soon as a mobile is added
- The class `Mobile.java` contains the fields for the Mobile, the class `MobileStore.java` creates a list of Mobile type for 
the store, containing all the necessary methods for performing the tasks.
- The class `MobileStoreImpl.java` contains the Main Method and calls all the other methods to perform the tasks based on 
user choice.

---

### Note-
This project is currently under development. Some parts of the program might appear to be missing or incomplete, and 
some parts of the program might not work as expected.