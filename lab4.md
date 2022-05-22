# Lab Report 1

[Home](https://adironene.github.io/CSE15l/index.html) 

Debugging might take more time than the intial coding process. It is important to offer clean and organized code in order to quickly find the error and fix it. Moreover, practicing clean coding habits allow other developers to understand and work with your code.
 <br/><br/>

## Intro

We will be running 3 tests on both [my solution](https://github.com/adironene/markdown-parser) and [other group solution](https://github.com/Combobyte/markdown-parser) to MarkdownParser For each test, I will include
- The test file
- The correct output
- The test implementation
- The outputs of the test
- An explanation of the code

<br/><br/>

## Test Case 1

#### The test file
```
`[a link`](url.com)
[another link](`google.com)`
[`cod[e`](google.com)
[`code]`](ucsd.edu)
```

#### The correct output

Only the second line would be considered a link so the correct output should be

``` ["`google.com"]```

#### The test implementation

> For my test file, this is how I added the tester method.

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.*;

public class MarkdownParseTest {

    @Test
    public void testFile() throws IOException {
        Path fileName = Path.of("lab4-snippet1.md");
        String content = Files.readString(fileName);
        MarkdownParse m = new MarkdownParse();
        ArrayList<String> links = m.getLinks(content);
        ArrayList<String> correct_links = new ArrayList<>(Arrays.asList("`google.com"));
        assertEquals(correct_links, links);
    }
}
```

The lab4-snippet1.md file had the snippet copied over.

> For the other group's file, this is how I added the tester method.

```java
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class MarkdownParseTest {

    @Test
    public void MarkdownParseTest() throws IOException{
        ArrayList<String> expected = new ArrayList<>(List.of("`google.com"));
        ArrayList<String> resultArray = MarkdownParse.getLinks(Files.readString(Path.of("lab4-snippet1.md")));
        assertEquals(expected, resultArray);
    }
}
```

The lab4-snippet1.md file had the snippet copied over.

#### The outputs of the test

My code did not pass the JUnit Test

![image](images/Lab4/snippet1_my.png)

The other group's code did not pass the JUnit Test

![image](images/Lab4/snippet1_other.png)

#### An explanation of the code

> Do you think there is a small (<10 lines) code change that will make your program work for snippet 1 and all related cases that use inline code with backticks? If yes, describe the code change. If not, describe why it would be a more involved change.


A: Yes, a small code change would make my program work for snippet 1. I believe that both teams were unaware of the backstick being a problem. In order to fix the issue, we would have an if() statement to check if there is a "(" ")" "[" or "]" in between multiple backsticks; if so, delete the link from the list.

## Test Case 2
<br/><br/>

## Test Case 3