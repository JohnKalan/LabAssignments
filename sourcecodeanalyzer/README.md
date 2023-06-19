# 4th Lab Assignment #

This 4th Lab Assignment focuses on the refactoring of a module Maven simple project called sourcecodeanalyzer.
Within the sourcecodeanalyzer package, there are 3 separate packages called: 

* metricsexporter
* sourcecodeanalyzer
* sourcefilereader 

## Design pattern

The refactoring of the given code is based on two different design patterns, the ***Factory Method*** design pattern and the ***Strategy Pattern***. The metricsexporter package use only the Factory Method and the other two packages, sourcefilereader and sourcecodeanalyzer implement both design patterns. The selection criteria and the trade-offs will be analyzed below.

##### Benefits

* **Factory Method Pattern**: The Factory Method pattern brings benefits such as encapsulating object creation, promoting code flexibility, and supporting extensibility. It allows the client code to obtain instances without knowing the specific implementation details, resulting in modular and maintainable code. New file reader types or code analyzer types can be added easily without modifying the existing client code, following the open-closed principle.
* **Strategy Pattern**: The Strategy pattern provides advantages such as clear separation of metric calculation algorithms, code reuse, extensibility, and improved testability. It separates the metric calculation strategies from the client code, allowing easy switching between different strategies without modifying the client code. For example, new strategies can be added by implementing the CodeAnalyzer interface, enabling the addition of new metric calculation techniques or improvement of existing ones. The Strategy pattern promotes modular code, maintainability, and flexible integration of new metric calculation strategies.

##### Trade-offs 

* **Factory Method Pattern**: One trade-off of using the Factory Method pattern is the potential increase in complexity. Introducing a factory class and creating concrete factory methods adds additional layers of abstraction and indirection, which may complicate the codebase. Additionally, maintaining a large number of factory methods for different types can lead to increased code complexity and potential code duplication if not properly managed.
* **Strategy Pattern**: The trade-offs of using the Strategy pattern include increased class count and potential complexity. Implementing multiple strategies requires creating separate classes for each strategy, which can increase the overall class count in the system. This may result in more classes to maintain and manage. Additionally, coordinating between different strategies and managing the selection of the appropriate strategy may introduce additional complexity. 

#### Build tools 

This module is part of the project using ***jdk 8*** and ***maven*** in order to be built.

#### Running the project 

1. Build the executable Java application with: 
```
mvn package jacoco:report
```
2. Run the executable by executing
```
java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
```
args translate to: 	
	arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
	arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
	arg2 = “SourceCodeLocationType” [local|web]
	arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
	arg4 = “OutputFileType” [csv|json]
example: 
```
java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv
```
