# FirstCPDemo
Sqlite Demo: Insert, Update, Delete and Select.

We have total of 4 packages:
1. data: This contains the logic of SQLite data base i.e. Insert, Update, Delete and Select. The classes are:
  i) SqliteDatabaseAdapter: This interact with SqliteDatabaseHelper for the sql operations.
  ii) SqliteDatabaseHelper: This creates database schema and table schema.
  
2. validation: This contains the validation logic i.e. show error i.e. requried when no data is entered in text box. Only one class.
  i) Validation: Just validate the input data from UI.
  
3. model: This contains the Employ model i.e. id, name and age. Only one class.
  i) Employ: This contains the emply properties.
  
4. app: This contains the interation with database and UI logic. It has two class.
  i) MainActivity: This calls the Operation class to do the Insert, Update, Delete and Select operations.
  ii) Operation: This interact with SqliteDatabaseHelper class to perform the Insert, Update, Delete and Select operations.
  
Find the few of the screenshots below:

![sqlite1](https://user-images.githubusercontent.com/37674711/38763036-5eddd84c-3fb1-11e8-9a0d-9c5a628d5b21.PNG)
![sqlite2](https://user-images.githubusercontent.com/37674711/38763037-5f32b362-3fb1-11e8-9e4f-f4f66e9e9d54.PNG)
![sqlite3](https://user-images.githubusercontent.com/37674711/38763038-5f75740e-3fb1-11e8-904c-13fe75f0d719.PNG)
![sqlite4](https://user-images.githubusercontent.com/37674711/38763039-5fb96740-3fb1-11e8-8e9b-0291794591fc.PNG)
![sqlite5](https://user-images.githubusercontent.com/37674711/38763040-5ff51ce0-3fb1-11e8-9b59-02a889dbc655.PNG)

