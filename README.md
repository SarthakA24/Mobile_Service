## Mobile Store

---
### Task Details

Imagine that you wish to purchase a mobile phone with specifications that include the brand name, cost, screen size, battery life, storage space and camera pixels. You have a list of the latest models available. Create a program that performs the following activities:
1. Find phones of a particular brand.
2. Find phones that cost $500 and above.
3. Find phones that have a camera specification of 12 MP or more.

---
### Challenge Task 1

Mobile class is having few attributes like (`brandName`, `cost`, `screenSize`, `batteryLife` etc.) You have
to create `getter`/`setter` for all the attributes.

Override `toString()` method in the `Mobile` class.

Inside the `MobileStore` class:
1. Create a list of type `Mobile`. 
2. Read the `mobile.csv` file line by line and store the data in the respective attribute of the `Mobile` class by calling the `setter` method, and return the list of type Mobile. Write the logic in the given method below:

```java
public List<Mobile> readMobileData(String fileName)
```

---
### Challenge Task 2

1. Given a brand name as input, return the list of all mobiles of that brand. Write the logic in the method given below.
```java
public List<Mobile> findPhoneByBrand (String brandName)
```
2. Iterate through the list of mobile and return the phone that costs more than $500. Write the logic in the method given below and return the list.
```java
public List<Mobile> findPhoneCostMoreThan$500()
```
3. Iterate through the list of mobile and return the phone having pixel more than 12MP. Write the logic in the method given below and return the list.
```java
public List<Mobile> findPhonePixelMoreThan12MP()
```
Note - Only once mobile.csv file should be read and store the value in list
