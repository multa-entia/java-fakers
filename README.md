## Summary 

The library provides tools for values generation.
__Faker__ is the main class of the library.
It provides the opportunity of generation values of the following types:
- Boolean
- Double
- Integer
- Long
- String
- UUID

## Examples

### Boolean example
The __Faker.bool\_().random()__ construction returns a logical value - true or false
with approximately 50 probability.
```java
boolean result = Faker.bool_().random();
```

### Double example
The __Faker.double\_().lessOrEqual(threshold)__ construction returns
a double value which less or equal than __threshold__.
```java
double threshold = 1.0;
double result = Faker.double_().lessOrEqual(threshold);
```

The __Faker.double\_().less(threshold)__ construction returns
a double value which less than __threshold__.
```java
double threshold = 1.1;
double result = Faker.double_().lessOrEqual(threshold);
```

The __Faker.double\_().greaterOrEqual(threshold)__ construction returns
a double value which more or equals than __threshold__.
```java
double threshold = 1.2;
double result = Faker.double_().greaterOrEqual(threshold);
```

The __Faker.double\_().greater(threshold)__ construction returns
a double value which more or than __threshold__.
```java
double threshold = 1.3;
double result = Faker.double_().greater(threshold);
```

The __Faker.double\_().between(min, max)__ construction returns
a double value that lies between __min__ & __max__.
```java
double min = 1.4;
double max = 14;
double result = Faker.double_().between(min, max);
```

The __Faker.double\_().random()__ construction returns
a double value that lies between __Long.MIN_VALUE__ & __Long.MAX_VALUE__.
```java
double result = Faker.double_().random();
```

### Float example
The __Faker.float\_().lessOrEqual(threshold)__ construction returns
a float value which less or equal than __threshold__.
```java
float threshold = 1.0f;
float result = Faker.float_().lessOrEqual(threshold);
```

The __Faker.float\_().less(threshold)__ construction returns
a float value which less than __threshold__.
```java
float threshold = 1.1f;
float result = Faker.float_().lessOrEqual(threshold);
```

The __Faker.float\_().greaterOrEqual(threshold)__ construction returns
a float value which more or equals than __threshold__.
```java
double threshold = 1.2f;
float result = Faker.float_().greaterOrEqual(threshold);
```

The __Faker.float\_().greater(threshold)__ construction returns
a float value which more or than __threshold__.
```java
float threshold = 1.3f;
float result = Faker.float_().greater(threshold);
```

The __Faker.float\_().between(min, max)__ construction returns
a float value that lies between __min__ & __max__.
```java
float min = 1.4f;
float min = 14f;
float result = Faker.float_().between(min, max);
```

The __Faker.float\_().random()__ construction returns
a float value that lies between __Long.MIN_VALUE__ & __Long.MAX_VALUE__.
```java
float result = Faker.float_().random();
```

### Integer example
The __Faker.int\_().lessOrEqual(threshold)__ construction returns
a int value which less or equal than __threshold__.
```java
int threshold = 1;
int result = Faker.int_().lessOrEqual(threshold);
```

The __Faker.int\_().less(threshold)__ construction returns
a int value which less than __threshold__.
```java
int threshold = 2;
int result = Faker.int_().lessOrEqual(threshold);
```

The __Faker.int\_().greaterOrEqual(threshold)__ construction returns
a int value which more or equals than __threshold__.
```java
int threshold = 3;
int result = Faker.int_().greaterOrEqual(threshold);
```

The __Faker.int\_().greater(threshold)__ construction returns
a int value which more or than __threshold__.
```java
int threshold = 4;
int result = Faker.int_().greater(threshold);
```

The __Faker.int\_().between(min, max)__ construction returns
a int value that lies between __min__ & __max__.
```java
int min = 14;
int max = 140;
int result = Faker.float_().between(min, max);
```

The __Faker.int\_().random()__ construction returns random int value.
```java
int result = Faker.int_().random();
```

### Long example
The __Faker.long\_().lessOrEqual(threshold)__ construction returns
a long value which less or equal than __threshold__.
```java
long threshold = 1L;
long result = Faker.long_().lessOrEqual(threshold);
```

The __Faker.long\_().less(threshold)__ construction returns
a long value which less than __threshold__.
```java
long threshold = 2L;
long result = Faker.long_().lessOrEqual(threshold);
```

The __Faker.long\_().greaterOrEqual(threshold)__ construction returns
a long value which more or equals than __threshold__.
```java
long threshold = 3L;
long result = Faker.long_().greaterOrEqual(threshold);
```

The __Faker.long\_().greater(threshold)__ construction returns
a long value which more or than __threshold__.
```java
long threshold = 4L;
long result = Faker.long_().greater(threshold);
```

The __Faker.long\_().between(min, max)__ construction returns
a long value that lies between __min__ & __max__.
```java
long min = 14L;
long max = 140L;
long result = Faker.long_().between(min, max);
```

The __Faker.long\_().random()__ construction returns random long value.
```java
long result = Faker.int_().random();
```

### String example
The __Faker.str\_().random(...)__ construction returns string value with defined length.
```java
int minLen = 5;
int maxLen = 10;
String result = Faker.str_().random(minLen, maxLen);
```

The __Faker.str\_().fromTemplate(...) construction returns string value which is on base template.
```java
String template = "line begin [5-7]{3:5} mid [a-z]{7:10} line end";
String result = Faker.str_().fromTemplate(template);
```
In this case, the result look like __line begin \<substr0\> mid \<substr1\> line end__ where 

- __substr0__ is sequence which contains chars from '5' to '7' and has length from 3 to 5
- __substr1__ is sequence which contains chars from 'a' to 'z' and has length from 7 to 10

### UUID example
The __Faker.uuid/_().random()__ construction returns UUID
```java
UUID result = Faker.uuid_().random();
```