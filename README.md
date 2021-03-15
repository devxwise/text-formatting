# Text Formatting Tool
Java application which reads a text from standard in and writes the formatted output to the console

## How to use
- Clone repository or extract Zip file
- From the root directory, run:
```shell script
mvn clean package
``` 
- Jar file: `formatter.jar` is created under `target` folder
- To run the tool, execute:
```shell script
java -jar formatter.jar <Alignment> <Line width>
``` 
where accepted values are:
```text
- Alignment: currently supported: LEFT, RIGHT, CENTER, JUSTIFY (not case sensitive)
- Line width: any positive (Integer) number (>0)  
```
For example:
```shell script
java -jar formatter.jar left 10
```

- You'll be prompted to enter the text to be formatted

## How to add more alignment algorithms
- Create a new `class` which implements `TextAlignment` under `com.sample.algorithm.formatter`
- Provide implementation for method:
```java
int[] pad(Line line, int width, int totalLines, int lineIdx)
```
- Add/confirm your alignment algorithm's name is in `Alignment` and your class can be initiated in `TextAlignmentFactory`

## Areas for improvements
- For a large text block, we should consider forking the text into smaller blocks and work on each one in a different thread individually, and join after each completed
- Try to reduce space complexity
