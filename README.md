![workflow](https://github.com/JohnKalan/LabAssignments/actions/workflows/maven.yml/badge.svg)

# Lab Assignments 

## 2nd Lab Assignment 

This 2nd Lab Assignment focuses on the creation of a parent Maven simple project (seip2023_practical_assignments)
and a module Maven simple project (gradeshistogram). The module Maven project will include a class named 
HistogramGenerator. This class will create a diagram which will depict graphically the data given by a file of grades. 

#### Build tools 
This project is using ***jdk 8*** and ***maven*** in order to be built.


#### Running the project 
In order to build the project you need to build it first by using this command: 
```
mvn clean package
```
In order to run the project use this command:
```
java -jar .\gradeshistogram\target\gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar .\gradeshistogram\target\classes\grades.txt
```

## 3rd Lab Assignment

The corresponding README file for the 3rd Lab Assignment is linked below.

> [`README.md for 3rd Lab Assignment`](unittesting/README.md)

## 4th Lab Assignment

The corresponding README file for the 4th Lab Assignment is linked below.

> [`README.md for 4th Lab Assignment`](sourcecodeanalyzer/README.md)